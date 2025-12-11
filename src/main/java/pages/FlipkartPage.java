package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class FlipkartPage {

    WebDriver driver;
    WebDriverWait wait;

    public FlipkartPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
    }

    public int getPrice(String productName) {

        driver.get("https://www.flipkart.com");

        try {
            WebElement closeBtn = wait.until(ExpectedConditions
                    .visibilityOfElementLocated(By.cssSelector("button._2KpZ6l._2doB4z")));
            closeBtn.click();
        } catch (Exception ignored) {}

        WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
        search.sendKeys(productName + Keys.ENTER);

        WebElement price = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("div._30jeq3._1_WHN1")));

        String amount = price.getText().replaceAll("[^0-9]", "");
        return Integer.parseInt(amount);
    }
}
