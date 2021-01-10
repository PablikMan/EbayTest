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

public class CheckoutPage extends ReportSetup {

    public static void assertPageTitle(WebDriver driver){
        String actualPageTitle = driver.getTitle();
        String expectedPageTitle = "Checkout | eBay";

        try {
            Assert.assertEquals(actualPageTitle, expectedPageTitle);
            test.log(Status.PASS, "Checkout page title matches");
        }catch (AssertionError error){
            test.log(Status.FAIL, "Checkout page title does not matches");
            error.printStackTrace();
        }
    }

    public static void chooseCountry(WebDriver driver){
        Select countryList = new Select(driver.findElement(By.xpath("//select[@id='country']")));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        try {
            countryList.selectByVisibleText("Israel");
            test.log(Status.PASS, "Selects 'Israel' from the country list");
        }catch (NoSuchElementException e){
            test.log(Status.FAIL, "Israel has not been found in the elements");
        }
    }

    public static void enterFirstName(WebDriver driver){
        WebElement firstNameField = driver.findElement(By.xpath("//input[@id='firstName']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(firstNameField));

        try {
            firstNameField.click();
            firstNameField.sendKeys("Paul");
            test.log(Status.PASS, "Enters 'Paul' as the name in the 'name field'");
        }catch (NoSuchElementException e){
            test.log(Status.FAIL, "The first name field has not been found");
            e.printStackTrace();
        }
    }

    public static void enterLastName(WebDriver driver){
        WebElement lastNameField = driver.findElement(By.xpath("//input[@id='lastName']"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        try {
            lastNameField.sendKeys("Jordan");
            test.log(Status.PASS, "Enters the last name in the 'last name' field");
        }catch (NoSuchElementException e){
            test.log(Status.FAIL, "The last name field element has not been found");
            e.printStackTrace();
        }
    }

    public static void enterAddress(WebDriver driver){
        WebElement address = driver.findElement(By.xpath("//input[@id='addressLine1']"));

        try {
            address.sendKeys("HaGiborim 8");
            test.log(Status.PASS, "Enters the street address in the 'address field'");
        }catch (NoSuchElementException e){
            test.log(Status.FAIL, "The 'street address' field element has not been found");
            e.printStackTrace();
        }
    }

    public static void enterCity(WebDriver driver){
        WebElement city = driver.findElement(By.xpath("//input[@id='city']"));

        try {
            city.sendKeys("Hadera");
            test.log(Status.PASS, "Enters the city in the 'city field'");
        }catch (NoSuchElementException e){
            test.log(Status.FAIL, "The 'city' field element has not been found");
        }
    }

//    public static void chooseState(WebDriver driver){
//        WebElement state = driver.findElement(By.xpath("//input[@id='stateOrProvince']"));
//        state.sendKeys("Haifa");
//    }

    public static void enterZipCode(WebDriver driver){
        WebElement zipCode = driver.findElement(By.xpath("//input[@name='postalCode']"));

        try {
            zipCode.sendKeys("256849");
            test.log(Status.PASS, "Enters the zip code in the 'zip code' field");
        }catch (NoSuchElementException e){
            test.log(Status.FAIL, "The 'zip code' field element has not been found");
            e.printStackTrace();
        }
    }

    public static void enterEmail(WebDriver driver){
        WebElement email = driver.findElement(By.xpath("//input[@id='email']"));

        try {
            email.sendKeys("example@gmail.com");
            test.log(Status.PASS, "Enters the email in the 'email' field");
        }catch (NoSuchElementException e){
            test.log(Status.FAIL, "The 'email' field element has not been found");
        }
    }

    public static void confirmEmail(WebDriver driver){
        WebElement confirmEmail = driver.findElement(By.xpath("//input[@id='emailConfirm']"));

        try {
            confirmEmail.sendKeys("example@gmail.com");
            test.log(Status.PASS, "Enters the email once again in the 'confirm email' field");
        }catch (NoSuchElementException e){
            test.log(Status.FAIL, "The 'confirm email' field element has not been found");
        }
    }

    public static void chooseCountryCode(WebDriver driver){
        WebElement countryCode = driver.findElement(By.xpath("//button[@aria-label='Israel +972, Country Code']"));

        try {
            countryCode.click();
            test.log(Status.PASS, "Chooses the Israel phone code from the list");
        }catch (NoSuchElementException e){
            test.log(Status.FAIL, "The 'country code' list element has not been found");
            e.printStackTrace();
        }
    }

    public static void enterPhoneNumber(WebDriver driver){
        WebElement phoneNumber = driver.findElement(By.xpath("//input[@id='phoneNumber']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(phoneNumber));

        try {
            phoneNumber.click();
            phoneNumber.sendKeys("529742168");
            test.log(Status.PASS, "Enters a phone number in the 'phone number' field");
        }catch (NoSuchElementException e){
            test.log(Status.FAIL, "The 'phone number' field element has not been found");
            e.printStackTrace();
        }
    }

    public static void clickOnDoneButton(WebDriver driver){
        WebElement doneButton = driver.findElement(By.xpath("//button[@data-test-id='ADD_ADDRESS_SUBMIT']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(doneButton));

        try {
            doneButton.submit();
            test.log(Status.PASS, "Clicks on the 'done' button");
        }catch (NoSuchElementException e){
            test.log(Status.FAIL, "The 'done' button element has not been found");
            e.printStackTrace();
        }
    }
}
