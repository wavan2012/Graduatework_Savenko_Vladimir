package PageObject;

import org.openqa.selenium.By;

public class MainPage extends BasePage {
    private static final By login = By.xpath("//input[@type='text' and contains(@class,'auth-form')]");
    private static final By lgnPsw = By.xpath("//input[@type='password' and contains(@class,'auth-form')]");
    private static final By entrance = By.xpath("//*[text()='Вход']");
    private static final By profileFrame = By.xpath("//div[contains(@class,'b-top-profile__item_arrow')]/a");
    private static final By logOff = By.xpath("//div[contains(@class,'b-top-profile__logout')]/a");
    private static final By lgnBtn = By.xpath("//button[contains(@class,'auth-button')]");
    private static final By errMsg = By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3");
    public static void openPage() {
        open("https://catalog.onliner.by/");
    }

    public static void verifyMainPage() {
        verifyUrl("https://catalog.onliner.by");
    }
    public static void logIn() {
        click(entrance);
        text(login, "wavan2012@gmail.com");
        text(lgnPsw, "32423345345bB");
        click(lgnBtn);
    }

    public static void logOut() {
        click(profileFrame);
        click(logOff);
    }
    public static void toCart() {
        click("//*[@id=\"shopping_cart_container\"]");
    }

    public static void addToCart(String product) {
        click("//*[@id=\"add-to-cart-sauce-" + product + "\"]");
    }

    public static void removeFromCart(String product) {
        click("//*[@id=\"remove-sauce-" + product + "\"]");
    }
}

