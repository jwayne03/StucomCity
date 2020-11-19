package model.neighborhoods;

import model.Neighborhood;

import java.util.ArrayList;
import java.util.List;

public class Alameda extends Neighborhood {

    private int minRent;
    private List<String> type;

    public Alameda(String name) {
        super(name);
        this.minRent = 1000;
        this.type = new ArrayList<>();
        init();
    }

    private void init() {
        type.add("RICH");
    }
}
