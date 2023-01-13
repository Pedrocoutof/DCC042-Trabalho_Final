import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class HandleConnection extends Thread{

    private Socket socket;

    HandleConnection(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println(socket);
        Message msg = new Message("","");
            try {
                ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());

                msg = (Message) inputStream.readObject();
                ControllerClients.addClient(msg.getFrom(), outputStream);

                while(true){
                    msg = (Message) inputStream.readObject();

                    if(msg.getBody().equals("quit")){
                        ControllerClients.sendDisconectMessage(msg);
                        ControllerClients.removeClient(msg.getFrom());
                        socket.close();
                    }

                    if(msg.getTo().equals("ALL")){
                        ControllerClients.sendMessageForAll(msg);
                    }

                    else{
                        ControllerClients.sendWhisperMessage(msg);
                    }
                }

            } catch (IOException e) {
                System.err.println(this.socket + " Desconectou-se");

            } catch (ClassNotFoundException e) {
                System.err.println("Alou 2");
            }

        return;
    }
}
