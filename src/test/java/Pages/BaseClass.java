package Pages;

import Utilities.BrowserFactory;
import Utilities.ConfigDataProvider;
import Utilities.ExcelDataProvider;
import Utilities.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;

public class BaseClass {
    public WebDriver driver;
    public ExcelDataProvider excel;
    public ConfigDataProvider config;
    public ExtentReports reports;
    public ExtentTest logger;

    @BeforeSuite
    public void setUpSuite() {
        Reporter.log("Setting up report and test is getting ready",true);
        excel = new ExcelDataProvider();
        config = new ConfigDataProvider();
        ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir") + "/Reports/DMP" + Helper.getCurrentDateTime() + ".html"));
        reports = new ExtentReports();
        reports.attachReporter(extent);
        Reporter.log("Setting Done- Test can be started",true);
    }

    @BeforeClass
    public void setUp() {
        Reporter.log("trying to start browser and getting application ready",true);
        driver = BrowserFactory.startApplication(driver, config.getBrowserFromConfig(), config.getStagingUrl());
        Reporter.log("Browser and Application is up and running",true);
    }

    @AfterClass
    public void tearDown() {

        BrowserFactory.quitBrowser(driver);

    }

    @AfterMethod
    public void tearDownScreenShot(ITestResult result) throws IOException {
        Reporter.log("Test is about to complete",true);
        if ((result.getStatus() == ITestResult.FAILURE)) {
            logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShots(driver)).build());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShots(driver)).build());
        } else if (result.getStatus() == ITestResult.SKIP) {
            logger.skip("Test Skip", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShots(driver)).build());

        }
        reports.flush();
        Reporter.log("Test Completed >>> Reports Generated",true);
    }

}
