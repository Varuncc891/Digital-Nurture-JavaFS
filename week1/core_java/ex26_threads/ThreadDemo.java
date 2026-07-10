class Worker implements Runnable {
    private String name;
    public Worker(String name) { this.name = name; }
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + " processing " + i);
            try { Thread.sleep(10); } catch (InterruptedException e) {}
        }
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Worker("Thread-A"));
        Thread t2 = new Thread(new Worker("Thread-B"));
        t1.start();
        t2.start();
    }
}