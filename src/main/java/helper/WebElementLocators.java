package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebElementLocators {
    WebDriver driver;
    Waiting wait;
    public WebElementLocators(WebDriver driver){
    this.driver = driver;
    wait = new Waiting(driver);
    }

    public WebElement findBy(String locatorValue, locators locatorType){
        By locateBy = locateElementBy(locatorValue,locatorType);
        try{
            return driver.findElement(locateBy);
        }
        catch (Exception e) {
            try {
                return wait.waitUntil(Waiting.waitMethod.visibilityOfElementLocated.toString(),locateBy, 30);
            }
            catch (Exception ex){
                try {
                    return wait.waitUntil(Waiting.waitMethod.presenceOfElementLocated.toString(),locateBy, 30);
                }
                catch (Exception exc){
                    return wait.waitUntil(Waiting.waitMethod.elementToBeClickable.toString(),locateBy,30);
                }
            }
        }
    }

    public By locateElementBy(String locatorValue, locators locatorType){
        switch (locatorType){
            case Xpath:
                return new By.ByXPath(locatorValue);
            case className:
                return new By.ByClassName(locatorValue);
            case css:
                return new By.ByCssSelector(locatorValue);
            case name:
                return new By.ByName(locatorValue);
            case tagName:
                return new By.ByTagName(locatorValue);
            case linkText:
                return new By.ByLinkText(locatorValue);
            case id:
                return new By.ById(locatorValue);
            case partialLinkText:
                return new By.ByPartialLinkText(locatorValue);
            default: return  null;
        }

    }



  public enum locators{
        Xpath,
        className,
        css,
        name,
        tagName,
        linkText,
        id,
        partialLinkText
    }

}
