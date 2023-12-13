package menu.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConverterUtil {
    public static List<String> covertStringToList(String str) {
        return Arrays.stream(str.split(","))
                .map(String::valueOf)
                .collect(Collectors.toList());
    }

    public static Integer convertStringToInt(String str){
        return Integer.parseInt(str);
    }



}
