package menu.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Coach {

    private final String name;

    private final List<String> noEatMenus = new ArrayList<>();
    private final List<String> recommendMenus = new ArrayList<>();

    public Coach(String name) {
        this.name = name;
    }

    public void addNoEatMenus(List<String> menus) {
        for (String menu : menus) {
            noEatMenus.add(menu);
        }
    }

    public void addRecommendMenus(String menu) {
        recommendMenus.add(menu);
    }

    public boolean eatableMenu(String menu) {
        return !noEatMenu(menu) || !isDuplicateMenu(menu);
    }

    public boolean noEatMenu(String menu) {
        for (String noEatMenu : noEatMenus) {
            if (menu.equals(noEatMenu)) {
                return true;
            }
        }
        return false;
    }

    public boolean isDuplicateMenu(String menu) {
        for (String recommedMenu : recommendMenus) {
            if (recommedMenu.equals(menu)) {
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public String recommendMenu() {
        return "[ " + name + " | " + recommendMenus.stream().collect(Collectors.joining(" | ")) + " ]";
    }
}
