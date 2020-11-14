package exceptions;

import java.util.Arrays;
import java.util.List;

public class MyException extends Exception {

    public static final int NUMBER_PARAMETERS_INCORRECT = 1;
    public static final int READ_ERROR = 2;
    public static final int WRONG_OPTION = 3;
    public static final int WRONG_NEIGHBORHOOD = 4;
    public static final int WRONG_TYPE_PERSON = 5;
    public static final int INCORRECT_NUMBER_OF_PERSON = 6;
    public static final int INCORRECT_RENT_PRICE = 7;
    public static final int HOUSE_NOT_FOUND = 8;
    public static final int PERSON_NOT_FOUND = 9;
    public static final int PERSON_NOT_ADMITTED_IN_NEIGHBORHOOD = 10;
    public static final int NO_MORE_TENANTS_FIT = 11;
    public static final int PROFESSION_NOT_ADMITTED_NEIGHBORHOOD = 12;
    public static final int INHABITED_HOUSE_CANT_BE_DESTROYED = 13;

    private int value;

    public MyException(int value) {
        this.value = value;
    }

    private List<String> messege = Arrays.asList(
            "Number of parameters are incorrect",
            "FATAL ERROR",
            "Wrong option",
            "Wrong neighborhood",
            "Wrong type of person",
            "Incorrect number of person",
            "Incorrect rent price",
            "House not found",
            "This person isn't admitted in the neighborhood",
            "No more tenants fit",
            "This profession isn't admitted in the neighborhood",
            "This house is inhabited, can't be destroyed"

    );
}
