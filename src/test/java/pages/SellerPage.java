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

public class SellerPage extends ReportSetup {

    public static void assertPageTitle(WebDriver driver){
        String expectedPageTitle = "A Game of Thrones Box Set. | eBay";
        String actualPageTitle = driver.getTitle();

        try {
            Assert.assertEquals(actualPageTitle, expectedPageTitle);
            test.log(Status.PASS, "Checks if the website's title matches");
        }catch (AssertionError error){
            test.log(Status.FAIL, "Website's title does not match");
            error.printStackTrace();
        }
    }

    public static void changeQuantity(WebDriver driver){
        WebElement quantity = driver.findElement(By.xpath("//input[@id='qtyTextBox']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(quantity));

        try {
            quantity.clear();
            quantity.sendKeys("2");
            test.log(Status.PASS, "Changes the quantity to 2");
        }catch (NoSuchElementException e){
            test.log(Status.FAIL, "The quantity field element has not been found");
            e.printStackTrace();
        }
    }

    public static void addToCart(WebDriver driver){
        WebElement addToCartButton = driver.findElement(By.xpath("//a[@id='isCartBtn_btn']"));

        try {
            addToCartButton.click();
            test.log(Status.PASS, "Adds the item to the cart");
        }catch (NoSuchElementException e){
            test.log(Status.FAIL, "The 'add to cart' button element has not been found");
            e.printStackTrace();
        }

    }
}
