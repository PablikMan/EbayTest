package pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilites.ReportSetup;

import java.time.Duration;

public class HomePage extends ReportSetup {

    public static void openWebPage(WebDriver driver){
        driver.manage().window().maximize();
        driver.get("https://www.ebay.com/");
        String expectedWebPageTitle = "Electronics, Cars, Fashion, Collectibles & More | eBay";
        String actualWebPageTitle = driver.getTitle();
        try {
            Assert.assertEquals(actualWebPageTitle, expectedWebPageTitle);
            test.log(Status.PASS, "Opens the website and checks if the website's title matches");
        }catch (AssertionError error){
            test.log(Status.FAIL, "Opens the website but the website's title does not match");
            error.printStackTrace();
        }
    }

    public static void searchFunction(WebDriver driver){
        WebElement searchBox = driver.findElement(By.xpath("//input[@aria-label='Search for anything']"));
        Select categories = new Select(driver.findElement(By.xpath("//select[@aria-label='Select a category for search']")));
        WebElement searchButton = driver.findElement(By.xpath("//input[@type='submit']"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(searchBox));
        try {
            searchBox.sendKeys("Game Of Thrones");
            categories.selectByVisibleText("Books");
            searchButton.click();
            test.log(Status.PASS, "Types 'Game Of Thrones' in the search bar, choosing the 'Books' category, and clicks on the search button");
        }catch (NoSuchElementException error){
            test.log(Status.FAIL, "The element could not been found");
            error.printStackTrace();
        }
    }
}
