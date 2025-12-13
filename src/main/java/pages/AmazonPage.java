package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AmazonPage {

    WebDriver driver;
    WebDriverWait wait;

    public AmazonPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public int getPrice(String product) {

        driver.get("https://www.amazon.in");

        WebElement search =
                wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.id("twotabsearchtextbox")
                ));
        search.sendKeys(product + Keys.ENTER);

        WebElement price =
                wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("(//span[@class='a-price-whole'])[1]")
                ));

        return Integer.parseInt(
                price.getText().replace(",", "").trim()
        );
    }
}