import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExample {
    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);

    public static void main(String[] args) {
        logger.info("Application started.");
        
        try {
            processCalculation(10, 0);
        } catch (ArithmeticException e) {
            logger.error("Error occurred during calculation: Division by zero", e);
        }

        processValue(-5);
        
        logger.info("Application finished.");
    }

    private static void processCalculation(int a, int b) {
        logger.debug("Dividing {} by {}", a, b);
        int result = a / b;
    }

    private static void processValue(int val) {
        if (val < 0) {
            logger.warn("Negative value encountered: {}", val);
        }
    }
}
