import java.util.*;
import java.util.stream.Collectors;

// Clase Evento
class Evento {
    private String nombre;
    private String categoria;
    private HashSet<String> participantes;

    public Evento(String nombre, String categoria) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.participantes = new HashSet<>();
    }

    // Agregar participante (HashSet evita duplicados)
    public void agregarParticipante(String dni) {
        participantes.add(dni);
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public HashSet<String> getParticipantes() {
        return participantes;
    }

    @Override
    public String toString() {
        return nombre + " (" + categoria + ") - Participantes: " + participantes.size();
    }
}

// Sistema de gestión
class SistemaEventos {
    private HashMap<String, Evento> eventos;

    public SistemaEventos() {
        eventos = new HashMap<>();
    }

    // Agregar evento
    public void agregarEvento(Evento evento) {
        eventos.put(evento.getNombre(), evento);
    }

    // Obtener evento
    public Evento obtenerEvento(String nombre) {
        return eventos.get(nombre);
    }

    // Listar eventos
    public void listarEventos() {
        eventos.values().forEach(System.out::println);
    }

    // 🔹 Total de participantes únicos en todos los eventos
    public long totalParticipantesUnicos() {
        return eventos.values().stream()
                .flatMap(e -> e.getParticipantes().stream())
                .distinct()
                .count();
    }

    // 🔹 Eventos por categoría
    public Map<String, Long> eventosPorCategoria() {
        return eventos.values().stream()
                .collect(Collectors.groupingBy(
                        Evento::getCategoria,
                        Collectors.counting()
                ));
    }

    // 🔹 Evento con más participantes
    public Optional<Evento> eventoConMasParticipantes() {
        return eventos.values().stream()
                .max(Comparator.comparing(e -> e.getParticipantes().size()));
    }
}

// Clase principal
public class Main {
    public static void main(String[] args) {

        SistemaEventos sistema = new SistemaEventos();

        // Crear eventos
        Evento e1 = new Evento("TechFest", "Tecnología");
        Evento e2 = new Evento("MusicLive", "Música");
        Evento e3 = new Evento("CodeDay", "Tecnología");

        // Agregar participantes
        e1.agregarParticipante("111");
        e1.agregarParticipante("222");
        e1.agregarParticipante("333");

        e2.agregarParticipante("222");
        e2.agregarParticipante("444");

        e3.agregarParticipante("111");
        e3.agregarParticipante("555");
        e3.agregarParticipante("666");
        e3.agregarParticipante("777");

        // Agregar eventos al sistema
        sistema.agregarEvento(e1);
        sistema.agregarEvento(e2);
        sistema.agregarEvento(e3);

        // Mostrar eventos
        System.out.println("Eventos:");
        sistema.listarEventos();

        // 🔹 Total participantes únicos
        System.out.println("\nTotal participantes únicos:");
        System.out.println(sistema.totalParticipantesUnicos());

        // 🔹 Eventos por categoría
        System.out.println("\nEventos por categoría:");
        System.out.println(sistema.eventosPorCategoria());

        // 🔹 Evento con más participantes
        System.out.println("\nEvento con más participantes:");
        sistema.eventoConMasParticipantes()
                .ifPresent(System.out::println);
    }
}