package WebDriver;

import org.bouncycastle.cms.SignerInfoGenerator;

public class WebDriverSingleton {

    private DriverFactory webDriver;
    private static WebDriverSingleton InstanceWebDriver=null;

    public WebDriverSingleton(){
        webDriver=new DriverFactory();
    }


    public static WebDriverSingleton getInstance(){
        if(InstanceWebDriver==null){
            InstanceWebDriver=new WebDriverSingleton();
        }
        return InstanceWebDriver;
    }

    public DriverFactory getWebDriver(){
        return webDriver;
    }

}
