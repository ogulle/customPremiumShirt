package customPremiumTshirt.pages;

import customPremiumTshirt.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GildanHeavyCotton {

    public GildanHeavyCotton() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[@class='price-item price-item--sale']")
    private List<WebElement> prices;

    @FindBy(xpath = "//label[@for='option-7578069041342-Size-0']/span")
    private WebElement selectSmallSize;

    @FindBy(xpath = "//label[@for='option-7578069041342-Size-12']/span")
    private WebElement selectMediumSize;

    @FindBy(xpath = "//label[@for='option-7578069041342-Size-24']/span")
    private WebElement selectLargeSize;

    @FindBy(xpath = "//label[@for='option-7578069041342-Size-36']/span")
    private WebElement selectXLargeSize;

    @FindBy(xpath = "//label[@for='option-7578069041342-Size-48']/span")
    private WebElement selectXXLargeSize;

    @FindBy(xpath = "//legend[@class='form__label']/span")
    private List<WebElement> sizeAndColor;

    @FindBy(xpath = "//label[@for='option-7578069041342-Color-0']")
    private WebElement heatherNavyColorShirt;

    @FindBy(xpath = "//label[@for='option-7578069041342-Color-1']")
    private WebElement blackColorShirt;

    @FindBy(xpath = "//label[@for='option-7578069041342-Color-2']")
    private WebElement charcoalColorShirt;

    @FindBy(xpath = "//label[@for='option-7578069041342-Color-3']")
    private WebElement ashColorShirt;

    @FindBy(xpath = "//label[@for='option-7578069041342-Color-4']")
    private WebElement irishGreenColorShirt;

    @FindBy(xpath = "//label[@for='option-7578069041342-Color-5']")
    private WebElement lightPinkColorShirt;

    @FindBy(xpath = "//label[@for='option-7578069041342-Color-6']")
    private WebElement purpleColorShirt;

    @FindBy(xpath = "//label[@for='option-7578069041342-Color-7']")
    private WebElement redColorShirt;

    @FindBy(xpath = "//label[@for='option-7578069041342-Color-8']")
    private WebElement safetyGreenColorShirt;

    @FindBy(xpath = "//label[@for='option-7578069041342-Color-9']")
    private WebElement safetyOrangeColorShirt;

    @FindBy(xpath = "//label[@for='option-7578069041342-Color-10']")
    private WebElement sportGreyColorShirt;

    @FindBy(xpath = "//label[@for='option-7578069041342-Color-11']")
    private WebElement whiteColorShirt;

    @FindBy(xpath = "//button[@name='minus'][1]")
    private WebElement quantityDecrease;

    @FindBy(xpath = "//button[@name='plus'][1]")
    private WebElement quantityIncrease;

    @FindBy(xpath = "//a[@id='qstomizer-product-button']")
    private WebElement customizeButton;

    public void selectSize(String size) {
        if (size.equalsIgnoreCase("S")) {
            selectSmallSize.click();
            String actualSize = sizeAndColor.get(0).getText();
            Assert.assertTrue(actualSize.equalsIgnoreCase(size));
        } else if (size.equalsIgnoreCase("M")) {
            selectMediumSize.click();
            String actualSize = sizeAndColor.get(0).getText();
            Assert.assertTrue(actualSize.equalsIgnoreCase(size));
        } else if (size.equalsIgnoreCase("L")) {
            selectLargeSize.click();
            String actualSize = sizeAndColor.get(0).getText();
            Assert.assertTrue(actualSize.equalsIgnoreCase(size));
        } else if(size.equalsIgnoreCase("XL")) {
            selectXLargeSize.click();
            String actualSize = sizeAndColor.get(0).getText();
            Assert.assertTrue(actualSize.equalsIgnoreCase(size));
        } else if(size.equalsIgnoreCase("XXL")) {
            selectXXLargeSize.click();
            String actualSize = sizeAndColor.get(0).getText();
            Assert.assertTrue(actualSize.equalsIgnoreCase(size));
        }
    }

    public void selectColor(String color){
        if (color.equalsIgnoreCase("heather navy")) {
            heatherNavyColorShirt.click();
            String actualColor = sizeAndColor.get(1).getText();
            Assert.assertTrue(actualColor.equalsIgnoreCase(color));
        } else if (color.equalsIgnoreCase("black")) {
            blackColorShirt.click();
            String actualColor = sizeAndColor.get(1).getText();
            Assert.assertTrue(actualColor.equalsIgnoreCase(color));
        } else if (color.equalsIgnoreCase("charcoal")) {
            charcoalColorShirt.click();
            String actualColor = sizeAndColor.get(1).getText();
            Assert.assertTrue(actualColor.equalsIgnoreCase(color));
        } else if(color.equalsIgnoreCase("ash")) {
            ashColorShirt.click();
            String actualColor = sizeAndColor.get(1).getText();
            Assert.assertTrue(actualColor.equalsIgnoreCase(color));
        } else if(color.equalsIgnoreCase("irish Green")) {
            irishGreenColorShirt.click();
            String actualColor = sizeAndColor.get(1).getText();
            Assert.assertTrue(actualColor.equalsIgnoreCase(color));
        } else if (color.equalsIgnoreCase("light Pink")) {
            lightPinkColorShirt.click();
            String actualColor = sizeAndColor.get(1).getText();
            Assert.assertTrue(actualColor.equalsIgnoreCase(color));
        } else if (color.equalsIgnoreCase("purple")) {
            purpleColorShirt.click();
            String actualColor = sizeAndColor.get(1).getText();
            Assert.assertTrue(actualColor.equalsIgnoreCase(color));
        } else if(color.equalsIgnoreCase("safety Green")) {
            safetyGreenColorShirt.click();
            String actualColor = sizeAndColor.get(1).getText();
            Assert.assertTrue(actualColor.equalsIgnoreCase(color));
        } else if(color.equalsIgnoreCase("safety Orange")) {
            safetyOrangeColorShirt.click();
            String actualColor = sizeAndColor.get(1).getText();
            Assert.assertTrue(actualColor.equalsIgnoreCase(color));
        } else if(color.equalsIgnoreCase("sportGrey")) {
            sportGreyColorShirt.click();
            String actualColor = sizeAndColor.get(1).getText();
            Assert.assertTrue(actualColor.equalsIgnoreCase(color));
        } else if(color.equalsIgnoreCase("white")) {
            whiteColorShirt.click();
            String actualColor = sizeAndColor.get(1).getText();
            Assert.assertTrue(actualColor.equalsIgnoreCase(color));
        }
    }

    public String getFirstPrice(){
        return prices.toString();
    }

    public void clickCustomize(){
        customizeButton.click();
    }
}
