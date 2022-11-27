package WebPages.GooglePages;

import WebDriver.WebDriverSingleton;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ResultsPage {

    By firstResult=By.xpath("//h3[contains(text(),'Trusk livre tout, tout de suite')]");
    WebDriverSingleton webDriverSingleton;
    RemoteWebDriver driver;
    WebDriverWait wait;

    public ResultsPage() {
        this.webDriverSingleton = new WebDriverSingleton();
        this.driver = webDriverSingleton.getWebDriver().get();
        wait=new WebDriverWait(driver, Duration.ofSeconds(30,10),Duration.ofSeconds(10));
    }

    public void UserVerifytheFirstResult(String keywords){
        wait.until(ExpectedConditions.presenceOfElementLocated(firstResult));
        String firstElement=driver.findElement(firstResult).getText();
        if(firstElement.equals(keywords))
        {
            Assert.isTrue(true,"The result is correct");
        }
        else
            Assert.state(false, "something has changed");
    }

    public void UserClickOntheFirstLink(){
        driver.findElement(firstResult).click();
    }

    public void userVerifythecurrentLink(String URL){
        wait.until(ExpectedConditions.urlContains(URL));
        String currentLink=driver.getCurrentUrl();
        if(currentLink.equals(URL)){
            Assert.state(true,"we are on the correct link");
        }
    }
}
