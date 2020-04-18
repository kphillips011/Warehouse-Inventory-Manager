// imports
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// the main program reads a file stream of input 'items' and adds them to our inventory, output a file
public class Main {

    // TODO output log - two different logs that print inventory, maybe comparing the two for a changelog?

    public static void main(final String[] args) {
        /* Test for Log file creation (creates in IntelliJ Warehouse directory) (Works; Tested 4/13)
        Log newLog = new Log();
        newLog.writeFile();
        */
    }

    public void checkInventoryIndex()
    {
        //TODO
    }

    public void readFile()
    {
        try {
            File file = new File("//TODO");
            Scanner fileReader = new Scanner(file);
            //TODO read file input, add to inventory
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("No file found.");
            e.printStackTrace();
        }
    }
}
