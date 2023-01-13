import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ReciveHandler extends Thread{
    private ObjectInputStream input;

    ReciveHandler(Socket socket) throws IOException {
        this.input = new ObjectInputStream(socket.getInputStream());
    }

    @Override
    public void run() {


        while(true){
            try {

                Message msg = (Message) input.readObject();
                System.out.println("[" + msg.getFrom() +"] - " + msg.getBody());

            } catch (IOException e) {
                System.err.println("Voce foi desconectado com sucesso!");
                return;

            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
