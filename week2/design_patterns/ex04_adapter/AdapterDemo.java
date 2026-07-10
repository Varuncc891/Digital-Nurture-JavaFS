interface PaymentProcessor {
    void processPayment(double amount);
}

class PayPalGateway {
    public void makePayment(double amount) { System.out.println("PayPal payment: " + amount); }
}

class StripeGateway {
    public void charge(double amount) { System.out.println("Stripe charge: " + amount); }
}

class PayPalAdapter implements PaymentProcessor {
    private PayPalGateway gateway;
    public PayPalAdapter(PayPalGateway g) { this.gateway = g; }
    public void processPayment(double amount) { gateway.makePayment(amount); }
}

class StripeAdapter implements PaymentProcessor {
    private StripeGateway gateway;
    public StripeAdapter(StripeGateway g) { this.gateway = g; }
    public void processPayment(double amount) { gateway.charge(amount); }
}

public class AdapterDemo {
    public static void main(String[] args) {
        PaymentProcessor p = new StripeAdapter(new StripeGateway());
        p.processPayment(250.0);
    }
}