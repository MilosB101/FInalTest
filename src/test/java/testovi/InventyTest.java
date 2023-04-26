package testovi;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObject.InvetoryPage;
import pageObject.LoginPage;

public class InventyTest extends BaseTest{
    ChromeDriver driver;

    LoginPage loginPage;

    InvetoryPage invetoryPage;
    @BeforeMethod
    public void SetUp()
    {
        driver = openWebDriver();
        loginPage = new LoginPage(driver);
        invetoryPage = new InvetoryPage(driver);

    }
    @Test
    public void addTwoItemsToCart(){
        loginPage.Login("standard_user","secret_sauce");
        invetoryPage.sortItemByText("Price (low to high)");
        invetoryPage.clickSauceLabsOnesie();
        invetoryPage.clickBikeLight();
        invetoryPage.clicktShirt();
        Assert.assertEquals(invetoryPage.getTextFromShoppingCartBadge(), "3");
    }



    @AfterMethod
    public void closeDriver() {
        driver.close();
    }


}
