package menu.view;

import java.util.List;

public class OutputView {

    private static final String START_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    private static final String END_MESSAGE = "추천을 완료했습니다.";
    private static final String RECOMMEND_RESULT_MESSAGE = "메뉴 추천 결과입니다.";
    private static final String DIVISIOIN_DAY_OF_WEEK_MESSAGE = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";


    public void startMessageOutput() {
        System.out.println(START_MESSAGE);
    }
    public void menuRecommendOutput(String recommendCategoies, List<String> recommendMenusResult){
        System.out.println(RECOMMEND_RESULT_MESSAGE);
        System.out.println(DIVISIOIN_DAY_OF_WEEK_MESSAGE);
        System.out.println(recommendCategoies);
        for(String recommendMenu : recommendMenusResult){
            System.out.println(recommendMenu);
        }
    }

    public void endMessageOutput() {
        System.out.println(END_MESSAGE);
    }
}
