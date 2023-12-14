package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {

    private final String name;

    private final List<String> noEatMenus = new ArrayList<>();
    private final List<String> recommendMenus = new ArrayList<>();

    public Coach(String name) {
        this.name = name;
    }

    public void addNoEatMenus(List<String> menus){
        for(String menu : menus){
            noEatMenus.add(menu);
        }
    }

    public String getName() {
        return name;
    }
}
