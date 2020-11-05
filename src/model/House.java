package model;

import java.util.List;

public class House {

    private int id;
    private int capacity;
    private int prize;
    private List<Person> person;

    public House(int id, int capacity, int prize, List<Person> person) {
        this.id = id;
        this.capacity = capacity;
        this.prize = prize;
        this.person = person;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getPrize() {
        return prize;
    }

    public void setPrize(int prize) {
        this.prize = prize;
    }

    public List<Person> getPerson() {
        return person;
    }

    public void setPerson(List<Person> person) {
        this.person = person;
    }
}
