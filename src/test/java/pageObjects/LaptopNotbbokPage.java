package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LaptopNotbbokPage extends BasePage
{
	
	//Constructor
	
	public LaptopNotbbokPage(WebDriver driver)   //created method
	{
	     super(driver);
	}
	
	// Locators
	@FindBy(xpath="//div//h1[normalize-space()='Laptops & Notebooks']")
	WebElement confirmText_LaptopNote;

	@FindBy(xpath="//div[@class='description']//a[contains(text(),'HP LP3065')]")
	WebElement productHPLP3065;

	//Action
	public WebElement confirmLaptopNotebook()
	{
		return confirmText_LaptopNote;
	}
	
	public void seletProduct() throws InterruptedException
	{
		Thread.sleep(1000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", productHPLP3065);
	}
	
}
