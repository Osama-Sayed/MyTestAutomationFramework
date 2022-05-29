package actions;

//import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Optional;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BrowserActions {
    public static Map<String, WebDriver> driverMap = new HashMap<>();
  // public static WebDriver driver;
    public void browserInit(@Optional("Chrome") String browserName, String className){

        if(browserName.toLowerCase().equals(BrowserActions.Browsers.chrome.toString())) {
           // WebDriverManager.chromedriver().setup();
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/drivers/chromedriver.exe");
           // driver = new ChromeDriver();

            driverMap.put(className, new ChromeDriver());
        }
        else if(browserName.toLowerCase().equals(BrowserActions.Browsers.firefox.toString())) {
           // WebDriverManager.firefoxdriver().setup();
            System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/drivers/geckodriver.exe");
            driverMap.put(className, new FirefoxDriver());
        }
        else if(browserName.toLowerCase().equals(Browsers.ie.toString())) {
            //WebDriverManager.iedriver().setup();
            System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"/drivers/IEDriverServer.exe");
            driverMap.put(className, new InternetExplorerDriver());
        }
        else if(browserName.toLowerCase().equals(Browsers.headless.toString()))
        {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setJavascriptEnabled(true);
            caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,System.getProperty("user.dir")+"/drivers/phantomjs.exe");
            String[] phantomJSArgs ={"--web-security=no","--ignore-ssl-errors=yes"};
            caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS,phantomJSArgs);
            driverMap.put(className, new PhantomJSDriver(caps));
        }

        else if(browserName.equalsIgnoreCase(Browsers.chrome_headless.toString())) {
           // WebDriverManager.chromedriver().setup();
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/drivers/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("--window-site=1920,1080");
            driverMap.put(className, new ChromeDriver(options));
        }
    }

    public void browserConfiguration(WebDriver driver, boolean maximizeScreen, boolean fullScreen,boolean minimize,boolean timeout){
        if(maximizeScreen)
            driver.manage().window().maximize();
        if(timeout)
            driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        if(fullScreen)
            driver.manage().window().fullscreen();
        if (minimize)
            driver.manage().window().minimize();
    }

    public void navigateToURL(String className, String url){
       WebDriver driver = driverMap.get(className);
       driver.navigate().to(url);
    }

    public WebDriver getDriver(String className){
        return  driverMap.get(className);
    }


    public void browserClose(String className){
        getDriver(className).quit();
        driverMap.remove(className);
    }



    enum Browsers{
        chrome,
        firefox,
        ie,
        headless,
        chrome_headless
    }


}

