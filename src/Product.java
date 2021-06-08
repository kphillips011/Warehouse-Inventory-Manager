public class Product {

  private int number; // Inventory ID
  private String name;
  private double price;
  private int quantity;

  // Constructs new Product object using only a number;
  // used when Product info is unconfirmed
  // Calls default constructor
  // with validity check done by default constructor
  public Product(final int n) {
    this(n, "unnamed", 0.00, 0);
  }

  // Constructs new Product object using number, name, price, and quantity
  public Product(final int n, final String name, final double p, final int q) {
    this.setNumber(n);
    this.setName(name);
    this.setPrice(p);
    this.setQuantity(q);
  }

  // Returns Product's associated ID number
  public int getNumber() {
    return this.number;
  }

  // Sets Product's associated ID number
  public void setNumber(final int n) throws IllegalArgumentException {
    // Validity checking for n
    if (n < 0) {
      throw new IllegalArgumentException("Inventory ID cannot be less than 0");
    }
    this.number = n;
  }

  // Returns Product's associated product name
  public String getName() {
    return this.name;
  }

  // Sets Product's associated product name
  public void setName(final String name) throws IllegalArgumentException {
    // Validity checking for name
    if (name == null) {
      throw new IllegalArgumentException("Name is null");
    }
    this.name = name;
  }

  // Returns Product's associated price
  public double getPrice() {
    return this.price;
  }

  // Sets Product's associated price
  public void setPrice(final double p) throws IllegalArgumentException {
    //  Validity checking for price
    if (p < 0) {
      throw new IllegalArgumentException("Price cannot be less than 0");
    }
    this.price = p;
  }

  // Returns Product's associated quantity of items
  public int getQuantity() {
    return this.quantity;
  }

  // Sets Product's associated quantity of items
  public void setQuantity(final int q) throws IllegalArgumentException {
    //  Validity checking for quantity
    if (q < 0) {
      throw new IllegalArgumentException("Number must be 0 or greater");
    }
    this.quantity = q;
  }

  // Increments quantity by specified number
  public boolean incQuantity(final int num) {
    if (num <= 0) {
      System.out.println("Increment value must be greater than 0");
      return false;
    }
    this.quantity += num;
    return true;
  }

  // Decrements quantity by specified number and
  // makes sure that the method won't decrement the quantity below 0
  // Prints alerts to the console if quantity reaches a low amount or zero
  public boolean decQuantity(final int num) {
    if (num <= 0) {
      System.out.println("Decrement value must be greater than 0");
      return false;
    }
    int count = num;
    while (this.quantity > 0 && count > 0) {
      this.quantity -= 1;
      count--;
      if (this.quantity == 0) {
        System.out.println("Quantity is 0. Please restock this product.");
      }
      else if (this.quantity < 3) {
        System.out.println("Low quantity alert. Please restock this product.");
      }
    }
    return true;
  }

  // Outputs the format for the log
  public String toString() {
    return (this.getName() + " | " + this.getPrice() + " | " + this.getQuantity() + " |");
  }
}
