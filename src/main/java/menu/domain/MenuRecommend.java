package menu.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import menu.util.CategoryAndMenuGenerator;

public class MenuRecommend {

    private final CategoryAndMenuGenerator categoryAndMenuGenerator;
    private final List<Coach> coaches;
    private List<MenuCategory> recommendMenuCategories = new ArrayList<>();

    public MenuRecommend(List<Coach> coaches) {
        this.coaches = coaches;
        this.categoryAndMenuGenerator = new CategoryAndMenuGenerator();
    }

    public MenuCategory generateRecommendCategory() {
        MenuCategory category = categoryAndMenuGenerator.categoryGenerate();
        addRecommendMenuCategory(category);
        return category;
    }

    private void addRecommendMenuCategory(MenuCategory category) {
        if (judgeAddCategory(category)) {
            recommendMenuCategories.add(category);
            return;
        }
        generateRecommendCategory();
    }

    private boolean judgeAddCategory(MenuCategory category) {
        int cnt = 0;
        for (MenuCategory recommendMenuCategory : recommendMenuCategories) {
            if (recommendMenuCategory.equals(category)) {
                cnt++;
            }
        }
        return cnt < 2;
    }

    public void applyRecommendMenu(MenuCategory menuCategory) {
        for (Coach coach : coaches) {
            generateRecommendMenu(menuCategory,coach);
        }
    }

    public void generateRecommendMenu(MenuCategory menuCategory,Coach coach) {
        String recommendMenu = categoryAndMenuGenerator.menuGenerate(menuCategory);
        if (coach.eatableMenu(recommendMenu)) {
            coach.addRecommendMenus(recommendMenu);
            return;
        }
        generateRecommendMenu(menuCategory,coach);
    }

    public String recommedCategoriesResult() {
        return recommendMenuCategories.stream()
                .map(MenuCategory::getCategory)
                .collect(Collectors.joining(" | ", "[ 카테고리 | ", " ]"));
    }

    public List<String> recommendMenuResult(){
        List<String> recommendMenuResult = new ArrayList<>();
        for(Coach coach : coaches){
            recommendMenuResult.add(coach.recommendMenu());
        }
        return recommendMenuResult;
    }


}
