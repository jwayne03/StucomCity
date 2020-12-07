package model.neighborhoods;

import model.Neighborhood;

import java.util.ArrayList;
import java.util.List;

public class Ofidelia extends Neighborhood {

    public Ofidelia(String name) {
        super(name);
        this.type = new ArrayList<>();
        super.type.add("POBRE");
        super.type.add("TRANQUILO");
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
