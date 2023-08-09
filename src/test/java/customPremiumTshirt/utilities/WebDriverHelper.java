package customPremiumTshirt.utilities;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

@Slf4j

public class WebDriverHelper {

    private WebDriver driver;
    public WebDriverHelper (WebDriver driver){
        this.driver = driver;
    }

    public WebElement waitForElementClickable(final WebElement element, int timeOutPeriod){
        WebDriverWait webDriverWait = new WebDriverWait(driver, timeOutPeriod);
        webDriverWait.pollingEvery(Duration.ofMillis(5));
        return webDriverWait.until(new ExpectedCondition<WebElement>() {

            public WebElement apply(WebDriver driver){
                try {
                    if (element.isEnabled()&& element.isDisplayed())
                        return element;
                    else
                        return null;
                } catch (NoSuchElementException ex){
                    ex.printStackTrace();
                    return null;
                } catch (StaleElementReferenceException ex){
                    return null;
                } catch (NullPointerException ex){
                    return null;
                }
            }
        });
    }

    public WebElement waitForElementDisplayed(final WebElement element, int timeOutPeriod){
        WebDriverWait webDriverWait = new WebDriverWait(driver, timeOutPeriod);
        webDriverWait.pollingEvery(Duration.ofMillis(5));

        return webDriverWait.until(new ExpectedCondition<WebElement>() {

            public WebElement apply(WebDriver driver){
                try {
                    if (element.isDisplayed())
                        return element;
                    else
                        return null;
                } catch (NoSuchElementException ex){
                    ex.printStackTrace();
                    return null;
                } catch (StaleElementReferenceException ex){
                    return null;
                } catch (NullPointerException ex){
                    return null;
                }
            }
        });

    }

    public void WaitForPageLoad(int timeOutPeriod){
        try{
            FluentWait<WebDriver> fluentWait = new FluentWait<>(driver);
            fluentWait.pollingEvery(Duration.ofSeconds(5));
            fluentWait.withTimeout(Duration.ofSeconds(timeOutPeriod));

            fluentWait.until(new Function<WebDriver, Boolean>() {

                public Boolean apply(WebDriver driver1){
                    log.info("State "+((JavascriptExecutor)driver).executeScript(
                            "return document.readyState"));
                    return ((JavascriptExecutor)driver).executeScript(
                            "return document.readyState").equals("complete");
                }
            });
        } catch (Exception e){
            e.printStackTrace();
            log.info("waitforpageload method");
        }
    }
}
