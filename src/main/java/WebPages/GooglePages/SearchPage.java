package WebPages.GooglePages;

import Utilities.Helpers.HelperClass;
import WebDriver.DriverFactory;
import WebDriver.WebDriverSingleton;
import dev.failsafe.internal.util.Assert;
import org.asynchttpclient.util.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

public class SearchPage {

    WebDriverSingleton webDriverSingleton;
    RemoteWebDriver driver;
    By googleSearchBar=By.xpath("//input[@type='text']");
    By googleSearchButton=By.xpath("//input[@name='btnK']");
    private HelperClass helperClass;
    WebDriverWait wait;
    public SearchPage(){
        webDriverSingleton=new WebDriverSingleton();
        driver=webDriverSingleton.getWebDriver().get();
        wait=new WebDriverWait(driver, Duration.ofSeconds(30,10),Duration.ofSeconds(10));
        helperClass=new HelperClass();

    }

    public void VerifytheCurrentLink(String URL) throws InterruptedException {
        driver.get(URL);
        helperClass.ACCEPTEGOOGLECOOKIES(webDriverSingleton);
        String currentLink=driver.getCurrentUrl();
        if(currentLink.contains(URL))
        {
            Assert.isTrue(true,"You are on the right link");
        }
        else{
            Assert.isTrue(false,"You are not on the right URL");
        }
    }

    public void fillThefieldinGoogleBarSearch(String text) throws InterruptedException {
        //Thread.sleep(2000);
        //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(googleSearchBar));
        wait.until(ExpectedConditions.presenceOfElementLocated(googleSearchBar));
        driver.findElement(googleSearchBar).sendKeys(text);
    }

    public void ClickOntheGoogleSearchButton(){
        driver.findElement(googleSearchButton).click();
    }

}
