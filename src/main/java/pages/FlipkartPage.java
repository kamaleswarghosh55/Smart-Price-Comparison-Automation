package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FlipkartPage {

    WebDriver driver;
    WebDriverWait wait;

    public FlipkartPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public int getPrice(String product) {

        driver.get("https://www.flipkart.com");

        try {
            driver.findElement(By.cssSelector("button._2KpZ6l._2doB4z")).click();
        } catch (Exception ignored) {}

        WebElement search =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
        search.sendKeys(product + Keys.ENTER);

        WebElement price =
                wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("(//a[contains(@href,'/p/')])[1]//div[contains(text(),'₹')]")
                ));

        return Integer.parseInt(
                price.getText().replace("₹", "").replace(",", "").trim()
        );
    }
}