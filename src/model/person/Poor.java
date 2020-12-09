package model.person;

import exceptions.MyException;
import model.Neighborhood;
import model.house.House;
import persistence.FileManagement;

public class Poor extends Person {

    public Poor(int id, String profession, String type) {
        super(id, profession, type);
    }

    @Override
    public void checkProfession(Neighborhood neighborhood, House house,
                                FileManagement fileManagement) throws MyException {
        if (!getProfession().equalsIgnoreCase("CONTABLE")
                && !getProfession().equalsIgnoreCase("PESCADOR")) {
            throw new MyException(MyException.INCORRECT_TENANT_PROFESSION);
        }

        if (!getProfession().equalsIgnoreCase("CONTABLE")) {
            if (!neighborhood.getName().equalsIgnoreCase("OFIDELIA")) {
                throw new MyException(MyException.INCORRECT_TENANT_PROFESSION);
            }
        }
        super.checkProfession(neighborhood, house, fileManagement);
    }
}
