import Base.BaseTest;
import Pages.LoginPage;
import Pages.MainPage;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;


@Feature("Login Page Test Senaryoları")

public class LoginTests extends BaseTest {

    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();


    @Test (description= "Başarılı giriş testi")
    public void LoginSuccessful() throws InterruptedException {

        mainPage.signInButton();

        loginPage.acceptCookies()
                .fillMail(email)
                .fillPassword(password)
                .clickLogin();

        loginPage.click2();
        sleep(2000);
        loginPage.welcomeMessage(welcomeMessageText);

    }

    @Test (description = "Zorunlu alanların boş bırakılarak giriş denemesi")
    public void ErrorMessagesRequiredFieldsEmpty() throws InterruptedException {

        mainPage.signInButton();

        loginPage.acceptCookies()
                .clickLogin()
                        .click2();

        sleep(3000);
        loginPage.errorMessageController(errorMessageText);

    }

    @Test (description = "Şifre kısmı boş bırakılarak giriş denemesi")
    public void ErrorMessageRequiredPasswordEmpty() throws InterruptedException {

        mainPage.signInButton();


        loginPage.acceptCookies()
                .fillMail(email)
                .clickLogin()
                        .click2();

        sleep(3000);
        loginPage.errorMessageController(errorMessageText);



    }

    @Test (description = "E-posta alanı boş bırakılarak giriş denemesi")
    public void ErrorMessageRequiredMailEmpty() throws InterruptedException {

        mainPage.signInButton();

        loginPage.acceptCookies()
                .fillPassword("987654P.")
                .clickLogin()
                        .click2();

        sleep(3000);
        loginPage.errorMessageController(errorMessageText);

    }

    @Test (description = "Geçersiz mail testi")
    public void ErrorMessageInvalidMail() throws InterruptedException {

        mainPage.signInButton();

        loginPage.acceptCookies()
                .fillMail("aaa")
                .fillPassword("987654P.")
                .clickLogin();
        loginPage.click2();

        sleep(3000);

        loginPage.errorMessageController(errorMessageText);

    }

    @Test (description = "Geçerisiz şifre denemesi")
    public void ErrorMessageInvalidPassword() throws InterruptedException {

        mainPage.signInButton();

        loginPage.acceptCookies()
                .fillMail(email)
                .fillPassword("98")
                .clickLogin()
                        .click2();

        sleep(2000);

        loginPage.errorMessageController(errorMessageText);

    }

    @Test (description = "Şifre görüntüleme ve gizleme buton testi")
    public void ShowAndHidePasswordIcon(){

        mainPage.signInButton();
        loginPage.fillMail(email)
                 .fillPassword(password)
                 .showPasswordIcon();
        screenshot();
        loginPage.hidePasswordIcon();
        screenshot();

    }

}
