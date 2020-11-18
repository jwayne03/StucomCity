package model;

public class Person {

    private String name;
    private String profession;
    private String type;

    public Person(String name, String profesion, String type) {
        this.name = name;
        this.profession = profesion;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
