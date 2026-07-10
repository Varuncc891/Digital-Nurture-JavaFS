public class SwitchPatternMatching {
    public static void printType(Object o) {
        String result = switch (o) {
            case Integer i -> "Integer: " + i;
            case String s -> "String: " + s;
            case Double d -> "Double: " + d;
            default -> "Unknown type";
        };
        System.out.println(result);
    }
    public static void main(String[] args) {
        printType(10);
        printType("Hello");
        printType(99.9);
    }
}