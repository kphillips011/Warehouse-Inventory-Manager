// imports
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {

  Inventory inv;
  Product p;

  // File name changes each time you create it with new date and time so no file will ever be the
  // same. Allows you to
  // create more than one log file if needed without overwriting.
  public void writeFile() {
    final String fileName =
        new SimpleDateFormat("'log_'MM-dd-yyyy_hh-mm-ss'.md'").format(new Date());
    final File newFile = new File(fileName);
    // Not necessary unless we need to specify where the file is being created
    // newFile.getParentFile().mkdir(); Use for testing
    // TODO fill newFile with fileFormat()
    try {
      System.out.println("Log file created successfully.");
      newFile.createNewFile();
    } catch (IOException e) {
      System.out.println("Log file creation error.");
      e.printStackTrace();
    }
    try {
      FileWriter writer = new FileWriter(fileName);
      writer.write(inv.toString());
      writer.close();
    } catch (IOException e) {
      System.out.println("An error occurred while writing to file.");
      e.printStackTrace();
    }
  }

  // Format for how to write the log
  public String fileFormat() {
    inv.getProductInfo(1);
    // for (int i = 0; i < inv.getMap().size(); i++) {
    // inv.getProductInfo(i);
    // }
    return "";
  }
}
