package model.neighborhoods;

import model.Neighborhood;

import java.util.ArrayList;
import java.util.List;

public class Nolomires extends Neighborhood {

    private int minLargeFamilies;
    private List<String> type;

    public Nolomires(String name) {
        super(name);
        this.minLargeFamilies = 5;
        this.type = new ArrayList<>();
    }

    private void init() {
        type.add("POOR");
    }
}
