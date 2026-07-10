interface Notifier {
    void send(String message);
}

class EmailNotifier implements Notifier {
    public void send(String msg) { System.out.println("Email: " + msg); }
}

abstract class NotifierDecorator implements Notifier {
    protected Notifier decorated;
    public NotifierDecorator(Notifier n) { this.decorated = n; }
    public void send(String msg) { decorated.send(msg); }
}

class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier n) { super(n); }
    public void send(String msg) {
        super.send(msg);
        System.out.println("SMS: " + msg);
    }
}

class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier n) { super(n); }
    public void send(String msg) {
        super.send(msg);
        System.out.println("Slack: " + msg);
    }
}

public class DecoratorDemo {
    public static void main(String[] args) {
        Notifier n = new SlackNotifierDecorator(new SMSNotifierDecorator(new EmailNotifier()));
        n.send("Hello System Alert");
    }
}