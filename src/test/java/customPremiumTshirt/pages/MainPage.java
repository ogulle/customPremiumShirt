package customPremiumTshirt.pages;

import customPremiumTshirt.utilities.ConfigurationReader;
import customPremiumTshirt.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {


    public MainPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@title='Polo Shirts']")
    private WebElement poloShirts;

    @FindBy(xpath = "//a[@class='slide-button button no-des'][1]")
    private WebElement startDesigningButton;

    public void goToMainPage(){
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().get(ConfigurationReader.getProperty("website"));
    }

    public String getTitle(){
       return Driver.getDriver().getTitle();
    }

    public void startDesigning(){
        startDesigningButton.click();
    }

    public void verifyTitle(){
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Custom Premium Shirt";
        Assert.assertEquals("Title Verification", actualTitle,expectedTitle);
    }

}
