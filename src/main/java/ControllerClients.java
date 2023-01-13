import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ControllerClients {
    private static Map<String, ObjectOutputStream> onlineClients = new HashMap<>();

    public static void addClient(String name, ObjectOutputStream outputStream){
        onlineClients.put(name, outputStream);
    }

    public static void removeClient(String name){
        onlineClients.remove(name);
    }

    public static Map<String, ObjectOutputStream> getOnlineClients() {
        return onlineClients;
    }

    public static void sendMessageForAll(Message message){
            onlineClients
                .forEach((s, outputStream) -> {
                    if(!message.getFrom().equals(s))
                        try {
                            outputStream.writeObject(message);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                });
    }

    public static void sendWhisperMessage(Message message) throws IOException {

        if(onlineClients.containsKey(message.getTo())){
            message.setFrom( message.getFrom() + " sussurou");
            onlineClients.get(message.getTo()).writeObject(message);
        };
    }

    public static void sendDisconectMessage(Message message) throws IOException {
        Message msgDisconect = new Message("SERVER", message.getFrom() + " Desconectou-se");
        onlineClients
                .forEach((s, outputStream) -> {
                        try {
                            outputStream.writeObject(msgDisconect);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                });
    }
}
