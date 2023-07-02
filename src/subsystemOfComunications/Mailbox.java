package subsystemOfComunications;

import subsystemOfProfiles.Profile;

import java.util.ArrayList;
import java.util.Objects;

public class Mailbox {
    ArrayList<Message> receivedMessages = new ArrayList<>();
    ArrayList<Message> sentMessages = new ArrayList<>();

    public Mailbox() {
    }

    public Message readMessage(String ID) {
        for (Message msg : sentMessages) {
            if (Objects.equals(msg.IDMessage, ID)) {
                return msg;
            }
        }
        for (Message msg : receivedMessages) {
            if (Objects.equals(msg.IDMessage, ID)) {
                return msg;
            }
        }
        return null;
    }

    public void sendMessage(Object content, Profile sender, Profile receiver) {
        Message message = new Message(content, sender, receiver);
        sentMessages.add(message);
        receiver.receiveMessage(message);
    }

    public void receiveMessage(Message message) {
        receivedMessages.add(message);
    }

    @Override
    public String toString() {
        String salida = "-------------------------MAILBOX-------------------------\n";
        salida += "Recibidos: \n";
        for (Message mensaje : receivedMessages) {
            salida += "\t\t [ ID: " + mensaje.IDMessage + " | SENDER: " + mensaje.getSender() + " ]\n";
        }
        salida += "\n";
        salida += "Enviados: \n";
        for (Message mensaje : sentMessages) {
            salida += "\t\t [ ID: " + mensaje.IDMessage + " | SENDER: " + mensaje.getSender() + " ]\n";
        }
        return salida;
    }
}
