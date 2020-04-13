import java.util.HashMap;
import java.util.Map;

// data structures to store inventory, add/remove methods, sort/search?
// possible Comparable implementation(s)?
public class Inventory {

    Map<Integer,Product> inventory;

    // default constructor, creates new Inventory
    public Inventory()
    {
        inventory = new HashMap<Integer,Product>();
    }

    // increments quantity of item with specified ID;
    // ID passed as parameter
    // the boolean confirms whether the ID is present or not,
    // and therefore if quantity was incremented or not
    public boolean addItem(int ID)
    {
        if (inventory.containsKey(ID)) {
            inventory.get(ID).incQuantity(1);
            return true;
        }
        else
        {
            return false;
        }
    }

    // adds a new product to Inventory
    // name, price, and quantity of the item passed as parameter
    public void addProduct(String name, double price, int quantity)
    {
        int ID = inventory.size() + 1;
        inventory.put(ID, new Product(ID,name,price,quantity));
    }

    // decrement item quantity, unless quantity is already at 0
    // ID passed as parameter
    public boolean removeItem(int ID)
    {
        if (inventory.get(ID).getQuantity() > 0)
        {
            inventory.get(ID).decQuantity(1);
            return true;
        }
        else
        {
            return false;
        }
    }

    // removes the product and its associated ID from the Inventory
    public boolean removeProduct(int ID)
    {
        if (inventory.containsKey(ID))
        {
            inventory.remove(ID);
            return true;
        }
        else
        {
            return false;
        }
    }

    // returns the Inventory sorted by item ID, in ascending order
    public void sortByID()
    {
        // TODO
    }

    // returns the Inventory sorted by item quantity, in ascending order
    public void sortByQuantity()
    {
        // TODO
    }

    // returns the Inventory sorted by item price, in ascending order
    public void sortByPrice()
    {
        // TODO
    }

    // TODO more sort methods

    // computes and returns the total value of the Inventory's items, taking quantity into account
    public int totalValue()
    {
        // TODO
        return -1;
    }

    // computes and returns the average price of the Inventory's items, taking quantity into account
    public int averagePrice()
    {
        // TODO
        return -1;
    }

    // returns the item in the Inventory with the lowest price
    public void findLowestPricedItem()
    {
        // TODO
    }

    // returns the item in the Inventory with the highest price
    public void findHighestPricedItem()
    {
        // TODO
    }

    // returns the item in the Inventory with the highest quantity
    public void findHighestQuantityItem()
    {
        // TODO
    }

    // returns the item in the Inventory with the lowest quantity
    public void findLowestQuantityItem()
    {
        // TODO
    }

    // returns String representation of the Inventory
    public String toString()
    {
        return (inventory.entrySet() + "");
    }

    // prints out specified ID's product info to the console
    public void getProductInfo(int ID)
    {
        if (inventory.containsKey(ID)) {
            System.out.println(ID + ": " + inventory.get(ID).getName() + ", " +
                    inventory.get(ID).getPrice() + ", " + inventory.get(ID).getQuantity());
        }
        else
        {
            System.out.print("Sorry, ID not found");
        }
    }

}
