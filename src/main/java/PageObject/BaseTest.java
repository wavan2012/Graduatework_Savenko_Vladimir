package PageObject;

import driver.DriverCreation;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    @BeforeTest
    public void beforeTest(){
       MainPage.openPage();
    }
    @AfterTest
    public void afterTest(){
        DriverCreation.quitDriver();
    }


}
