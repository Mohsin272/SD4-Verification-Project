package cme;

import java.math.BigDecimal;

public class ManagementCarPark implements CarParkRate {

    @Override
    public BigDecimal reduction(BigDecimal total) {
        BigDecimal minAmount = BigDecimal.valueOf(5);
        if (total.compareTo(minAmount) <= 0) { // if total is less than 5 then return 5
            return minAmount;
        }
        else{ //return the total amount
            return total;
        }
    }
}
