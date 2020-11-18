package manager;

import exceptions.MyException;
import model.House;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Manager implements Runnable {

    private static Manager manager;
    private House house;

    private Manager() {
        house = new House();
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
            File file = new File("P0_ejemplo_entrada.txt");
            BufferedReader read = new BufferedReader(new FileReader(file));
            String line;

            while ((line = read.readLine()) != null) {
                if (line.isEmpty()) break;
                String[] data = line.split(" ");

                try {
                    switch (data[0].toUpperCase()) {
                        case "C":
                            house.buildHouse(data[1].toUpperCase(), Integer.parseInt(data[2]),
                                    Integer.parseInt(data[3]), Integer.parseInt(data[4]));
                            break;
                        case "E":
                            house.destroyHouse(data[1].toUpperCase(), Integer.parseInt(data[2]));
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
                            throw new MyException(MyException.NUMBER_PARAMETERS_INCORRECT);
                    }
                } catch (MyException e) {
                    System.out.println(e.getMessage());
                }
            }
            fatalError();
        } catch (MyException | FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.getMessage();
        }
    }

    private static void fatalError() throws MyException {
        throw new MyException(MyException.READ_ERROR);
    }

    private static void numberOfParametersIncorrect() throws MyException {
        throw new MyException(MyException.NUMBER_PARAMETERS_INCORRECT);
    }
}
