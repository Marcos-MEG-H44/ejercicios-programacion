import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        // Lista de números
        List<Integer> numeros = Arrays.asList(
                1,2,3,4,5,6,7,8,9,10,
                11,12,13,14,15,16,17,18,19,20
        );

        // Mostrar lista original
        System.out.println("Lista original: " + numeros);

        // 🔹 Filtrar pares y mayores a 10
        List<Integer> resultado = numeros.stream()
                .filter(n -> n % 2 == 0)   // pares
                .filter(n -> n > 10)       // mayores a 10
                .collect(Collectors.toList());

        System.out.println("Pares mayores a 10: " + resultado);

        // 🔹 Alternativa (todo en un filtro)
        List<Integer> resultado2 = numeros.stream()
                .filter(n -> n % 2 == 0 && n > 10)
                .collect(Collectors.toList());

        System.out.println("Resultado alternativo: " + resultado2);
    }
}

/*Qué es .stream()? Convierte la lista en un flujo de datos para procesar. */

/* “Uso Streams para aplicar un enfoque declarativo, donde 
especifico qué quiero obtener en lugar de cómo recorrer 
la lista, mejorando la legibilidad y mantenibilidad del código.”*/

/* 
¿Qué hace .filter()? 
.filter(n -> n % 2 == 0) Filtra los números pares

.filter(n -> n > 10) Filtra los mayores a 10

¿Qué hace .collect()?
.collect(Collectors.toList()) Convierte el resultado en una nueva lista

Cómo funciona el flujo (importante) 
Lista → Stream → Filter → Filter → Collect → Nueva lista

“Streams introduce programación funcional en Java, permitiendo operaciones 
6635 como filter, map y reduce sobre colecciones.”

*/