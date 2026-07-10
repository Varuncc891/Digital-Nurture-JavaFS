public class FinancialForecasting {
    public static double forecast(double val, double rate, int periods) {
        if (periods == 0) return val;
        return forecast(val * (1 + rate), rate, periods - 1);
    }

    public static void main(String[] args) {
        double futureVal = forecast(1000, 0.05, 5);
        System.out.println("Forecasted Value: " + futureVal);
    }
}