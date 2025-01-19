package Pages;

import Base.BaseTest;
import constants.MainPageLocators;
import io.qameta.allure.Step;


public class MainPage extends BaseTest {


    @Step ("Üye Girişi butonuna tıklanır.")
    public MainPage signInButton(){

        driver.findElement(MainPageLocators.SignInButtonL).click();
        return this;

    }

    @Step ("Üye Ol butonuna tıklanır.")
    public MainPage signUpButton(){

        driver.findElement(MainPageLocators.SignUpButtonL).click();
        return this;

    }

    @Step ("Arama çubuğuna veri girişi yapılır.")
    public MainPage searchBar(String text){

        driver.findElement(MainPageLocators.SearchBarL).sendKeys(text);

        return this;
    }

    @Step ("Arama çubuğunda veri girildikten sonra tıklanır.")
    public  MainPage searchBarEnter(){

        driver.findElement(MainPageLocators.SearchBarEnterL).click();
        return this;
    }


}
