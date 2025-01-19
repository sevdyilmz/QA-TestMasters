package Base;

import io.qameta.allure.Attachment;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;



public class BaseLibrary extends Data {

    public static WebDriver driver;

    public void sleep(int time) throws InterruptedException {

        Thread.sleep(time);
    }

    @Attachment (value= "Screenshot", type= "image/png")
    public byte[] screenshot(){
        return((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }


}