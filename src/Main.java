// imports
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

// the main program reads a file stream of input 'items' and adds them to our inventory, output a
// file
public class Main {

  // TODO output log - two different logs that print inventory, maybe comparing the two for a
  //  changelog?
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

    writeFile();
    inv.sortDescendingName();
    writeFile();
  }

  // Reads input file and adds elements in file to inventory
  // Checks if ID of product is already in system, if so just adds quantity
  static void readFile(String fileName) {
    final File file = new File(fileName);
    try {
      final Scanner fileReader = new Scanner(file);

      while (fileReader.hasNext()) {
        int id = fileReader.nextInt();
        String name = fileReader.next();
        while (fileReader.hasNext()) {
          if (fileReader.hasNextDouble() || fileReader.hasNextInt())
          {
            break;
          }
          else {
            name += " " + fileReader.next();
          }
        }
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

  // Creates a log file of all products in the inventory to the program directory
  // Log file name is always different so it does not overwrite old log file
  // Writes to the log file using the fileFormat method as the String
  static void writeFile() {
    final String date =
        new SimpleDateFormat("MM-dd-yyyy_hh-mm-ss").format(new Date());
    final String fileName = ("log_" + date + ".md");
    final File newFile = new File(fileName);
    try {
      System.out.println("Log file created successfully.");
      newFile.createNewFile();
    } catch (IOException e) {
      System.out.println("Log file creation error.");
      e.printStackTrace();
    }
    try {
      final FileWriter writer = new FileWriter(fileName);
      writer.write("#Warehouse Inventory Log: " + date + "  " + System.lineSeparator());
      writer.write(fileFormat());
      writer.close();
    } catch (IOException e) {
      System.out.println("An error occurred while writing to file.");
      e.printStackTrace();
    }
  }

  // Format for the writeFile method to use
  // Structured in markdown syntax to create a table of all the products in the inventory
  // The lineSeparator() is unnecessary but used for ease of reading before the format to markdown
  public static String fileFormat() {
    final StringBuilder format = new StringBuilder();
    format.append("| ID | Name | Price | Quantity |" + "  " + System.lineSeparator());
    format.append(
        "| :------------: | :------------: | :-------------: | :------------: |"
            + "  "
            + System.lineSeparator());
    for (Map.Entry<Integer, Product> i : inv.getMap().entrySet()) {
      format.append(
          "| " + i.getKey() + " | " + i.getValue().toString() + "  " + System.lineSeparator());
    }
    final DecimalFormat df = new DecimalFormat(("###.##"));
    format.append(
        "| **Total** | **...** | **"
            + df.format(inv.totalValue())
            + "** | **"
            + inv.totalQuantity()
            + "** |");
    return format.toString();
  }
}
