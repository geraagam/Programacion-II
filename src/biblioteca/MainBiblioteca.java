package biblioteca;

public class MainBiblioteca {

    public static void main(String[] args) {

        Libro libro1 = new Libro("Clean Code", "Robert C. Martin", "9780132350884");

        Libro libro2 = new Libro("Efectivo con Java", "Ana Restrepo", "9781234567897", 3, 22000.0);
        Libro libro3 = new Libro("Cien Años de Soledad", "Gabriel García Márquez", "9780307474728", 2, 18500.0);

        // new Libro(); // no compila: al declarar constructores propios,
        // el constructor sin parámetros que regalaba el compilador ya no existe.

        Libro libroInvalido = new Libro("   ", "Camila Duarte", "9789871234567", -5, 0.0);
        System.out.println("Verificación con getTitulo(): \"" + libroInvalido.getTitulo() + "\"");
        System.out.println("Verificación con getCopiasDisponibles(): " + libroInvalido.getCopiasDisponibles());
        System.out.println("Verificación con getPrecioReposicion(): $" + libroInvalido.getPrecioReposicion());

        double precioAnterior = libro1.getPrecioReposicion();
        boolean aceptado = libro1.setPrecioReposicion(-100.0);
        System.out.println("¿Se aceptó el precio -100.0? " + aceptado + " (se mantiene el precio anterior)");
        System.out.println("getPrecioReposicion() sigue devolviendo $" + libro1.getPrecioReposicion()
                + " (antes: $" + precioAnterior + ")");
        System.out.println();

        libro1.mostrarFicha();
        libro2.mostrarFicha();
        libro3.mostrarFicha();

        boolean primerPrestamo = libro1.prestar();
        System.out.println("¿Se pudo prestar \"" + libro1.getTitulo() + "\"? " + primerPrestamo);

        boolean segundoPrestamo = libro1.prestar();
        System.out.println("¿Se pudo prestar de nuevo? " + segundoPrestamo);

        System.out.println("Copias tras el préstamo rechazado: " + libro1.getCopiasDisponibles()
                + " (nunca queda en negativo)");

        libro1.devolver();

        precioAnterior = libro1.getPrecioReposicion();
        if (libro1.setPrecioReposicion(18000.0)) {
            System.out.println("Precio de reposición actualizado de \"" + libro1.getTitulo() + "\": $"
                    + precioAnterior + " -> $" + libro1.getPrecioReposicion());
        }

        System.out.println("Intentos de préstamo de \"" + libro1.getTitulo() + "\": "
                + libro1.getPrestamosHistoricos() + " (aceptados o no)");

        System.out.println("Copias de \"" + libro2.getTitulo() + "\": " + libro2.getCopiasDisponibles());
        System.out.println("Copias de \"" + libro3.getTitulo() + "\": " + libro3.getCopiasDisponibles());
    }
}
