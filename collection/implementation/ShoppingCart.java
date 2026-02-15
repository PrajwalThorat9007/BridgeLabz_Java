package collection.implementation;

/*
 * Question 4: Implement a Shopping Cart
 *
 * Description:
 * - Use HashMap to store product prices
 * - Use LinkedHashMap to maintain the order of items added
 * - Use TreeMap to display items sorted by price
 */

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ShoppingCart {

    // Product class representing an item in the store
    static class Product {
        private String productId;
        private String name;
        private String category;
        private double price;
        private int stockQuantity;

        public Product(String productId, String name, String category, double price, int stockQuantity) {
            this.productId = productId;
            this.name = name;
            this.category = category;
            this.price = price;
            this.stockQuantity = stockQuantity;
        }

        public String getProductId() {
            return productId;
        }

        public String getName() {
            return name;
        }

        public String getCategory() {
            return category;
        }

        public double getPrice() {
            return price;
        }

        public int getStockQuantity() {
            return stockQuantity;
        }

        public void reduceStock(int quantity) {
            this.stockQuantity -= quantity;
        }

        public void increaseStock(int quantity) {
            this.stockQuantity += quantity;
        }

        @Override
        public String toString() {
            return String.format("%s - %s ($%.2f) [Stock: %d]",
                    productId, name, price, stockQuantity);
        }
    }

    // Cart Item class to track quantity of products
    static class CartItem {
        private Product product;
        private int quantity;
        private LocalDateTime addedTime;

        public CartItem(Product product, int quantity) {
            this.product = product;
            this.quantity = quantity;
            this.addedTime = LocalDateTime.now();
        }

        public Product getProduct() {
            return product;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public void addQuantity(int amount) {
            this.quantity += amount;
        }

        public LocalDateTime getAddedTime() {
            return addedTime;
        }

        public double getTotalPrice() {
            return product.getPrice() * quantity;
        }

        @Override
        public String toString() {
            return String.format("%s x%d = $%.2f",
                    product.getName(), quantity, getTotalPrice());
        }
    }

    // Shopping Cart Manager
    static class CartManager {
        private Map<String, Product> productCatalog; // HashMap: Product ID -> Product
        private Map<String, Double> productPrices; // HashMap: Product ID -> Price
        private Map<String, CartItem> cartItems; // LinkedHashMap: Maintains insertion order
        private String customerId;

        public CartManager(String customerId) {
            this.customerId = customerId;
            this.productCatalog = new HashMap<>();
            this.productPrices = new HashMap<>();
            this.cartItems = new LinkedHashMap<>();
        }

        // Add product to catalog
        public void addProductToCatalog(Product product) {
            productCatalog.put(product.getProductId(), product);
            productPrices.put(product.getProductId(), product.getPrice());
        }

        // Add item to cart
        public boolean addToCart(String productId, int quantity) {
            Product product = productCatalog.get(productId);

            if (product == null) {
                System.out.println("Error: Product not found!");
                return false;
            }

            if (product.getStockQuantity() < quantity) {
                System.out.println("Error: Insufficient stock! Available: " + product.getStockQuantity());
                return false;
            }

            // Check if item already in cart
            if (cartItems.containsKey(productId)) {
                CartItem existingItem = cartItems.get(productId);
                int newQuantity = existingItem.getQuantity() + quantity;

                if (product.getStockQuantity() < newQuantity) {
                    System.out.println("Error: Cannot add more. Stock limit reached!");
                    return false;
                }

                existingItem.addQuantity(quantity);
                System.out.println("Updated quantity: " + product.getName() + " (Total: " +
                        newQuantity + ")");
            } else {
                CartItem newItem = new CartItem(product, quantity);
                cartItems.put(productId, newItem);
                System.out.println("Added to cart: " + product.getName() + " x" + quantity);
            }

            return true;
        }

        // Remove item from cart
        public boolean removeFromCart(String productId) {
            CartItem removed = cartItems.remove(productId);

            if (removed != null) {
                System.out.println("Removed from cart: " + removed.getProduct().getName());
                return true;
            }

            System.out.println("Error: Item not found in cart!");
            return false;
        }

        // Update quantity of item in cart
        public boolean updateQuantity(String productId, int newQuantity) {
            CartItem item = cartItems.get(productId);

            if (item == null) {
                System.out.println("Error: Item not found in cart!");
                return false;
            }

            if (newQuantity <= 0) {
                return removeFromCart(productId);
            }

            Product product = item.getProduct();
            if (product.getStockQuantity() < newQuantity) {
                System.out.println("Error: Insufficient stock! Available: " + product.getStockQuantity());
                return false;
            }

            item.setQuantity(newQuantity);
            System.out.println("Updated: " + product.getName() + " x" + newQuantity);
            return true;
        }

        // Display cart items (LinkedHashMap - insertion order)
        public void displayCart() {
            System.out.println("=== Shopping Cart (Order Added) ===");
            System.out.println("Customer: " + customerId);

            if (cartItems.isEmpty()) {
                System.out.println("Cart is empty!");
                return;
            }

            int itemNumber = 1;
            for (CartItem item : cartItems.values()) {
                System.out.println(itemNumber + ". " + item);
                itemNumber++;
            }

            System.out.println("---");
            System.out.printf("Total Items: %d%n", getTotalItemCount());
            System.out.printf("Total Amount: $%.2f%n", getTotalAmount());
        }

        // Display items sorted by price using TreeMap
        public void displayCartSortedByPrice() {
            System.out.println("=== Shopping Cart (Sorted by Price) ===");

            if (cartItems.isEmpty()) {
                System.out.println("Cart is empty!");
                return;
            }

            // Create TreeMap sorted by price
            TreeMap<Double, List<CartItem>> sortedByPrice = new TreeMap<>();

            for (CartItem item : cartItems.values()) {
                double price = item.getProduct().getPrice();
                sortedByPrice.computeIfAbsent(price, k -> new ArrayList<>()).add(item);
            }

            int itemNumber = 1;
            for (Map.Entry<Double, List<CartItem>> entry : sortedByPrice.entrySet()) {
                for (CartItem item : entry.getValue()) {
                    System.out.println(itemNumber + ". " + item + " (Unit: $" +
                            String.format("%.2f", entry.getKey()) + ")");
                    itemNumber++;
                }
            }

            System.out.println("---");
            System.out.printf("Total Amount: $%.2f%n", getTotalAmount());
        }

        // Display product catalog with prices (HashMap)
        public void displayCatalog() {
            System.out.println("=== Product Catalog ===");

            for (Product product : productCatalog.values()) {
                System.out.println(product);
            }
        }

        // Display catalog sorted by category
        public void displayCatalogByCategory() {
            System.out.println("=== Product Catalog (By Category) ===");

            Map<String, List<Product>> byCategory = new TreeMap<>();

            for (Product product : productCatalog.values()) {
                byCategory.computeIfAbsent(product.getCategory(), k -> new ArrayList<>()).add(product);
            }

            for (Map.Entry<String, List<Product>> entry : byCategory.entrySet()) {
                System.out.println("\n" + entry.getKey() + ":");
                for (Product product : entry.getValue()) {
                    System.out.println("  " + product);
                }
            }
        }

        // Get total amount
        public double getTotalAmount() {
            double total = 0;
            for (CartItem item : cartItems.values()) {
                total += item.getTotalPrice();
            }
            return total;
        }

        // Get total item count
        public int getTotalItemCount() {
            int count = 0;
            for (CartItem item : cartItems.values()) {
                count += item.getQuantity();
            }
            return count;
        }

        // Apply discount
        public double applyDiscount(double discountPercentage) {
            double total = getTotalAmount();
            double discount = total * (discountPercentage / 100);
            double finalAmount = total - discount;

            System.out.println("=== Discount Applied ===");
            System.out.printf("Original Amount: $%.2f%n", total);
            System.out.printf("Discount (%.0f%%): -$%.2f%n", discountPercentage, discount);
            System.out.printf("Final Amount: $%.2f%n", finalAmount);

            return finalAmount;
        }

        // Search products by price range
        public List<Product> searchByPriceRange(double minPrice, double maxPrice) {
            List<Product> result = new ArrayList<>();

            for (Product product : productCatalog.values()) {
                if (product.getPrice() >= minPrice && product.getPrice() <= maxPrice) {
                    result.add(product);
                }
            }

            // Sort by price
            result.sort(Comparator.comparing(Product::getPrice));

            return result;
        }

        // Search products by category
        public List<Product> searchByCategory(String category) {
            List<Product> result = new ArrayList<>();

            for (Product product : productCatalog.values()) {
                if (product.getCategory().equalsIgnoreCase(category)) {
                    result.add(product);
                }
            }

            return result;
        }

        // Get product price from HashMap
        public Double getProductPrice(String productId) {
            return productPrices.get(productId);
        }

        // Clear cart
        public void clearCart() {
            cartItems.clear();
            System.out.println("Cart cleared!");
        }

        // Checkout
        public void checkout() {
            if (cartItems.isEmpty()) {
                System.out.println("Cart is empty! Cannot checkout.");
                return;
            }

            System.out.println("=== CHECKOUT ===");
            displayCart();

            System.out.println("\n--- Processing Order ---");

            // Reduce stock for all items
            for (CartItem item : cartItems.values()) {
                Product product = item.getProduct();
                product.reduceStock(item.getQuantity());
                System.out.println("Processed: " + item);
            }

            double total = getTotalAmount();
            System.out.println("\n*** Order Completed ***");
            System.out.printf("Total Paid: $%.2f%n", total);
            System.out.println("Order Date: " + LocalDateTime.now().format(
                    DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss")));

            clearCart();
        }

        // Get cart summary
        public void displayCartSummary() {
            System.out.println("=== Cart Summary ===");
            System.out.println("Customer: " + customerId);
            System.out.println("Total Items: " + getTotalItemCount());
            System.out.println("Unique Products: " + cartItems.size());
            System.out.printf("Total Amount: $%.2f%n", getTotalAmount());

            if (!cartItems.isEmpty()) {
                System.out.printf("Average Item Price: $%.2f%n",
                        getTotalAmount() / getTotalItemCount());
            }
        }

        // Get most expensive item
        public CartItem getMostExpensiveItem() {
            CartItem mostExpensive = null;

            for (CartItem item : cartItems.values()) {
                if (mostExpensive == null ||
                        item.getProduct().getPrice() > mostExpensive.getProduct().getPrice()) {
                    mostExpensive = item;
                }
            }

            return mostExpensive;
        }

        // Get least expensive item
        public CartItem getLeastExpensiveItem() {
            CartItem leastExpensive = null;

            for (CartItem item : cartItems.values()) {
                if (leastExpensive == null ||
                        item.getProduct().getPrice() < leastExpensive.getProduct().getPrice()) {
                    leastExpensive = item;
                }
            }

            return leastExpensive;
        }
    }

    public static void main(String[] args) {
        CartManager cart = new CartManager("CUST001");

        System.out.println("=== ONLINE SHOPPING CART SYSTEM ===\n");

        // Add products to catalog
        System.out.println("--- Setting Up Product Catalog ---");
        cart.addProductToCatalog(new Product("P001", "Laptop", "Electronics", 999.99, 10));
        cart.addProductToCatalog(new Product("P002", "Mouse", "Electronics", 25.99, 50));
        cart.addProductToCatalog(new Product("P003", "Keyboard", "Electronics", 75.50, 30));
        cart.addProductToCatalog(new Product("P004", "Monitor", "Electronics", 299.99, 15));
        cart.addProductToCatalog(new Product("P005", "Desk Chair", "Furniture", 189.99, 20));
        cart.addProductToCatalog(new Product("P006", "Desk Lamp", "Furniture", 45.00, 25));
        cart.addProductToCatalog(new Product("P007", "Notebook", "Stationery", 5.99, 100));
        cart.addProductToCatalog(new Product("P008", "Pen Set", "Stationery", 12.50, 75));
        cart.addProductToCatalog(new Product("P009", "USB Cable", "Electronics", 15.99, 60));
        cart.addProductToCatalog(new Product("P010", "Water Bottle", "Accessories", 19.99, 40));

        System.out.println("Catalog setup complete!\n");

        // Display catalog
        cart.displayCatalog();
        System.out.println();

        // Display catalog by category
        cart.displayCatalogByCategory();
        System.out.println();

        // Add items to cart
        System.out.println("--- Adding Items to Cart ---");
        cart.addToCart("P001", 1); // Laptop
        cart.addToCart("P002", 2); // Mouse
        cart.addToCart("P003", 1); // Keyboard
        cart.addToCart("P005", 1); // Desk Chair
        cart.addToCart("P007", 5); // Notebook
        cart.addToCart("P002", 1); // Add more mice

        System.out.println();

        // Display cart (LinkedHashMap - insertion order)
        cart.displayCart();
        System.out.println();

        // Display cart sorted by price (TreeMap)
        cart.displayCartSortedByPrice();
        System.out.println();

        // Update quantity
        System.out.println("--- Updating Quantities ---");
        cart.updateQuantity("P007", 10);
        System.out.println();

        // Display updated cart
        cart.displayCart();
        System.out.println();

        // Cart summary
        cart.displayCartSummary();
        System.out.println();

        // Most and least expensive items
        CartItem mostExpensive = cart.getMostExpensiveItem();
        CartItem leastExpensive = cart.getLeastExpensiveItem();

        System.out.println("--- Price Analysis ---");
        System.out.println("Most Expensive: " + mostExpensive.getProduct().getName() +
                " ($" + String.format("%.2f", mostExpensive.getProduct().getPrice()) + ")");
        System.out.println("Least Expensive: " + leastExpensive.getProduct().getName() +
                " ($" + String.format("%.2f", leastExpensive.getProduct().getPrice()) + ")");
        System.out.println();

        // Apply discount
        cart.applyDiscount(10);
        System.out.println();

        // Search products by price range
        System.out.println("--- Products in $10-$50 Range ---");
        List<Product> affordableProducts = cart.searchByPriceRange(10, 50);
        for (Product product : affordableProducts) {
            System.out.println(product);
        }
        System.out.println();

        // Remove an item
        System.out.println("--- Removing Item ---");
        cart.removeFromCart("P007");
        System.out.println();

        // Display final cart
        cart.displayCart();
        System.out.println();

        // Checkout
        cart.checkout();
        System.out.println();

        // Try to display empty cart
        cart.displayCart();
    }
}