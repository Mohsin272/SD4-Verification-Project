package cme;

import java.math.BigDecimal;

public class VisitorCarPark implements CarParkRate {
    @Override
    public BigDecimal reduction(BigDecimal total) {
        BigDecimal freeAmount = BigDecimal.valueOf(10);
        BigDecimal fiftyPercent = BigDecimal.valueOf(0.5);
        if (total.compareTo(freeAmount) <= 0) { // if total is less than freeAmount then return total
            return total;
        } else { // If total is greater than 10, then apply 50% reduction above the 10
            BigDecimal remainingCost = total.subtract(freeAmount).multiply(fiftyPercent);
            return remainingCost;
        }
    }
}
