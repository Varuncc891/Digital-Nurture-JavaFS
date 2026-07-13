public class ForecastingTest {
    public static void main(String[] args) {
        double presentValue = 1000.0;
        double growthRate = 0.05; // 5% growth
        int periods = 10; // 10 years

        double predictedValue = FinancialForecasting.predictValue(presentValue, growthRate, periods);
        System.out.println("Initial Value: $" + presentValue);
        System.out.println("Growth Rate: " + (growthRate * 100) + "%");
        System.out.println("Periods (Years): " + periods);
        System.out.println("Predicted Value: $" + String.format("%.2f", predictedValue));
    }
}
