import java.io.Serializable;

public class Message implements Serializable {
    private String from;
    private String to;
    private String body;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Message(String name, String to_body){
        this.from = name;

        // Se for para todos
        if(to_body.split(";").length == 1){
            //System.out.println("Mensagem para todos");
            to = "ALL";
            body = to_body;
        }

        // Caso contrario
        else{
            to = to_body.split(";")[0];
            body = to_body.split(";")[1];
        }
    }
}
