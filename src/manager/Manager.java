package manager;

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

    }

}
