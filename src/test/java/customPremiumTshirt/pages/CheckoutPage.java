package customPremiumTshirt.pages;

import customPremiumTshirt.utilities.Driver;
import customPremiumTshirt.utilities.PageUtil;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CheckoutPage extends PageUtil {
    public CheckoutPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@id='SHIPPING']")
    WebElement shipCheckbox;

    @FindBy(xpath = "//input[@id='PICK_UP']")
    WebElement pickupCheckbox;

    @FindBy(xpath = "//input[@placeholder='First name']")
    WebElement firstNameTextBox;

    @FindBy(xpath = "//input[@placeholder='Last name']")
    WebElement lastNameTextBox;

    @FindBy(xpath = "//input[@id='address1']")
    WebElement addressTextBox;

    @FindBy(xpath = "//input[@id='TextField9']")
    WebElement apartmentNumberTextBox;

    @FindBy(xpath = "//input[@placeholder='City']")
    WebElement cityTextBox;

    @FindBy(xpath = "//input[@placeholder='ZIP code']")
    WebElement zipCodeTextBox;

    @FindBy(xpath = "//select[@name='zone']")
    WebElement stateDropbox;

    @FindBy(xpath = "//p[@class='_1x52f9s1 _1fragemai _1x52f9sl _1fragem1l _1x52f9sh']")
    WebElement orderSizeAndColor;

    @FindBy(xpath = "//input[@placeholder='Gift card or discount code']")
    WebElement couponTextBox;

    @FindBy(xpath = "//button[@aria-label='Apply Discount Code']")
    WebElement couponApplyButton;

    @FindBy(xpath = "//strong[@translate='yes']")
    WebElement totalPrice;

//    @FindBy(xpath = "//strong[@class='_19gi7yt0 _19gi7ytk _1fragem1o _19gi7yt1 notranslate']")
//    WebElement totalPriceForPickup;
//
//    @FindBy(xpath = "_19gi7yt0 _19gi7ytk _1fragem1s _19gi7yt1 notranslate")
//    WebElement totalPriceForShipping;

    @FindBy(xpath = "//button[@class='QT4by rqC98 hodFu VDIfJ j6D1f janiy']")
    WebElement continueToShippingButton;

    @FindBy(xpath = "//button[@class='QT4by rqC98 hodFu VDIfJ j6D1f janiy']")
    WebElement continueToPaymentButton;

    @FindBy(id = "email")
    WebElement emailTextBox;

    @FindBy(xpath = "//span[@class='_1fragem37 _1fragem10 _1fragem9t _1fragem9s a8x1wu5 _1fragem18 a8x1wui a8x1wum']")
    WebElement searchButton;

    @FindBy(xpath = "//p[@class='_1x52f9s1 _1fragemam _1x52f9sl _1fragem1p _1x52f9sh']")
    WebElement sizeAndColorOnPaymentPage;

    @FindBy(xpath = "//input[@id='basic-creditCards']")
    WebElement creditCardCheckbox;

    @FindBy(xpath = "//input[@id='delivery_strategies-SHIPPING']")
    WebElement shippingCheckbox;

    @FindBy(xpath = "//input[@id='delivery_strategies-PICK_UP']")
    WebElement pickingupCheckbox;


    public void shipInformation(){
        emailTextBox.sendKeys("alexgulle@gmail.com");
        firstNameTextBox.sendKeys("Osman");
        lastNameTextBox.sendKeys("Gulle");
        addressTextBox.sendKeys("435 Rocky Briar Ct");
        emailTextBox.click();
        cityTextBox.sendKeys("Richmond");
        Select select = new Select(stateDropbox);
        select.selectByValue("TX");
        zipCodeTextBox.sendKeys("77406");
        continueToShippingButton.click();
        waitForPageElement(continueToPaymentButton, "element_clickable", "Continue to Payment");
        continueToPaymentButton.click();
    }

    public void shipInformation_ship(String email, String firstname, String lastname, String address, String city, String stateCode, String zipcode){
        emailTextBox.sendKeys(email);
        shippingCheckbox.click();
        firstNameTextBox.sendKeys(firstname);
        lastNameTextBox.sendKeys(lastname);
        addressTextBox.sendKeys(address);
        emailTextBox.click();
        cityTextBox.sendKeys(city);
        Select select = new Select(stateDropbox);
        select.selectByValue(stateCode);
        zipCodeTextBox.sendKeys(zipcode);
        continueToShippingButton.click();
        waitForPageElement(continueToPaymentButton, "element_clickable", "Continue to Payment");
        continueToPaymentButton.click();
    }

    public void shipInformation_pickup(String email){
        emailTextBox.click();
        emailTextBox.sendKeys(email);
        pickingupCheckbox.click();
        waitForPageLoad(2);
        continueToShippingButton.click();
        waitForPageElement(continueToPaymentButton, "element_clickable", "Continue to Payment");
        continueToPaymentButton.click();
    }

    public String getTotalPriceForShipping(){
        return totalPrice.getText();
    }

    public String getTotalPriceForPickup(){
        return totalPrice.getText();
    }

    public void verifyOrderDetails(String size, String color){
        waitForPageElement(creditCardCheckbox, "element_clickable", "Credit Card");
        creditCardCheckbox.click();
        String[] sizeAndColor =  sizeAndColorOnPaymentPage.getText().split(" ");
        String actualSize = sizeAndColor[0];
        String actualColor = sizeAndColor[2];
        System.out.println(actualSize + ", " + actualColor);
        Assert.assertTrue(size.equalsIgnoreCase(actualSize));
        Assert.assertTrue(color.equalsIgnoreCase(actualColor));
    }







}
