interface PaymentStrategy {
    void pay(double amount);
}

class CreditCardPayment implements PaymentStrategy {
    public void pay(double amount) { System.out.println("Credit Card Payment: " + amount); }
}

class PayPalPayment implements PaymentStrategy {
    public void pay(double amount) { System.out.println("PayPal Payment: " + amount); }
}

class PaymentContext {
    private PaymentStrategy strategy;
    public void setStrategy(PaymentStrategy s) { this.strategy = s; }
    public void execute(double amount) { strategy.pay(amount); }
}

public class StrategyDemo {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();
        context.setStrategy(new PayPalPayment());
        context.execute(340.00);
    }
}