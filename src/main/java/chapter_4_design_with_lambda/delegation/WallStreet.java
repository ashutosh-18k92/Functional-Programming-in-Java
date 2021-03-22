package chapter_4_design_with_lambda.delegation;

import java.math.BigDecimal;

public class WallStreet implements ITicker {
    @Override
    public BigDecimal getPrice(String ticker) {
        return new BigDecimal(20);
    }
}
