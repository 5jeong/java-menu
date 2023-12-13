package menu.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import menu.util.ConverterUtil;

public class Coach {

    private final String name;

    private final List<String> noEatMenus = new ArrayList<>();

    private final List<String> recommendMenus = new ArrayList<>();

    public Coach(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (isNotCoachName(name)) {
            throw new IllegalArgumentException("[ERROR] 코치이름은 2~4글자여야 합니다.");
        }
    }

    private boolean isNotCoachName(String name) {
        return name.length() < 2 || name.length() > 4;
    }

    public void addNoEatMenu(String noEatMeun) {
        List<String> noEatmenu = ConverterUtil.covertStringToList(noEatMeun);
        for(String menu : noEatmenu){
            noEatMenus.add(menu);
        }
    }

    public void addRecommendMenu(String menu) {
        recommendMenus.add(menu);
    }

    public boolean isCorrectMenu(String menu) {
        return !isDuplicateMenu(menu) || !isNoEatMenu(menu);
    }

    private boolean isNoEatMenu(String menu) {
        return noEatMenus.stream()
                .anyMatch(noEatMenu -> noEatMenu.equals(menu));
    }

    private boolean isDuplicateMenu(String menu) {
        return recommendMenus.stream()
                .anyMatch(recommendMenu -> recommendMenu.equals(menu));
    }

    public String printRecommendMenu( ) {
        return "[ " + getName() + " | " + recommendMenus.stream().collect(Collectors.joining(" | ")) + " ]";
    }

    public String getName() {
        return name;
    }
}
