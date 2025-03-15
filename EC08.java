/*  
    Implement classes for the given scenario:
	    - A reatail store which can store,edit,and delete multible products like fruits, vegetables, grocery, etc..
        - Ddisplay the avilabe products like price, name, quantity
*/

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

abstract class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() { 
        return name; 
    }
    public double getPrice() { 
        return price; 
    }
    public int getQuantity() { 
        return quantity; 
    }

    public void setPrice(double price) { 
        this.price = price; 
    }
    public void setQuantity(int quantity) { 
        this.quantity = quantity; 
    }

    public abstract void displayDetails();
}

// Fruits
class Fruit extends Product {
    public Fruit(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    @Override
    public void displayDetails() {
        System.out.println("Fruit: " + getName() + " | Price: $" + getPrice() + " | Quantity: " + getQuantity());
    }
}

// Vegetables
class Vegetable extends Product {
    public Vegetable(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    @Override
    public void displayDetails() {
        System.out.println("Vegetable: " + getName() + " | Price: $" + getPrice() + " | Quantity: " + getQuantity());
    }
}

// Grocery
class Grocery extends Product {
    public Grocery(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    @Override
    public void displayDetails() {
        System.out.println("Grocery: " + getName() + " | Price: $" + getPrice() + " | Quantity: " + getQuantity());
    }
}

// manage products
class Store {
    private ArrayList<Product> products = new ArrayList<>();
    
    // product adding
    public void addProduct(Product product) {
        products.add(product);
        System.out.println(product.getName() + " added to store.");
    }

    // edit price and quantity
    public void editProduct(String name, double newPrice, int newQuantity) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                product.setPrice(newPrice);
                product.setQuantity(newQuantity);
                System.out.println(name + " updated successfully.");
                return;
            }
        }
        System.out.println("Product not found!");
    }

    // Delete a product
    public void deleteProduct(String name) {
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName().equalsIgnoreCase(name)) {
                iterator.remove();
                System.out.println(name + " removed from store.");
                return;
            }
        }
        System.out.println("Product not found!");
    }

    // display all products
    public void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
        } else {
            System.out.println("\nAvailable Products:");
            for (Product product : products) {
                product.displayDetails();
            }
        }
    }
}

// Main class
public class EC08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Store store = new Store();

        // Adding some initial products
        store.addProduct(new Fruit("Apple", 1.5, 50));
        store.addProduct(new Vegetable("Carrot", 0.8, 30));
        store.addProduct(new Grocery("Rice", 2.5, 100));

        while (true) {
            System.out.println("\nRetail Store Menu:");
            System.out.println("1. Display Products");
            System.out.println("2. Add Product");
            System.out.println("3. Edit Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    store.displayProducts();
                    break;

                case 2:
                    System.out.print("Enter product type (fruit/vegetable/grocery): ");
                    String type = scanner.next().toLowerCase();
                    System.out.print("Enter name: ");
                    String name = scanner.next();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();

                    if (type.equals("fruit")) {
                        store.addProduct(new Fruit(name, price, quantity));
                    } 
                    else if (type.equals("vegetable")) {
                        store.addProduct(new Vegetable(name, price, quantity));
                    } 
                    else if (type.equals("grocery")) {
                        store.addProduct(new Grocery(name, price, quantity));
                    } 
                    else {
                        System.out.println("Invalid product type!");
                    }
                    break;

                case 3:
                    System.out.print("Enter product name to edit: ");
                    String editName = scanner.next();
                    System.out.print("Enter new price: ");
                    double newPrice = scanner.nextDouble();
                    System.out.print("Enter new quantity: ");
                    int newQuantity = scanner.nextInt();
                    store.editProduct(editName, newPrice, newQuantity);
                    break;

                case 4:
                    System.out.print("Enter product name to delete: ");
                    String deleteName = scanner.next();
                    store.deleteProduct(deleteName);
                    break;

                case 5:
                    System.out.println("Exiting... Thank you!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
