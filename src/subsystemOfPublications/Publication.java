package subsystemOfPublications;


import java.time.LocalDate;
import java.util.ArrayList;

public class Publication {
    private static int counter = 0;
    public String idPublication;
    int[] numberReactions = {0, 0, 0, 0};
    private ArrayList<Coment> coments = new ArrayList<>();
    private LocalDate publicationDate;
    private Object content;

    public Publication(Object content, LocalDate publicationDate) {
        this.content = content;
        this.publicationDate = publicationDate;
        idPublication = String.valueOf(counter++);
    }

    public void increaseNumberReactions(int reactionsID) {
        numberReactions[reactionsID]++;
    }

    @Override
    public String toString() {
        return "[ ID: " + idPublication + " | Fecha de publicacion: " + publicationDate + "| Contenido: " + content + " | Reacciones: " + " (Like: " + numberReactions[0] + ") (Love: " + numberReactions[1] + ") (Interested: " + numberReactions[2] + ") (Dislike: " + numberReactions[3] + ") (Comentarios: " + coments + ") ]";
    }

    public void addComent(Coment coment) {
        coments.add(coment);
    }

    public void setContent(Object content){
        this.content = content;
    }
}
