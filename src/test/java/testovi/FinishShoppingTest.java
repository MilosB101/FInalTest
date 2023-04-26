package testovi;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObject.*;

public class FinishShoppingTest extends BaseTest {
    ChromeDriver driver;

    LoginPage loginPage;

    InvetoryPage invetoryPage;

    CartPage cartPage;

    YourInformation yourInformation;

    CheckoutOverviewPage checkoutOverviewPage;

    FinalPage finalPage;


    @BeforeMethod
    public void SetUp() {
        driver = openWebDriver();
        loginPage = new LoginPage(driver);
        invetoryPage = new InvetoryPage(driver);
        cartPage = new CartPage(driver);
        yourInformation = new YourInformation(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
        finalPage = new FinalPage(driver);
    }

    @Test
    public void FinalTest() throws InterruptedException {
        loginPage.Login("standard_user", "secret_sauce");
        invetoryPage.clicktShirt();
        invetoryPage.clickJacket();
        invetoryPage.clickShoppingCart();
        cartPage.clickCheckout();
        yourInformation.inputCredentials("Milos", "Bukumirovic", "11000");
        yourInformation.clickContinueBotton();
        checkoutOverviewPage.clickFinish();
        Assert.assertEquals(finalPage.getCompleteText(),"Your order has been" +
                " dispatched, and will arrive just as fast as the pony can get there!");
    }

    @AfterMethod
    public void closeDriver() {
        driver.close();
    }
}

