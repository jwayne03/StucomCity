package model;

import exceptions.Exception;
import exceptions.MyException;

import java.util.ArrayList;
import java.util.List;

public class Neighborhood {

    private String name;
//    private
    private List<House> houses;

    public Neighborhood() {
        houses = new ArrayList<>();
    }

    public Neighborhood(String name) {
        this.name = name;
    }

    public void build(String[] data) throws Exception, ArrayIndexOutOfBoundsException {
        if (data.length != 5) throw new Exception(Exception.NUMBER_PARAMETERS_INCORRECT);
        String neighborhood = data[1].toUpperCase();
        int rent = Integer.parseInt(data[2]);
        int houseSize = Integer.parseInt(data[3]);
        int houseId = Integer.parseInt(data[4]);

        if (!checkHouseRent(rent)) throw new MyException(MyException.INCORRECT_RENT_PRICE);

//        checkHouseId(houseId);
    }

    public boolean checkHouseRent(int rent) {
        return false;
    }

    public void destroy(String[] data) throws Exception {
        if (data.length != 3) throw new Exception(Exception.NUMBER_PARAMETERS_INCORRECT);
    }

    public List<House> getHouses() {
        return houses;
    }

    public void setHouses(List<House> houses) {
        this.houses = houses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
