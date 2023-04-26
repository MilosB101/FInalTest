package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class InvetoryPage extends Base{

    @FindBy (id = "add-to-cart-sauce-labs-onesie")
    WebElement sauceLabsOnesie;

    @FindBy (name = "add-to-cart-sauce-labs-bike-light" )
    WebElement bikeLight;

    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    WebElement tShirt;

    @FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
    WebElement jacket;

    @FindBy(css = ".shopping_cart_badge")
    WebElement shoppingCartBadge;

    @FindBy(className = "product_sort_container")
    WebElement sortDropDown;

    @FindBy(css = ".shopping_cart_link")
    WebElement shoppingCart;

    public InvetoryPage(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickSauceLabsOnesie(){
        sauceLabsOnesie.click();
    }
    public void clickBikeLight(){
        bikeLight.click();
    }
    public void clicktShirt(){
        tShirt.click();
    }

    public void clickJacket() {
        jacket.click();
    }

    public void clickShoppingCart() {
        shoppingCart.click();
    }
    public String getTextFromShoppingCartBadge(){
        return shoppingCartBadge.getText();
    }
    public void sortItemByText (String text){
        Select drop = new Select(sortDropDown);
        drop.selectByVisibleText(text);
    }

}