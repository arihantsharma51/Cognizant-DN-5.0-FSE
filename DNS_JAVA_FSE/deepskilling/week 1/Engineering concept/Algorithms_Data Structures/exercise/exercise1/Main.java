public class Main {

    public static void main(String[] args) {

        InventoryManager manager = new InventoryManager();

        Product p1 = new Product(101, "Laptop", 20, 65000);

        Product p2 = new Product(102, "Mouse", 50, 500);

        Product p3 = new Product(103, "Keyboard", 30, 1500);

        // Add Products
        manager.addProduct(p1);
        manager.addProduct(p2);
        manager.addProduct(p3);

        // Display Products
        System.out.println("----- Inventory -----");
        manager.displayProducts();

        // Update Product
        manager.updateProduct(102, 60, 550);

        // Search Product
        System.out.println("\n----- Search Product -----");
        manager.searchProduct(102);

        // Delete Product
        manager.deleteProduct(103);

        // Display Products Again
        System.out.println("\n----- Updated Inventory -----");
        manager.displayProducts();

    }
}