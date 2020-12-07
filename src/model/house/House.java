package model.house;

import exceptions.MyException;
import model.Neighborhood;
import model.person.Person;
import persistence.FileManagement;

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

    public List<Person> getPeople() {
        return people;
    }

    public boolean isThisSize() {
        return (this.capacity >= people.size());
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }

    public int getId() {
        return id;
    }

    public void rent(String[] data, Neighborhood neighborhood,
                     House house, FileManagement fileManagement) throws MyException {
        String tenantType = data[3].toUpperCase();
        String tenantProfession = data[4].toUpperCase();
        int tenantId = Integer.parseInt(data[5]);

        person = new Person(tenantId, tenantProfession, tenantType);

        if (!isThisSize()) throw new MyException(MyException.NO_MORE_TENANTS_FIT);
        if (!person.isType(neighborhood)) throw new MyException(MyException.INCORRECT_TENANT_PROFESSION);
        person.checkProfession(neighborhood, house, fileManagement);
    }

    public boolean isEvicted(int id, FileManagement fileManagement) {
        for (Person person : people) {
            if (person.getId() == id) people.remove(person);
            fileManagement.saveData("< OK: Evicted tenant of the house >");
            return true;
        }
        return false;
    }

    public void accomodationList(FileManagement fileManagement) {
        fileManagement.saveData("\n< OK: Listing tenants of the House >");

        for (Person person : people) {
            fileManagement.saveData("<Tenant with id: " + person.getId() + " is " + person.getType() + " and "
                    + person.getProfession() + ">");
        }
        fileManagement.saveData("< There are no more tenants in the house >");
    }
}