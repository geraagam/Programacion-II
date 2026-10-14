package flotalogistica;

public class Vehiculo {

    protected String patente;
    protected String marca;
    protected double costoBaseKm;

    // Constructor canónico: inicializa todos los atributos de la superclase
    public Vehiculo(String patente, String marca, double costoBaseKm) {
        this.patente = patente;
        this.marca = marca;
        this.costoBaseKm = costoBaseKm;
    }

    // Tarifa base: distancia por costo por kilómetro
    public double calcularCostoViaje(double distanciaKm) {
        return distanciaKm * costoBaseKm;
    }

    // SOBRECARGA (mismo nombre, distinta lista de parámetros).
    // Se resuelve en tiempo de compilación según los argumentos que se pasen.
    // Llama a calcularCostoViaje(distanciaKm), así que si el objeto es un Camion,
    // una Furgoneta o una MotoEnvios se usa la versión sobrescrita de cada uno.
    public double calcularCostoViaje(double distanciaKm, double peajes) {
        return calcularCostoViaje(distanciaKm) + peajes;
    }

    public void mostrarFicha() {
        System.out.println("[Vehículo] Patente: " + patente + " | Marca: " + marca
                + " | Costo base por km: $" + costoBaseKm);
    }
}
