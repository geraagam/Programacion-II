package gestioninventario;

public class MainInventario {

    public static void main(String[] args) {

        // ===== 1. Instanciación: tres objetos independientes con new =====
        Producto productoUno = new Producto();
        productoUno.codigo = "P-001";
        productoUno.nombre = "Teclado mecánico";
        productoUno.precio = 45000.0;
        productoUno.stock = 12;

        Producto productoDos = new Producto();
        productoDos.codigo = "P-002";
        productoDos.nombre = "Mouse inalámbrico";
        productoDos.precio = 18500.0;
        productoDos.stock = 30;

        Producto productoTres = new Producto();
        productoTres.codigo = "P-003";
        productoTres.nombre = "Monitor 24 pulgadas";
        productoTres.precio = 210000.0;
        productoTres.stock = 5;

        // ===== 2. Métodos sobre productoUno (casos válidos primero) =====
        System.out.println("----- Operaciones sobre productoUno -----");
        productoUno.mostrarFicha();
        productoUno.venderUnidades(3);          // válida
        productoUno.venderUnidades(50);         // error: stock insuficiente
        productoUno.reponerStock(20);           // válida
        productoUno.actualizarPrecio(39900.0);  // usa this.precio

        // ===== 3. Casos de error: cantidades cero o negativas =====
        System.out.println();
        System.out.println("----- Casos de error -----");
        productoUno.venderUnidades(0);
        productoUno.venderUnidades(-4);
        productoUno.reponerStock(0);
        productoUno.reponerStock(-10);

        // ===== 4. Independencia de los objetos =====
        System.out.println();
        System.out.println("----- Independencia de los objetos -----");
        System.out.println("productoUno se modificó varias veces, pero los otros objetos");
        System.out.println("conservan sus valores originales:");
        productoDos.mostrarFicha();
        productoTres.mostrarFicha();

        System.out.println("Ahora se modifican productoDos y productoTres:");
        productoDos.venderUnidades(10);
        productoTres.reponerStock(3);
        System.out.println("productoUno sigue igual -> stock: " + productoUno.stock
                + ", precio: $" + productoUno.precio);

        // ===== 5. Referencias: alias vs. objeto nuevo =====
        System.out.println();
        System.out.println("----- Referencias: alias vs. objeto nuevo -----");

        // Copiar la referencia NO crea un objeto: ambas variables apuntan al mismo lugar del Heap
        Producto copia = productoUno;
        System.out.println("Stock de productoUno antes de modificar copia: " + productoUno.stock);
        copia.stock = 35;
        System.out.println("Stock de productoUno tras modificar copia: " + productoUno.stock
                + " (mismo objeto en el Heap)");
        System.out.println("¿copia == productoUno? " + (copia == productoUno));

        // Con new SÍ se crea un objeto nuevo, aunque tenga los mismos datos
        Producto otroTeclado = new Producto();
        otroTeclado.codigo = productoUno.codigo;
        otroTeclado.nombre = productoUno.nombre;
        otroTeclado.precio = productoUno.precio;
        otroTeclado.stock = productoUno.stock;
        otroTeclado.venderUnidades(5);
        System.out.println("Stock de otroTeclado: " + otroTeclado.stock
                + " | Stock de productoUno: " + productoUno.stock + " (objetos distintos)");
        System.out.println("¿otroTeclado == productoUno? " + (otroTeclado == productoUno));

        // ===== 6. Desafíos de extensión =====
        System.out.println();
        System.out.println("----- Desafío: aplicarDescuento -----");
        productoDos.aplicarDescuento(10);    // válido
        productoDos.aplicarDescuento(150);   // error: mayor a 100
        productoDos.aplicarDescuento(-5);    // error: negativo

        System.out.println();
        System.out.println("----- Desafío: inventario recorrido con un arreglo -----");
        Producto[] inventario = {productoUno, productoDos, productoTres};
        for (int i = 0; i < inventario.length; i++) {
            inventario[i].mostrarFicha();
        }
    }
}
