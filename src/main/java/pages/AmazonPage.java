package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class AmazonPage {

    WebDriver driver;
    WebDriverWait wait;

    public AmazonPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
    }

    public int getPrice(String productName) {

        driver.get("https://www.amazon.in");

        WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("twotabsearchtextbox")));
        search.sendKeys(productName + Keys.ENTER);

        WebElement price = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("span.a-price-whole")));

        String amount = price.getText().replaceAll("[^0-9]", "");
        return Integer.parseInt(amount);
    }
}
