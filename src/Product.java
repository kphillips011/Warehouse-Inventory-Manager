public class Product {

    private int number; // inventory ID
    private String name;
    private double price;
    private int quantity;

    // constructs new Product object using only a number;
    // used when product info is unconfirmed
    public Product(int n)
    {
        // calls default constructor
        // validity check done by default constructor
        this(n, "unnamed", 0.00, 0);
    }

    // constructs new Product object using number, name, price, and quantity
    public Product(int n, String name, double p, int q) throws IllegalArgumentException
    {
        // validity checking for n
        if (n < 0) {
            throw new IllegalArgumentException("inventory ID cannot be less than 0");
        }

        // validity checking for name
        if (name == null) {
            throw new IllegalArgumentException("name is null");
        }

        //  validity checking for price
        if (p < 0) {
            throw new IllegalArgumentException("price cannot be less than 0");
        }

        // validity checking for quantity
        if (q < 0) {
            throw new IllegalArgumentException("quantity cannot be less than 0");
        }

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
    public void setNumber(int n) throws IllegalArgumentException
    {
        // validity checking for n
        if (n < 0) {
            throw new IllegalArgumentException("inventory ID cannot be less than 0");
        }
        this.number = n;
    }

    // returns Product's associated product name
    public String getName()
    {
        return this.name;
    }

    // sets Product's associated product name
    public void setName(String name) throws IllegalArgumentException
    {
        // validity checking for name
        if (name == null) {
            throw new IllegalArgumentException("name is null");
        }
        this.name = name;
    }

    // returns Product's associated price
    public double getPrice()
    {
        return this.price;
    }

    // sets Product's associated price
    public void setPrice(double p) throws IllegalArgumentException
    {
        //  validity checking for price
        if (p < 0) {
            throw new IllegalArgumentException("price cannot be less than 0");
        }
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
        checkValidQuantity(q);
        this.quantity = q;
    }

    // increments quantity by specified number
    public void incQuantity(int num)
    {
        checkValidQuantity(num);
        this.quantity += num;
    }

    // decrements quantity by specified number
    public void decQuantity(int num)
    {
        checkValidQuantity(num);
        this.quantity -= num;
    }

    private void checkValidQuantity(int num) throws IllegalArgumentException {
        if (num < 0) {
            throw new IllegalArgumentException("Number must be 0 or greater");
        }
    }
}
