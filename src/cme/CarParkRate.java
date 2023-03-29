package cme;

import java.math.BigDecimal;

public interface CarParkRate {
    BigDecimal reduction(BigDecimal total);
}
