import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;
import utilites.Driver;
import utilites.ReportSetup;

public class MainTest extends ReportSetup {

    private static WebDriver driver;

    @BeforeClass
    public WebDriver preparations(){
        testSetup();
        test.log(Status.INFO, "Beginning of the test");
        driver = Driver.getDriver();
        return driver;
    }

    @Test(priority = 1)
    public void test_01(){
        HomePage.openWebPage(driver);
        takeScreenshot("src/test/java/screenshots/Screenshot", "1", driver);
    }

    @Test(priority = 2)
    public void test_02(){
        HomePage.searchFunction(driver);
    }

    @Test(priority = 3)
    public void test_03(){
        SearchResultPage.assertPage(driver);
        takeScreenshot("src/test/java/screenshots/Screenshot", "2", driver);
    }

    @Test(priority = 4)
    public void test_04(){
        SearchResultPage.enterTheFirstResult(driver);
    }

    @Test(priority = 5)
    public void test_05(){
        SellerPage.assertPageTitle(driver);
        takeScreenshot("src/test/java/screenshots/Screenshot", "3", driver);
    }

    @Test(priority = 6)
    public void test_06(){
        SellerPage.changeQuantity(driver);
    }

    @Test(priority = 7)
    public void test_07(){
        SellerPage.addToCart(driver);
    }

    @Test(priority = 8)
    public void test_08(){
        ShoppingCartPage.assertPageTitle(driver);
        takeScreenshot("src/test/java/screenshots/Screenshot", "4", driver);
    }

    @Test(priority = 9)
    public void test_09(){
        ShoppingCartPage.clickOnTheCheckoutButton(driver);
    }

    @Test(priority = 10)
    public void test_10(){
        ShoppingCartPage.clickOnContinueAsGuest(driver);
    }

    @Test(priority = 11)
    public void test_11(){
        CheckoutPage.assertPageTitle(driver);
        takeScreenshot("src/test/java/screenshots/Screenshot", "5", driver);
    }

    @Test(priority = 12)
    public void test_12(){
        CheckoutPage.chooseCountry(driver);
    }

    @Test(priority = 13)
    public void test_13(){
        CheckoutPage.enterFirstName(driver);
    }

    @Test(priority = 14)
    public void test_14(){
        CheckoutPage.enterLastName(driver);
    }

    @Test(priority = 15)
    public void test_15(){
        CheckoutPage.enterAddress(driver);
    }

    @Test(priority = 16)
    public void test_16(){
        CheckoutPage.enterCity(driver);
    }

//    @Test(priority = 17)
//    public void test_17(){
//        CheckoutPage.chooseState(driver);
//    }

    @Test(priority = 18)
    public void test_18(){
        CheckoutPage.enterZipCode(driver);
    }

    @Test(priority = 19)
    public void test_19(){
        CheckoutPage.enterEmail(driver);
    }

    @Test(priority = 20)
    public void test_20(){
        CheckoutPage.confirmEmail(driver);
    }

    @Test(priority = 21)
    public void test_21(){
        CheckoutPage.chooseCountryCode(driver);
    }

    @Test(priority = 22)
    public void test_22(){
        CheckoutPage.enterPhoneNumber(driver);
        takeScreenshot("src/test/java/screenshots/Screenshot", "6", driver);
    }

    @Test(priority = 23)
    public void test_23(){
        CheckoutPage.clickOnDoneButton(driver);
    }

    @AfterClass
    public void endOfTest(){
        driver.quit();
        test.log(Status.INFO, "End of test");
        extentReports.flush();
    }
}
