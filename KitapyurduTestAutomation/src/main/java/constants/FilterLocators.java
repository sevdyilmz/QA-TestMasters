package constants;

import org.openqa.selenium.By;

public class FilterLocators  {

    public static final By bookKaplumbagalar = By.id("product-280996");
    public static final By BestSellerL = By.xpath("/html//div[@id='mainNav']/div[@class='nav-content']/ul//ul[@class='js-ajaxCt js-bookCt']/li[1]/a[@href='cok-satan-kitaplar/haftalik/1.html']");
    public static final By BestSellerLiteratureL = By.xpath("/html//div[@id='mainNav']/div[@class='nav-content']/ul//ul[@class='js-ajaxCt js-bookCt']/li[1]/div/div[1]/div[@class='subCategories']/ul[1]//a[@href='index.php?route=product/best_sellers&list_id=16']");
    //public static final By LiteratureL = By.cssSelector(".box.other-categories > div:nth-of-type(7) > .alt");
    public static final By SortDropDownL = By.xpath("/html//div[@id='content']//div[@class='product-filter']//div[@class='sort']/select");
    public static final By SortLowToL = By.xpath("//option[@value='https://www.kitapyurdu.com/index.php?route=product/best_sellers&sort=p.price&order=ASC&list_id=16']");
    public static final By SortHighToL = By.xpath("//option[@value='https://www.kitapyurdu.com/index.php?route=product/best_sellers&sort=p.price&order=DESC&list_id=16']");
    public static final By SeacrhBoxL = By.id("search-input");
    public static final By SeacrhBoxClickL = By.cssSelector("div#search > .button-search.common-sprite");


}
