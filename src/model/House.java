package model;

import exceptions.Exceptions;
import exceptions.MyException;

import java.util.ArrayList;
import java.util.List;

public class House {

    private int id;
    private int capacity;
    private int prize;
    private List<Person> people;
    private Person person;

    public House() {

    }

    public House(int id, int capacity, int prize) {
        this.id = id;
        this.capacity = capacity;
        this.prize = prize;
        people = new ArrayList<>();
    }

    public void rent(String[] data, Neighborhood neighborhood) throws Exceptions, MyException {
        String tenantType = data[3].toUpperCase();
        String tenantProfession = data[4].toUpperCase();
        int tenantId = Integer.parseInt(data[5]);

        person = new Person(tenantId, tenantProfession, tenantType);

        if (!isThisSize()) throw new MyException(MyException.NO_MORE_TENANTS_FIT);
        if (!person.isType(neighborhood)) throw new MyException(MyException.WRONG_TYPE_PERSON);
        person.checkProfession(neighborhood);

//        person.checkProfession(neighborhood);
    }

    public boolean isEvicted(int id) {
        for (Person person : people) {
            if (person.getId() == id) people.remove(person);
            System.out.println("Tenant evicted");
            return true;
        }
        return false;
    }

    public void accomodationList() {
        System.out.println("\nOK: List houses of renters");

        for (Person person : people) {
            System.out.println("<Renter with ID: " + person.getId() + " is " + person.getType() + " and "
                    + person.getProfession() + ">");

        }
        System.out.println("<No more renters in the house>");
    }

    public List<Person> getPeople() {
        return people;
    }

    private boolean isThisSize() {
        return (this.capacity >= people.size());
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }

    public int getId() {
        return id;
    }

}