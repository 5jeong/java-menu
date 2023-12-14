package menu.controller;

import java.util.List;
import menu.InputHandler.InputTemplate;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuRecommendController {
    private final InputView inputView;
    private final OutputView outputView;


    public MenuRecommendController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run(){
        outputView.startMessageOutput();
        List<String> coachNames = generateCoachNames();
        Coaches coaches = generateCoachs(coachNames);
        generateNoEatMenus(coaches);
    }

    private List<String> generateCoachNames() {
        return InputTemplate.execute(() -> {
            return  inputView.inputCoachNames();
        });
    }

    private Coaches generateCoachs(List<String> coachNames) {
        return new Coaches(coachNames);
    }

    private void generateNoEatMenus(Coaches coaches) {
        for(Coach coach : coaches.getCoaches()){
            List<String> noEatMenus = inputView.noEatMenu(coach.getName());
            coach.addNoEatMenus(noEatMenus);
        }

    }


}
