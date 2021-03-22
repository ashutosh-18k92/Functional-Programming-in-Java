package chapter_4_design_with_lambda.delegation;

import java.math.BigDecimal;

public interface ITicker {
    BigDecimal getPrice(String ticker);
}
