package manager;

import exceptions.MyException;
import exceptions.Exception;
import model.House;
import model.Neighborhood;
import model.neighborhoods.Alameda;
import model.neighborhoods.Barriobajo;
import model.neighborhoods.Nolomires;
import model.neighborhoods.Ofidelia;
import model.neighborhoods.Villaconcha;
import model.neighborhoods.Villaconchaalta;
import model.neighborhoods.Vistaalegre;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Manager implements Runnable {

    private static Manager manager;
    private House house;
    private Neighborhood neighborhood;
    private List<Neighborhood> neighborhoods;


    private Manager() {
        house = new House();
        neighborhood = new Neighborhood();
        neighborhoods = new ArrayList<>();
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
            File file = new File("P1_ejemplo_entrada.txt");
            BufferedReader read = new BufferedReader(new FileReader(file));
            String line;

            while ((line = read.readLine()) != null) {
                try {
                    if (line.isEmpty()) break;
                    String[] data = line.split(" ");

                    for (String x : data) {
                        System.out.print(x + " ");
                    }

                    clasificator(data);
                    System.out.println();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            fatalError();
        } catch (Exception | FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.getMessage();
        }
    }

    private void clasificator(String[] data) throws Exception {
        switch (data[0].toUpperCase()) {
            case "C":
                neighborhood.build(data);
                break;
            case "E":
                neighborhood.destroy(data);
                break;
            case "A":
                rent(data);
                break;
            case "D":
                evict(data);
                break;
            case "L":
                listHousesNeighborhood(data);
                break;
            case "V":
                accomodationList(data);
                break;
            case "S":
                stucomCityList(data);
                break;
            case "X":
                finish();
                break;
            default:
                throw new Exception(Exception.WRONG_OPTION);
        }
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

//    private void checkHouseId(int houseId) throws MyException {
//        for (Neighborhood neighborhood : neighborhoods) {
//            for (House arrayHouse : neighborhood.getHouses()) {
//                if (arrayHouse.getHouseId() == houseId) throw new MyException(MyException.HOUSE_NOT_FOUND);
//            }
//        }
//    }

    private void rent(String[] data) throws Exception {
        if (data.length != 6) throw new Exception(Exception.NUMBER_PARAMETERS_INCORRECT);
    }

    private void evict(String[] data) throws Exception {
        if (data.length != 4) throw new Exception(Exception.NUMBER_PARAMETERS_INCORRECT);
    }

    private void listHousesNeighborhood(String[] data) throws Exception {
        if (data.length != 2) throw new Exception(Exception.NUMBER_PARAMETERS_INCORRECT);
    }

    private void accomodationList(String[] data) throws Exception {
        if (data.length != 3) throw new Exception(Exception.NUMBER_PARAMETERS_INCORRECT);
    }

    private void stucomCityList(String[] data) throws Exception {
        if (data.length != 1) throw new Exception(Exception.NUMBER_PARAMETERS_INCORRECT);
    }


    private static void fatalError() throws Exception {
        throw new Exception(Exception.READ_ERROR);
    }

    private static void numberOfParametersIncorrect() throws Exception {
        throw new Exception(Exception.NUMBER_PARAMETERS_INCORRECT);
    }

    private void finish() {
    }


}
