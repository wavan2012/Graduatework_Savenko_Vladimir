import PageObject.*;

import driver.DriverCreation;
import org.testng.annotations.Test;

import static PageObject.RegistrationPage.getSafetyPsw;

public class PositiveTests extends BaseTest {


    @Test(enabled = false)
    public void example() {
        MainPage.logIn();
        MainPage.logOut();
    }

    @Test
    public void safetyPswExamination() {
        MainPage.openPage();
        MainPage.toRegisterNP();
        RegistrationPage.setChoosePsw("3232323");
        RegistrationPage.isDisplayed( getSafetyPsw() ,"Минимум 8 символов" );
        RegistrationPage.setChoosePsw("32323233");
        RegistrationPage.isDisplayed( getSafetyPsw() ,"Ненадежный пароль, 8 символов" );
        RegistrationPage.setChoosePsw("323232333");
        RegistrationPage.isDisplayed( getSafetyPsw() ,"Ненадежный пароль, 9 символов" );
        RegistrationPage.setChoosePsw("3232323333");
        RegistrationPage.isDisplayed( getSafetyPsw() ,"Ненадежный пароль, 10 символов" );
        RegistrationPage.setChoosePsw("3232323334");
        RegistrationPage.isDisplayed( getSafetyPsw() ,"Средний пароль, 10 символов" );
        RegistrationPage.setChoosePsw("32323233333");
        RegistrationPage.isDisplayed( getSafetyPsw() ,"Ненадежный пароль, 11 символов" );
        RegistrationPage.setChoosePsw("32323234444");
        RegistrationPage.isDisplayed( getSafetyPsw() ,"Средний пароль, 11 символов" );
        RegistrationPage.setChoosePsw("323232333333");
        RegistrationPage.isDisplayed( getSafetyPsw() ,"Ненадежный пароль, 12 символов" );
        RegistrationPage.setChoosePsw("323232333334");
        RegistrationPage.isDisplayed( getSafetyPsw() ,"Сильный пароль, 12 символов" );
        RegistrationPage.setChoosePsw("32323233333444");
        RegistrationPage.isDisplayed( getSafetyPsw() ,"Сильный пароль, 14 символов" );
        DriverCreation.quitDriver();
    }
    @Test
    public void popUpErrMsg() {
        MainPage.openPage();
        MainPage.logIn("wavan","343232423");
        MainPage.verifyErrMsg("Неверный логин или пароль");
        DriverCreation.quitDriver();
    }
}
