package chapter_4_design_with_lambda.delegation;

import java.math.BigDecimal;

public class YahooFinance implements ITicker {
    @Override
    public  BigDecimal getPrice(final String ticker) {
       return new BigDecimal(100);
    }
}