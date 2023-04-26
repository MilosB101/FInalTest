package testovi;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObject.*;

public class ItemTotalTest extends BaseTest{

    ChromeDriver driver;

    LoginPage loginPage;

    InvetoryPage invetoryPage;

    CartPage cartPage;

    YourInformation yourInformation;

    CheckoutOverviewPage checkoutOverviewPage;

    @BeforeMethod
    public void SetUp()
    {
        driver = openWebDriver();
        loginPage = new LoginPage(driver);
        invetoryPage = new InvetoryPage(driver);
        cartPage = new CartPage(driver);
        yourInformation = new YourInformation(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
    }

    @Test
    public void checkItemTotalPrice() {
        loginPage.Login("standard_user","secret_sauce");
        invetoryPage.clicktShirt();
        invetoryPage.clickJacket();
        invetoryPage.clickShoppingCart();
        cartPage.clickCheckout();
        yourInformation.inputCredentials("Milos","Bukumirovic","11000");
        yourInformation.clickContinueBotton();
        String itemTotalText = checkoutOverviewPage.summarySubtotalLabelText();
        assert itemTotalText.contains("65.98");
    }

    @AfterMethod
    public void closeDriver() {
        driver.close();
    }
}
