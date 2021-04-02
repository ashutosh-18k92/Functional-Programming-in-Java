package chapter4.patterns.delegation;

import java.math.BigDecimal;

public class TickerMethodRef implements ITicker {
    @Override
    public BigDecimal getPrice(String ticker) {
        return new BigDecimal(50);
    }
}
