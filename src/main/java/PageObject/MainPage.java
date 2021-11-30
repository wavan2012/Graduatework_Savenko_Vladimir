package PageObject;

import org.openqa.selenium.By;

public class MainPage extends BasePage {
    private static final By login = By.xpath("//input[@type='text' and contains(@class,'auth-form')]");
    private static final By lgnPsw = By.xpath("//input[@type='password' and contains(@class,'auth-form')]");
    private static final By entrance = By.xpath("//*[text()='Вход']");
    private static final By profileFrame = By.xpath("//div[contains(@class,'b-top-profile__item_arrow')]/a");
    private static final By logOff = By.xpath("//div[contains(@class,'b-top-profile__logout')]/a");
    private static final By lgnBtn = By.xpath("//button[contains(@class,'auth-button')]");
    private static final By errMsg = By.xpath("//div[contains(@class,'auth-form__description_error')]");
    private static final By searchField = By.xpath("//input[@type='text' and contains(@class,'search__input')]");

    public static void openPage() {
        open("https://catalog.onliner.by/");
    }

    public static void verifyMainPage() {
        verifyUrl("https://catalog.onliner.by");
    }

    public static void toEntrance() {
        click(entrance);
    }

    public static void logIn() {
        toEntrance();
        text(login, "wavan2012@gmail.com");
        text(lgnPsw, "32423345345bB");
        click(lgnBtn);
    }

    public static void logIn(String name, String password) {
        toEntrance();
        text(login, name);
        text(lgnPsw, password);
        click(lgnBtn);
    }

    public static void logOut() {
        click(profileFrame);
        click(logOff);
    }

    public static void toCart() {
        open("https://cart.onliner.by");
    }

    public static void toRegisterNP() {
        open("https://profile.onliner.by/registration");
    }

    public static void verifyErrMsg(String message) {
        isDisplayed(errMsg, message);
    }
}


