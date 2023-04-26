package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOverviewPage extends Base{

    @FindBy(name = "finish")
    WebElement finishButton;

    @FindBy(css = ".summary_subtotal_label")
    WebElement summarySubtotalLabel;

    public CheckoutOverviewPage(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickFinish(){
        finishButton.click();
    }

    public String summarySubtotalLabelText() {
        return summarySubtotalLabel.getText();
    }

}
