package model;

public class Person {

    private String name;
    private String profesion;
    private String type;

    public Person(String name, String profesion, String type) {
        this.name = name;
        this.profesion = profesion;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
