import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SearchTest {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("P103", "Laptop", "Electronics"));
        products.add(new Product("P101", "Smartphone", "Electronics"));
        products.add(new Product("P105", "Headphones", "Accessories"));
        products.add(new Product("P102", "Coffee Maker", "Appliances"));
        products.add(new Product("P104", "Desk Chair", "Furniture"));

        String targetId = "P104";

        long startTime = System.nanoTime();
        Product resultLinear = SearchAlgorithms.linearSearch(products, targetId);
        long endTime = System.nanoTime();
        System.out.println("Linear Search Result: " + resultLinear);
        System.out.println("Linear Search Time: " + (endTime - startTime) + " ns");

        Collections.sort(products, Comparator.comparing(Product::getProductId));

        startTime = System.nanoTime();
        Product resultBinary = SearchAlgorithms.binarySearch(products, targetId);
        long endTimeBinary = System.nanoTime();
        System.out.println("Binary Search Result: " + resultBinary);
        System.out.println("Binary Search Time: " + (endTimeBinary - startTime) + " ns");
    }
}
