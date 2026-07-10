import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LambdaDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Orange");
        list.add("Banana");
        Collections.sort(list, (a, b) -> a.compareTo(b));
        for (String s : list) {
            System.out.println(s);
        }
    }
}