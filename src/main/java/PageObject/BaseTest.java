package PageObject;

import driver.DriverCreation;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    static WebDriver driver;
    @BeforeTest
    public void beforeTest(){
       MainPage.openPage();
    }
    @AfterTest
    public void afterTest(){
        DriverCreation.quitDriver();
    }


}
