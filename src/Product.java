public class Product {

  private int number; // inventory ID
  private String name;
  private double price;
  private int quantity;

  // constructs new Product object using only a number;
  // used when product info is unconfirmed
  public Product(final int n) {
    // calls default constructor
    // validity check done by default constructor
    this(n, "unnamed", 0.00, 0);
  }

  // constructs new Product object using number, name, price, and quantity
  public Product(final int n, final String name, final double p, final int q)
      throws IllegalArgumentException {
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
  public int getNumber() {
    return this.number;
  }

  // sets Product's associated ID number
  public void setNumber(final int n) throws IllegalArgumentException {
    // validity checking for n
    if (n < 0) {
      throw new IllegalArgumentException("inventory ID cannot be less than 0");
    }
    this.number = n;
  }

  // returns Product's associated product name
  public String getName() {
    return this.name;
  }

  // sets Product's associated product name
  public void setName(final String name) throws IllegalArgumentException {
    // validity checking for name
    if (name == null) {
      throw new IllegalArgumentException("name is null");
    }
    this.name = name;
  }

  // returns Product's associated price
  public double getPrice() {
    return this.price;
  }

  // sets Product's associated price
  public void setPrice(final double p) throws IllegalArgumentException {
    //  validity checking for price
    if (p < 0) {
      throw new IllegalArgumentException("price cannot be less than 0");
    }
    this.price = p;
  }

  // returns Product's associated quantity of items
  public int getQuantity() {
    return this.quantity;
  }

  // sets Product's associated quantity of items
  public void setQuantity(final int q) throws IllegalArgumentException {
    if (q < 0) {
      throw new IllegalArgumentException("Number must be 0 or greater");
    }
    this.quantity = q;
  }

  // increments quantity by specified number
  public void incQuantity(final int num) {
    this.quantity += num;
  }

  // decrements quantity by specified number and
  // makes sure that the method won't decrement the quantity
  // below 0
  public void decQuantity(final int num) {
    int count = num;
    while (this.quantity > 0 && count > 0) {
      this.quantity -= 1;
      count--;
      if (this.quantity == 0) {
        System.out.println("Quantity is 0. Please restock this product.");
      }
      if (this.quantity < 3 && this.quantity > 0) {
        System.out.println("Low quantity alert. Please restock this product.");
      }
    }
  }

  public String toString() {
    return (this.getName() + " | " + this.getPrice() + " | " + this.getQuantity() + " |");
  }
}
