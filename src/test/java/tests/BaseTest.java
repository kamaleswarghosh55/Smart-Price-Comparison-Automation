package tests;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class BaseTest {

    protected WebDriver driver;
    protected Properties config;

    @BeforeClass
    public void setup() throws Exception {

        config = new Properties();
        config.load(new FileInputStream("src/main/resources/config.properties"));

        String browser = config.getProperty("browser").toLowerCase();

        if (browser.equals("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            driver = new FirefoxDriver(options);
            driver.manage().window().maximize();

        } else {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            driver = new ChromeDriver(options);
        }
    }

    protected void takeScreenshot(String name) {
        try {
            File src = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);

            // RELATIVE PATH (GOOD PRACTICE)
            File dest = new File("screenshots/" + name + ".png");

            FileHandler.copy(src, dest);

            System.out.println("Screenshot saved at: " + dest.getPath());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}