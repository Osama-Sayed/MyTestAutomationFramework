package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Optional;

public class WebUIActions {

    WebDriver driver;
    BrowserActions browserActions;
    public WebUIActions(@Optional("Chrome") String browserName, String className,String url){
        browserActions = new BrowserActions();
        browserActions.browserInit(browserName,className);
        browserActions.navigateToURL(className, url);
        driver = browserActions.getDriver(className);
        browserActions.browserConfiguration(driver,true,false,false,true);
    }

    public void sendKeys(WebElement element, String data){
        element.sendKeys(data);
    }

    public void buttonClick(WebElement element){
        element.click();
    }

    public void scrollToParagraph() {
        String script = "window.scrollTo(0,document.body.scrollHeight)";
        var jsExecutor = ((JavascriptExecutor) driver);
        jsExecutor.executeScript(script);
    }

    public void quitDriver(String className){
        browserActions.browserClose(className);
    }



}
