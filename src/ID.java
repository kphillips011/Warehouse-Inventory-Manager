public class ID {

    private int number;
    private String name;
    private double price;
    private int quantity;

    // constructs new ID object using only a number
    public ID(int n)
    {
        this.number = n;
        this.name = "unnamed";
        this.price = 0.00;
        this.quantity = 0;
    }

    // constructs new ID object using number, name, price, and quantity
    public ID (int n, String name, double p, int q)
    {
        this.number = n;
        this.name = name;
        this.price = p;
        this.quantity = q;
    }
}
