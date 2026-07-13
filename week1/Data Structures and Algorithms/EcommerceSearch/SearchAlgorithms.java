import java.util.List;

public class SearchAlgorithms {
    public static Product linearSearch(List<Product> products, String targetId) {
        for (Product product : products) {
            if (product.getProductId().equals(targetId)) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(List<Product> products, String targetId) {
        int low = 0;
        int high = products.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            Product midProduct = products.get(mid);
            int cmp = midProduct.getProductId().compareTo(targetId);

            if (cmp == 0) {
                return midProduct;
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }
}
