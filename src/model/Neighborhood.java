package model;

import java.util.List;

public class Neighborhood {

    private String name;
    private int minRent;
    private int maxRent;
    private List<House> houses;

    public Neighborhood(String name, int minRent, int maxRent, List<House> houses) {
        this.name = name;
        this.minRent = minRent;
        this.maxRent = maxRent;
        this.houses = houses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMinRent() {
        return minRent;
    }

    public void setMinRent(int minRent) {
        this.minRent = minRent;
    }

    public int getMaxRent() {
        return maxRent;
    }

    public void setMaxRent(int maxRent) {
        this.maxRent = maxRent;
    }

    public List<House> getHouses() {
        return houses;
    }

    public void setHouses(List<House> houses) {
        this.houses = houses;
    }
}
