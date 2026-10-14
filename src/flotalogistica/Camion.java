package flotalogistica;

public class Camion extends Vehiculo {

    private double capacidadToneladas;

    public Camion(String patente, String marca, double costoBaseKm, double capacidadToneladas) {
        super(patente, marca, costoBaseKm); // primera línea: inicializa la parte de Vehiculo
        this.capacidadToneladas = capacidadToneladas;
    }

    // SOBRESCRITURA: 5% extra por cada tonelada de capacidad
    @Override
    public double calcularCostoViaje(double distanciaKm) {
        return (distanciaKm * costoBaseKm) * (1 + capacidadToneladas * 0.05);
    }

    @Override
    public void mostrarFicha() {
        System.out.println("[Vehículo] Camión | Patente: " + patente + " | Marca: " + marca
                + " | Toneladas: " + capacidadToneladas);
    }
}
