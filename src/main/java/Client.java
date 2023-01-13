import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {

        System.out.println("Digite o seu nome:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        try {
            Socket socket = new Socket("localhost", 4444);

            SendHandler sendHandler = new SendHandler(name, socket);
            ReciveHandler reciveHandler = new ReciveHandler(socket);

            sendHandler.start();
            reciveHandler.start();

        } catch (IOException e) {
            System.err.println("[CLIENTE] - Nao foi possivel se conectar com o servidor.");
        }


    }
}
