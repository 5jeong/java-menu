package menu.util;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.MenuCategory;

public class CategoryAndMenuGenerator implements Generator {

    private static final int RANDOM_LOWER_INCLUSIVE = 1;
    private static final int RANDOM_UPPER_INCLUSIVE = 5;


    @Override
    public MenuCategory categoryGenerate() {
        MenuCategory category = MenuCategory.judgeMenuCategory(
                Randoms.pickNumberInRange(RANDOM_LOWER_INCLUSIVE, RANDOM_UPPER_INCLUSIVE));
        return category;
    }

    @Override
    public String menuGenerate(MenuCategory recommendCategory) {
        for (MenuCategory menuCategory : MenuCategory.values()) {
            if (menuCategory.equals(recommendCategory)) {
                String menu = Randoms.shuffle(menuCategory.getMenuList()).get(0);
                return menu;
            }
        }
        return null;
    }

}
