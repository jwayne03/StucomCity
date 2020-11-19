package model.neighborhoods;

import model.Neighborhood;

import java.util.ArrayList;
import java.util.List;

public class Vistaalegre extends Neighborhood {

    private int couple;
    private List<String> type;

    public Vistaalegre(String name) {
        super(name);
        this.couple = 2;
        this.type = new ArrayList<>();
    }

    private void init() {
        type.add("CHILL");
        type.add("RICH");
        type.add("POOR");
    }
}
