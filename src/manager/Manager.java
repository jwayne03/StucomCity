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
    private List<Neighborhood> neighborhoods;

    private Manager() {
        house = new House();
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
                if (line.isEmpty()) break;
                String[] data = line.split(" ");
                try {
                    switch (data[0].toUpperCase()) {
                        case "C":
                            build(data);
                            break;
                        case "E":
                            destroy(data);
                            break;
                        case "A":
                            // rent
                            break;

                        case "D":
                            // evict
                            break;
                        case "L":
                            // houses neighborhood list
                            break;
                        case "V":
                            // accomodation list
                            break;
                        case "S":
                            // stucom city list
                            break;
                        case "X":
                            System.out.println("EXIT HAHAAH");
                            System.exit(0);
                            break;
                        default:
                            throw new Exception(Exception.NUMBER_PARAMETERS_INCORRECT);
                    }
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

    private void initArrayOfNeighborhood() {
        neighborhoods.add(new Alameda("ALAMEDA"));
        neighborhoods.add(new Barriobajo("BARRIOBAJO"));
        neighborhoods.add(new Vistaalegre("VISTAALEGRE"));
        neighborhoods.add(new Villaconcha("VILLACONCHA"));
        neighborhoods.add(new Villaconchaalta("VILLACONCHAALTA"));
        neighborhoods.add(new Nolomires("NOLOMIRES"));
        neighborhoods.add(new Ofidelia("OFIDELIA"));
    }

    private void build(String[] data) throws Exception, ArrayIndexOutOfBoundsException {

    }

    private void destroy(String[] data) {

    }

    private static void fatalError() throws Exception {
        throw new Exception(Exception.READ_ERROR);
    }

    private static void numberOfParametersIncorrect() throws Exception {
        throw new Exception(Exception.NUMBER_PARAMETERS_INCORRECT);
    }
}
