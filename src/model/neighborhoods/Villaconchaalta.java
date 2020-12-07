package model.neighborhoods;

import model.Neighborhood;

import java.util.ArrayList;
import java.util.List;

public class Villaconchaalta extends Neighborhood {

    private int minRent;

    public Villaconchaalta(String name) {
        super(name);
        this.minRent = 500;
        this.type = new ArrayList<>();
        super.type.add("POBRE");
        super.type.add("RICO");
        super.type.add("POBRE");
    }

    @Override
    public boolean checkHouseRent(int rent) {
        return rent > this.minRent;
    }

    @Override
    public boolean checkSize(int size) {
        return true;
    }
}
