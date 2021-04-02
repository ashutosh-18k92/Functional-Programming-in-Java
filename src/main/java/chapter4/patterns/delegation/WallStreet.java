package chapter4.patterns.delegation;

import java.math.BigDecimal;

public class WallStreet implements ITicker {
    @Override
    public BigDecimal getPrice(String ticker) {
        return new BigDecimal(20);
    }
}
