package subsystemOfProfiles;
import subsystemOfSearch.Search;
import subsystemOfSearch.VACANCYFITLER;
import java.util.ArrayList;
import java.util.Objects;

public class User extends Profile {
    private ArrayList<Networking> networkings= new ArrayList<>();
    // TODO: public ArrayList<User> users= new ArrayList<>();
    private String firstName;
    private String universityDegree;
    private String cellphoneNumber;
    private String country;
    private String email;
    private String lastName;
    static ArrayList<User> allUsers = new ArrayList<>();

    public User(String firstName, String lastName, String universityDegree, String cellphoneNumber, String country, String email) {
        super(firstName);
        this.lastName = lastName;
        this.firstName = firstName;
        this.universityDegree = universityDegree;
        this.cellphoneNumber = cellphoneNumber;
        this.country = country;
        this.email = email;
        allUsers.add(this);
        profiles.add(this);
    }

    public static ArrayList<User> getAllVacants() {
        return allUsers;
    }

    public void createNetworking(String nameOfNetworking, String description, String subject) {
        //TODO: HAY QUE PEDIR DATOS XD
        Networking nw = new Networking(nameOfNetworking, description, subject);
        networkings.add(nw);
        nw.addUserToMyNetworking(this);
    }


    public String showNW() {
        String salida = "-------------------------NETWORKINGS CREADAS-------------------------\n";
        for (Networking network : networkings) {
            salida += network;
        }
        salida += "-------------------------NETWORKINGS A LAS QUE PERTENECES-------------------------\n";
        salida += Networking.getNWJoined(this);
        return salida;
    }

    @Override
    public void createPublication(Object publication) {
        super.createPublication(publication);
    }

    @Override
    public String toString() {
        return "[ Nombre: "+firstName + ", ID:  "+ IDProfile + " ]";
    }

    public void addUserToMyNetworking(String idNW, String IDuserToJoin) {
        User userToJoin = getUser(IDuserToJoin);
        for (Networking nw : networkings) {
            if (Objects.equals(nw.idNW, idNW)) {
                nw.addUserToMyNetworking(userToJoin);
            }
        }
    }

    private User getUser(String IDuserToJoin) {
        for (User user: allUsers ) {
            if (user.getID().equals(IDuserToJoin)) {
                return user;
            }
        }
        return null;
    }

    public ArrayList<Vacant> searchVacant(VACANCYFITLER filter, String keyword) {
        Search search = new Search();
        searches.add(search);
        return search.searchVacant(filter, keyword);
    }

    public String getCampo(String fieldToSearch) {
        switch (fieldToSearch) {
            case "universityDegree":
                return this.universityDegree;
            case "country":
                return this.country;
        }
        return null;
    }

}