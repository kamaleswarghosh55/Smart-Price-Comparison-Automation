package tests;

import org.testng.annotations.Test;
import pages.AmazonPage;
import pages.FlipkartPage;
import pages.CromaPage;
import utils.ExcelWriter;

public class PriceComparisonTest extends tests.BaseTest {

    @Test
    public void compareProductPrices() {

        String product = "iPhone 14 128GB";

        AmazonPage amazon = new AmazonPage(driver);
        FlipkartPage flipkart = new FlipkartPage(driver);
        CromaPage croma = new CromaPage(driver);

        int amazonPrice = amazon.getPrice(product);
        int flipkartPrice = flipkart.getPrice(product);
        int cromaPrice = croma.getPrice(product);

        System.out.println("Amazon: " + amazonPrice);
        System.out.println("Flipkart: " + flipkartPrice);
        System.out.println("Croma: " + cromaPrice);

        int lowest = Math.min(amazonPrice, Math.min(flipkartPrice, cromaPrice));
        System.out.println("Lowest Price: " + lowest);

        ExcelWriter.writePriceReport(product, amazonPrice, flipkartPrice, cromaPrice, lowest);
    }
}
