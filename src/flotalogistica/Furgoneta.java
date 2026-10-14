package flotalogistica;

public class Furgoneta extends Vehiculo {

    private static final double RECARGO_REFRIGERACION = 5000.0;

    private boolean tieneRefrigeracion;

    public Furgoneta(String patente, String marca, double costoBaseKm, boolean tieneRefrigeracion) {
        super(patente, marca, costoBaseKm);
        this.tieneRefrigeracion = tieneRefrigeracion;
    }

    // SOBRESCRITURA: recargo fijo de $5000 si tiene refrigeración
    @Override
    public double calcularCostoViaje(double distanciaKm) {
        double costo = distanciaKm * costoBaseKm;
        if (tieneRefrigeracion) {
            costo += RECARGO_REFRIGERACION;
        }
        return costo;
    }

    @Override
    public void mostrarFicha() {
        System.out.println("[Vehículo] Furgoneta | Patente: " + patente + " | Marca: " + marca
                + " | Refrigerado: " + (tieneRefrigeracion ? "Sí" : "No"));
    }
}
