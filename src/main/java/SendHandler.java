import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class SendHandler extends Thread{

    private ObjectOutputStream outputStream;
    private String name;

    SendHandler(String name, Socket socket) throws IOException {
        this.name = name;
        this.outputStream = new ObjectOutputStream(socket.getOutputStream());
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);

        Message msgConect = new Message(name, "SERVER;CONECTADO");

        try {

            outputStream.writeObject(msgConect);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        while(true){
            Message message = new Message(name, scanner.nextLine());

            try {
                this.outputStream.writeObject(message);
                this.outputStream.flush();

            } catch (IOException e) {
                System.err.println("[SEND-HANDLER] - Não foi possivel enviar a mensagem para o servidor.");
            }


        }
    }
}
