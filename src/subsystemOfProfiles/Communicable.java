package subsystemOfProfiles;

import subsystemOfComunications.Message;

public interface Communicable {
    void sendMessage(String content, String IDreceiver);
    Message readMessage(String ID);

}
