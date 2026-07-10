import java.util.concurrent.*;

public class ExecutorServiceDemo {
    public static void main(String[] args) {
        ExecutorService ex = Executors.newFixedThreadPool(2);
        Future<Integer> f = ex.submit(() -> 42);
        try {
            System.out.println("Result: " + f.get());
        } catch (Exception e) {}
        ex.shutdown();
    }
}