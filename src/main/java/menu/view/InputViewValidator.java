package menu.view;

import java.util.regex.Pattern;

public class InputViewValidator {
    private static final String INPUT_REGEX = ".*\\s*,\\s*.*";


    public void validateInput(String input ) {
        if (isNotSeparateByComma(input)) {
            throw new IllegalArgumentException("[ERROR] 콤마로 구분되어야합니다.");
        }
    }

    private boolean isNotSeparateByComma(String input) {
        return !Pattern.compile(INPUT_REGEX).matcher(input).matches();
    }
}
