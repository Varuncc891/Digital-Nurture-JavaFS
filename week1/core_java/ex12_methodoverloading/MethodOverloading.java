public class MethodOverloading {
    public int add(int a, int b) {
        return a + b;
    }
    public double add(double a, double b) {
        return a + b;
    }
    public int add(int a, int b, int c) {
        return a + b + c;
    }
    public static void main(String[] args) {
        MethodOverloading mo = new MethodOverloading();
        System.out.println(mo.add(5, 10));
        System.out.println(mo.add(5.5, 10.5));
        System.out.println(mo.add(5, 10, 15));
    }
}