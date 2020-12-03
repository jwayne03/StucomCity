package model.neighborhoods;

import model.Neighborhood;

import java.util.ArrayList;
import java.util.List;

public class Ofidelia extends Neighborhood {

    private List<String> type;

    public Ofidelia(String name) {
        super(name);
        this.type = new ArrayList<>();
        type.add("POBRE");
        type.add("TRANQUILO");
    }

    @Override
    public boolean checkHouseRent(int rent) {
        return true;
    }

    @Override
    public boolean checkSize(int size) {
        return true;
    }
}
