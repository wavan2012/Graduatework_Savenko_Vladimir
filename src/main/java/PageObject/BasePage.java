package PageObject;

import driver.DriverCreation;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import properties.PropertyReader;

import java.time.Duration;


public class BasePage extends BaseTest{
    static WebDriver driver;

    public BasePage() {
        driver = DriverCreation.getDriver();
    }
    public static void open(){
        DriverCreation.getDriver().get(PropertyReader.getProperty("url"));
    }

    public static void open(String url) {
        DriverCreation.getDriver().get(url);
    }

    public static void verifyUrl(String url) {
        isDisplayed("/html/head/meta[@property='og:url' and @content='" + url + "']");
    }

    public static void pause() throws InterruptedException {
        Thread.sleep(1000);
    }

    public static void isDisplayed(By... elements) {
        for (By element : elements) {
            Assert.assertTrue(DriverCreation.getDriver().findElement(element).isDisplayed());
        }
    }

    public static void isDisplayed(By element, String text) {
        Assert.assertEquals(DriverCreation.getDriver().findElement(element).getText(), text);
    }

    public static boolean isDisplayed(String xpath) {
        boolean condition;
        try {
            condition = DriverCreation.getDriver().findElement(By.xpath(xpath)).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
        return condition;
    }

    public static void click(By element) {
        DriverCreation.getDriver().findElement(element).click();
    }

    public static void click(String xpath) {
        DriverCreation.getDriver().findElement(By.xpath(xpath)).click();
    }

    public static void text(By element, String text) {
        DriverCreation.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        DriverCreation.getDriver().findElement(element).sendKeys(text);
    }
    public static void text(By element, Keys text) {
        DriverCreation.getDriver().findElement(element).sendKeys(text);
    }

    public static void clear(By element) {
        DriverCreation.getDriver().findElement(element).clear();
    }
}
