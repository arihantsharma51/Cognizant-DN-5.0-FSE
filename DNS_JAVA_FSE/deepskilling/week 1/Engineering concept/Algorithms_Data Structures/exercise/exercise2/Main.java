import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

        Product[] products = {

                new Product(101, "Laptop", "Electronics"),
                new Product(102, "Mouse", "Accessories"),
                new Product(103, "Keyboard", "Accessories"),
                new Product(104, "Monitor", "Electronics"),
                new Product(105, "Printer", "Office")

        };

        System.out.println("----- Linear Search -----");

        Product result1 = SearchOperations.linearSearch(products, "Mouse");

        if (result1 != null) {

            System.out.println(result1);

        } else {

            System.out.println("Product Not Found");

        }

        // Sort array before Binary Search

        Arrays.sort(products, Comparator.comparing(Product::getProductName));

        System.out.println("\n----- Binary Search -----");

        Product result2 = SearchOperations.binarySearch(products, "Mouse");

        if (result2 != null) {

            System.out.println(result2);

        } else {

            System.out.println("Product Not Found");

        }

    }

}