package setupDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class UserRegistration  {
    //HomePage homeObject;
    //UserRegistrationPage userRegistrationObject;
    @Given("the user in the home page")
    public void the_user_in_the_home_page() {
      //  homeObject = new HomePage(driver);
        //homeObject.openRegistrationPage();
    }
    @When("I click on register link")
    public void i_click_on_register_link()
    {
        //Assert.assertTrue(driver.getCurrentUrl().contains("register"));

    }
//    @When("I entered the user data")
//    public void i_entered_the_user_data() {
//        userRegistrationObject = new UserRegistrationPage(driver);
//        userRegistrationObject.userRegistration("Osama","Sayed","test@gmail.com","123456");
//    }

    @When("I entered {string}, {string}, {string}, {string}")
    public void i_entered(String firstname, String lastname, String email, String password) {
        //userRegistrationObject = new UserRegistrationPage(driver);
      //userRegistrationObject.userRegistration(firstname,lastname,email,password);
    }
    @Then("The registration page displayed successfully")
    public void the_registration_page_displayed_successfully() {
        //userRegistrationObject.userLogout();
    }
}
