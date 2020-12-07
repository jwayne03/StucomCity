package exceptions;

import java.util.Arrays;
import java.util.List;

public class MyException extends Exception {

    public static final int WRONG_NEIGHBORHOOD = 0;
    public static final int INCORRECT_TENANT_PROFESSION = 1;
    public static final int INCORRECT_NUMBER_OF_PERSON = 2;
    public static final int INCORRECT_RENT_PRICE = 3;
    public static final int HOUSE_NOT_FOUND = 4;
    public static final int PERSON_NOT_FOUND = 5;
    public static final int PERSON_NOT_ADMITTED_IN_NEIGHBORHOOD = 6;
    public static final int NO_MORE_TENANTS_FIT = 7;
    public static final int PROFESSION_NOT_ADMITTED_NEIGHBORHOOD = 8;
    public static final int INHABITED_HOUSE_CANT_BE_DESTROYED = 9;

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
            "< Inhabited house, cannot be destroyed >"
    );

    @Override
    public String getMessage() {
        return messege.get(value);
    }
}
