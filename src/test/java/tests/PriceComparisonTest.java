package tests;

import org.testng.annotations.Test;
import pages.AmazonPage;
import pages.CromaPage;
import pages.FlipkartPage;
import utils.ExcelUtil;

public class PriceComparisonTest extends BaseTest {

    @Test
    public void comparePricesAndSaveToExcel() {

        String[] products = config.getProperty("products").split(",");

        FlipkartPage flipkart = new FlipkartPage(driver);
        AmazonPage amazon = new AmazonPage(driver);
        CromaPage croma = new CromaPage(driver);

        for (String product : products) {

            product = product.trim();
            String safeProductName = product.replace(" ", "_");
            int flipkartPrice = -1;
            int amazonPrice = -1;
            int cromaPrice = -1;

            // Step 1: Get prices
            try {
                flipkartPrice = flipkart.getPrice(product);
            } catch (Exception ignored) {}

            try {
                amazonPrice = amazon.getPrice(product);
            } catch (Exception ignored) {}

            try {
                cromaPrice = croma.getPrice(product);
            } catch (Exception ignored) {}

            // Step 2: Decide status
            String status;
            if (flipkartPrice == -1 && amazonPrice == -1 && cromaPrice == -1) {
                status = "FAIL";
            } else if (flipkartPrice == -1 || amazonPrice == -1 || cromaPrice == -1) {
                status = "PARTIAL";
            } else {
                status = "PASS";
            }

            // Step 3: Take screenshot for ALL cases
            String screenshotName = safeProductName + "_" + status + ".png";
            takeScreenshot(safeProductName + "_" + status);

            // Step 4: Save everything to Excel
            ExcelUtil.saveToExcel(
                    product,
                    flipkartPrice,
                    amazonPrice,
                    cromaPrice,
                    screenshotName
            );
        }
    }
}