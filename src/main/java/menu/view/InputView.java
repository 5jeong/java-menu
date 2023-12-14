package menu.view;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import menu.util.ConvertUtil;

public class InputView {

    public List<String> inputCoachNames(){
        String coachNames = Console.readLine();
        InputViewValidator.validateCoachNames(coachNames);
        return ConvertUtil.convertStringToList(coachNames);
    }

    public List<String> noEatMenu(){
        String noEatMenu = Console.readLine();
        InputViewValidator.validateNoEatMenu(noEatMenu);
        return ConvertUtil.convertStringToList(noEatMenu);
    }

}
