package POM;

import helper.WebElementLocators;
import actions.BrowserActions;
import actions.WebUIActions;
import org.openqa.selenium.WebElement;



public class GooglePage {
    WebUIActions webUIActions;
    WebElementLocators webLocators;


    public GooglePage(){
        webUIActions = new WebUIActions("chrome",this.getClass().getName(),"https://www.google.com.eg/");
        webLocators = new WebElementLocators(BrowserActions.driverMap.get(this.getClass().getName()));
    }
    public void enterDataInSearchTextBox(String SearchKeyWord){
        WebElement searchTextBox = webLocators.findBy("q", WebElementLocators.locators.name);
        webUIActions.sendKeys(searchTextBox,SearchKeyWord);
    }

    public void clickSearchBtn(){
        WebElement searchBtn = webLocators.findBy("//span[contains(text(),'osama elzero')]", WebElementLocators.locators.Xpath);
        webUIActions.buttonClick(searchBtn);
    }

    public void scrollAfterSearch(){
       // webUIActions.buttonClick(webLocators.findBy("osama", WebElementLocators.locators.name));
        webUIActions.scrollToParagraph();
    }

    public void closeBrowser(){
        webUIActions.quitDriver(this.getClass().getName());
    }
}
