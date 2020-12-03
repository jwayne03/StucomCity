package model.neighborhoods;

import model.Neighborhood;

import java.util.ArrayList;
import java.util.List;

public class Villaconcha extends Neighborhood {

    private int minRent;
    private List<String> type;

    public Villaconcha(String name) {
        super(name);
        this.minRent = 500;
        this.type = new ArrayList<>();
        type.add("RICO");
        type.add("TRANQUILO");
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
