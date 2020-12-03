package model.neighborhoods;

import model.Neighborhood;

import java.util.ArrayList;
import java.util.List;

public class Villaconchaalta extends Neighborhood {

    private int minRent;
    private List<String> type;

    public Villaconchaalta(String name) {
        super(name);
        this.minRent = 500;
        this.type = new ArrayList<>();
        type.add("POBRE");
        type.add("RICO");
        type.add("POBRE");
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
