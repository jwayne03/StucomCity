package manager;

import exceptions.MyException;

import java.io.*;

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
