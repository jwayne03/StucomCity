package model;

import exceptions.Exceptions;
import exceptions.MyException;

import java.util.ArrayList;
import java.util.List;

public class Neighborhood {

    protected String name;
    protected ArrayList<House> houses;
    protected List<String> type;

    public Neighborhood() {
    }

    public Neighborhood(String name) {
        this.name = name;
        houses = new ArrayList<>();
        type = new ArrayList<>();
    }

    public void build(String[] data) throws Exceptions, MyException {
        int rent = Integer.parseInt(data[2]);
        int houseSize = Integer.parseInt(data[3]);
        int houseId = Integer.parseInt(data[4]);

        if (!checkHouseRent(rent)) throw new MyException(MyException.INCORRECT_RENT_PRICE);
        if (!checkSize(houseSize)) throw new MyException(MyException.INCORRECT_NUMBER_OF_PERSON);

        this.houses.add(new House(houseId, houseSize, rent));
    }

    public void destroy(int id) throws MyException {
        House house = checkIdHouse(id);
        if (house.getPeople().size() > 0) throw new MyException(MyException.INHABITED_HOUSE_CANT_BE_DESTROYED);
        this.getHouses().remove(house);
        System.out.print("House has been destroyed");
    }

    public House checkIdHouse(int id) throws MyException {
        for (House house : this.getHouses()) {
            if (house.getId() == id) {
                return house;
            }
        }
        throw new MyException(MyException.HOUSE_NOT_FOUND);
    }

    public void listHousesNeighborhood(String data) throws Exceptions {
        System.out.println("OK: List houses of neighborhood");

        houses.stream().forEach(house -> {
            if (house.getPeople().size() == 0) {
                System.out.println("<House with ID: " + house.getId() + " has " + house.getPeople().size() + " renters>");
            } else {
                System.out.println("<House with ID: " + house.getId() + " has " + house.getPeople().size() + " renters>");
                if (data.equalsIgnoreCase("s")) house.accomodationList();
            }
            System.out.println("<No more houses in the neighborhood>");
        });
    }

    public List<String> getType() {
        return type;
    }

    public void setType(List<String> type) {
        this.type = type;
    }

    public boolean checkSize(int size) {
        return false;
    }

    public boolean checkHouseRent(int rent) {
        return false;
    }


    public List<House> getHouses() {
        return houses;
    }

    public void setHouses(ArrayList<House> houses) {
        this.houses = houses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
