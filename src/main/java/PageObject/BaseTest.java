package PageObject;

import driver.DriverCreation;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import static io.restassured.RestAssured.baseURI;

@Listeners(Listener.class)
public class BaseTest {

    @BeforeTest
    public void beforeTest() {
        baseURI = "https://catalog.onliner.by";
        MainPage.openPage();
    }

    @AfterTest
    public void afterTest() {
        DriverCreation.quitDriver();
    }

   /* @DataProvider(name = "dataProvider")
    public Object[][] dataProviderMethod() {
        return new Object[][]{{
                RegistrationPage.setChoosePsw();
        }, {

        }};
    }*/

}
