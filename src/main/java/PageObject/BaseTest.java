package PageObject;

import driver.DriverCreation;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static io.restassured.RestAssured.*;

public class BaseTest {
    @BeforeTest
    public void beforeTest(){
        baseURI= "https://catalog.onliner.by";
       MainPage.openPage();
    }

    @AfterTest
    public void afterTest(){
        DriverCreation.quitDriver();
    }
}
