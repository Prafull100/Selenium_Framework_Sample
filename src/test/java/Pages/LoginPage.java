package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver ldriver) {
        this.driver = ldriver;

    }

    @FindBy(id = "txtID")
    WebElement username;

    @FindBy(id = "txtPwd")
    WebElement Password;

    @FindBy(id = "txtCompName")
    WebElement companyName;

    @FindBy(id = "lblLogin")
    WebElement submitButton;

    public void loginToDMP(String uname, String pass, String company) throws InterruptedException {

        Thread.sleep(2000);

        username.sendKeys(uname);
        Password.sendKeys(pass);
        companyName.sendKeys(company);
        submitButton.click();

    }
}
