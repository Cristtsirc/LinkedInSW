package subsystemOfComunications;

import subsystemOfProfiles.Profile;

public class Message {
    public String IDMessage;
    private Object contentMessage;
    private Profile receiver;
    private Profile sender;
    static int generator = 1;

    public Message(Object contentMessage, Profile sender, Profile receiver) {
        this.IDMessage = String.valueOf(generator++);
        this.contentMessage = contentMessage;
        this.receiver = receiver;
        this.sender = sender;
    }


    @Override
    public String toString() {

        return "[ ID: " + IDMessage + "| Sender: " + sender + "| Receiver: " + receiver + " Content: " + contentMessage + "]";
    }

    public String getSender() {
        return sender.getName();
    }
}
