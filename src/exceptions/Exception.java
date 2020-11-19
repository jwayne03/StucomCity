package exceptions;

import java.util.Arrays;
import java.util.List;

public class Exception extends java.lang.Exception {

    public static final int NUMBER_PARAMETERS_INCORRECT = 0;
    public static final int READ_ERROR = 1;
    public static final int WRONG_OPTION = 2;

    private List<String> messege = Arrays.asList(
            "Number of parameters are incorrect",
            "READ ERROR",
            "Wrong option"
    );

    private int value;

    public Exception(int value) {
        this.value = value;
    }

    @Override
    public String getMessage() {
        return messege.get(value);
    }
}
