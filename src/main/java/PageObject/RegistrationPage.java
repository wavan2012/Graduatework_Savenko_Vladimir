package PageObject;

import org.openqa.selenium.By;

public class RegistrationPage extends BasePage {
    private static final By email = By.xpath("//input[@type='email']");
    public static final By choosePsw = By.xpath("//input[@type='password' and contains(@placeholder,'Придумайте пароль')]");
    private static final By repeatPsw = By.xpath("//input[@type='password' and contains(@placeholder,'Повторите пароль')]");
    private static final By registerBtn = By.xpath("//button[@type='submit' and contains(@class,'auth-button')]");
    private static final By safetyPsw = By.xpath("//div[contains(@class,'auth-form__securebox')]/div[2]");
    private static final By licenseBtn = By.xpath("//span[@class='i-checkbox__faux']");

    public static By getSafetyPsw() {
        return safetyPsw;
    }

    public static void setEmail(String setEmail) {
        clear(email);
        text(email, setEmail);
    }

    public static void setChoosePsw(String setChoosePsw) {
        clear(choosePsw);
        text(choosePsw, setChoosePsw);
    }

    public static void setRepeatPsw(String setRepeatPsw) {
        clear(repeatPsw);
        text(repeatPsw, setRepeatPsw);
    }

    public static void clickRegisterBtn() {
        click(registerBtn);
    }

    public static void clickLicenseBtn() {
        click(licenseBtn);
    }
}
