package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coaches {

    private static final int MIN_COACH_NUMBER = 2;
    private static final int MAX_COACH_NUMBER = 5;

    private final List<Coach> coachs = new ArrayList<>();

    public Coaches(List<String> coachNames){
        validateCoachNames(coachNames);
        initCoachs(coachNames);
    }

    public void initCoachs(List<String> coachNames) {
        for(String name : coachNames){
            coachs.add(new Coach(name));
        }
    }

    private void validateCoachNames(List<String> coachNames) {
        if(isNotCorrectNumberOfCoachs(coachNames)){
            throw new IllegalArgumentException("[ERROR] 코치는 2~5명이여야 합니다.");
        }
        if(isDuplicateCoachName(coachNames)){
            throw new IllegalArgumentException("[ERROR] 코치의 이름이 중복되었습니다.");
        }
    }

    private boolean isDuplicateCoachName(List<String> coachNames) {
        long distinctCount = coachNames.stream().distinct().count();
        return distinctCount < coachNames.size();
    }

    private boolean isNotCorrectNumberOfCoachs(List<String> coachNames) {
        return coachNames.size() < MIN_COACH_NUMBER || coachNames.size() > MAX_COACH_NUMBER;
    }

    public List<Coach> getCoachs() {
        return coachs;
    }

}
