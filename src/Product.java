public class Product {

    private int number;
    private String name;
    private double price;
    private int quantity;

    // constructs new Product object using only a number
    public Product(int n)
    {
        this.number = n;
        this.name = "unnamed";
        this.price = 0.00;
        this.quantity = 0;
    }

    // constructs new Product object using number, name, price, and quantity
    public Product(int n, String name, double p, int q)
    {
        this.number = n;
        this.name = name;
        this.price = p;
        this.quantity = q;
    }

    // returns Product's associated ID number
    public int getNumber()
    {
        return this.number;
    }

    // sets Product's associated ID number
    public void setNumber(int n)
    {
        this.number = n;
    }

    // returns Product's associated product name
    public String getName()
    {
        return this.name;
    }

    // sets Product's associated product name
    public void setName(String name)
    {
        this.name = name;
    }

    // returns Product's associated price
    public double getPrice()
    {
        return this.price;
    }

    // sets Product's associated price
    public void setPrice(double p)
    {
        this.price = p;
    }

    // returns Product's associated quantity of items
    public int getQuantity()
    {
        return this.quantity;
    }

    // sets Product's associated quantity of items
    public void setQuantity(int q)
    {
        this.quantity = q;
    }
}
