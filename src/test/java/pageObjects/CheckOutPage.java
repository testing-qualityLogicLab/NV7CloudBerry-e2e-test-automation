package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage extends BasePage
{
	//Constructor.... created method
	public CheckOutPage(WebDriver driver)
	{
		super(driver);
		
	}
	
	//locator
	@FindBy(xpath="//strong[normalize-space()='login page']")
	WebElement loginBtn_ChkOtPage;
	
	@FindBy(id = "input-shipping-address")
    WebElement shippingAddressDropdown;

    @FindBy(id = "button-shipping-methods")
    WebElement shippingMethodsButton;

    @FindBy(id = "button-shipping-method")
    WebElement flatShippingButton;

    @FindBy(id = "button-payment-methods")
    WebElement paymentMethodsButton;

    @FindBy(id = "button-payment-method")
    WebElement codButton;
    
    @FindBy(xpath = "//div[@class='text-end']//button[contains(text(),'Confirm')]")
    WebElement confirmButton;
    
    		
	//Action
	
	public void clickLoginbtn()
	{
	 loginBtn_ChkOtPage.click();
	}
	
	public void completeCheckout() throws InterruptedException {
        new Select(shippingAddressDropdown).selectByIndex(1);
        Thread.sleep(500);
        shippingMethodsButton.click();
        Thread.sleep(500);
        flatShippingButton.click();
        paymentMethodsButton.click();
        codButton.click();
        scroll(confirmButton);
        Thread.sleep(500);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", confirmButton);
    }
	

    private void scroll(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
       // ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
}
