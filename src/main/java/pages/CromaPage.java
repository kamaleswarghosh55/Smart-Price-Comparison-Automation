package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class CromaPage {

    WebDriver driver;
    WebDriverWait wait;

    public CromaPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
    }

    public int getPrice(String productName) {

        driver.get("https://www.croma.com");

        WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("searchV2")));
        search.sendKeys(productName + Keys.ENTER);

        WebElement price = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".amount")));

        String amount = price.getText().replaceAll("[^0-9]", "");
        return Integer.parseInt(amount);
    }
}
