package Pages;

import Base.BaseTest;
import constants.BasketPageLocators;
import constants.FilterLocators;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class BasketPage extends BaseTest {



    @Step("Boş sepet bilgisi alınır.")
    public BasketPage emptyBasket (String text) {

        String textEmpty = driver.findElement(BasketPageLocators.BasketEmptyL).getText();
        Assert.assertEquals(textEmpty, text);
        return this;

    }


    @Step("Sepet içerisindeki ürün sayısı alınır.")
    public BasketPage basketCount (String text) {

        String basketCount = driver.findElement(BasketPageLocators.BasketContentCountL).getText();
        Assert.assertEquals(basketCount, text);
        return this;

    }


    @Step("Mouse Kaplumbağalar kitabı üzerine gelerek gizli iconlar gösterilir. ")
    public BasketPage addKaplumbagalar (){

        WebElement kaplumbagalar = driver.findElement(FilterLocators.bookKaplumbagalar);
        Actions action = new Actions(driver);
        action.moveToElement(kaplumbagalar).perform();
        return this;

    }


    @Step("Gizli ikonlar içerisinde yer alan sepete ekle iconuna tıklanır.")
    public BasketPage clickToBasketIcon () throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement addBasketIconE = wait.until(ExpectedConditions.elementToBeClickable(BasketPageLocators.addToBasketIconL));
        addBasketIconE.click();
        sleep(3000);
        return this;
    }


    @Step ("Eklenen kirabın eklendi pop-up mesajı ekranda görüntülenir.")
    public BasketPage addedKaplumbagalarT(String text) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement addedBook = wait.until(ExpectedConditions.visibilityOfElementLocated(BasketPageLocators.AddedKaplumbagalarL));
        String message = addedBook.getText();
        Assert.assertEquals(message, text);
        return this;
    }


    @Step ("Gizli ikonlar içerisinde yer alan sepete git iconuna tıklanır.")
    public BasketPage goToBasketIconClick() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement goToBasketIconC = wait.until(ExpectedConditions.elementToBeClickable(BasketPageLocators.GoToBasketIconL));
        goToBasketIconC.click();
        sleep(2000);
        return this;
    }


    @Step ("Sepete eklenen kitap silinir.")
    public BasketPage deleteFromBasketButton() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement delete = wait.until(ExpectedConditions.elementToBeClickable(BasketPageLocators.DeleteFromBasketL));
        delete.click();
        sleep(2000);
        return this;
    }


    @Step ("Silme işlemi onaylanır.")
    public BasketPage yesDelete() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement delete = wait.until(ExpectedConditions.elementToBeClickable(BasketPageLocators.DeleteYesL));
        delete.click();
        sleep(2000);
        return this;
    }


    @Step ("Sepette yer alan Satın Al butonuna tıklanır.")
    public BasketPage buyButton() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement delete = wait.until(ExpectedConditions.elementToBeClickable(BasketPageLocators.BuyButtonL));
        delete.click();
        sleep(2000);
        return this;
    }


}
