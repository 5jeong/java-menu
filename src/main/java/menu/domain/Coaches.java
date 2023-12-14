package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coaches {

    private final List<Coach> coaches = new ArrayList<>();

    private final List<String> coachNames;
    public Coaches(List<String> coachNames) {
        this.coachNames = coachNames;
        generateCoach(coachNames);
    }
    private void generateCoach(List<String> coachNames){
        for(String name : coachNames){
            coaches.add(new Coach(name));
        }
    }

    public int coachesSize(){
        return coaches.size();
    }

    public List<Coach> getCoaches() {
        return coaches;
    }
}
