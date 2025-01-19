package constants;

import org.openqa.selenium.By;

public class BasketPageLocators {

    //public static final By BasketContentL= By.id("cart-content");
    public static final By BasketEmptyL= By.id("cart-items-empty");
    public static final By BasketContentCountL= By.id("cart-items");
    public static final By AddedKaplumbagalarL= By.xpath("/html//h2[@id='swal2-title']");
    public static final By addToBasketIconL = By.xpath("/html//div[@id='content']//div[@class='box-content search-page-top']/ul/li[1]/div[@class='product-cr']//a[@class='add-to-cart']/i[@class='fa fa-shopping-cart']");
    public static final By GoToBasketIconL = By.xpath("/html//div[@id='content']//div[@class='box-content search-page-top']/ul/li[1]/div[@class='product-cr']//a[@class='go-to-cart']/i");
    public static final By DeleteFromBasketL = By.xpath("/html/body[@class='tr']/main[@id='cart']//section//div[@class='d-flex ms-auto']/div[2]/span[@class='fs-13 fw-bold lh-1 text-red-dark']");
    public static final By DeleteYesL = By.xpath("/html//div[@id='swal2-html-container']//button[.='Sil']");
    public static final By BuyButtonL = By.xpath("/html//div[@id='cart-sidebar']//a[@href='https://www.kitapyurdu.com/index.php?route=checkout/delivery']");

}
