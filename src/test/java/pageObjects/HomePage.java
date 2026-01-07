package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage
{

	public HomePage(WebDriver driver)   //created method
	{
	     super(driver);
	}

	// Locators

	@FindBy(xpath = "//i[@class='fa-solid fa-user']")
	WebElement link_MyAccount;

	@FindBy(xpath = "//a[normalize-space()='Login']")
	WebElement link_Login;
	
	@FindBy(xpath = "//a[normalize-space()='Laptops & Notebooks']")
	WebElement laptopNotebook;

	@FindBy(xpath = "//a[normalize-space()='Show All Laptops & Notebooks']")
	WebElement showAll;
	
	@FindBy(xpath="//a[normalize-space()='Affiliate']")
	WebElement affiliate_link;

	// Action method
	public void clickMyaccount()

	{
		link_MyAccount.click();
	}

	public void clickLogin()

	{
		link_Login.click();
	}
	
	public void clickLapTopNote() throws InterruptedException
	{
		
		scrollToView(laptopNotebook);
		Thread.sleep(500);
		laptopNotebook.click();
	}
	 
	public void clickShowAll() throws InterruptedException
	{
		scrollToView(showAll);
		Thread.sleep(500);
		showAll.click();
	}
		
		public void clickOnAffiliate() throws InterruptedException
		{
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", affiliate_link);
			Thread.sleep(1000);
			affiliate_link.click();
		}
		
	
	
	private void scrollToView(WebElement element)
	{
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
