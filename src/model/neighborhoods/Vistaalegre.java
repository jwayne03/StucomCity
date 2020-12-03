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
        type.add("TRANQUILO");
        type.add("RICO");
        type.add("POBRE");
    }

    @Override
    public boolean checkHouseRent(int rent) {
        return true;
    }

    @Override
    public boolean checkSize(int size) {
        return size == this.couple;
    }

}
