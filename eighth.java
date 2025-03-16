class Product {
    private String id;
    private String name;
    private double price;
    private int quantity;

    public Product(String id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getId() { return id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    
    public void displayInfo() {
        System.out.println("ID: " + id + 
                          " | Name: " + name + 
                          " | Price: $" + price + 
                          " | Quantity: " + quantity);
    }
}

class Fruit extends Product {
    private String season;
    
    public Fruit(String id, String name, double price, int quantity, String season) {
        super(id, name, price, quantity);
        this.season = season;
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: Fruit | Season: " + season);
    }
}

class Vegetable extends Product {
    private boolean organic;
    
    public Vegetable(String id, String name, double price, int quantity, boolean organic) {
        super(id, name, price, quantity);
        this.organic = organic;
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: Vegetable | Organic: " + (organic ? "Yes" : "No"));
    }
}

class Grocery extends Product {
    private String expiryDate;
    
    public Grocery(String id, String name, double price, int quantity, String expiryDate) {
        super(id, name, price, quantity);
        this.expiryDate = expiryDate;
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: Grocery | Expiry Date: " + expiryDate);
    }
}

class RetailStore {
    private Product[] products;
    private int productCount;
    
    public RetailStore(int capacity) {
        products = new Product[capacity];
        productCount = 0;
    }
    
    public void addProduct(Product product) {
        if (productCount < products.length) {
            products[productCount] = product;
            productCount++;
            System.out.println(product.getName() + " added successfully.");
        } else {
            System.out.println("Store capacity full. Cannot add more products.");
        }
    }

    public void editProduct(String id, String name, double price, int quantity) {
        for (int i = 0; i < productCount; i++) {
            if (products[i].getId().equals(id)) {
                products[i].setName(name);
                products[i].setPrice(price);
                products[i].setQuantity(quantity);
                System.out.println("Product with ID " + id + " updated successfully.");
                return;
            }
        }
        System.out.println("Product with ID " + id + " not found.");
    }

    public void deleteProduct(String id) {
        for (int i = 0; i < productCount; i++) {
            if (products[i].getId().equals(id)) {
                for (int j = i; j < productCount - 1; j++) {
                    products[j] = products[j + 1];
                }
                products[productCount - 1] = null;
                productCount--;
                System.out.println("Product with ID " + id + " deleted successfully.");
                return;
            }
        }
        System.out.println("Product with ID " + id + " not found.");
    }
    
    public void displayAllProducts() {
        if (productCount == 0) {
            System.out.println("No products in the store.");
            return;
        }
        
        System.out.println("\n===== RETAIL STORE INVENTORY =====");
        for (int i = 0; i < productCount; i++) {
            System.out.println("-----------------------------");
            products[i].displayInfo();
        }
        System.out.println("========== END OF LIST ==========");
    }



    public void displayByType(String type) {
        boolean found = false;
        System.out.println("\n===== " + type.toUpperCase() + " PRODUCTS =====");
        
        for (int i = 0; i < productCount; i++) {
            if ((type.equalsIgnoreCase("Fruit") && products[i] instanceof Fruit) ||
                (type.equalsIgnoreCase("Vegetable") && products[i] instanceof Vegetable) ||
                (type.equalsIgnoreCase("Grocery") && products[i] instanceof Grocery)) {
                products[i].displayInfo();
                System.out.println("-----------------------------");
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("No " + type + " products found.");
        }
    }
}

public class eighth {
    public static void main(String[] args) {
        RetailStore store = new RetailStore(10);
        
        Fruit apple = new Fruit("F001", "Apple", 1.99, 100, "Fall");
        Fruit banana = new Fruit("F002", "Banana", 0.99, 150, "Year-round");
        
        Vegetable carrot = new Vegetable("V001", "Carrot", 1.49, 80, true);
        Vegetable spinach = new Vegetable("V002", "Spinach", 2.99, 50, true);
        
        Grocery rice = new Grocery("G001", "Rice", 5.99, 30, "2025-12-31");
        Grocery pasta = new Grocery("G002", "Pasta", 2.49, 45, "2026-06-30");

        store.addProduct(apple);
        store.addProduct(banana);
        store.addProduct(carrot);
        store.addProduct(spinach);
        store.addProduct(rice);
        store.addProduct(pasta);

        store.displayAllProducts();
        
        store.displayByType("Fruit");
        store.displayByType("Vegetable");
        store.displayByType("Grocery");

        store.editProduct("F001", "Red Apple", 2.29, 120);

        store.deleteProduct("G002");

        store.displayAllProducts();
    }
}