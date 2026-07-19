import java.util.HashMap;

public class InventoryManager {

    private HashMap<Integer, Product> inventory = new HashMap<>();

    // Add Product
    public void addProduct(Product product) {

        inventory.put(product.getProductId(), product);

        System.out.println("Product Added Successfully.\n");
    }

    // Update Product
    public void updateProduct(int productId, int quantity, double price) {

        Product product = inventory.get(productId);

        if (product != null) {

            product.setQuantity(quantity);
            product.setPrice(price);

            System.out.println("Product Updated Successfully.\n");

        } else {

            System.out.println("Product Not Found.\n");

        }

    }

    // Delete Product
    public void deleteProduct(int productId) {

        if (inventory.remove(productId) != null) {

            System.out.println("Product Deleted Successfully.\n");

        } else {

            System.out.println("Product Not Found.\n");

        }

    }

    // Search Product
    public void searchProduct(int productId) {

        Product product = inventory.get(productId);

        if (product != null) {

            System.out.println(product);

        } else {

            System.out.println("Product Not Found.");

        }

    }

    // Display All Products
    public void displayProducts() {

        if (inventory.isEmpty()) {

            System.out.println("Inventory is Empty.");

            return;
        }

        for (Product product : inventory.values()) {

            System.out.println(product);
            System.out.println("----------------------------");

        }

    }

}