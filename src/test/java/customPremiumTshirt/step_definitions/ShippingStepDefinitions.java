package customPremiumTshirt.step_definitions;

import customPremiumTshirt.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ShippingStepDefinitions {

    MainPage mainPage = new MainPage();
    GildanHeavyCotton gildanHeavyCotton = new GildanHeavyCotton();
    CustomizePage customizePage = new CustomizePage();
    CartPage cartPage = new CartPage();

    CheckoutPage checkoutPage = new CheckoutPage();

    String expectedPrice = "";

    @Given("User is on the CPS home page")
    public void userIsOnTheCPSHomePage() {
        mainPage.goToMainPage();
    }

    @Then("User should see title is as expected")
    public void userShouldSeeTitleIsAsExpected() {
        mainPage.verifyTitle();
    }

    @When("User starts by clicking start designing")
    public void userStartsByClickingStartDesigning() {
        mainPage.startDesigning();
    }

    @And("User selects {string},{string},{string} of the tShirt")
    public void userSelectsOfTheTShirt(String size, String color, String quantity) {
        gildanHeavyCotton.selectSize(size);
        gildanHeavyCotton.selectColor(color);
        expectedPrice = gildanHeavyCotton.getFirstPrice();
        gildanHeavyCotton.clickCustomize();
    }

    @And("User adds {string}")
    public void userAdds(String design) throws InterruptedException {
        customizePage.customizeText(design);
    }

    @And("User verifies order details on cart {string}, {string}")
    public void userVerifiesOrderDetailsOnCart(String state, String zipcode) {
        cartPage.selectStateAndProceed(state, zipcode);
    }

    @When("User fills out shipping information for pickup {string}")
    public void user_fills_out_shipping_information_for_pickup(String email) {
        checkoutPage.shipInformation_pickup(email);
    }

    @When("User fills out shipping information for shipping {string},{string},{string},{string},{string},{string},{string}")
    public void user_fills_out_shipping_information_for_shipping(String email, String firstname, String lastname, String address, String city, String stateCode, String zipcode) {
        checkoutPage.shipInformation_ship(email, firstname, lastname, address, city, stateCode, zipcode);
    }

    @Then("User verify all order details for shipping {string},{string}")
    public void userVerifyAllOrderDetailsForShipping(String size, String color) {
        String total = checkoutPage.getTotalPriceForShipping();
        checkoutPage.verifyOrderDetails(size, color);
        System.out.println(total);
    }

    @Then("User verify all order details for pickup {string},{string}")
    public void userVerifyAllOrderDetailsForPickup(String size, String color) {
        String total = checkoutPage.getTotalPriceForPickup();
        checkoutPage.verifyOrderDetails(size, color);
        System.out.println(total);
    }
}
