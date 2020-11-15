package manager;

import exceptions.MyException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Manager implements Runnable {

    private static Manager manager;

    private Manager() {

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
        File file = new File("P0_ejemplo_entrada.txt");
        if (file.exists()) {
            try {
                BufferedReader read = new BufferedReader(new FileReader(file));
                String line;

                while ((line = read.readLine()) != null) {
                    if (line.isEmpty()) break;
                    String[] data = line.split(" ");

                    switch (data[0].toUpperCase()) {
                        case "C":
                            // build
                            break;
                        case "E":
                            // destroy
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
                            // exit
                            break;
                        default:
                            // throw exception
                            break;
                    }
                }
                fatalError();
            } catch (MyException | FileNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                e.getMessage();
            }
        }
    }

    private static void fatalError() throws MyException {
        throw new MyException(MyException.READ_ERROR);
    }
}
