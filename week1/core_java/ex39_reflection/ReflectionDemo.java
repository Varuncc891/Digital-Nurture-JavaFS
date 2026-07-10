import java.lang.reflect.Method;

public class ReflectionDemo {
    public void printMessage() {
        System.out.println("Reflection message");
    }
    public static void main(String[] args) {
        try {
            Class<?> clazz = Class.forName("ReflectionDemo");
            Object obj = clazz.getDeclaredConstructor().newInstance();
            Method method = clazz.getDeclaredMethod("printMessage");
            method.invoke(obj);
        } catch (Exception e) {}
    }
}