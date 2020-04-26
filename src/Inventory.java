import java.util.*;

public class Inventory {

  private Map<Integer, Product> inventory;

  // default constructor, creates new Inventory
  public Inventory(final Map<Integer, Product> i) {
    this.inventory = i;
  }

  // returns the map representation of inventory
  public Map<Integer, Product> getMap() {
    return this.inventory;
  }

  // increments quantity of item with specified ID;
  // ID passed as parameter
  // the boolean confirms whether the ID is present or not,
  // and if the increment passed is valid
  public boolean addItem(final int ID, final int inc) {
    // TODO exception throwing and return false if inc <= 0
    if (inventory.containsKey(ID) && inc > 0) {
      inventory.get(ID).incQuantity(inc);
      return true;
    } else {
      return false;
    }
  }

  // adds a new product to Inventory
  // name, price, and quantity of the item passed as parameter

  public void addProduct(final String name, final double price, final int quantity) {
    final int ID = inventory.size() + 1;
    inventory.put(ID, new Product(ID, name, price, quantity));
  }

  // adds a new product to Inventory
  // Product passed as parameter
  public boolean addProduct(final Product p) {
    if (inventory.containsKey(p.getNumber())) {
      System.out.println("ID already in use. Use another ID number.");
      return false;
    } else {
      inventory.put(p.getNumber(), p);
      return true;
    }
  }

  // decrement item quantity, unless quantity is already at 0
  // ID passed as parameter
  // boolean confirms whether ID is present or not
  // and if the decrement passed is valid
  public boolean removeItem(final int ID, final int dec) {
    // TODO exception throwing and return false if dec <= 0
    if (inventory.get(ID).getQuantity() > 0 && dec > 0) {
      inventory.get(ID).decQuantity(dec);
      return true;
    } else {
      return false;
    }
  }

  // removes the product and its associated ID from the Inventory
  public boolean removeProduct(final int ID) {
    if (inventory.containsKey(ID)) {
      inventory.remove(ID);
      return true;
    } else {
      System.out.println("Product not found so it could not be removed");
      return false;
    }
  }

  // returns the Inventory sorted by item ID, in ascending order
  public void sortAscendingID() {
    Map<Integer, Product> ascend = inventory;
    inventory = new TreeMap<Integer, Product>();
    inventory.putAll(ascend);
  }

  // returns the Inventory sorted by item ID, in descending order
  public void sortDescendingID() {
    Map<Integer, Product> reverse = inventory;
    inventory = new TreeMap<Integer, Product>(Collections.reverseOrder());
    inventory.putAll(reverse);
  }

  // returns the Inventory sorted by item price, in ascending order
  public void sortAscendingQuantity() {
    List<Map.Entry<Integer, Product>> ascendQuantity = new ArrayList<>(inventory.entrySet());
    ascendQuantity.sort(Collections.reverseOrder(new DescendingQuantity()));
    inventory = new LinkedHashMap<Integer, Product>();
    for (Map.Entry<Integer, Product> i : ascendQuantity) {
      inventory.put(i.getKey(), i.getValue());
    }
  }

  // returns the Inventory sorted by item price, in descending order
  public void sortDescendingQuantity() {
    List<Map.Entry<Integer, Product>> descendQuantity = new ArrayList<>(inventory.entrySet());
    descendQuantity.sort(new DescendingQuantity());
    inventory = new LinkedHashMap<Integer, Product>();
    for (Map.Entry<Integer, Product> i : descendQuantity) {
      inventory.put(i.getKey(), i.getValue());
    }
  }

  // returns the Inventory sorted by item price, in ascending order
  public void sortAscendingPrice() {
    List<Map.Entry<Integer, Product>> ascendPrice = new ArrayList<>(inventory.entrySet());
    ascendPrice.sort(Collections.reverseOrder(new DescendingPrice()));
    inventory = new LinkedHashMap<Integer, Product>();
    for (Map.Entry<Integer, Product> i : ascendPrice) {
      inventory.put(i.getKey(), i.getValue());
    }
  }

  // returns the Inventory sorted by item price, in descending order
  public void sortDescendingPrice() {
    List<Map.Entry<Integer, Product>> descendPrice = new ArrayList<>(inventory.entrySet());
    descendPrice.sort(new DescendingPrice());
    inventory = new LinkedHashMap<Integer, Product>();
    for (Map.Entry<Integer, Product> i : descendPrice) {
      inventory.put(i.getKey(), i.getValue());
    }
  }

  public void sortAscendingName() {
    List<Map.Entry<Integer, Product>> ascendName = new ArrayList<>(inventory.entrySet());
    ascendName.sort(new AscendingName());
    inventory = new LinkedHashMap<Integer, Product>();
    for (Map.Entry<Integer, Product> i : ascendName) {
      inventory.put(i.getKey(), i.getValue());
    }
  }

  public void sortDescendingName() {
    List<Map.Entry<Integer, Product>> descendName = new ArrayList<>(inventory.entrySet());
    descendName.sort(Collections.reverseOrder(new AscendingName()));
    inventory = new LinkedHashMap<Integer, Product>();
    for (Map.Entry<Integer, Product> i : descendName) {
      inventory.put(i.getKey(), i.getValue());
    }
  }

  // computes and returns the total value of the Inventory's items, taking quantity into account
  public double totalValue() {
    double totalValue = 0;
    for (Map.Entry<Integer, Product> entry : this.getMap().entrySet()) {
      Product product = entry.getValue();
      totalValue += (product.getPrice() * product.getQuantity());
    }
    return totalValue;
  }

  // computes and returns the total quantity of items in the Inventory
  public int totalQuantity() {
    int totalQuantity = 0;
    for (Map.Entry<Integer, Product> entry : this.getMap().entrySet()) {
      Product product = entry.getValue();
      totalQuantity += product.getQuantity();
    }
    return totalQuantity;
  }

  // computes and returns the average price of the Inventory's items, taking quantity into account
  public double averagePrice() {
    double average = this.totalValue() / this.totalQuantity();
    return average;
  }

  // returns the item ID in the Inventory with the lowest price
  public int findLowestPricedItem() {

    int lowestID = getMap().entrySet().iterator().next().getValue().getNumber();
    for (Map.Entry<Integer, Product> entry : this.getMap().entrySet()) {
      double currPrice = entry.getValue().getPrice();
      if (currPrice < getMap().get(lowestID).getPrice()) {
        lowestID = entry.getValue().getNumber();
      }
    }
    return lowestID;
  }

  // returns the item ID in the Inventory with the highest price
  public int findHighestPricedItem() {
    int highestID = getMap().entrySet().iterator().next().getValue().getNumber();
    for (Map.Entry<Integer, Product> entry : this.getMap().entrySet()) {
      double currPrice = entry.getValue().getPrice();
      if (currPrice > getMap().get(highestID).getPrice()) {
        highestID = entry.getValue().getNumber();
      }
    }
    return highestID;
  }

  // returns the item ID in the Inventory with the highest quantity
  public int findHighestQuantityItem() {
    int highestID = getMap().entrySet().iterator().next().getValue().getNumber();
    for (Map.Entry<Integer, Product> entry : this.getMap().entrySet()) {
      int currQuantity = entry.getValue().getQuantity();
      if (currQuantity > getMap().get(highestID).getQuantity()) {
        highestID = entry.getValue().getNumber();
      }
    }
    return highestID;
  }

  // returns the item ID in the Inventory with the lowest quantity
  public int findLowestQuantityItem() {
    int lowestID = getMap().entrySet().iterator().next().getValue().getNumber();
    for (Map.Entry<Integer, Product> entry : this.getMap().entrySet()) {
      int currQuantity = entry.getValue().getQuantity();
      if (currQuantity < getMap().get(lowestID).getQuantity()) {
        lowestID = entry.getValue().getNumber();
      }
    }
    return lowestID;
  }

  // given a String name, returns the ID of the first item with that name
  public int findProduct(final String name) {
    for (Map.Entry<Integer, Product> entry : this.getMap().entrySet()) {
      if (entry.getValue().getName().equalsIgnoreCase(name)) {
        return entry.getKey();
      }
    }
    System.out.println("Could not find an item with that name");
    return -1;
  }

  // returns String representation of the Inventory
  public String toString() {
    return (inventory.entrySet() + "");
  }

  // returns String representation of Product information, as used in the log
  public String toString(final int ID) {
    Product p = inventory.get(ID);
    return (p.getNumber() + " " + p.getName() + " " + p.getPrice() + " " + p.getQuantity());
  }

  // prints out specified ID's product info to the console
  public void getProductInfo(final int ID) {
    if (inventory.containsKey(ID)) {
      System.out.println(
          ID
              + ": "
              + inventory.get(ID).getName()
              + ", "
              + inventory.get(ID).getPrice()
              + ", "
              + inventory.get(ID).getQuantity());
    } else {
      System.out.println("Sorry, ID not found");
    }
  }
}
