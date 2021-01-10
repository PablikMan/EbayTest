package utilites;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ReportSetup {

    public static WebDriver driver;
    private static ExtentSparkReporter htmlReport;
    public static ExtentReports extentReports;
    public static ExtentTest test;

    public static void testSetup(){
        htmlReport = new ExtentSparkReporter("src\\test\\java\\report\\TestReport.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReport);
        test = extentReports.createTest("Sample Test", "Searching for a book in eBay, and selecting the first product result then proceeds to add it to the cart and continuing to checkout");
        extentReports.setSystemInfo("Tester", "Pablik");
    }

    public static String takeScreenshot(String imagePath, String imageNumber, WebDriver driver){
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File screenshotFile = screenshot.getScreenshotAs(OutputType.FILE);
        File destinationOfFile = new File(imagePath + " " + imageNumber + ".jpg");
        try {
            FileUtils.copyFile(screenshotFile, destinationOfFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imagePath + " " + imageNumber + ".jpg";
    }
}
