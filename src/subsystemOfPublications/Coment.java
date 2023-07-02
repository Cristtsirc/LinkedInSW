package subsystemOfPublications;

import java.util.Objects;

public class Coment {
    private String comentOfThePublication;
    public Coment(String comentOfThePublication) {
        this.comentOfThePublication = comentOfThePublication;
    }

    @Override
    public String toString() {
        return comentOfThePublication ;
    }
}
