package menu.view;

import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;
import menu.util.ConvertUtil;

public class InputViewValidator {
    private static final String INPUT_REGEX = ".*[^\\s],[^\\s].*";

    public static void validateCoachNames(String coachNames){
        if(isNotSeparateByComma(coachNames)){
            throw new IllegalArgumentException("[ERROR] 쉼표로 구분해야 합니다.");
        }
        if(isNotCoachName(coachNames)){
            throw new IllegalArgumentException("[ERROR] 이름은 최소 2글자, 최대 4글자여야 합니다.");
        }
        if(isNotCoachSize(coachNames)){
            throw new IllegalArgumentException("[ERROR] 코치는 최소 2명, 최대 5명이여야 합니다..");
        }
        if(isDuplicateCoachName(coachNames)){
            throw new IllegalArgumentException("[ERROR] 코치의 이름은 중복되면 안됩니다.");
        }

    }

    private static boolean isDuplicateCoachName(String coachNames) {
        List<String> coachs = ConvertUtil.convertStringToList(coachNames);
        return coachs.stream().distinct().count() != coachs.size();
    }

    private static boolean isNotSeparateByComma(String coachNames) {
        return !Pattern.compile(INPUT_REGEX).matcher(coachNames).matches();
    }

    private static boolean isNotCoachSize(String coachNames) {
        List<String> coachs = ConvertUtil.convertStringToList(coachNames);
        return coachs.size() < 2 || coachs.size() > 5;

    }

    private static boolean isNotCoachName(String coachNames) {
        List<String> coachs = ConvertUtil.convertStringToList(coachNames);
        for(String coach : coachs){
            if(coach.length() < 2 || coach.length() > 4){
                return true;
            }
        }
        return false;

    }

    public static void validateNoEatMenu(String noEatMenu){
        if(isNotNoEatMenuSize(noEatMenu)){
            throw new IllegalArgumentException("최소 0개 최대 2개까지 고를수있습니다.");
        }

    }

    private static boolean isNotNoEatMenuSize(String noEatMenu) {
        List<String> noEatMenus = ConvertUtil.convertStringToList(noEatMenu);
        return noEatMenus.size() > 2;
    }


}
