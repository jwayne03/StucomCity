package exceptions;

import java.util.Arrays;
import java.util.List;

public class MyException extends Exception {

    public static final int WRONG_NEIGHBORHOOD = 3;
    public static final int WRONG_TYPE_PERSON = 4;
    public static final int INCORRECT_NUMBER_OF_PERSON = 5;
    public static final int INCORRECT_RENT_PRICE = 6;
    public static final int HOUSE_NOT_FOUND = 7;
    public static final int PERSON_NOT_FOUND = 8;
    public static final int PERSON_NOT_ADMITTED_IN_NEIGHBORHOOD = 9;
    public static final int NO_MORE_TENANTS_FIT = 10;
    public static final int PROFESSION_NOT_ADMITTED_NEIGHBORHOOD = 11;
    public static final int INHABITED_HOUSE_CANT_BE_DESTROYED = 12;

    private int value;

    public MyException(int value) {
        this.value = value;
    }

    private List<String> messege = Arrays.asList(
            "< Wrong Neighborhood Name >",
            "< Incorrect Tenant Profession >",
            "< Incorrect number of tenants >",
            "< Incorrect rental price >",
            "< House not found >",
            "< Tenant not admitted in the neighborhood >",
            "< There are no more houses in the neighborhood >",
            "< This profession isn't admitted in the neighborhood >",
            "< This house is inhabited, can't be destroyed >"
    );

    @Override
    public String getMessage() {
        return messege.get(value);
    }
}
