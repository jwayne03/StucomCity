package manager;

import exceptions.Exceptions;
import exceptions.MyException;
import model.house.House;
import model.Neighborhood;
import model.neighborhoods.Alameda;
import model.neighborhoods.Barriobajo;
import model.neighborhoods.Nolomires;
import model.neighborhoods.Ofidelia;
import model.neighborhoods.Villaconcha;
import model.neighborhoods.Villaconchaalta;
import model.neighborhoods.Vistaalegre;
import persistence.FileManagement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Manager implements Runnable {

    private static Manager manager;
    private FileManagement fileManagement;
    private House house;
    private Neighborhood neighborhood;
    private List<Neighborhood> neighborhoods;
    private boolean exit;

    private final String INPUT_FILE = "P1_ejemplo_entrada.txt";

    private Manager() {
        house = new House();
        neighborhood = new Neighborhood();
        neighborhoods = new ArrayList<>();
        fileManagement = new FileManagement();
        initArrayOfNeighborhood();
    }

    public static Manager getInstance() {
        if (manager == null) manager = new Manager();
        return manager;
    }

    @Override
    public void run() {
        readFile();
    }

    private void readFile() {
        try {
            File file = new File(INPUT_FILE);
            if (!file.exists()) fatalError();
            BufferedReader read = new BufferedReader(new FileReader(file));
            String line;
            exit = false;

            while ((line = read.readLine()) != null && (!exit)) {
                try {
                    String[] data = line.split(" ");
                    dataManager(data);
                } catch (Exceptions | MyException e) {
                    fileManagement.saveData(e.getMessage());
                }
            }
        } catch (Exceptions | IOException e) {
            fileManagement.saveData(e.getMessage());
        }
    }

    private void dataManager(String[] data) throws Exceptions, MyException {
        switch (data[0].toUpperCase()) {
            case "C":
                if (data.length != 5) throw new Exceptions(Exceptions.NUMBER_PARAMETERS_INCORRECT);
                neighborhood = checkNeighborhood(data[1].toUpperCase());
                neighborhood.build(data, fileManagement);
                break;
            case "E":
                if (data.length != 3) throw new Exceptions(Exceptions.NUMBER_PARAMETERS_INCORRECT);
                neighborhood = checkNeighborhood(data[1].toUpperCase());
                neighborhood.destroy(Integer.parseInt(data[2]), fileManagement);
                break;
            case "A":
                if (data.length != 6) throw new Exceptions(Exceptions.NUMBER_PARAMETERS_INCORRECT);
                neighborhood = checkNeighborhood(data[1].toUpperCase());
                house = neighborhood.checkIdHouse(Integer.parseInt(data[2]));
                house.rent(data, neighborhood, house, fileManagement);
                break;
            case "D":
                if (data.length != 4) throw new Exceptions(Exceptions.NUMBER_PARAMETERS_INCORRECT);
                neighborhood = checkNeighborhood(data[1].toUpperCase());
                house = neighborhood.checkIdHouse(Integer.parseInt(data[2]));
                if (!house.isEvicted(Integer.parseInt(data[3]), fileManagement))
                    throw new MyException(MyException.PERSON_NOT_FOUND);
                break;
            case "L":
                if (data.length != 2) throw new Exceptions(Exceptions.NUMBER_PARAMETERS_INCORRECT);
                neighborhood = checkNeighborhood(data[1].toUpperCase());
                neighborhood.listHousesNeighborhood(data[0], fileManagement);
                break;
            case "V":
                if (data.length != 3) throw new Exceptions(Exceptions.NUMBER_PARAMETERS_INCORRECT);
                house.accommodationList(fileManagement);
                break;
            case "S":
                if (data.length != 1) throw new Exceptions(Exceptions.NUMBER_PARAMETERS_INCORRECT);
                stucomCityList();
                break;
            case "X":
                fileManagement.saveData("< End of Program >");
                exit = true;
                break;
            default:
                throw new Exceptions(Exceptions.WRONG_OPTION);
        }
    }

    private Neighborhood checkNeighborhood(String data) throws MyException {
        for (Neighborhood neighborhood : neighborhoods) {
            if (neighborhood.getName().equalsIgnoreCase(data)) {
                return neighborhood;
            }
        }
        throw new MyException(MyException.WRONG_NEIGHBORHOOD);
    }

    private void initArrayOfNeighborhood() {
        neighborhoods.add(new Alameda("ALAMEDA"));
        neighborhoods.add(new Barriobajo("BARRIOBAJO"));
        neighborhoods.add(new Vistaalegre("VISTAALEGRE"));
        neighborhoods.add(new Villaconcha("VILLACONCHA"));
        neighborhoods.add(new Villaconchaalta("VILLACONCHAALTA"));
        neighborhoods.add(new Nolomires("NOLOMIRES"));
        neighborhoods.add(new Ofidelia("OFIDELIA"));
    }

    private void stucomCityList() {
        fileManagement.saveData("< OK: Listing Neighborhoods >");
        neighborhoods.forEach(neighborhood1 -> {
            fileManagement.saveData("< Neighborhood " + neighborhood1.getName() + " >");
            if (neighborhood1.getHouses().size() == 0) {
                fileManagement.saveData("   < There are not houses >");
            } else {
                neighborhood1.getHouses().forEach(house -> {
                    fileManagement.saveData("       < House with id: " + house.getId()
                            + " has " + house.getPeople().size() + " tenants >");
                    house.getPeople().forEach(person -> {
                        fileManagement.saveData("       < Tenant with id: " + person.getId() + " is "
                                + person.getType() + " and "
                                + person.getProfession() + " >");
                    });
                });
            }
        });
        fileManagement.saveData("< End of the neighborhood list >");
    }

    private void fatalError() throws Exceptions {
        throw new Exceptions(Exceptions.READ_ERROR);
    }
}
