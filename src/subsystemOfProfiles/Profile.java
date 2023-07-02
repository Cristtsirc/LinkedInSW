package subsystemOfProfiles;

import subsystemOfComunications.Message;
import subsystemOfPublications.Coment;
import subsystemOfPublications.Feed;
import subsystemOfPublications.Publication;
import subsystemOfPublications.Reactions;
import subsystemOfSearch.Search;
import subsystemOfComunications.Mailbox;

import java.util.ArrayList;
import java.util.Objects;

public class Profile implements Communicable, Publishable {
    public String IDProfile;
    private Mailbox mailBox = new Mailbox();
    ArrayList<Search> searches = new ArrayList<>();
    private Feed feed = new Feed();
    private String name;
    static int generatorP = 1;

    static ArrayList<Profile> profiles = new ArrayList<>();
    public Profile(String name) {
        this.name = name;
        this.IDProfile = String.valueOf(generatorP++);

    }

    public Mailbox showMailbox() {
        return mailBox;
    }

    public Feed showFeed() {
        return feed;
    }


    public void sendMessage(String content, String IDreceiver) {
        getProfileFromID(IDreceiver);
        mailBox.sendMessage(content, this, getProfileFromID(IDreceiver));
    }

    private Profile getProfileFromID(String IDreceiver) {
        for (Profile profile : profiles) {
             if (profile.getID().equals(IDreceiver)) {
                return profile;
            }
        }
        return null;
    }

    public void receiveMessage(Message message) {
        mailBox.receiveMessage(message);
    }

    public void createPublication(Object content) {
        this.feed.createPublication(content);
    }

    public void editPublication(String id, String editedContent) {
        this.feed.editPublication(id, editedContent);
    }

    public void removePublication(String id) {
        this.feed.removePublication(id);
    }


    public Message readMessage(String ID) {
        return mailBox.readMessage(ID);
    }

    public void comentToPublication(String idPublication, String coment) {
        Coment cmt = new Coment(coment);
        feed.addComentToPublication(idPublication, cmt);
    }

    public void reactToPublication(Reactions reactionChoised, String publicationID) {
        switch (reactionChoised) {
            case LIKE -> sendReactionIndex(publicationID, 0);
            case LOVE -> sendReactionIndex(publicationID, 1);
            case INTERESTED -> sendReactionIndex(publicationID, 2);
            case DISLIKE -> sendReactionIndex(publicationID, 3);
        }
    }

    public void sendReactionIndex(String publicationID, int reactionID) {
        for (Publication publication : feed.getPublications()) { //TODO: funciona??
            if (Objects.equals(publicationID, publication.idPublication)) {
                publication.increaseNumberReactions(reactionID);
            }
        }
    }

    public String getName() {
        return name;
    }

    public String getID() {
        return IDProfile;
    }
}

