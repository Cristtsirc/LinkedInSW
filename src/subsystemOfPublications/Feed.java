package subsystemOfPublications;

import subsystemOfComunications.Message;
import subsystemOfProfiles.Networking;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Objects;

public class Feed {
    private ArrayList<Publication> publications;

    public Feed() {
        publications = new ArrayList<>();
    }

    public void createPublication(Object content) {
        publications.add(new Publication(content, LocalDate.now()));
    }

    public void editPublication(String id, String editedContent) {
        for (Publication publication : publications) {
            if (Objects.equals(publication.idPublication, id)) {
                publication.setContent(editedContent);
            }
        }
    }

    public void removePublication(String id) {
        for (Publication publication : publications) {
            if (Objects.equals(publication.idPublication, id)) {
                publications.remove(Integer.parseInt(id));
                return;
            }
        }
        System.out.println("No exite la publicacion con ID: " + id);
    }

    @Override
    public String toString() {
        String salida = "-------------------FEED------------------------\n";

        for (Publication publication : publications) {
            salida += publication + "\n";
        }

        return salida;
    }

    public void addComentToPublication(String idPublication, Coment coment) {
        for (Publication pub : publications) {
            if (Objects.equals(idPublication, pub.idPublication)) {
                pub.addComent(coment);
            }
            break;
        }
    }

    public ArrayList<Publication> getPublications() {
        return publications;
    }

}
