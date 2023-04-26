package testovi;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObject.LoginPage;

public class LoginTest extends BaseTest{
    ChromeDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void SetUp()
    {
        driver = openWebDriver();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void loginWithWalidData()
    {
        loginPage.Login("standard_user","secret_sauce");
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
    }

    @Test
    public void loginWithNotWalidData()
    {
        loginPage.Login("Milos","12345");
        Assert.assertEquals(loginPage.getTextFromErrorContainer(),"Epic sadface: " +
                "Username and password do not match any user in this service");
    }
    @Test
    public void loginWithEmptyUserNameAndPassword(){
        loginPage.Login("","");
        Assert.assertEquals(loginPage.getTextFromErrorContainer(),"Epic sadface: Username is required");
    }
    @AfterMethod
    public void closeDriver() {
        driver.close();
    }

}
