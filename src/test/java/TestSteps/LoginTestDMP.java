package TestSteps;

import Pages.BaseClass;
import Pages.LoginPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LoginTestDMP extends BaseClass {

    @Test(priority = 1)
    public void loginApp() throws InterruptedException {

        logger = reports.createTest("Login to DMP");

        //driver= BrowserFactory.startApplication(driver, "chrome","https://hrmax.myadrenalin.com/AdrenalinMAX/#/");
        // System.out.println(driver.getTitle());
        //    ExcelDataProvider excel=new ExcelDataProvider();
        //   excel.getStringData("Login",0,0);
        LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
        logger.info("Starting Application");
        // Need to user this once Excel issue get sorted
        loginpage.loginToDMP(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1), excel.getStringData("Login", 0, 2));
        // loginpage.loginToDMP("FD005678", "passwordXYZ", "fulcrum");
        logger.pass("Login Successfully");


    }

    // Just added for report generation
    @Test(priority = 2)
    public void logOutApp1() {

        logger = reports.createTest("Logout");
        logger.fail("Login Failed");


    }

}
