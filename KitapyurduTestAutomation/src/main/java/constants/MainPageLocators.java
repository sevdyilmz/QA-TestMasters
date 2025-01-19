package constants;

import org.openqa.selenium.By;

public class MainPageLocators {

    public static final By SignUpButtonL = By.cssSelector("[class='menu-top-button register']");
    public static final By SignInButtonL = By.cssSelector("[class='menu-top-button login']");
    public static final By SearchBarL = By.id("search-input");
    public static final By SearchBarEnterL = By.xpath("//div[@id='search']/span");

}
