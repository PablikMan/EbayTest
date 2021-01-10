package pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilites.ReportSetup;

import java.time.Duration;
import java.util.function.Function;

public class ShoppingCartPage extends ReportSetup {

    public static void assertPageTitle(WebDriver driver){
        String actualPageTitle = driver.getTitle();
        String expectedPageTitle = "eBay shopping cart";

       try {
           Assert.assertEquals(actualPageTitle, expectedPageTitle);
           test.log(Status.PASS, "The website's title matches");
       }catch (AssertionError error){
           test.log(Status.FAIL, "The website's title does not match");
           error.printStackTrace();
       }
    }

    public static void clickOnTheCheckoutButton(WebDriver driver){
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);
        WebElement checkoutButton = wait.until(new Function<WebDriver, WebElement>() {
            public  WebElement apply(WebDriver driver){
                return driver.findElement(By.xpath("//button[@class='call-to-action btn btn--large btn--primary']"));
            }
        });
        try {
            checkoutButton.click();
            test.log(Status.PASS, "Click the 'checkout' button");
        }catch (NoSuchElementException e){
            test.log(Status.FAIL, "The 'checkout' button element has not been found");
            e.printStackTrace();
        }
    }

    public static void clickOnContinueAsGuest(WebDriver driver){
        WebElement continueAsGuest = driver.findElement(By.xpath("//button[@id='gxo-btn']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(continueAsGuest));

        try {
            continueAsGuest.click();
            test.log(Status.PASS, "Choose the 'continue as guest' option");
        }catch (NoSuchElementException e){
            test.log(Status.FAIL, "The 'continue as guest' element has not been found");
            e.printStackTrace();
        }

    }
}
