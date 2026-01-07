package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderConfirmtionPage extends BasePage
{
    //constructor ....method
	public OrderConfirmtionPage(WebDriver driver)
	{
		super(driver);
		
	}
	
	//locater
	 @FindBy(xpath="//h1[normalize-space()='Your order has been placed!']")
	   WebElement orderConfirmText;

	 
	 //Action
	 public boolean isOrderConfirmation()
		{
			return orderConfirmText.isDisplayed();
			
		}
	   
}
