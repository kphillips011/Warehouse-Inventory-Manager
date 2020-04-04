// imports

// data structures to store inventory, add/remove methods, sort/search?
// possible Comparable implementation(s)?
public class Inventory {

    // TODO insert <data structure> and global instance variables here

    // constructor, creates new <data structure>
    public Inventory()
    {
        // TODO
    }

    // add new item entry unless the <data structure> already contains an item with the specified ID;
    // else just increment the item quantity
    // ID passed as parameter
    public boolean addItem()
    {
        // TODO
        return false;
    }

    // decrement item quantity, unless quantity is already at 0
    // in which case we remove the item from the data structure
    // ID passed as parameter
    public boolean removeItem()
    {
        // TODO
        return false;
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
