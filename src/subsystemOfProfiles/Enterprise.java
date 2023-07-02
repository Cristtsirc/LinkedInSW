package subsystemOfProfiles;

import subsystemOfSearch.APPLICANTFILTER;
import subsystemOfSearch.Search;

import java.util.ArrayList;

public class Enterprise extends Profile {
    private ArrayList<Vacant> vacants;
    private String name;
    private String industryType;
    private String website;
    private String ubication;
    private String establishmentDate;
    private String description;

    public Enterprise(String name, String industryType, String website, String ubication, String establishmentDate, String description) {
        super(name);
        this.vacants = new ArrayList<>();
        this.name = name;
        this.industryType = industryType;
        this.website = website;
        this.ubication = ubication;
        this.establishmentDate = establishmentDate;
        this.description = description;
        profiles.add(this);
    }

    public ArrayList<User> searchPersonal(APPLICANTFILTER filter, String keyword) {
        Search search = new Search();
        searches.add(search);
        return search.searchPersonal(filter, keyword);
    }

    public void publicateVacant(String jobTitle,String description) {
        Vacant vacant = new Vacant(jobTitle, description, this);
        vacants.add(vacant);
        this.createPublication(vacant);
    }


    @Override
    public String toString() {
        return "[ Nombre: "+name + ", ID:  "+ this.IDProfile + " ]";
    }
}
