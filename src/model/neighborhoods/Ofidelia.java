package model.neighborhoods;

import model.Neighborhood;

import java.util.ArrayList;
import java.util.List;

public class Ofidelia extends Neighborhood {

    private List<String> type;

    public Ofidelia(String name) {
        super(name);
        this.type = new ArrayList<>();
    }

    private void init() {
        type.add("POOR");
        type.add("CHILL");
    }
}