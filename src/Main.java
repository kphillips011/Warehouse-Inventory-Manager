import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

// The main program reads a file stream of input 'items', adds them to the inventory,
// and outputs files. We also added an average price calculation for showcasing purposes.
public class Main {

  static Inventory inv = new Inventory(new TreeMap<>());

  public static void main(final String[] args) {
    final String name = "inventoryIn.txt";

    readFile(name);
    // TODO print search method results for each search method
    // TODO show adding/removing products, quantity, etc
    // Inventory is automatically sorted by ascending ID, since it is a TreeMap
    writeFile();
    inv.sortDescendingID();
    writeFile();
    inv.sortAscendingName();
    writeFile();
    inv.sortDescendingName();
    writeFile();
    inv.sortAscendingPrice();
    writeFile();
    inv.sortDescendingPrice();
    writeFile();
    inv.sortAscendingQuantity();
    writeFile();
    inv.sortDescendingQuantity();
    writeFile();

    // Print average price of inventory
    System.out.printf("average price of inventory: $%.2f %n", inv.averagePrice());
  }

  // Reads input file and adds elements in file to inventory
  // Checks if ID of product is already in system, if so just adds quantity
  static void readFile(String fileName) {
    final File file = new File(fileName);
    try {
      final Scanner fileReader = new Scanner(file);

      while (fileReader.hasNext()) {
        final int id = fileReader.nextInt();
        String name = fileReader.next();
        while (fileReader.hasNext()) {
          if (fileReader.hasNextDouble() || fileReader.hasNextInt()) {
            break;
          } else {
            name += " " + fileReader.next();
          }
        }
        final double price = fileReader.nextDouble();
        final int quantity = fileReader.nextInt();
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
  // Writes to the file using fileFormat method
  static void writeFile() {
    final String date = new SimpleDateFormat("MM-dd-yyyy_hh-mm-ss-SS").format(new Date());
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
    try {
      TimeUnit.MILLISECONDS.sleep(1);
    } catch (InterruptedException e) {
      System.out.println("Sleep did not work.");
      e.printStackTrace();
    }
  }

  // Format for the writeFile method to use
  // Structured in markdown syntax to create a table of all the products in the inventory
  public static String fileFormat() {
    final StringBuilder format = new StringBuilder();
    format.append("| ID | Name | Price | Quantity |" + "  " + System.lineSeparator());
    format.append(
        "| :------------: | :------------: | :-------------: | :------------: |"
            + "  "
            + System.lineSeparator());
    for (final Map.Entry<Integer, Product> i : inv.getMap().entrySet()) {
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
