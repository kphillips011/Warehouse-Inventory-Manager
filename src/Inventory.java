import java.security.Key;
import java.util.*;

// TODO: possible Comparable implementation(s)?
public class Inventory {

    Map<Integer,Product> inventory;

    // default constructor, creates new Inventory
    public Inventory(final Map<Integer,Product> i)
    {
        this.inventory = i;
    }

    // returns the map representation of inventory
    public Map<Integer,Product> getMap()
    {
        return this.inventory;
    }

    // increments quantity of item with specified ID;
    // ID passed as parameter
    // the boolean confirms whether the ID is present or not,
    // and if the increment passed is valid
    public boolean addItem(final int ID, final int inc)
    {
        if (inventory.containsKey(ID) && inc > 0) {
            inventory.get(ID).incQuantity(inc);
            return true;
        }
        else
        {
            return false;
        }
    }

    // adds a new product to Inventory
    // name, price, and quantity of the item passed as parameter
    public void addProduct(final String name, final double price, final int quantity)
    {
        final int ID = inventory.size() + 1;
        inventory.put(ID, new Product(ID,name,price,quantity));
    }

    // decrement item quantity, unless quantity is already at 0
    // ID passed as parameter
    // boolean confirms whether ID is present or not
    // and if the decrement passed is valid
    public boolean removeItem(final int ID, final int dec)
    {
        if (inventory.get(ID).getQuantity() > 0 && dec > 0)
        {
            inventory.get(ID).decQuantity(dec);
            return true;
        }
        else
        {
            return false;
        }
    }

    // removes the product and its associated ID from the Inventory
    public boolean removeProduct(final int ID)
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
    public TreeMap<Integer,Product> sortByID()
    {
        return new TreeMap<Integer, Product>(inventory);
    }

    // add descending version with Comparator

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
    public double totalValue()
    {
        // TODO
        double totalValue = 0;
        for (Map.Entry<Integer,Product> entry : this.getMap().entrySet())
        {
            Product product = entry.getValue();
            totalValue += (product.getPrice() * product.getQuantity());
        }
        return totalValue;
    }

    // computes and returns the average price of the Inventory's items, taking quantity into account
    public double averagePrice()
    {
        // TODO
        int totalQuantity = 0;
        for (Map.Entry<Integer,Product> entry : this.getMap().entrySet())
        {
            Product product = entry.getValue();
            totalQuantity += product.getQuantity();
        }
        double average = this.totalValue() / totalQuantity;
        return average;
    }

    // returns the item ID in the Inventory with the lowest price
    public int findLowestPricedItem()
    {
        int lowestID = getMap().entrySet().iterator().next().getValue().getNumber();
        for (Map.Entry<Integer,Product> entry : this.getMap().entrySet())
        {
            double currPrice = entry.getValue().getPrice();
            if (currPrice < getMap().get(lowestID).getPrice())
            {
                lowestID = entry.getValue().getNumber();
            }
        }
        return lowestID;
    }

    // returns the item ID in the Inventory with the highest price
    public int findHighestPricedItem()
    {
        int highestID = getMap().entrySet().iterator().next().getValue().getNumber();
        for (Map.Entry<Integer,Product> entry : this.getMap().entrySet())
        {
            double currPrice = entry.getValue().getPrice();
            if (currPrice > getMap().get(highestID).getPrice())
            {
                highestID = entry.getValue().getNumber();
            }
        }
        return highestID;
    }

    // returns the item ID in the Inventory with the highest quantity
    public int findHighestQuantityItem()
    {
        int highestID = getMap().entrySet().iterator().next().getValue().getNumber();
        for (Map.Entry<Integer,Product> entry : this.getMap().entrySet())
        {
            int currQuantity = entry.getValue().getQuantity();
            if (currQuantity > getMap().get(highestID).getQuantity())
            {
                highestID = entry.getValue().getNumber();
            }
        }
        return highestID;
    }

    // returns the item ID in the Inventory with the lowest quantity
    public int findLowestQuantityItem()
    {
        int lowestID = getMap().entrySet().iterator().next().getValue().getNumber();
        for (Map.Entry<Integer,Product> entry : this.getMap().entrySet())
        {
            int currQuantity = entry.getValue().getQuantity();
            if (currQuantity < getMap().get(lowestID).getQuantity())
            {
                lowestID = entry.getValue().getNumber();
            }
        }
        return lowestID;
    }

    // returns String representation of the Inventory
    public String toString()
    {
        return (inventory.entrySet() + "");
    }

    // prints out specified ID's product info to the console
    public void getProductInfo(final int ID)
    {
        if (inventory.containsKey(ID)) {
            System.out.println(ID + ": " + inventory.get(ID).getName() + ", " +
                    inventory.get(ID).getPrice() + ", " + inventory.get(ID).getQuantity());
        }
        else
        {
            System.out.println("Sorry, ID not found");
        }
    }

}
