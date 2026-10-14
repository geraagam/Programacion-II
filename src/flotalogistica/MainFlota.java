package flotalogistica;

public class MainFlota {

    public static void main(String[] args) {

        // Arreglo polimórfico: el tipo declarado es Vehiculo,
        // pero cada posición guarda un objeto de una subclase distinta.
        Vehiculo[] flota = new Vehiculo[3];
        flota[0] = new Camion("AA123BB", "Scania", 450.0, 18.0);
        flota[1] = new Furgoneta("AF456CD", "Mercedes-Benz", 420.0, true);
        flota[2] = new MotoEnvios("A099XYZ", "Honda", 180.0);

        double distancia = 150.0;
        double costoTotal = 0;

        System.out.println("=== Reporte de Operaciones de Flota ===");

        // Despacho dinámico: no hay if/switch ni instanceof.
        // En tiempo de ejecución Java mira el objeto real que está en el Heap
        // y ejecuta la versión de mostrarFicha() y calcularCostoViaje() de esa subclase.
        for (Vehiculo v : flota) {
            v.mostrarFicha();
            double costo = v.calcularCostoViaje(distancia);
            System.out.println("Costo de viaje (" + distancia + " km): $" + costo);
            System.out.println("--------------------------------------------------");
            costoTotal += costo;
        }

        System.out.println("Costo total operativo de la flota: $" + costoTotal);

        // Sobrecarga vs. sobrescritura:
        // - El compilador elige la versión de 2 parámetros porque se pasan 2 argumentos (sobrecarga).
        // - Adentro, esa versión llama a calcularCostoViaje(distancia), y como el objeto real
        //   es un Camion, se ejecuta la versión sobrescrita de Camion (sobrescritura).
        double peajes = 3500.0;
        double costoConPeajes = flota[0].calcularCostoViaje(distancia, peajes);
        System.out.println();
        System.out.println("Costo del camión con peajes ($" + peajes + "): $" + costoConPeajes);
    }
}
