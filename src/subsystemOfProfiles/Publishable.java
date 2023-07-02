package subsystemOfProfiles;

import subsystemOfPublications.Reactions;

public interface Publishable {

     void reactToPublication(Reactions reactionChoised, String publicationID);
     void comentToPublication(String idPublication, String coment);
     void createPublication(Object content);
     void editPublication(String id, String editedContent);
     void removePublication(String id);

}
