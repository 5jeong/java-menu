package menu.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import menu.util.MenuCategoryGenerator;

public class MenuRecommend {
    private static final int POSSIBLE_CATEGORY_COUNT = 2;
    private static final MenuCategoryGenerator menuCategoryGenerator = new MenuCategoryGenerator();

    private final List<MenuCategory> selectedCategory = new ArrayList<>();

    private final Coaches coaches;
    public MenuRecommend(Coaches coaches) {
        this.coaches = coaches;
    }

    public MenuCategory applyMenuCategory() {
        MenuCategory menuCategory = generateMenuCategory();
        if (checkPossibleCategory(menuCategory)) {
            selectedCategory.add(menuCategory);
            return menuCategory;
        }
        return applyMenuCategory();
    }

    private MenuCategory generateMenuCategory() {
        return menuCategoryGenerator.categoryGenerate();
    }

    private boolean checkPossibleCategory(MenuCategory menuCategory) {
        long overlapCount = selectedCategory.stream()
                .filter(selected -> selected.equals(menuCategory))
                .count();

        return overlapCount < POSSIBLE_CATEGORY_COUNT;
    }

    public void applyRecommendMenu(MenuCategory menuCategory) {
        for(Coach coach : coaches.getCoachs()){
            generateRecommendMenu(menuCategory,coach);
        }
    }

    private void generateRecommendMenu(MenuCategory menuCategory, Coach coach) {
        String selectMenu = menuCategoryGenerator.menuGenerate(menuCategory);
        if (coach.isCorrectMenu(selectMenu)) {
            coach.addRecommendMenu(selectMenu);
            return;
        }
        generateRecommendMenu(menuCategory, coach);
    }

    public String printSelectCategory() {
        return "[ 카테고리 | " +
                selectedCategory.stream()
                        .map(MenuCategory::getName)
                        .collect(Collectors.joining(" | ")) +
                " ]";
    }

}
