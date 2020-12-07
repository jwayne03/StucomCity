package model;

import exceptions.MyException;
import model.house.House;
import persistence.FileManagement;

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

    public void build(String[] data, FileManagement fileManagement) throws MyException {
        int rent = Integer.parseInt(data[2]);
        int houseSize = Integer.parseInt(data[3]);
        int houseId = Integer.parseInt(data[4]);

        if (!checkHouseRent(rent)) throw new MyException(MyException.INCORRECT_RENT_PRICE);
        if (!checkSize(houseSize)) throw new MyException(MyException.INCORRECT_NUMBER_OF_PERSON);

        houses.add(new House(houseId, houseSize, rent));

        fileManagement.saveData("< OK: House created in the neighborhood >");
    }

    public void destroy(int id, FileManagement fileManagement) throws MyException {
        House house = checkIdHouse(id);
        if (house.getPeople().size() > 0) throw new MyException(MyException.INHABITED_HOUSE_CANT_BE_DESTROYED);
        this.getHouses().remove(house);
        fileManagement.saveData("< OK: Destroyed house in the neighborhood >");
    }

    public House checkIdHouse(int id) throws MyException {
        for (House house : this.getHouses()) {
            if (house.getId() == id) {
                return house;
            }
        }
        throw new MyException(MyException.HOUSE_NOT_FOUND);
    }

    public void listHousesNeighborhood(String data, FileManagement fileManagement) {
        if (data.equalsIgnoreCase("l")) {
            fileManagement.saveData("< OK: Listing houses in the neighborhood >");
            houses.forEach(house -> {
                fileManagement.saveData("       <House with id: " + house.getId()
                        + " has " + house.getPeople().size() + " tenants >");

            });
        }
        fileManagement.saveData("< There are no more houses in the neighborhood >");
    }
}
