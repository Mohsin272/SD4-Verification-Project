package cme;

import java.math.BigDecimal;

public class StudentCarPark implements CarParkRate{
    @Override
    public BigDecimal reduction(BigDecimal total) {
        BigDecimal reductionAmount = BigDecimal.valueOf(5.50);
        BigDecimal reductionPercent = BigDecimal.valueOf(0.33);
        if (total.compareTo(reductionAmount) <= 0) {// if total is less than 5.50 then return total
            return total;
        }
        else { // If total is greater than 5.50, then apply 33% reduction above the 5.50
            BigDecimal remainder=total.subtract(reductionAmount);//get how much over it is 5.50
            BigDecimal remainderCost=remainder.multiply(reductionPercent);//apply 33% to that amount over 5.50
            BigDecimal totalReductionAmount=remainder.subtract(remainderCost);//take that amount from the amount over 5.50
            return totalReductionAmount.add(reductionAmount);//add 5.50 and the reduced amount
        }
    }
}
