package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CromaPage {

    WebDriver driver;
    WebDriverWait wait;

    public CromaPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public int getPrice(String product) {

        driver.get("https://www.croma.com");

        WebElement search =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchV2")));
        search.sendKeys(product + Keys.ENTER);

        WebElement price =
                wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("(//span[contains(@class,'amount')])[1]")
                ));

        return Integer.parseInt(
                price.getText().replace("₹", "").replace(",", "").trim()
        );
    }
}