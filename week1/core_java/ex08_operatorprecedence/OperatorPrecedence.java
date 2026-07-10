public class OperatorPrecedence {
    public static void main(String[] args) {
        int res1 = 10 + 5 * 2;
        int res2 = (10 + 5) * 2;
        System.out.println("10 + 5 * 2 = " + res1);
        System.out.println("(10 + 5) * 2 = " + res2);
    }
}