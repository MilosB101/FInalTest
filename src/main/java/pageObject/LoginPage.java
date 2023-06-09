package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Base{

    @FindBy(id = "user-name")
    WebElement userName;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "login-button")
    WebElement loginButton;

    @FindBy(css = ".error-message-container h3")
    WebElement errorContainer;



    public LoginPage(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void Login(String user, String pass) {
        userName.sendKeys(user);
        password.sendKeys(pass);
        loginButton.click();
    }

    public String getTextFromErrorContainer(){
        return errorContainer.getText();
    }
}