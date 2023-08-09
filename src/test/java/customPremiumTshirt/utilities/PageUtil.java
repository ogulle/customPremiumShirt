package customPremiumTshirt.utilities;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Slf4j

public class PageUtil {

    public WebDriver driver = null;
    public WebDriverHelper webDriverHelper;

    public PageUtil(){
        if(driver==null){
            this.driver = Driver.getDriver();
            webDriverHelper = new WebDriverHelper(driver);
        }
    }

    public void waitForPageElement(WebElement pageElement, String waitType, String logMessage, int timeOut){
        WebElement webElement = null;

        WaitType waitTypes = WaitType.valueOf(waitType);

        switch (waitTypes){
            case element_clickable:
                try {
                    webDriverHelper.waitForElementClickable(pageElement, timeOut);
                    log.info("pageElement " + pageElement + " is clicked");
                } catch (Exception e){
                    e.printStackTrace();
                    log.info("pageElement " + pageElement + " is not clickable");
                }
                break;
            case element_displayed:
                try {
                    webDriverHelper.waitForElementDisplayed(pageElement, timeOut);
                    log.info("pageElement " + pageElement + " is displayed");
                } catch (Exception e){
                    e.printStackTrace();
                    log.info("pageElement " + pageElement + " is not displayed");
                }
        }
    }

    public void waitForPageElement(WebElement pageElement, String waitType, String logMessage){
        waitForPageElement(pageElement, waitType, logMessage, 150);
    }

    public void waitForPageLoad(int timeOutPeriod){
        webDriverHelper.WaitForPageLoad(timeOutPeriod);
    }

    public void waitForPageLoad(){
        webDriverHelper.WaitForPageLoad(600);
    }


}
