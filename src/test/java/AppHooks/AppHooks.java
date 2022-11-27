package AppHooks;

import Utilities.Helpers.HelperClass;
import WebDriver.DriverFactory;
import WebDriver.WebDriverSingleton;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.junit.Before.*;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;

public class AppHooks {

    private WebDriverSingleton driver;
    private DriverFactory driverFactory;
    private HelperClass helperClass;
    WebDriverWait wait;

    @Before(order=1)
    public void LaunchBrower() throws InterruptedException {
        driver=new WebDriverSingleton();
        driver.getWebDriver().createRemoteDriver();
        helperClass=new HelperClass();

    }
/*
    @Before(order=1)
    public void accepteCookies() throws InterruptedException {
        helperClass.ACCEPTEGOOGLECOOKIES(driver);
    //driver.getWebDriver().get().manage().deleteCookieNamed ("CONSENT");
    //Cookie cookie=new Cookie("seleniumTest","");
    //driver.getWebDriver().get().manage().addCookie(new Cookie("CONSENT","YES+","https://www.google.com"));
    //driver.getWebDriver().get().navigate().refresh();
    }

*/

    @After
    public void CloseBrowser(){
        driver.getWebDriver().closeDriver();
    }
}
