package cme;

import java.math.BigDecimal;

public class StaffCarPark implements CarParkRate{
    @Override
    public BigDecimal reduction(BigDecimal total) {
        BigDecimal maxPayable=BigDecimal.valueOf(10);
        if(total.compareTo(maxPayable)<=0){// If total is less than 10 then return total
            return total;
        }
        else {// If total is greater than 10 then return 10
            return maxPayable;
        }
    }
}
