package exercise7;

public class Main {

    public static void main(String[] args) {

        FinancialForecast forecast = new FinancialForecast();

        double revenue = 1000;
        double growthRate = 10;
        int years = 3;

        double predictedRevenue = forecast.predictRevenue(revenue, growthRate, years);

        System.out.println("Current Revenue : ₹" + revenue);
        System.out.println("Growth Rate : " + growthRate + "%");
        System.out.println("Years : " + years);
        System.out.printf("Predicted Revenue after %d years : ₹%.2f%n",
                years, predictedRevenue);

    }
}