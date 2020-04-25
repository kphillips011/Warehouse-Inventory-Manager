// imports
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

// the main program reads a file stream of input 'items' and adds them to our inventory, output a
// file
public class Main {

  // TODO output log - two different logs that print inventory, maybe comparing the two for a
  // changelog?
  static Inventory inv = new Inventory(new HashMap<Integer, Product>());

  public static void main(final String[] args) {
    inv.addProduct(new Product(1, "IPhoneSE", 399.99, 1));
    String name = "inventoryIn.txt";
    inv.getProductInfo(1);
    inv.getProductInfo(2); // Should be non-existent
    inv.getProductInfo(3); // Should be non-existent
    readFile(name);
    inv.getProductInfo(
        1); // Test to see if IPhoneSE just adds quantity of readFile to existing product
    inv.getProductInfo(2); // Test to see if Non-existing product gets added in readFile
    inv.getProductInfo(3);
    inv.addItem(2, 3); // Test for adding to existing readFile product
    inv.getProductInfo(2);

    /* Test for Log file creation (creates in IntelliJ Warehouse directory) (Works; Tested 4/13)
    Log newLog = new Log();
    newLog.writeFile();
    */
  }

  static void readFile(String fileName) {
    final File file = new File(fileName);
    try {
      final Scanner fileReader = new Scanner(file);

      while (fileReader.hasNext()) {
        int id = fileReader.nextInt();
        String name = fileReader.next();
        double price = fileReader.nextDouble();
        int quantity = fileReader.nextInt();
        if (inv.getMap().containsKey(id)) {
          inv.addItem(id, quantity);
        } else {
          inv.addProduct(new Product(id, name, price, quantity));
        }
      }
      fileReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("No file found.");
      e.printStackTrace();
    }
  }
}
