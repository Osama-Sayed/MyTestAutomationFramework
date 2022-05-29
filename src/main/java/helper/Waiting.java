package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiting {

    WebDriver driver;
    public Waiting(WebDriver driver){
        this.driver =driver;
    }

    public WebElement waitUntil(String waitingMethod,By findBy,int durationOfSeconds){
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationOfSeconds));
    if (waitingMethod.equalsIgnoreCase(waitMethod.visibilityOfElementLocated.toString()))
            return wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    else if (waitingMethod.equalsIgnoreCase(waitMethod.presenceOfElementLocated.toString()))
        return  wait.until(ExpectedConditions.presenceOfElementLocated(findBy));
    else if (waitingMethod.equalsIgnoreCase(waitMethod.elementToBeClickable.toString()))
        return  wait.until(ExpectedConditions.elementToBeClickable(findBy));
    else
        return null;
    }



     public static enum waitMethod{
        visibilityOfElementLocated,
        presenceOfElementLocated,
        elementToBeClickable
    }

}