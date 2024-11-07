import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ClienteUDP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String respuesta;
        int correctas = 0; // Contador de respuestas correctas
        StringBuilder resultados = new StringBuilder(); // Usamos StringBuilder para acumular las respuestas

        // Pregunta 1
        System.out.println("¿Cuál es el río más largo del mundo?");
        System.out.println("a) Nilo");
        System.out.println("b) Amazonas");
        System.out.println("c) Yangtsé");
        respuesta = scanner.nextLine();
        if (respuesta.equalsIgnoreCase("b")) {
            correctas++;
        } else {
            resultados.append("Pregunta 1: Incorrecto! La respuesta correcta es: b) Amazonas\n");
        }

        // Pregunta 2
        System.out.println("¿Cuál es el océano más grande del mundo?");
        System.out.println("a) Atlántico");
        System.out.println("b) Índico");
        System.out.println("c) Pacífico");
        respuesta = scanner.nextLine();
        if (respuesta.equalsIgnoreCase("c")) {
            correctas++;
        } else {
            resultados.append("Pregunta 2: Incorrecto! La respuesta correcta es: c) Pacífico\n");
        }

        // Pregunta 3
        System.out.println("¿Cuál es el planeta más cercano al sol?");
        System.out.println("a) Venus");
        System.out.println("b) Mercurio");
        System.out.println("c) Marte");
        respuesta = scanner.nextLine();
        if (respuesta.equalsIgnoreCase("b")) {
            correctas++;
        } else {
            resultados.append("Pregunta 3: Incorrecto! La respuesta correcta es: b) Mercurio\n");
        }

        // Pregunta 4
        System.out.println("¿Quién escribió 'Cien años de soledad'?");
        System.out.println("a) Gabriel García Márquez");
        System.out.println("b) Mario Vargas Llosa");
        System.out.println("c) Julio Cortázar");
        respuesta = scanner.nextLine();
        if (respuesta.equalsIgnoreCase("a")) {
            correctas++;
        } else {
            resultados.append("Pregunta 4: Incorrecto! La respuesta correcta es: a) Gabriel García Márquez\n");
        }

        // Pregunta 5
        System.out.println("¿Cuál es el idioma oficial de Brasil?");
        System.out.println("a) Español");
        System.out.println("b) Inglés");
        System.out.println("c) Portugués");
        respuesta = scanner.nextLine();
        if (respuesta.equalsIgnoreCase("c")) {
            correctas++;
        } else {
            resultados.append("Pregunta 5: Incorrecto! La respuesta correcta es: c) Portugués\n");
        }

        // Resultado en consola
        System.out.println("\nFin del cuestionario");
        System.out.println("Respuestas correctas: " + correctas);
        System.out.println("Respuestas incorrectas: " + (5 - correctas));

        // Mostrar si el usuario aprobó o no (al menos 3 respuestas correctas)
        if (correctas >= 3) {
            System.out.println("¡Felicidades, aprobaste el cuestionario!");
        } else {
            System.out.println("Lo siento, no aprobaste el cuestionario.");
        }

        // Guardar los resultados en un archivo de texto
        resultados.append("\nRespuestas correctas: ").append(correctas).append("\n");
        resultados.append("Respuestas incorrectas: ").append(5 - correctas).append("\n");
        if (correctas >= 3) {
            resultados.append("¡Felicidades, aprobaste el cuestionario!\n");
        } else {
            resultados.append("Lo siento, no aprobaste el cuestionario.\n");
        }

        // Guardar el archivo
        try {
            File archivo = new File("resultados_cuestionario.txt");
            if (archivo.createNewFile()) {
                System.out.println("Archivo creado: " + archivo.getName());
            } else {
                System.out.println("El archivo ya existe.");
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(archivo));
            writer.write(resultados.toString());
            writer.close();
            System.out.println("Los resultados han sido guardados en 'resultados_cuestionario.txt'");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al guardar el archivo: " + e.getMessage());
        }

        scanner.close();
    }
}
