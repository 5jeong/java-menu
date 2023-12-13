package menu.util;

import menu.domain.MenuCategory;

public interface Generator {

    MenuCategory categoryGenerate();
    String menuGenerate(MenuCategory menuCategory);
}
