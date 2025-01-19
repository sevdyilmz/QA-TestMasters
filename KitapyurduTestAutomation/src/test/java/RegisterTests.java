import Base.BaseTest;
import Pages.LoginPage;
import Pages.MainPage;
import Pages.RegisterPage;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;



@Feature("Register Page Test Senaryoları")


public class RegisterTests extends BaseTest {

    MainPage mainPage = new MainPage();
    LoginPage loginPage = new LoginPage();
    RegisterPage registerPage = new RegisterPage();


    @Test (description = "Tüm zorunlu alanların boş bırakılması")
    public void allRequiredFieldsEmpty() throws InterruptedException {

        loginPage.acceptCookies();
        mainPage.signUpButton();
        registerPage.scrollDown()
                    .registerButton();
        sleep(2000);
        registerPage.registerClick2();
        sleep(2000);
        registerPage.personalDataError(personalDataErrorMessageText)
                    .nameError(nameErrorMessageText)
                    .lastNameError(lastNameErrorMessageText)
                    .emailError(emailErrorMessageText)
                    .passwordError(passwordErrorMessageText);

    }

    @Test (description = "Geçersiz ad girişi")
    public void invalidName() throws InterruptedException {

        loginPage.acceptCookies();
        mainPage.signUpButton();
        registerPage.fillName("a")
                .fillLastName("Yılmaz")
                .fillMail(registerPage.generateRandomEmail())
                .fillPassword("987654S.")
                .confirmPassword("987654S.")
                .acceptPersonalData()
                .registerButton();
        sleep(2000);
        registerPage.registerClick2();
        sleep(2000);
        registerPage.nameError(nameErrorMessageText);


    }

    @Test (description = "Geçersiz soyisim girilmesi")
    public void invalidLastName() throws InterruptedException {

        loginPage.acceptCookies();
        mainPage.signUpButton();
        registerPage.fillName("Sevda")
                .fillLastName("a")
                .fillMail(registerPage.generateRandomEmail())
                .fillPassword("987654S.")
                .confirmPassword("987654S.")
                .acceptPersonalData()
                .registerButton();
        sleep(3000);
        registerPage.registerClick2();
        sleep(1000);
        registerPage.lastNameError(lastNameErrorMessageText);
    }

    @Test (description = "Geçersiz e-posta girişi")
    public void invalidEmail() throws InterruptedException {

        loginPage.acceptCookies();
        mainPage.signUpButton();
        registerPage.fillName("Sevda")
                .fillLastName("Yılmaz")
                .fillMail("kitap")
                .fillPassword("987654S.")
                .confirmPassword("987654S.")
                .acceptPersonalData()
                        .registerButton();
        sleep(2000);
        registerPage.registerClick2();
        sleep(3000);
        registerPage.emailError(emailErrorMessageText);
    }

    @Test (description = "Geçersiz şifre girilmesi")
    public void invalidPassword() throws InterruptedException {

        loginPage.acceptCookies();
        mainPage.signUpButton();
        registerPage.fillName("Sevda")
                .fillLastName("Yılmaz")
                .fillMail(registerPage.generateRandomEmail())
                .fillPassword("a")
                .confirmPassword("a")
                .acceptPersonalData()
                        .registerButton();
        sleep(2000);
        registerPage.registerClick2();
        sleep(3000);
        registerPage.passwordError(passwordErrorMessageText);
    }

    @Test (description = "Şifrelerin eşleşmemesi")
    public void passwordMisMatch() throws InterruptedException {

        loginPage.acceptCookies();
        mainPage.signUpButton();
        registerPage.fillName("Sevda")
                .fillLastName("Yılmaz")
                .fillMail(registerPage.generateRandomEmail())
                .fillPassword("987654S.")
                .confirmPassword("987654S")
                .acceptPersonalData()
                        .registerButton();
        sleep(2000);
        registerPage.registerClick2();
        sleep(3000);
        registerPage.doNotMatchPasswordError(DoNotMatchPasswordErrorText);

    }

    @Test (description = "Kayıtlı e-posta ile tekrar kayıt denemesi")
    public void registeredEmail() throws InterruptedException {

        loginPage.acceptCookies();
        mainPage.signUpButton();
        registerPage.fillName("Sevda")
                .fillLastName("Yılmaz")
                .fillMail(email)
                .fillPassword("987654S.")
                .confirmPassword("987654S.")
                .acceptPersonalData()
                .registerButton();
        sleep(3000);
        registerPage.registerButton();
        sleep(3000);
        registerPage.registeredEmailError(registeredEmailErrorMessageText);

    }

    @Test (description = "KVKK kabulü")
    public void personalDataInfo (){

        mainPage.signUpButton();
        registerPage.showPersonalDataInfo();
        screenshot();

    }

    @Test (description = "Elektronik ileti kabulü")
    public void electronicCommunicationInfo(){

        mainPage.signUpButton();
        registerPage.showElectronicCommunicationInfo();
        screenshot();

    }

}
