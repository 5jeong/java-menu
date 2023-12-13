package menu.controller;

import java.util.List;
import menu.InputHandler.InputTemplate;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.MenuCategory;
import menu.domain.MenuRecommend;
import menu.util.ConverterUtil;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuRecommendController {

    private final InputView inputView;
    private final OutputView outputView;


    public MenuRecommendController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        outputView.startMessageOutput();
        Coaches coaches = generateCoachsStep();
        generateNoEatMenuStep(coaches);
        menuRecommendStep(coaches);
    }

    private Coaches generateCoachsStep() {
        return InputTemplate.execute(() -> {
            String coachName = inputView.inputCoachName();
            List<String> coachNames = ConverterUtil.covertStringToList(coachName);
            return new Coaches(coachNames);
        });

    }

    private void generateNoEatMenuStep(Coaches coaches) {
        for (Coach coach : coaches.getCoachs()) {
            String noEatFood = generateNoEatMenu(coach);
            coach.addNoEatMenu(noEatFood);
        }
    }

    private String generateNoEatMenu(Coach coach) {
        return InputTemplate.execute(() -> {
            return inputView.inputNoEatMenu(coach.getName());
        });
    }

    private void menuRecommendStep(Coaches coaches) {
        MenuRecommend menuRecommend = createMenuRecommendation(coaches);
        printMenuRecommendation(menuRecommend, coaches);
    }

    private MenuRecommend createMenuRecommendation(Coaches coaches) {
        MenuRecommend menuRecommend = new MenuRecommend(coaches);
        for (int i = 0; i < 5; i++) {
            MenuCategory selectCategory = menuRecommend.applyMenuCategory();
            menuRecommend.applyRecommendMenu(selectCategory);
        }
        return menuRecommend;
    }

    private void printMenuRecommendation(MenuRecommend menuRecommend, Coaches coaches) {
        printSelectedCategories(menuRecommend);
        printCoachRecommendMenus(coaches);
        outputView.endMessageOutput();
    }

    private void printSelectedCategories(MenuRecommend menuRecommend) {
        outputView.menuRecommendOutput(menuRecommend.printSelectCategory());
    }

    private void printCoachRecommendMenus(Coaches coaches) {
        for (Coach coach : coaches.getCoachs()) {
            outputView.coachMenuOutput(coach.printRecommendMenu());
        }
    }
}
