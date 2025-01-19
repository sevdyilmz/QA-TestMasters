package constants;

import org.openqa.selenium.By;

public class LoginPageLocators {

    public static final By FillMailLoginL = By.id("login-email");
    public static final By FillPasswordLoginL = By.id("login-password");
    public static final By ClickLoginL = By.cssSelector("[class='ky-form-buttons'] button");
    public static final By AcceptCookiesL = By.id("cookiescript_accept");
    public static final By ErrorMessageLoginL = By.cssSelector("[class='ky-error']");
    public static final By WelcomeMessageLoginL = By.cssSelector(".login.menu.top > ul  .common-sprite");
    public static final By ShowPasswordIcon = By.cssSelector(".fa.fa-eye-slash.js-show-toggle-pw.ky-show-password");
    public static final By HidePasswordIcon = By.cssSelector(".fa.fa-eye.js-show-toggle-pw.ky-show-password");
}
