import Base.BaseTest;
import Pages.BasketPage;
import Pages.LoginPage;
import Pages.MainPage;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;



@Feature("Basket Page Test Senaryoları")

public class BasketTests extends BaseTest {

    MainPage mainPage = new MainPage();
    LoginPage loginPage = new LoginPage();
    BasketPage basketPage = new BasketPage();

    @Test (description = "Boş sepet yazı ve sayı testi")
    public void emptyBasketTest () throws InterruptedException{

        mainPage.signInButton();

        loginPage.acceptCookies()
                .fillMail(email)
                .fillPassword(password)
                .clickLogin();
        loginPage.click2();
        basketPage.emptyBasket("Sepetiniz boş")
                .basketCount("0");

    }

    @Test (description = "Sepete başarılı bir şekilde ürün ekleme testi")
    public void addItemToBasket () throws InterruptedException {

        loginPage.acceptCookies();
        mainPage.searchBar("fareler ve insanlar")
                        .searchBarEnter();
        sleep(3000);
        basketPage.addKaplumbagalar()
                .clickToBasketIcon()
                .addedKaplumbagalarT("Fareler ve İnsanlar sepetinize eklendi!");


    }

    @Test (description = "Sepetten başarılı bir şekilde ürün silme testi")
    public void removeItemFromBasket () throws InterruptedException {

        loginPage.acceptCookies();
        mainPage.searchBar("fareler ve insanlar")
                .searchBarEnter();
        sleep(3000);
        basketPage.addKaplumbagalar()
                .clickToBasketIcon()
                .addedKaplumbagalarT("Fareler ve İnsanlar sepetinize eklendi!")
                .goToBasketIconClick();
        screenshot();
        basketPage.deleteFromBasketButton()
                .yesDelete();
        screenshot();



    }


    @Test (description = "Üye olmadan satın alma testi - üye giriş sayfasına yönelndirildi.")
    public void buyButtonTest () throws InterruptedException {

        loginPage.acceptCookies();
        mainPage.searchBar("fareler ve insanlar")
                .searchBarEnter();
        sleep(3000);
        basketPage.addKaplumbagalar()
                .clickToBasketIcon()
                .goToBasketIconClick()
                .buyButton();
        screenshot();


    }

    @Test (description = "Üye girişi yapıldıktan sonra satın alma testi - satın alma sayfasına yönlendirildi")
    public void buyButtonTest2 () throws InterruptedException {

        loginPage.acceptCookies();
        mainPage.signInButton();
        loginPage.fillMail(email)
                .fillPassword(password)
                .clickLogin();
        sleep(2000);
        loginPage.click2();
        sleep(2000);
        mainPage.searchBar("fareler ve insanlar")
                .searchBarEnter();
        sleep(3000);
        basketPage.addKaplumbagalar()
                .clickToBasketIcon()
                .goToBasketIconClick()
                .buyButton();
        screenshot();


    }

}
