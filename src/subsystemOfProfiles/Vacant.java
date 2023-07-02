package subsystemOfProfiles;

import java.util.ArrayList;
import java.util.Date;

public class Vacant {
    private String idVacant;
    private String jobTitle;
    private String description;
    static int count = 0;
    static ArrayList<Vacant> allVacants = new ArrayList<>();
    private Enterprise owner;


    public Vacant(String jobTitle, String description, Enterprise owner) {
        this.owner = owner;
        this.idVacant = String.valueOf(count++);
        this.jobTitle = jobTitle;
        this.description = description;
        allVacants.add(this);
    }

    public static ArrayList<Vacant> getAllVacants() {
        return allVacants;
    }

    public String getCampo(String fieldToSearch) {
        switch (fieldToSearch) {
            case "jobTitle":
                return this.jobTitle;
            case "description":
                return this.description;
        }
        return null;
    }

    @Override
    public String toString() {
        String salida = "-----------------Vacantes--------------\n";
        return salida + "[ Nombre: " + jobTitle+  ") (ID: " + idVacant + ") (Descripcion: " + description + ")] " +
                "DE LA EMPRESA: [Nombre:" + owner.getName() + " | ID: "+ owner.getID() +" ]";
    }
}