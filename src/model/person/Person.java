package model.person;

import exceptions.MyException;
import model.Neighborhood;
import model.house.House;
import persistence.FileManagement;

public class Person {

    protected int id;
    protected String profession;
    protected String type;

    public Person(int id, String profession, String type) {
        this.id = id;
        this.profession = profession;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getName() {
        return id;
    }

    public void setName(int id) {
        this.id = id;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isType(Neighborhood neighborhoodType)  {
        for (String i : neighborhoodType.getType()) {
            if (type.equalsIgnoreCase(i)) {
                return true;
            }
        }
        return false;
    }

    public void checkProfession(Neighborhood neighborhood, House house,
                                FileManagement fileManagement) throws MyException {
        if (house.isThisSize()) {
            fileManagement.saveData("< OK: Rented the house to a new tenant >");
        } else throw new MyException(MyException.NO_MORE_TENANTS_FIT);
    }
}