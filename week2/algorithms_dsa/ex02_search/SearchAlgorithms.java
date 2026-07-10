import java.util.Arrays;

class Product implements Comparable<Product> {
    private String id;
    private String name;
    private String category;

    public Product(String id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int compareTo(Product other) {
        return this.name.compareTo(other.name);
    }
}

public class SearchAlgorithms {
    public static int linearSearch(Product[] arr, String targetName) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getName().equalsIgnoreCase(targetName)) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(Product[] arr, String targetName) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = arr[mid].getName().compareToIgnoreCase(targetName);
            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Product[] arr = {
            new Product("1", "Camera", "Electronics"),
            new Product("2", "Laptop", "Electronics"),
            new Product("3", "Phone", "Electronics")
        };
        Arrays.sort(arr);
        int idx = binarySearch(arr, "Laptop");
        System.out.println("Binary Search Index: " + idx);
    }
}