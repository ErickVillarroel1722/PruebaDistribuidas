import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ServidorUDP {
    private static final int PUERTO = 5000;
    private static final String LOG_FILE = "respuestas.txt"; 

    public static void main(String[] args) {
        List<Pregunta> preguntas = new ArrayList<>();
        preguntas.add(new Pregunta("¿Cuál es el río más largo del mundo?", "a) Nilo", "b) Amazonas", "c) Yangtsé", 'b'));
        preguntas.add(new Pregunta("¿Cuál es el océano más grande del mundo?", "a) Atlántico", "b) Índico", "c) Pacífico", 'c'));
        preguntas.add(new Pregunta("¿Cuál es el planeta más cercano al sol?", "a) Venus", "b) Mercurio", "c) Marte", 'b'));
        preguntas.add(new Pregunta("¿Quién escribió 'Cien años de soledad'?", "a) Gabriel García Márquez", "b) Mario Vargas Llosa", "c) Julio Cortázar", 'a'));
        preguntas.add(new Pregunta("¿Cuál es el idioma oficial de Brasil?", "a) Español", "b) Inglés", "c) Portugués", 'c'));

        try (DatagramSocket socket = new DatagramSocket(PUERTO)) {
            System.out.println("Servidor UDP iniciado en el puerto " + PUERTO);

            while (true) {
                byte[] buffer = new byte[1024];
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                InetAddress clientAddress = packet.getAddress();
                int clientPort = packet.getPort();
                System.out.println("Cliente conectado desde " + clientAddress + ":" + clientPort);

                
                new HiloClienteUDP(socket, clientAddress, clientPort, preguntas).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void escribirEnLog(String respuesta, String ip) {
        try (PrintWriter out = new PrintWriter(new FileWriter(LOG_FILE, true))) {
            String fecha = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            out.println("Fecha: " + fecha + ", IP: " + ip + ", Respuesta: " + respuesta);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
