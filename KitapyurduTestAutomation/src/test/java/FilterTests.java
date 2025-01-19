import Base.BaseTest;
import Pages.FilterPage;
import Pages.LoginPage;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;



@Feature("Filter Page Test Senaryosu")


public class FilterTests extends BaseTest {


    LoginPage loginPage = new LoginPage();
    FilterPage filterPage = new FilterPage();


    @Test (description = "Arama çubuğu kullanarak filtreleme")
    public void filterWithSearchBox() throws InterruptedException {
        loginPage.acceptCookies();
        filterPage.searchBox("fakir baykurt")
                .searchBoxClick();
        screenshot();

    }


    @Test (description = "Ucuzdan Pahalıya sıralama")
    public void filterLowPrices()throws InterruptedException {

        loginPage.acceptCookies();
        sleep(2000);
        filterPage.moveToBestSeller()
                .bestsellerLiterature()
                .sortDropdown()
                .sortLowToClick()
                .sortLowToControl();

    }


    @Test (description = "Pahalıdan Ucuza sıralama")
    public void filterHighPrices()throws InterruptedException {

        loginPage.acceptCookies();
        sleep(2000);
        filterPage.moveToBestSeller()
                .bestsellerLiterature()
                .sortDropdown()
                .sortHighToClick()
                .sortHighToControl();

    }
}
