package model.person;

import exceptions.MyException;
import model.Neighborhood;
import model.house.House;
import persistence.FileManagement;

public class Chill extends Person{

    public Chill(int id, String profession, String type) {
        super(id, profession, type);
    }

    @Override
    public void checkProfession(Neighborhood neighborhood, House house,
                                FileManagement fileManagement) throws MyException {
        if (!getProfession().equalsIgnoreCase("DIRECTIVO")) {
            throw new MyException(MyException.INCORRECT_TENANT_PROFESSION);
        } else super.checkProfession(neighborhood, house, fileManagement);
    }
}
