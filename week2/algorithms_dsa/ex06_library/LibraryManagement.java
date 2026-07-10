import java.util.Arrays;

class Book implements Comparable<Book> {
    private String id;
    private String title;
    private String author;

    public Book(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public String getTitle() { return title; }
    public int compareTo(Book other) {
        return this.title.compareTo(other.title);
    }
}

public class LibraryManagement {
    public static int linearSearch(Book[] arr, String title) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getTitle().equalsIgnoreCase(title)) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(Book[] arr, String title) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = arr[mid].getTitle().compareToIgnoreCase(title);
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
        Book[] books = {
            new Book("1", "Clean Code", "Robert C. Martin"),
            new Book("2", "Design Patterns", "Gang of Four")
        };
        Arrays.sort(books);
        System.out.println("Index: " + binarySearch(books, "Clean Code"));
    }
}