package Utilities.Helpers;

import WebDriver.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class HelperClass {

    By accepteButtonGoogle = By.xpath("//div[@class='QS5gu sy4vM'][contains(text(),'Tout accepter')]");
    WebDriverWait wait;
    public void ACCEPTEGOOGLECOOKIES(WebDriverSingleton driver) throws InterruptedException {
        wait=new WebDriverWait(driver.getWebDriver().get(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(accepteButtonGoogle));
        driver.getWebDriver().get().findElement(accepteButtonGoogle).click();
    }

    public String REDIRECTEDTOTHERIGHTLINK(WebDriverSingleton driver){
        return driver.getWebDriver().get().getCurrentUrl();
    }
}
