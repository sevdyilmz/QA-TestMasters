package Pages;

import Base.BaseTest;
import constants.LoginPageLocators;
import io.qameta.allure.Step;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage extends BaseTest {

    @Step ("E-posta alanı doldurulur.")
    public LoginPage fillMail(String text){

        driver.findElement(LoginPageLocators.FillMailLoginL).sendKeys(text);
        return this;
    }

    @Step ("Şifre alanı doldurulur.")
    public LoginPage fillPassword(String text){

        driver.findElement(LoginPageLocators.FillPasswordLoginL).sendKeys(text);
        return this;

    }

    public LoginPage clickLogin(){

        driver.findElement(LoginPageLocators.ClickLoginL).click();
        return this;

    }

    @Step ("Üye girişi yaparken bağlantı hatası oluşması durumunda yeniden tıklama yapılır.")
    public LoginPage click2() throws InterruptedException {

        //sisteme giriş yaparken bazen doğrulama hatası veriyor, ikinci tıklamada sorun çıkmıyor. ama ne zaman doğrulama hatası vereceğini bilemediğimden yazdığım kod.
        sleep(5000);
        String currentUrl = driver.getCurrentUrl();

        if(currentUrl.equals("https://www.kitapyurdu.com/index.php?route=account/account")){

            System.out.println("doğru");

        }

        else {

            sleep(2000);
            driver.findElement(LoginPageLocators.ClickLoginL).click();

        }
        return this;
    }


    @Step ("Cookies görüntüleniyorsa kabul eder.")
    public LoginPage acceptCookies() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement acceptCookiesButton = wait.until(ExpectedConditions.elementToBeClickable(LoginPageLocators.AcceptCookiesL));
            acceptCookiesButton.click();
            System.out.println("Çerez pop-up'ı kapatıldı.");
        } catch (TimeoutException e) {
            System.out.println("Çerez pop-up'ı bulunamadı.");
        }
        return this;
    }

    @Step ("Hata mesajını karşılaştırır.")
    public LoginPage errorMessageController(String text){

        //String errorMessage = driver.findElement(LoginPageLocators.ErrorMessageLoginL).getText();
        //Assert.assertEquals(errorMessage, text);
        //return this;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPageLocators.ErrorMessageLoginL));
        String errorMessage = errorMessageElement.getText();
        Assert.assertEquals(errorMessage, text);
        return this;

    }

    @Step ("Başarılı üye girişi sonrası kayıt olunan isim soyisim görüntülemesi.")
    public LoginPage welcomeMessage(String text){

        String welcome = driver.findElement(LoginPageLocators.WelcomeMessageLoginL).getText();
        Assert.assertEquals(welcome, text);
        return this;

    }

    @Step ("Girilen şifrenin gözterilmesi")
    public LoginPage showPasswordIcon(){

        driver.findElement(LoginPageLocators.ShowPasswordIcon).click();
        return this;

    }

    @Step ("Görüntülenen şifrenin gizlenmesi")
    public LoginPage hidePasswordIcon(){

        driver.findElement(LoginPageLocators.HidePasswordIcon).click();
        return this;

    }



}
