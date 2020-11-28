package model.neighborhoods;

import model.Neighborhood;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Alameda extends Neighborhood {

    private int minRent;
    private List<String> type;

    public Alameda(String name) {
        super(name);
        this.minRent = 1000;
        this.type = new ArrayList<>();
        init();
    }

    @Override
    public boolean checkHouseRent(int rent) {
        return rent > this.minRent;
    }

    @Override
    public boolean checkSize(int size) {
        return true;
    }

    @Override
    public List<String> getType() {
        return type;
    }

    private void init() {
        type.add("RICH");
    }
}
