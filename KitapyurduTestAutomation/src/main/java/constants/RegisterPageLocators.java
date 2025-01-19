package constants;

import org.openqa.selenium.By;

public class RegisterPageLocators {

    //inputs locators
    public static final By FillName = By.id("register-name");
    public static final By FillLastName = By.id("register-lastname");
    public static final By FillMail = By.id("register-email");
    public static final By FillPassword = By.id("register-password");
    public static final By FillConfirmPassword = By.id("register-password-confirm");
    public static final By ShowPersonalData = By.xpath("/html//form[@id='register-form']//a[@alt='Kişisel Verilerin Korunması']/strong[.='Kişisel Verilerin Korunması']");
    public static final By AcceptPersonalData = By.cssSelector("div:nth-of-type(6) > .ky-form-check-label > .ky-checkbox-input");
    public static final By AcceptElectronicCommunication = By.id("id='is_campaign_newsletter'");
    public static final By ShowElectronicCommunication = By.cssSelector("div:nth-of-type(7) > .ky-form-check-label strong");
    public static final By RegisterButton = By.cssSelector("button[role='button']");


    //text locators
    public static final By PersonalDataErrorLocator = By.cssSelector(".ky-error");
    public static final By NameErrorLocator = By.cssSelector("div:nth-of-type(1) > .ky-error-input");
    public static final By LastNameErrorLocator = By.cssSelector("div:nth-of-type(2) > .ky-error-input");
    public static final By EmailErrorLocator = By.cssSelector("div:nth-of-type(3) > .ky-error-input");
    public static final By PasswordErrorLocator = By.xpath("//form[@id='register-form']/div[4]/span[@class='ky-error-input']");
    public static final By RegisteredEmailErrorLocator = By.cssSelector(".ky-error");
    public static final By DoNotMatchPasswordErrorLocator = By.xpath("//form[@id='register-form']//span[@class='ky-error-input']");

}

