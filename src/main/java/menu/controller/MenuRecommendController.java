package menu.controller;

import java.util.List;
import menu.InputHandler.InputTemplate;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.MenuCategory;
import menu.domain.MenuRecommend;
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
        List<String> coachNames = generateCoachNames();
        Coaches coaches = generateCoachs(coachNames);
        applyNoEatMenus(coaches);
        menuRecommendStep(coaches);
    }

    private void menuRecommendStep(Coaches coaches) {
        MenuRecommend menuRecommend = new MenuRecommend(coaches.getCoaches());
        for (int i = 0; i < 5; i++) {
            MenuCategory recommendCategory = menuRecommend.generateRecommendCategory();
            menuRecommend.applyRecommendMenu(recommendCategory);
        }
        outputView.menuRecommendOutput(menuRecommend.recommedCategoriesResult(), menuRecommend.recommendMenuResult());
        outputView.endMessageOutput();

    }

    private List<String> generateCoachNames() {
        return InputTemplate.execute(() -> {
            return inputView.inputCoachNames();
        });
    }

    private Coaches generateCoachs(List<String> coachNames) {
        return new Coaches(coachNames);
    }

    private void applyNoEatMenus(Coaches coaches) {
        for (Coach coach : coaches.getCoaches()) {
            List<String> noEatMenus = inputView.noEatMenu(coach.getName());
            coach.addNoEatMenus(noEatMenus);
        }
    }
}
