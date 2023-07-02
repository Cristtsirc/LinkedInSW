package subsystemOfSearch;

import subsystemOfProfiles.User;
import subsystemOfProfiles.Vacant;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Scanner;

public class Search {
    public String keyword;
    public ArrayList<Object> listRecoveredOfObjs;

    public Search() {
        listRecoveredOfObjs = new ArrayList<>();
    }

    public ArrayList<Vacant> searchVacant(VACANCYFITLER filter, String keyword) {
        //isVacantFree
        ArrayList<Vacant> recopilatedVacants = new ArrayList<>();
        for (Vacant vacant: Vacant.getAllVacants()) {
            if (vacant.getCampo(String.valueOf(filter)).equals(keyword)){
                recopilatedVacants.add(vacant);
            }
        }
        return recopilatedVacants;
    }

    public ArrayList<User> searchPersonal(APPLICANTFILTER filter, String keyword) {
        ArrayList<User> recopilatedPersonal = new ArrayList<>();
        for (User user: User.getAllVacants()) {
            if (user.getCampo(String.valueOf(filter)).equals(keyword)){
                recopilatedPersonal.add(user);
            }
        }
        return recopilatedPersonal;
    }
}


