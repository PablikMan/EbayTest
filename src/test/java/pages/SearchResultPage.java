package pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilites.ReportSetup;

import java.time.Duration;

public class SearchResultPage extends ReportSetup {

    public static void assertPage(WebDriver driver){
        String expectedPageTitle = "Game Of Thrones in Books | eBay";
        String actualPageTitle = driver.getTitle();

        try {
            Assert.assertEquals(actualPageTitle, expectedPageTitle);
            test.log(Status.PASS, "The website's title matches");
        }catch (AssertionError error){
            test.log(Status.FAIL, "The website's title does not match");
            error.printStackTrace();
        }
    }

    public static void enterTheFirstResult(WebDriver driver){
        WebElement firstResult = driver.findElement(By.xpath("//a[@_sp='p2351460.m1686.l7400']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(firstResult));

        try {
            firstResult.click();
            test.log(Status.PASS, "Enters the first result that is given");
        }catch (NoSuchElementException e){
            test.log(Status.FAIL, "The first result element has not been found");
            e.printStackTrace();
        }
    }
}
