package menu.view;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import menu.util.ConvertUtil;

public class InputView {

    public List<String> inputCoachNames(){
        System.out.println();
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        String coachNames = Console.readLine();
        InputViewValidator.validateCoachNames(coachNames);
        return ConvertUtil.convertStringToList(coachNames);
    }

    public List<String> noEatMenu(String name){
        System.out.println();
        System.out.println(String.format("%s(이)가 못 먹는 메뉴를 입력해 주세요.",name));
        String noEatMenu = Console.readLine();
        InputViewValidator.validateNoEatMenu(noEatMenu);
        return ConvertUtil.convertStringToList(noEatMenu);
    }

}
