import java.util.*;

public class Inventory {

  private Map<Integer, Product> inventory;

  // Default constructor; creates new Inventory
  public Inventory(final Map<Integer, Product> i) {
    this.inventory = i;
  }

  // Returns the Map representation of the Inventory
  public Map<Integer, Product> getMap() {
    return this.inventory;
  }

  // Increments quantity of item with specified ID;
  // ID passed as parameter
  // The boolean confirms whether the ID is present or not,
  // and if the increment passed is valid
  public boolean addItem(final int ID, final int inc) {
    if (inc <= 0)
    {
      System.out.println("Increment value must be greater than 0");
      return false;
    }
    if (inventory.containsKey(ID)) {
      inventory.get(ID).incQuantity(inc);
      return true;
    } else {
      return false;
    }
  }

  // Adds a new product to Inventory
  // Name, price, and quantity of the item passed as parameter
  public void addProduct(final String name, final double price, final int quantity) {
    final int ID = inventory.size() + 1;
    inventory.put(ID, new Product(ID, name, price, quantity));
  }

  // Adds a new product to Inventory if not already present
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

  // Decrement item quantity, unless quantity is already at 0
  // ID and decrement value passed as parameters
  // Boolean confirms whether ID is present or not
  // and if the decrement passed is valid
  public boolean removeItem(final int ID, final int dec) {
    if (dec <= 0)
    {
      System.out.println("Decrement value must be greater than 0");
      return false;
    }
    if (inventory.containsKey(ID) && inventory.get(ID).getQuantity() > 0) {
      inventory.get(ID).decQuantity(dec);
      return true;
    } else {
      return false;
    }
  }

  // Given a valid ID, removes a product from the Inventory
  // unless associated ID not present
  public boolean removeProduct(final int ID) {
    if (ID < 0)
    {
      System.out.println("Error: ID cannot be less than 0");
      return false;
    }
    if (inventory.containsKey(ID)) {
      inventory.remove(ID);
      return true;
    } else {
      System.out.println("Error: Product not found so it could not be removed");
      return false;
    }
  }

  // Sorts the inventory by item ID, in ascending order
  public void sortAscendingID() {
    final Map<Integer, Product> ascend = inventory;
    inventory = new TreeMap<>();
    inventory.putAll(ascend);
  }

  // Sorts the inventory by item ID, in descending order
  public void sortDescendingID() {
    final Map<Integer, Product> reverse = inventory;
    inventory = new TreeMap<>(Collections.reverseOrder());
    inventory.putAll(reverse);
  }

  // Sorts the inventory by item quantity, in ascending order
  public void sortAscendingQuantity() {
    List<Map.Entry<Integer, Product>> ascendQuantity = new ArrayList<>(inventory.entrySet());
    ascendQuantity.sort(Collections.reverseOrder(new DescendingQuantity()));
    inventory = new LinkedHashMap<>();
    for (Map.Entry<Integer, Product> i : ascendQuantity) {
      inventory.put(i.getKey(), i.getValue());
    }
  }

  // Sorts the inventory by item quantity, in descending order
  public void sortDescendingQuantity() {
    List<Map.Entry<Integer, Product>> descendQuantity = new ArrayList<>(inventory.entrySet());
    descendQuantity.sort(new DescendingQuantity());
    inventory = new LinkedHashMap<>();
    for (Map.Entry<Integer, Product> i : descendQuantity) {
      inventory.put(i.getKey(), i.getValue());
    }
  }

  // Sorts the inventory by item price, in ascending order
  public void sortAscendingPrice() {
    List<Map.Entry<Integer, Product>> ascendPrice = new ArrayList<>(inventory.entrySet());
    ascendPrice.sort(Collections.reverseOrder(new DescendingPrice()));
    inventory = new LinkedHashMap<>();
    for (Map.Entry<Integer, Product> i : ascendPrice) {
      inventory.put(i.getKey(), i.getValue());
    }
  }

  // Sorts the inventory by item price, in descending order
  public void sortDescendingPrice() {
    List<Map.Entry<Integer, Product>> descendPrice = new ArrayList<>(inventory.entrySet());
    descendPrice.sort(new DescendingPrice());
    inventory = new LinkedHashMap<>();
    for (Map.Entry<Integer, Product> i : descendPrice) {
      inventory.put(i.getKey(), i.getValue());
    }
  }

  // Sorts the inventory by item name, in ascending order
  public void sortAscendingName() {
    List<Map.Entry<Integer, Product>> ascendName = new ArrayList<>(inventory.entrySet());
    ascendName.sort(new AscendingName());
    inventory = new LinkedHashMap<>();
    for (Map.Entry<Integer, Product> i : ascendName) {
      inventory.put(i.getKey(), i.getValue());
    }
  }

  // Sorts the inventory by item name, in descending order
  public void sortDescendingName() {
    List<Map.Entry<Integer, Product>> descendName = new ArrayList<>(inventory.entrySet());
    descendName.sort(Collections.reverseOrder(new AscendingName()));
    inventory = new LinkedHashMap<>();
    for (Map.Entry<Integer, Product> i : descendName) {
      inventory.put(i.getKey(), i.getValue());
    }
  }

  // Computes and returns the total value of the Inventory's items, taking quantity into account
  public double totalValue() {
    double totalValue = 0;
    for (final Map.Entry<Integer, Product> entry : this.getMap().entrySet()) {
      Product product = entry.getValue();
      totalValue += (product.getPrice() * product.getQuantity());
    }
    return totalValue;
  }

  // Computes and returns the total quantity of items in the Inventory
  public int totalQuantity() {
    int totalQuantity = 0;
    for (final Map.Entry<Integer, Product> entry : this.getMap().entrySet()) {
      Product product = entry.getValue();
      totalQuantity += product.getQuantity();
    }
    return totalQuantity;
  }

  // Computes and returns the average price of the Inventory's items, taking quantity into account
  public double averagePrice() {
    return this.totalValue() / this.totalQuantity();
  }

  // Returns the item ID in the Inventory with the lowest price
  public int findLowestPricedItem() {

    int lowestID = getMap().entrySet().iterator().next().getValue().getNumber();
    for (final Map.Entry<Integer, Product> entry : this.getMap().entrySet()) {
      double currPrice = entry.getValue().getPrice();
      if (currPrice < getMap().get(lowestID).getPrice()) {
        lowestID = entry.getValue().getNumber();
      }
    }
    return lowestID;
  }

  // Returns the item ID in the Inventory with the highest price
  public int findHighestPricedItem() {
    int highestID = getMap().entrySet().iterator().next().getValue().getNumber();
    for (final Map.Entry<Integer, Product> entry : this.getMap().entrySet()) {
      double currPrice = entry.getValue().getPrice();
      if (currPrice > getMap().get(highestID).getPrice()) {
        highestID = entry.getValue().getNumber();
      }
    }
    return highestID;
  }

  // Returns the item ID in the Inventory with the highest quantity
  public int findHighestQuantityItem() {
    int highestID = getMap().entrySet().iterator().next().getValue().getNumber();
    for (final Map.Entry<Integer, Product> entry : this.getMap().entrySet()) {
      int currQuantity = entry.getValue().getQuantity();
      if (currQuantity > getMap().get(highestID).getQuantity()) {
        highestID = entry.getValue().getNumber();
      }
    }
    return highestID;
  }

  // Returns the item ID in the Inventory with the lowest quantity
  public int findLowestQuantityItem() {
    int lowestID = getMap().entrySet().iterator().next().getValue().getNumber();
    for (final Map.Entry<Integer, Product> entry : this.getMap().entrySet()) {
      int currQuantity = entry.getValue().getQuantity();
      if (currQuantity < getMap().get(lowestID).getQuantity()) {
        lowestID = entry.getValue().getNumber();
      }
    }
    return lowestID;
  }

  // Given a String name, returns the ID of the first item with that name
  public int findProduct(final String name) {
    for (final Map.Entry<Integer, Product> entry : this.getMap().entrySet()) {
      if (entry.getValue().getName().equalsIgnoreCase(name)) {
        return entry.getKey();
      }
    }
    System.out.println("Could not find an item with that name");
    return -1;
  }

  // Returns String representation of the Inventory
  public String toString() {
    return (inventory.entrySet() + "");
  }
}
