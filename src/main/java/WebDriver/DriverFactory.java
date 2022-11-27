package WebDriver;


import Utilities.ConfigReader.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

//Cette classe a pour objectif de loader le webdriver correspondant
public class DriverFactory {
    private ConfigReader configReader;

    //j'utilise Remote Web driver en cas si j'ai besoin de lancer mes tests sur une autre machine
    private final RemoteWebDriver remoteWebDriver;
        public DriverFactory(){
            configReader=new ConfigReader();
            this.remoteWebDriver=createRemoteDriver();

        }
        private static InheritableThreadLocal<RemoteWebDriver> driverPool=new InheritableThreadLocal<>();
        public RemoteWebDriver get(){
            return this.remoteWebDriver;
        }

        public RemoteWebDriver createRemoteDriver(){
            if(driverPool.get()==null){
                String browser=configReader.init_props().getProperty("browser");
                switch (browser){
                    case "chrome":
                        driverPool.set(createChromeDriver(false));
                        break;
                    case "chrome-headless":
                        driverPool.set(createChromeDriver(true));
                        break;
                    case "firefox":
                        driverPool.set(createFirefoxDriver(false));
                        break;
                    case "firefox-headless":
                        driverPool.set(createFirefoxDriver(true));
                        break;
                    default:
                        throw new RuntimeException("Unknown driver for " + browser + " browser");
                }

            }
            return driverPool.get();
        }

    private RemoteWebDriver createChromeDriver(boolean isHeadless) {
        WebDriverManager.chromedriver().setup();
        if (isHeadless) {
            return new ChromeDriver(new ChromeOptions().setHeadless(true).addArguments("window-size=1920,1080"));
        }
        try {
            return new ChromeDriver();
        } catch (WebDriverException e) {
            return new ChromeDriver();
        }
    }

    private RemoteWebDriver createFirefoxDriver(boolean isHeadless) {
        WebDriverManager.firefoxdriver().setup();
        if (isHeadless) {
            return new FirefoxDriver(new FirefoxOptions().setHeadless(true).addArguments("window-size=1920,1080"));
        }
        try {
            return new FirefoxDriver();
        } catch (WebDriverException e) {
            return new FirefoxDriver();
        }
    }

    public void closeDriver() {
        if (driverPool != null) {
            driverPool.get().quit();
            driverPool.remove();
        }
    }


}
