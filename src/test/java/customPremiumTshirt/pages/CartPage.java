package customPremiumTshirt.pages;

import customPremiumTshirt.utilities.Driver;
import customPremiumTshirt.utilities.PageUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CartPage extends PageUtil {
    public CartPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//select[@id='address_province']")
    WebElement stateDropdown;

    @FindBy(xpath = "//input[@id='address_zip']")
    WebElement zipCodeText;

    @FindBy(xpath = "//input[@id='get-rates-submit']")
    WebElement calculateShippingButton;

    @FindBy(xpath = "//input[@id='cart-coupon-code']")
    WebElement couponCodeText;

    @FindBy(xpath = "//div[@class='cart-total-value']/span[1]")
    WebElement totalPrice;

    @FindBy(xpath = "//button[@id='cart-checkout']")
    WebElement proceedToCheckoutButton;

    public void selectStateAndProceed(String state, String zipCode){
        waitForPageLoad();
        Select stateSelect = new Select(stateDropdown);
        stateSelect.selectByValue(state);
        zipCodeText.sendKeys(zipCode);
        proceedToCheckoutButton.click();
    }

}
