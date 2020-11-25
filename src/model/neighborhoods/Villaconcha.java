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
    }

    @Override
    public boolean checkHouseRent(int rent) {
        return rent > this.minRent;
    }

    private void init() {
        type.add("RICH");
        type.add("CHILL");
    }
}
