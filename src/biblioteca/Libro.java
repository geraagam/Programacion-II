package biblioteca;

// Se declara final porque no está pensada para extenderse: una subclase podría
// sobrescribir prestar() o setPrecioReposicion() y saltearse las validaciones
// que garantizan que un Libro nunca quede con datos inválidos.

public final class Libro {

    private static final String TITULO_POR_DEFECTO = "Sin título";
    private static final String AUTOR_POR_DEFECTO = "Autor desconocido";
    private static final String ISBN_POR_DEFECTO = "ISBN pendiente";
    private static final int COPIAS_POR_DEFECTO = 0;
    private static final double PRECIO_POR_DEFECTO = 15000.0;

    private final String titulo;
    private final String autor;
    private final String isbn;
    private int copiasDisponibles;
    private double precioReposicion;

    private int prestamosHistoricos;

    public Libro(String titulo, String autor, String isbn, int copiasDisponibles, double precioReposicion) {
        this.titulo = textoValidoOPorDefecto(titulo, TITULO_POR_DEFECTO, "Título");
        this.autor = textoValidoOPorDefecto(autor, AUTOR_POR_DEFECTO, "Autor");
        this.isbn = textoValidoOPorDefecto(isbn, ISBN_POR_DEFECTO, "ISBN");

        if (copiasDisponibles < 0) {
            System.out.println("Copias disponibles inválidas (" + copiasDisponibles
                    + "): no puede ser negativo. Se usó " + COPIAS_POR_DEFECTO + " por defecto.");
            this.copiasDisponibles = COPIAS_POR_DEFECTO;
        } else {
            this.copiasDisponibles = copiasDisponibles;
        }

        this.precioReposicion = PRECIO_POR_DEFECTO;
        if (!setPrecioReposicion(precioReposicion)) {
            System.out.println("Precio de reposición inválido (" + precioReposicion
                    + "): debe ser mayor a 0. Se usó $" + PRECIO_POR_DEFECTO + " por defecto.");
        }

        this.prestamosHistoricos = 0;
    }

    public Libro(String titulo, String autor, String isbn) {
        this(titulo, autor, isbn, 1, PRECIO_POR_DEFECTO);
    }

    private static boolean esTextoValido(String valor) {
        return valor != null && !valor.isBlank();
    }

    private static String textoValidoOPorDefecto(String valor, String porDefecto, String campo) {
        if (esTextoValido(valor)) {
            return valor;
        }
        System.out.println(campo + " inválido, se usó \"" + porDefecto + "\" por defecto.");
        return porDefecto;
    }

    private static boolean esPrecioValido(double precio) {
        return precio > 0;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getCopiasDisponibles() {
        return copiasDisponibles;
    }

    public double getPrecioReposicion() {
        return precioReposicion;
    }

    public int getPrestamosHistoricos() {
        return prestamosHistoricos;
    }

    public boolean setPrecioReposicion(double precio) {
        if (!esPrecioValido(precio)) {
            return false;
        }
        this.precioReposicion = precio;
        return true;
    }

    public boolean prestar() {
        prestamosHistoricos++;
        if (copiasDisponibles <= 0) {
            System.out.println("Error: no hay copias disponibles de \"" + titulo + "\" para prestar.");
            return false;
        }
        copiasDisponibles--;
        System.out.println("Préstamo registrado: \"" + titulo + "\". Copias disponibles: " + copiasDisponibles);
        return true;
    }

    public void devolver() {
        copiasDisponibles++;
        System.out.println("Devolución registrada: \"" + titulo + "\". Copias disponibles: " + copiasDisponibles);
    }

    public void mostrarFicha() {
        System.out.println("Ficha de libro");
        System.out.println("Título:  " + titulo);
        System.out.println("Autor:   " + autor);
        System.out.println("ISBN:    " + isbn);
        System.out.println("Copias disponibles: " + copiasDisponibles);
        System.out.println("Precio de reposición: $" + precioReposicion);
        System.out.println();
    }
}
