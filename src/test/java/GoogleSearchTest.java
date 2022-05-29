import POM.GooglePage;
import org.junit.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class GoogleSearchTest {
    GooglePage googlePage;

   @Test(retryAnalyzer = testCasesRetry.Retry.class)
    public void tryGoogleSearch(){
        googlePage = new GooglePage();
        googlePage.enterDataInSearchTextBox("Osama");
        googlePage.clickSearchBtn();
        googlePage.scrollAfterSearch();
       //Assert.assertTrue(false);
    }

    @AfterSuite
    public void closeBrowser(){
        googlePage.closeBrowser();
    }
}
