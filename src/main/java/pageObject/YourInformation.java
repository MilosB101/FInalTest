package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourInformation extends Base{

    @FindBy(id = "first-name")
    WebElement firstName;

    @FindBy(id = "last-name")
    WebElement lastN;

    @FindBy(id = "postal-code")
    WebElement postalCode;

    @FindBy(id = "continue")
    WebElement continueButton;


    public YourInformation (ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void inputCredentials (String name , String lastName , String zipCode){
        firstName.sendKeys(name);
        lastN.sendKeys(lastName);
        postalCode.sendKeys(zipCode);
    }
    public void clickContinueBotton(){
        continueButton.click();
    }
}
