package model;

import exceptions.Exception;
import exceptions.MyException;
import model.Person;

import java.util.ArrayList;
import java.util.List;

public class House {

    private int id;
    private int capacity;
    private int prize;
    private List<Person> people;

    public House() {

    }

    public House(int id, int capacity, int prize) {
        this.id = id;
        this.capacity = capacity;
        this.prize = prize;
        people = new ArrayList<>();
    }

    public void rent(String[] data, Neighborhood neighborhood) throws Exception {
        String tenantType = data[3].toUpperCase();
        String tenantProfession = data[4].toUpperCase();
        int tenantId = Integer.parseInt(data[5]);

        if (checkSize()) throw new MyException(MyException.NO_MORE_TENANTS_FIT);
        if (neighborhood.checkType(tenantType)) throw new MyException(MyException.WRONG_TYPE_PERSON);
    }

    public void evict(String[] data, Neighborhood neighborhood) {
        String neighbordhood = data[1].toUpperCase();
        int id = Integer.parseInt(data[2]);
        int tenantId = Integer.parseInt(data[3]);


    }

    public List<Person> getPeople() {
        return people;
    }

    private boolean checkSize() {
        return (this.capacity >= people.size());
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }

    public int getId() {
        return id;
    }
}