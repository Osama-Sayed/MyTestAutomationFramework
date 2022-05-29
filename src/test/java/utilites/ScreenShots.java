package utilites;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ScreenShots {
    //Method to take screenshot when the test case fail
    public static void captureScreenshot(WebDriver driver, String screenshotName){
        Path dest = Paths.get("./screenshots",screenshotName+".png");
        try {
            Files.createDirectories(dest.getParent());
            FileOutputStream out =new FileOutputStream(dest.toString());
            out.write(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
            out.close();

        }
        catch (Exception e){
            System.out.println("Exception while taking screenshot" + e.getMessage());
        }
    }

}
