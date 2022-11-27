package WebPages.TruskPages;

import Utilities.Helpers.HelperClass;
import WebDriver.WebDriverSingleton;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WelcomePage {

    By truskersLink;
    By businessLink;
    WebDriverSingleton webDriverSingleton;
    HelperClass helperClass;
    RemoteWebDriver driver;
    WebDriverWait wait;

    public WelcomePage(){
        this.webDriverSingleton = new WebDriverSingleton();
        this.driver = webDriverSingleton.getWebDriver().get();
        wait=new WebDriverWait(driver, Duration.ofSeconds(30,10),Duration.ofSeconds(10));
        helperClass=new HelperClass();
    }

    public void UserClickonTheLink(String linkElements){
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        truskersLink=By.xpath("//a[@title='"+linkElements+"']");
        driver.findElement(truskersLink).click();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        }

    public void theUserisRedirectedTotheCorrectURL(String URL){
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        wait.until(ExpectedConditions.urlContains("https://trusk.com/fr/"+URL));
        String currentURL=helperClass.REDIRECTEDTOTHERIGHTLINK(webDriverSingleton);
        if(currentURL.equals("https://trusk.com/fr/"+URL)){
            Assert.state(true,"You are on the correct Link");
        }
        else Assert.state(false,"You are not the correct link");

    }
    }


