package setupDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
public class E2ETests {

   /* SearchPage searchObject;
    ProductDetailsPage productDetailsObject;
    ShoppingCartPage shoppingCartObject;
    CheckOutPage checkOutObject;
    String productName =  "Apple MacBook Pro 13-inch";

*/
    @Given("user is on Home Page")
    public void user_is_on_home_page() {
        // Write code here that turns the phrase above into concrete actions
       // Assert.assertTrue(driver.getCurrentUrl().contains("demo.nopcommerce.com"));
    }
    @When("he search for {string}")
    public void he_search_for(String productName) {
        /*searchObject = new SearchPage(driver);
        searchObject.productSearchUsingAutoSuggest(productName);
        productDetailsObject= new ProductDetailsPage(driver);
        Assert.assertTrue(productDetailsObject.productNamebreadCrumb.getText().contains(productName));*/
    }
    @When("choose to buy two items")
    public void choose_to_buy_two_items() {
        //shoppingCartObject = new ShoppingCartPage(driver);
        //productDetailsObject.addToCart();
    }
    @Then("moves to checkout cart and enter personal details on checkout page and place the order")
    public void moves_to_checkout_cart_and_enter_personal_details_on_checkout_page_and_place_the_order() throws InterruptedException {
        /*checkOutObject = new CheckOutPage(driver);
        shoppingCartObject.openCheckOutPage();
        checkOutObject.clickOnCheckOutAsGuest();
        checkOutObject.registeredUserCheckoutProduct("test","usre","test@gmail.com","Alabama","United States","Egypt","15055","01022233455","Fayoum");
   */
    }


}
