package chapter4.patterns.delegation;

import java.math.BigDecimal;

public interface ITicker {
    BigDecimal getPrice(String ticker);
}
