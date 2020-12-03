package model;

import exceptions.MyException;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private int id;
    private String profession;
    private String type;

    public Person(int id, String profesion, String type) {
        this.id = id;
        this.profession = profesion;
        this.type = type;
    }

    public void checkProfession(Neighborhood neighborhood) throws MyException {
        if (!professions()) throw new MyException(MyException.PROFESSION_NOT_ADMITTED_NEIGHBORHOOD);
        if (neighborhood.getName().equalsIgnoreCase("ofidelia")) {
            switch (this.type.toUpperCase()) {
                case "RICO":
                    if (!this.profession.equalsIgnoreCase("pescador") ||
                            this.profession.equalsIgnoreCase("contable"))
                        throw new MyException(MyException.PROFESSION_NOT_ADMITTED_NEIGHBORHOOD);
                    break;
                case "POBRE":
                    if (neighborhood.getName().equalsIgnoreCase("ofidelia")) {
                        if (!this.profession.equalsIgnoreCase("pescador") ||
                                this.profession.equalsIgnoreCase("contable"))
                            throw new MyException(MyException.PROFESSION_NOT_ADMITTED_NEIGHBORHOOD);
                    } else {
                        if (!this.profession.equalsIgnoreCase("pescador"))
                            throw new MyException(MyException.PROFESSION_NOT_ADMITTED_NEIGHBORHOOD);
                    }
                    break;
                case "TRANQUILO":
                    if (this.profession.equalsIgnoreCase("directivo"))
                        throw new MyException(MyException.PROFESSION_NOT_ADMITTED_NEIGHBORHOOD);
                    break;
            }
        }
    }

    private boolean professions() {
        List<String> stringList = new ArrayList<>();
        stringList.add("CONTABLE");
        stringList.add("EMPRESARIO");
        stringList.add("DIRECTIVO");
        stringList.add("PESCADOR");

        for (String x : stringList) if (this.profession.equalsIgnoreCase(x)) return true;
        return false;
    }

    public boolean checkType(Neighborhood neighborhoodType) throws MyException {
        if (!isTypeTrue(this.type)) throw new MyException(MyException.WRONG_TYPE_PERSON);
        for (String i : neighborhoodType.getType()) if (type.equalsIgnoreCase(i)) return true;
        return false;
    }

    public boolean isTypeTrue(String tenantType) {
        return tenantType.equalsIgnoreCase("RICO")
                || tenantType.equalsIgnoreCase("POBRE")
                || tenantType.equalsIgnoreCase("TRANQUILO");
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
}