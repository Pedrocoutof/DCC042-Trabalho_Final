import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int porta = 4444;
        try {
            ServerSocket serverSocket = new ServerSocket(porta);
            System.out.println("Servidor iniciado na porta: " + porta);

            while (true){
                Socket client = serverSocket.accept();
                HandleConnection handleConnection = new HandleConnection(client);
                handleConnection.start();
            }



        } catch (IOException e) {
            System.err.println("Não foi possível inicializar o servidor");
        }
    }
}
