package exercise7;

public class FinancialForecast {

  
    public double predictRevenue(double revenue, double growthRate, int years) {

       
        if (years == 0) {
            return revenue;
        }

        double newRevenue = revenue * (1 + growthRate / 100);

     
        return predictRevenue(newRevenue, growthRate, years - 1);
    }
}