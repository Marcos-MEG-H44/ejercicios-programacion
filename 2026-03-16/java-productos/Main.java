import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Clase Producto
class Producto {
    private String nombre;
    private double precio;
    private String categoria;

    // Constructor
    public Producto(String nombre, double precio, String categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getCategoria() {
        return categoria;
    }

    // toString para mostrar el objeto
    @Override
    public String toString() {
        return nombre + " - $" + precio + " (" + categoria + ")";
    }
}

// Clase principal
public class Main {
    public static void main(String[] args) {

        // Crear lista
        List<Producto> productos = new ArrayList<>();

        // Agregar productos
        productos.add(new Producto("Laptop", 999.99, "Electrónica"));
        productos.add(new Producto("Mouse", 25.50, "Accesorios"));
        productos.add(new Producto("Teclado", 75.00, "Accesorios"));
        productos.add(new Producto("Monitor", 299.99, "Electrónica"));

        // 🔹 Mostrar lista original
        System.out.println("Lista original:");
        for (Producto p : productos) {
            System.out.println(p);
        }

        // 🔹 Ordenar por precio (ascendente)
        Collections.sort(productos, Comparator.comparing(Producto::getPrecio));
        System.out.println("\nOrdenado por precio:");
        for (Producto p : productos) {
            System.out.println(p);
        }

        // 🔹 Ordenar por nombre (descendente)
        Collections.sort(productos, Comparator.comparing(Producto::getNombre).reversed());
        System.out.println("\nOrdenado por nombre (descendente):");
        for (Producto p : productos) {
            System.out.println(p);
        }

        // 🔹 Ordenar por categoría y luego precio
        Collections.sort(productos,
                Comparator.comparing(Producto::getCategoria)
                          .thenComparing(Producto::getPrecio));
        System.out.println("\nOrdenado por categoría y precio:");
        for (Producto p : productos) {
            System.out.println(p);
        }
    }
}



// Primero creo una clase Producto con atributos privados (encapsulamiento).
// Luego uso una lista (ArrayList) para almacenar objetos.
// Finalmente uso Comparator con Collections.sort() para ordenar de distintas formas sin modificar la clase.