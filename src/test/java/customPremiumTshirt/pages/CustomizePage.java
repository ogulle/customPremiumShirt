package customPremiumTshirt.pages;

import customPremiumTshirt.utilities.Driver;
import customPremiumTshirt.utilities.PageUtil;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomizePage extends PageUtil {

    public CustomizePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[@class='qsmzl_BTNADDTEXT']")
    WebElement addTextButton;

    @FindBy(xpath = "//textarea[@id='newTexto']")
    WebElement addNewText;

    @FindBy(xpath = "//a[@id='btnnewtextok']")
    WebElement okButton;

    @FindBy(xpath = "//a[@id='addtocart']")
    WebElement orderNowButton;

    @FindBy(xpath = "//iframe[@id='qsmziFrameCont']")
    WebElement iFrame;

    public void customizeText(String text) throws InterruptedException {
        //waitForPageElement(orderNowButton, "element_displayed", "Page is loaded");
        Thread.sleep(5000);
        Driver.getDriver().switchTo().frame(iFrame);
        waitForPageElement(addNewText, "element_clickable", "add new text");
        addNewText.click();
        waitForPageElement(addNewText, "element_displayed", "Text box displayed");
        addNewText.sendKeys(text);
        waitForPageElement(okButton, "element_clickable", "Click Ok Button");
        JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
        js.executeScript("arguments[0].click();", okButton);
        waitForPageElement(orderNowButton, "element_clickable", "Click Order Now Button");
        orderNowButton.click();
        Driver.getDriver().switchTo().defaultContent();
        Thread.sleep(15000);
    }

}
