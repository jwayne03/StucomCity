package model.person;

import exceptions.MyException;
import model.Neighborhood;
import model.house.House;
import persistence.FileManagement;

public class Rich extends Person {

    public Rich(int id, String profession, String type) {
        super(id, profession, type);
    }

    @Override
    public void checkProfession(Neighborhood neighborhood, House house,
                                FileManagement fileManagement) throws MyException {
        if (!getProfession().equalsIgnoreCase("pescador") ||
                getProfession().equalsIgnoreCase("contable")) {
            throw new MyException(MyException.INCORRECT_TENANT_PROFESSION);
        }
        super.checkProfession(neighborhood, house, fileManagement);
    }
}
