package model.neighborhoods;

import model.Neighborhood;

import java.util.ArrayList;
import java.util.List;

public class Nolomires extends Neighborhood {

    private int minLargeFamilies;

    public Nolomires(String name) {
        super(name);
        this.minLargeFamilies = 5;
        this.type = new ArrayList<>();
        super.type.add("POBRE");
    }

    @Override
    public boolean checkHouseRent(int rent) {
        return true;
    }

    @Override
    public boolean checkSize(int size) {
        return size >= this.minLargeFamilies;
    }
}
