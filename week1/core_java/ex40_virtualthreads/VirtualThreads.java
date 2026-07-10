public class VirtualThreads {
    public static void main(String[] args) {
        try {
            Thread.Builder builder = Thread.ofVirtual().name("virtual-", 0);
            Thread t = builder.start(() -> {
                System.out.println("Virtual thread run");
            });
            t.join();
        } catch (Exception e) {}
    }
}