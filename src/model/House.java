package model;

import java.util.ArrayList;

public class House {

    private String neighborhood;
    private int rent;
    private int maxPerson;
    private int houseId;

    private ArrayList<House> houses;
    private ArrayList<Person> person;

    public House() {
        person = new ArrayList<>();
        houses = new ArrayList<>();
    }

    public House(String neighborhood, int rent, int maxPerson, int houseId) {
        this.neighborhood = neighborhood;
        this.rent = rent;
        this.maxPerson = maxPerson;
        this.houseId = houseId;
    }

    public void buildHouse(String neighborhood, int rent, int maxPerson, int houseId) {
        House house = new House(neighborhood, rent, maxPerson, houseId);
        houses.add(house);
    }

    public void destroyHouse(String neighborhood, int houseId) {

    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public int getMaxPerson() {
        return maxPerson;
    }

    public void setMaxPerson(int maxPerson) {
        this.maxPerson = maxPerson;
    }

    public int getHouseId() {
        return houseId;
    }

    public void setHouseId(int houseId) {
        this.houseId = houseId;
    }
}
