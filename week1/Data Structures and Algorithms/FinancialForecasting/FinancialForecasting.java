public class FinancialForecasting {
    public static double predictValue(double presentValue, double growthRate, int periods) {
        if (periods <= 0) {
            return presentValue;
        }
        return predictValue(presentValue * (1 + growthRate), growthRate, periods - 1);
    }
}
