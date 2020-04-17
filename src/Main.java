// imports
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// the main program reads a file stream of input 'items' and adds them to our inventory, output a file
public class Main {

    // TODO output log -

    public static void main(final String[] args) {
        // testing for now
        Inventory inv = new Inventory();
        inv.addProduct("item one",1.11,1);
        inv.addProduct("item two",2.22,2);
        inv.addProduct("item three",3.33,3);
        System.out.println(inv);
        inv.getProductInfo(1);
        inv.getProductInfo(2);
        inv.getProductInfo(3);
        inv.addItem(1,1); // quantity of ID '1' should now be 2
        System.out.println(inv);
        inv.getProductInfo(1);
        inv.getProductInfo(2);
        inv.getProductInfo(3);
        inv.removeItem(2,1); // quantity of ID '2' should now be 1
        System.out.println(inv);
        inv.getProductInfo(1);
        inv.getProductInfo(2);
        inv.getProductInfo(3);
        inv.removeProduct(3); // ID '3' should be completely removed
        System.out.println(inv);
        inv.getProductInfo(1);
        inv.getProductInfo(2);
        inv.getProductInfo(3);

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
