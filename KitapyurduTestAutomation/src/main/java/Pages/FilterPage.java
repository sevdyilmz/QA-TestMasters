package Pages;

import Base.BaseTest;
import constants.FilterLocators;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class FilterPage extends BaseTest {


    @Step ("Arama çubuğuna aranacak kelime girilir.")
    public  FilterPage searchBox(String text){

     driver.findElement(FilterLocators.SeacrhBoxL).sendKeys(text);
     return this;

    }


    @Step ("Click butonuna tıklanır.")
    public FilterPage searchBoxClick () throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchClick = wait.until(ExpectedConditions.elementToBeClickable(FilterLocators.SeacrhBoxClickL));
        searchClick.click();
        sleep(2000);
        return this;
    }


    @Step ("Mouse Çok Satanlar sekmesine hareket eder.")
    public FilterPage moveToBestSeller (){

        WebElement bestSeller = driver.findElement(FilterLocators.BestSellerL);
        Actions action = new Actions(driver);
        action.moveToElement(bestSeller).perform();
        return this;

    }

    @Step ("Çok Satan Edebiyat filtreleme seçeneğine tıklanır.")
    public FilterPage bestsellerLiterature () throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement literature = wait.until(ExpectedConditions.elementToBeClickable(FilterLocators.BestSellerLiteratureL));
        literature.click();
        sleep(2000);
        return this;
    }


    @Step ("Sıralama dropdownına tıklanır.")
    public FilterPage sortDropdown () throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement sorting = wait.until(ExpectedConditions.elementToBeClickable(FilterLocators.SortDropDownL));
        sorting.click();
        sleep(2000);
        return this;
    }


    @Step ("Ucuzdan pahalıya seçeneği seçilir.")
    public FilterPage sortLowToClick () throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement sorting = wait.until(ExpectedConditions.elementToBeClickable(FilterLocators.SortLowToL));
        sorting.click();
        sleep(2000);
        return this;
    }


    @Step("Pahalıdan ucuza sıralama kontrol edilir.")
    public FilterPage sortHighToClick () throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement sorting = wait.until(ExpectedConditions.elementToBeClickable(FilterLocators.SortHighToL));
        sorting.click();
        sleep(2000);
        return this;
    }


    @Step ("Ucuzdan pahalıya sıralaması doğru yapılmış mı kontrol edilir.")
    public FilterPage sortLowToControl(){

        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //WebElement sort=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='value']"))); // Fiyatların yüklendiğini kontrol et

        // Ürün fiyatlarını al
        List<WebElement> priceElements = driver.findElements(By.cssSelector("[class='value']")); // Fiyatların bulunduğu elementin class'ını doğru yazın
        List<Double> prices = new ArrayList<>();

        // Fiyatları al ve listeye ekle
        for (WebElement priceElement : priceElements) {
            String priceText = priceElement.getText().replace("₺", "").replace(",", "").trim();
            try {
                prices.add(Double.parseDouble(priceText));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        //sıralama
        List<Double> sortedPrices = new ArrayList<>(prices);
        sortedPrices.sort(Double::compareTo);

        System.out.println("Orijinal Fiyatlar: " + prices);
        System.out.println("Sıralanmış Fiyatlar: " + sortedPrices);


        if (prices.equals(sortedPrices)) {
            System.out.println("Fiyatlar doğru bir şekilde ucuzdan pahalıya sıralanmış.");
        } else {
            System.out.println("Fiyat sıralaması hatalı.");
        }
        return this;
    }



    @Step ("Pahalıdan ucuza filtreleme kontrol edilir.")
    public FilterPage sortHighToControl(){

        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //WebElement sort=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='value']")));

        // Ürün fiyatlarını al
        List<WebElement> priceElements = driver.findElements(By.cssSelector("[class='value']"));
        List<Double> prices = new ArrayList<>();

        // Fiyatları al ve listeye ekle
        for (WebElement priceElement : priceElements) {
            String priceText = priceElement.getText().replace("₺", "").replace(",", "").trim();
            try {
                prices.add(Double.parseDouble(priceText));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        //sıralama
        List<Double> sortedPrices = new ArrayList<>(prices);
        sortedPrices.sort((a, b) -> b.compareTo(a));

        System.out.println("Orijinal Fiyatlar: " + prices);
        System.out.println("Sıralanmış Fiyatlar: " + sortedPrices);


        if (prices.equals(sortedPrices)) {
            System.out.println("Fiyatlar doğru bir şekilde ucuzdan pahalıya sıralanmış.");
        } else {
            System.out.println("Fiyat sıralaması hatalı.");
        }
        return this;
    }
}
