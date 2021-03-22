package chapter_4_design_with_lambda.delegation;

import java.math.BigDecimal;
import java.util.function.Function;

public class DelegatingWithLambdas {
    /*Strategy pattern : separting a concern either from a class or method*/
    /*Rather than delegating part o the responsibility to another class,
     * we can delegate it to lambda expressions and method references*/


    /*We are delgating the concern of calculating the ticker price*/
    static class CalculateNAV {
        private Function<String, BigDecimal> priceFinder;
        private ITicker ticker;

        public CalculateNAV(ITicker ticker) {
            this.ticker = ticker;
        }

        public CalculateNAV(Function<String, BigDecimal> priceFinder) {
            this.priceFinder = priceFinder;
        }

        /*Segregation using lambdas*/
        public BigDecimal computeStockWorthv1(final String ticker, final int shares) {
            return priceFinder.apply(ticker).multiply(BigDecimal.valueOf(shares));
        }

        /*Segregation using interfaces*/
        public BigDecimal computeStockWorthv2(final String ticker, final int shares) {
            return this.ticker.getPrice(ticker).multiply(BigDecimal.valueOf(shares));
        }
    }

    public static void main(String[] args) {

        /*Segregation of concern using lambdas */
        final Function<String, BigDecimal> yho = (stock) -> new BigDecimal(200);
        CalculateNAV c1 = new CalculateNAV(yho);
        System.out.printf("100 shares of Yahoo worth: $%.2f%n", c1.computeStockWorthv1("GOOG", 100));
        final Function<String,BigDecimal> wst = (stock)->new BigDecimal(20);

        c1 = new CalculateNAV(wst);
        System.out.printf("100 shares of WST worth: $%.2f%n", c1.computeStockWorthv1("GOOG", 100));

        c1 = new CalculateNAV((Function<String, BigDecimal>)  stock->new BigDecimal(30));
        System.out.printf("100 shares of WST worth: $%.2f%n", c1.computeStockWorthv1("GOOG", 100));


        /*Segregation of concern using method reference */
        /*Sorry we had to explicitly cast*/
         c1 = new CalculateNAV((Function<String, BigDecimal>) TickerMethodRef::getTickerPrice);
        System.out.printf("100 shares of WST worth: $%.2f%n", c1.computeStockWorthv1("GOOG", 100));

        /*Segregation of concern using Interfaces*/
        ITicker yahoo = new YahooFinance();
        CalculateNAV c2 = new CalculateNAV(yahoo);
        System.out.printf("100 shares of Yahoo worth: $%.2f%n", c2.computeStockWorthv2("GOOG", 100));

        ITicker wallStreet = new WallStreet();
        c2 = new CalculateNAV(wallStreet);
        System.out.printf("100 shares of WST worth: $%.2f%n", c2.computeStockWorthv2("GOOG", 100));


    }

}
