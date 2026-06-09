import java.util.Scanner;

// Product Class
class Product {
    private int productId;
    private String productName;
    private double price;
    private int quantity;

    // Constructor
    Product(int productId, String productName, double price, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public double getAmount() {
        return price * quantity;
    }

    public void displayProduct() {
        System.out.println(productName + " - " + price +
                " x " + quantity + " = " + getAmount());
    }
}

// Cart Class
class Cart {
    private Product[] products = new Product[10];
    private int count = 0;

    // Add Product
    public void addProduct(Product p) {
        products[count] = p;
        count++;
        System.out.println("Product Added Successfully!");
    }

    // Display Cart
    public void displayCart() {
        if (count == 0) {
            System.out.println("Cart is Empty.");
            return;
        }

        System.out.println("\nProducts in Cart:");
        for (int i = 0; i < count; i++) {
            products[i].displayProduct();
        }
    }

    // Calculate Total
    public double calculateTotal() {
        double total = 0;

        for (int i = 0; i < count; i++) {
            total += products[i].getAmount();
        }

        return total;
    }

    // Checkout
    public void checkout() {

        if (count == 0) {
            System.out.println("Cart is Empty.");
            return;
        }

        double total = calculateTotal();
        double discount = total * 0.10;
        double tax = (total - discount) * 0.05;
        double finalAmount = total - discount + tax;

        System.out.println("\n===== FINAL BILL =====");
        displayCart();

        System.out.println("\nTotal Amount : " + total);
        System.out.println("Discount (10%) : " + discount);
        System.out.println("Tax (5%) : " + tax);
        System.out.println("Final Amount : " + finalAmount);
    }
}

// Main Class
public class ShoppingCartSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cart cart = new Cart();
        int n;
        System.out.print("Enter Number of Products: ");
        n = sc.nextInt();
        for (int i = 1; i <= n; i++) {

            System.out.println("\nEnter Product " + i + " Details");

            System.out.print("Product ID: ");
            int id = sc.nextInt();

            sc.nextLine();

            System.out.print("Product Name: ");
            String name = sc.nextLine();

            System.out.print("Price: ");
            double price = sc.nextDouble();

            System.out.print("Quantity: ");
            int quantity = sc.nextInt();

            Product p = new Product(id, name, price, quantity);
            cart.addProduct(p);
        }
        cart.checkout();
        sc.close();
    }
}