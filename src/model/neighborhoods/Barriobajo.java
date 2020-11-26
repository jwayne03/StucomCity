package model.neighborhoods;

import model.Neighborhood;

import java.util.ArrayList;
import java.util.List;

public class Barriobajo extends Neighborhood {

    private int maxRent;
    private int minPeople;
    private List<String> type;

    public Barriobajo(String name) {
        super(name);
        this.maxRent = 400;
        this.minPeople = 3;
        this.type = new ArrayList<>();
    }

    @Override
    public boolean checkHouseRent(int rent) {
        return rent <= this.maxRent;
    }

    @Override
    public boolean checkSize(int size) {
        return size >= this.minPeople;
    }

    private void init() {
        type.add("POOR");
    }
}
