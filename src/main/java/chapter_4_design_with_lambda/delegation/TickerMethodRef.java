package chapter_4_design_with_lambda.delegation;

import java.math.BigDecimal;

public class TickerMethodRef {
    public static BigDecimal getTickerPrice(String stockName){

        //some computation to fetch current stock values
        return new BigDecimal(50);
    }

}
