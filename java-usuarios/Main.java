import java.util.HashMap;
import java.util.Map;

// Clase Usuario
class Usuario {
    private String dni;
    private String nombre;
    private String email;
    private String telefono;

    // Constructor
    public Usuario(String dni, String nombre, String email, String telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    // Getters
    public String getDni() { return dni; }
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public String getTelefono() { return telefono; }

    // toString
    @Override
    public String toString() {
        return "DNI: " + dni + " | Nombre: " + nombre + " | Email: " + email + " | Teléfono: " + telefono;
    }
}

// Sistema de gestión
class SistemaUsuarios {
    private HashMap<String, Usuario> usuarios;

    public SistemaUsuarios() {
        usuarios = new HashMap<>();
    }

    // Agregar usuario
    public void agregarUsuario(Usuario usuario) {
        usuarios.put(usuario.getDni(), usuario);
    }

    // Buscar usuario por DNI
    public Usuario buscarPorDni(String dni) {
        return usuarios.get(dni);
    }

    // Actualizar usuario
    public boolean actualizarUsuario(String dni, Usuario usuarioActualizado) {
        if (usuarios.containsKey(dni)) {
            usuarios.put(dni, usuarioActualizado);
            return true;
        }
        return false;
    }

    // Eliminar usuario
    public boolean eliminarUsuario(String dni) {
        return usuarios.remove(dni) != null;
    }

    // Listar usuarios
    public void listarUsuarios() {
        for (Map.Entry<String, Usuario> entry : usuarios.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}

// Clase principal
public class Main {
    public static void main(String[] args) {

        SistemaUsuarios sistema = new SistemaUsuarios();

        // Agregar usuarios
        sistema.agregarUsuario(new Usuario("12345678", "Juan Pérez", "juan@email.com", "111222333"));
        sistema.agregarUsuario(new Usuario("87654321", "María García", "maria@email.com", "999888777"));

        // Listar
        System.out.println("Lista de usuarios:");
        sistema.listarUsuarios();

        // Buscar
        System.out.println("\nBuscando usuario...");
        Usuario encontrado = sistema.buscarPorDni("12345678");

        if (encontrado != null) {
            System.out.println("Usuario encontrado: " + encontrado);
        } else {
            System.out.println("Usuario no encontrado");
        }

        // Actualizar
        System.out.println("\nActualizando usuario...");
        sistema.actualizarUsuario("12345678",
                new Usuario("12345678", "Juan Actualizado", "nuevo@email.com", "000000000"));

        sistema.listarUsuarios();

        // Eliminar
        System.out.println("\nEliminando usuario...");
        sistema.eliminarUsuario("87654321");

        sistema.listarUsuarios();
    }
}

/*¿Por qué usamos HashMap? Porque permite: Buscar por clave (DNI) rápidamente
Evitar duplicados Acceso directo 
Frase clave: “Uso un HashMap donde el DNI
 es la clave única, lo que permite búsquedas eficientes en tiempo constante.” */

 /*¿Qué hace cada método?
put() → agrega o reemplaza
get() → busca
containsKey() → verifica existencia
remove() → elimina */

/* “Este sistema utiliza un HashMap para indexar usuarios por DNI, permitiendo 
operaciones eficientes de búsqueda, actualización y eliminación 
sin necesidad de recorrer estructuras completas.”*/