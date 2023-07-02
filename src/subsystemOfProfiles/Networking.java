package subsystemOfProfiles;

import java.util.ArrayList;

public class Networking {
    public String idNW;
    public String nwDescription;
    public String subject;
    private String nwName;
    static int generador = 1;
    private ArrayList<User> miembros = new ArrayList<>();
    private static ArrayList<Networking> networkings = new ArrayList<>();




    public Networking(String nwName, String nwDescription, String subject) {
        networkings.add(this);
        this.idNW = String.valueOf(generador++);
        this.nwName = nwName;
        this.nwDescription = nwDescription;
        this.subject = subject;
    }

    public static Networking getNWJoined(User user) {
        for (Networking nw : networkings ) {
            if (nw.miembros.contains(user)) {
                return nw;
            }
        }
        return null;
    }

    public String getIdNW() {
        return idNW;
    }

    public void addUser(User usuarioAIngresar) {
        miembros.add(usuarioAIngresar);
    }

    public void deleteUser() {
    }

    @Override
    public String toString() {
        return "[ Nombre: " + nwName + "| La id de la Networking es: " + idNW + "| Descripcion del Netkorwing: " + nwDescription + "| Miembros: " + miembros + "]\n";
    }

    public void addUserToMyNetworking(User usuarioAIngresar) {
        miembros.add(usuarioAIngresar);
    }
}
