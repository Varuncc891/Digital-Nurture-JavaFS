public class BytecodeInspection {
    public int compute(int a, int b) {
        return a + b;
    }
    public static void main(String[] args) {
        BytecodeInspection bi = new BytecodeInspection();
        bi.compute(10, 20);
    }
}