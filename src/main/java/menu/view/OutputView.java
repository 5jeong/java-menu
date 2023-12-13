package menu.view;

public class OutputView {

    private static final String START_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    private static final String MENU_RECOMMENDATION_HEADER = "메뉴 추천 결과입니다.";
    private static final String DAY_SEPARATOR = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";
    private static final String RECOMMENDATION_COMPLETE_MESSAGE = "추천을 완료했습니다.";

    public void startMessageOutput() {
        System.out.println(START_MESSAGE);
    }

    public void menuRecommendOutput(String selectedCategories) {
        System.out.println(MENU_RECOMMENDATION_HEADER);
        System.out.println(DAY_SEPARATOR);
        System.out.println(selectedCategories);
    }

    public void coachMenuOutput(String printRecommendMenu) {
        System.out.println(printRecommendMenu);
    }

    public void endMessageOutput() {
        System.out.println();
        System.out.println(RECOMMENDATION_COMPLETE_MESSAGE);
    }
}
