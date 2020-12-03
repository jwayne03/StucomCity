package manager;

import exceptions.Exceptions;
import exceptions.MyException;
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

//                    Arrays.stream(data).forEach(i -> System.out.print(i + " "));

                    classification(data);
                } catch (Exceptions | MyException e) {
                    System.out.println(e.getMessage());
                }
            }
            fatalError();
        } catch (Exceptions | FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.getMessage();
        }
    }

    private void classification(String[] data) throws Exceptions, MyException {
        switch (data[0].toUpperCase()) {
            case "C":
                if (data.length != 5) throw new Exceptions(Exceptions.NUMBER_PARAMETERS_INCORRECT);
                neighborhood = checkNeighborhood(data[1].toUpperCase());
                neighborhood.build(data);
                break;
            case "E":
                if (data.length != 3) throw new Exceptions(Exceptions.NUMBER_PARAMETERS_INCORRECT);
                neighborhood = checkNeighborhood(data[1].toUpperCase());
                neighborhood.destroy(Integer.parseInt(data[2]));
                break;
            case "A":
                if (data.length != 6) throw new Exceptions(Exceptions.NUMBER_PARAMETERS_INCORRECT);
                neighborhood = checkNeighborhood(data[1].toUpperCase());
                house = neighborhood.checkIdHouse(Integer.parseInt(data[2]));
                house.rent(data, neighborhood);
                break;
            case "D":
                if (data.length != 4) throw new Exceptions(Exceptions.NUMBER_PARAMETERS_INCORRECT);
                neighborhood = checkNeighborhood(data[1].toUpperCase());
                house = neighborhood.checkIdHouse(Integer.parseInt(data[2]));
                if (!house.isEvicted(Integer.parseInt(data[3])))
                    throw new MyException(MyException.PERSON_NOT_FOUND);
                break;
            case "L":
                if (data.length != 2) throw new Exceptions(Exceptions.NUMBER_PARAMETERS_INCORRECT);
                neighborhood = checkNeighborhood(data[1].toUpperCase());
                neighborhood.listHousesNeighborhood("l");
                break;
            case "V":
                if (data.length != 3) throw new Exceptions(Exceptions.NUMBER_PARAMETERS_INCORRECT);
                house.accomodationList();
                break;
            case "S":
                if (data.length != 1) throw new Exceptions(Exceptions.NUMBER_PARAMETERS_INCORRECT);
                stucomCityList(data);
                break;
            case "X":
                finish();
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

    private void stucomCityList(String[] data) {
        System.out.println("OK: List all");
        neighborhoods.stream().forEach(neighborhood1 -> {
            System.out.print("<Neighborhood " + neighborhood.getName() + " >");
            try {
                neighborhood.listHousesNeighborhood("s");
            } catch (Exceptions exceptions) {
                exceptions.printStackTrace();
            }
        });
    }

    private static void fatalError() throws Exceptions {
        throw new Exceptions(Exceptions.READ_ERROR);
    }

    private boolean finish() {
        return true;
    }
}
