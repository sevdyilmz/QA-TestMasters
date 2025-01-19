package Pages;

import Base.BaseTest;
import constants.LoginPageLocators;
import constants.RegisterPageLocators;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.UUID;


public class RegisterPage extends BaseTest {

    LoginPage loginPage = new LoginPage();

    @Step ("Sayfa aşağı kaydırılır.")
    public RegisterPage scrollDown(){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 300);");
        return this;

    }

    @Step ("İsim alanı doldurulur.")
    public RegisterPage fillName(String text){

        driver.findElement(RegisterPageLocators.FillName).sendKeys(text);
        return this;

    }

    @Step ("Soyisim alanı doldurulur.")
    public RegisterPage fillLastName(String text){

        driver.findElement(RegisterPageLocators.FillLastName).sendKeys(text);
        return this;

    }

    @Step ("E-posta alanı doldurulur.")
    public RegisterPage fillMail(String text){

        driver.findElement(RegisterPageLocators.FillMail).sendKeys(text);
        return this;

    }

    @Step ("Şifre alanı doldurulur.")
    public RegisterPage fillPassword(String text){

        driver.findElement(RegisterPageLocators.FillPassword).sendKeys(text);
        return this;

    }

    @Step ("Girilen şifre tekrarlanır.")
    public RegisterPage confirmPassword(String text){

        driver.findElement(RegisterPageLocators.FillConfirmPassword).sendKeys(text);
        return this;

    }

    @Step ("Kişisel Verilerin Korunması Kanun bilgilendirme ekranı açılır.")
    public RegisterPage showPersonalDataInfo(){

        driver.findElement(RegisterPageLocators.ShowPersonalData).click();
        return this;

    }

    @Step ("Kişisel Verilerin Korunması ile ilgili metin kabul edilir.")
    public RegisterPage acceptPersonalData(){

        driver.findElement(RegisterPageLocators.AcceptPersonalData).click();
        return this;

    }

    @Step ("Reklam amaçlı elektronik bilgilendirme kabul edilir.")
    public RegisterPage acceptElectronicCommunication(){

        driver.findElement(RegisterPageLocators.AcceptElectronicCommunication).click();
        return this;

    }

    @Step ("Elektronik bilgilendirme metni ekranda görüntülenir.")
    public RegisterPage showElectronicCommunicationInfo(){

        driver.findElement(RegisterPageLocators.ShowElectronicCommunication).click();
        return this;

    }

    @Step ("Üye Ol butonuna tıklanır.")
    public RegisterPage registerButton(){

        driver.findElement(RegisterPageLocators.RegisterButton).click();
        return this;

    }

    //GET TEXT

    @Step ("Kişisel verilerin kabul edilmeme hata mesajı")
    public RegisterPage personalDataError(String text){

        String personalDataErrorSee = driver.findElement(RegisterPageLocators.PersonalDataErrorLocator).getText();
        Assert.assertEquals(personalDataErrorSee, text);
        return this;

    }

    @Step ("İsim alanı hata mesajı")
    public RegisterPage nameError(String text){

        String nameErrorControl= driver.findElement(RegisterPageLocators.NameErrorLocator).getText();
        Assert.assertEquals(nameErrorControl, text);
        return this;

    }

    @Step ("Soyisim alanı hata mesajı")
    public RegisterPage lastNameError(String text){

        String lastNameErrorControl = driver.findElement(RegisterPageLocators.LastNameErrorLocator).getText();
        Assert.assertEquals(lastNameErrorControl, text);
        return this;

    }

    @Step ("Mail alanı hata mesajı")
    public RegisterPage emailError(String text){

        String emailError = driver.findElement(RegisterPageLocators.EmailErrorLocator).getText();
        Assert.assertEquals(emailError, text);
        return this;

    }

    @Step ("Şifre alanı hata mesajı")
    public RegisterPage passwordError(String text){

        String passwordErrorControl = driver.findElement(RegisterPageLocators.PasswordErrorLocator).getText();
        Assert.assertEquals(passwordErrorControl, text);
        return this;

    }

    @Step ("Kayıtlı e-posta ile kayıt deneme hata mesajı")
    public RegisterPage registeredEmailError(String text){

        String registeredEmailErrorControl = driver.findElement(RegisterPageLocators.RegisteredEmailErrorLocator).getText();
        Assert.assertEquals(registeredEmailErrorControl, text);
        return this;

    }

    @Step ("Eşleşmeyen şifre hata mesajı")
    public RegisterPage doNotMatchPasswordError(String text){

        String doNotMatchPasswordErrorControl = driver.findElement(RegisterPageLocators.DoNotMatchPasswordErrorLocator).getText();
        Assert.assertEquals(doNotMatchPasswordErrorControl, text);
        return this;
    }


    @Step ("Random e-mail oluşturulur.")
    public String generateRandomEmail() {
        // UUID kullanarak rastgele bir kullanıcı adı oluşturuyoruz
        String userName = UUID.randomUUID().toString().substring(0, 8);
        String domain = "gmail.com";
        return userName + "@" + domain;
    }

    public RegisterPage registerClick2() throws InterruptedException {

        WebElement elementText= driver.findElement(LoginPageLocators.ErrorMessageLoginL);
        //sisteme giriş yaparken bazen doğrulama hatası veriyor, ikinci tıklamada sorun çıkmıyor. ama ne zaman doğrulama hatası vereceğini bilemediğimden yazdığım kod.
        sleep(3000);

        if(elementText.isDisplayed()){

            sleep(2000);
            driver.findElement(LoginPageLocators.ClickLoginL).click();

        }

        else {


            System.out.println("giriş yapılmış");

        }
        return this;
    }


}
