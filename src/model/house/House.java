package model.house;

import exceptions.MyException;
import model.Neighborhood;
import model.person.Chill;
import model.person.Person;
import model.person.Poor;
import model.person.Rich;
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

        //person = new Person(tenantId, tenantProfession, tenantType);


        if (!isThisSize()) throw new MyException(MyException.NO_MORE_TENANTS_FIT);
        person = checkType(person, tenantType, tenantId, tenantProfession, tenantType);
        if (!person.isType(neighborhood)) throw new MyException(MyException.PERSON_NOT_ADMITTED_IN_NEIGHBORHOOD);
        person.checkProfession(neighborhood, house, fileManagement);
        this.people.add(person);
    }

    public Person checkType(Person person, String type,int tenantId,String tenantProfession, String tenantType) throws MyException {
        Person person1;
        switch (type.toUpperCase()) {
            case "TRANQUILO":
                person1 = new Chill(tenantId, tenantProfession, tenantType);
                break;
            case "POBRE":
                person1 = new Poor(tenantId, tenantProfession, tenantType);
                break;
            case "RICO":
                person1 = new Rich(tenantId, tenantProfession, tenantType);
                break;
            default:
                throw new MyException(MyException.INCORRECT_TENANT_PROFESSION);
        }
        return person1;
    }

    public boolean isEvicted(int id, FileManagement fileManagement) throws MyException {
        for (Person person : people) {
            if (person.getId() == id) {
                people.remove(person);
                fileManagement.saveData("< OK: Evicted tenant of the house >");
                return true;
            }
        }
        throw new MyException(MyException.PERSON_NOT_FOUND);
    }

    public void accommodationList(FileManagement fileManagement) {
        fileManagement.saveData("\n< OK: Listing tenants of the House >");

        for (Person person : people) {
            fileManagement.saveData("<Tenant with id: " + person.getId() + " is " + person.getType() + " and "
                    + person.getProfession() + ">");
        }
        fileManagement.saveData("< There are no more tenants in the house >");
    }
}