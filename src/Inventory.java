import java.util.HashMap;
import java.util.Map;

// data structures to store inventory, add/remove methods, sort/search?
// possible Comparable implementation(s)?
public class Inventory {

    // TODO insert global instance variables here
    Map<Integer,Product> inventory;

    // constructor, creates new <data structure>
    public Inventory()
    {
        // TODO
        inventory = new HashMap<Integer,Product>();
    }

    public Inventory(int size)
    {
        inventory = new HashMap<Integer,Product>(size);
    }

    // increments quantity of item with specified ID;
    // ID passed as parameter
    // the boolean confirms whether the ID is present or not,
    // and therefore if quantity was incremented or not
    public boolean addItem(int ID)
    {
        // TODO
        if (inventory.containsKey(ID)) {
            inventory.get(ID).incQuantity(1);
            return true;
        }
        else
        {
            return false;
        }
    }

    // adds a new item to inventory
    // name, price, and quantity of the item passed as parameter
    public void addItem(String name, double price, int quantity)
    {
        // TODO
        int ID = inventory.size() - 1;
        inventory.put(ID, new Product(ID,name,price,quantity));
    }

    // decrement item quantity, unless quantity is already at 0
    // ID passed as parameter
    public void removeItem()
    {
        // TODO
    }

    // returns the inventory <data structure> sorted by item ID, in ascending order
    public void sortByID()
    {
        // TODO
    }

    // returns the inventory <data structure> sorted by item quantity, in ascending order
    public void sortByQuantity()
    {
        // TODO
    }

    // returns the inventory <data structure> sorted by item price, in ascending order
    public void sortByPrice()
    {
        // TODO
    }

    // TODO more sort methods

    // computes and returns the total value of the inventory's items, taking quantity into account
    public int totalValue()
    {
        // TODO
        return -1;
    }

    // computes and returns the average price of the inventory's items, taking quantity into account
    public int averagePrice()
    {
        // TODO
        return -1;
    }

    // returns the item in the inventory with the lowest price
    public void findLowestPricedItem()
    {
        // TODO
    }

    // returns the item in the inventory with the highest price
    public void findHighestPricedItem()
    {
        // TODO
    }

    // returns the item in the inventory with the highest quantity
    public void findHighestQuantityItem()
    {
        // TODO
    }

    // returns the item in the inventory with the lowest quantity
    public void findLowestQuantityItem()
    {
        // TODO
    }

}
