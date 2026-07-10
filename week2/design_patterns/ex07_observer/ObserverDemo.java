import java.util.ArrayList;
import java.util.List;

interface Stock {
    void register(Observer o);
    void deregister(Observer o);
    void notifyObservers();
}

interface Observer {
    void update(double price);
}

class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();
    private double price;

    public void register(Observer o) { observers.add(o); }
    public void deregister(Observer o) { observers.remove(o); }
    public void notifyObservers() {
        for (Observer o : observers) { o.update(price); }
    }
    public void setPrice(double price) {
        this.price = price;
        notifyObservers();
    }
}

class MobileApp implements Observer {
    public void update(double price) { System.out.println("Mobile Price alert: " + price); }
}

class WebApp implements Observer {
    public void update(double price) { System.out.println("Web Price alert: " + price); }
}

public class ObserverDemo {
    public static void main(String[] args) {
        StockMarket market = new StockMarket();
        market.register(new MobileApp());
        market.register(new WebApp());
        market.setPrice(150.50);
    }
}