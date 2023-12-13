package menu.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String COACH_NAME_INPUT_MESSAGE = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String NO_EAT_MENU_INPUT_MESSAGE = "%s(이)가 못 먹는 메뉴를 입력해 주세요.";

    private final InputViewValidator inputViewValidator = new InputViewValidator();

    public String inputCoachName() {
        System.out.println(COACH_NAME_INPUT_MESSAGE);
        String coachNames = Console.readLine();
        inputViewValidator.validateInput(coachNames);

        return coachNames;
    }

    public String inputNoEatMenu(String name) {
        System.out.println(String.format(NO_EAT_MENU_INPUT_MESSAGE, name));
        return Console.readLine();
    }
}
