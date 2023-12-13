package menu.util;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.MenuCategory;

public class MenuCategoryGenerator implements Generator {

    private static final int RANDOM_LOWER_INCLUSIVE = 1;
    private static final int RANDOM_UPPER_INCLUSIVE = 5;

    @Override
    public MenuCategory categoryGenerate() {
        int randomNumber =  Randoms.pickNumberInRange(RANDOM_LOWER_INCLUSIVE, RANDOM_UPPER_INCLUSIVE);
        MenuCategory menuCategory = MenuCategory.getCategoryByNumber(randomNumber);
        return menuCategory;
    }

    @Override
    public String menuGenerate(MenuCategory menuCategory) {
        String menu = Randoms.shuffle(menuCategory.getMenuList()).get(0);
        return menu;
    }
}
