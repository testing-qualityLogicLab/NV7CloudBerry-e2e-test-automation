package pageObjects;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailPage extends BasePage

{
     //constructor - created method
	public ProductDetailPage(WebDriver driver) 
	{
		super(driver);
		
	}
	
	
	//Locators
	@FindBy(xpath="//input[@id='input-option-225']")
	WebElement dateInPut;
	
	@FindBy(xpath="//button[@id='button-cart']")
	WebElement btnAddTocart;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement alert_success;
	
	@FindBy(xpath = "//div//button//i[@class='fa-solid fa-heart']")
    WebElement wishlistIcon;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement wishList_Alert;
	
	@FindBy(xpath="//span[normalize-space()='Checkout']")
	WebElement btnChekOut;
	
	
	//Actions
	public void deliveryDate() throws InterruptedException {
		LocalDate currentDate = LocalDate.now();
		// System.out.println(currentDate);

		LocalDate deliveryDate = currentDate.plusDays(5);
		// System.out.println(deliveryDate);

		// convert to mm/dd/yy
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		String formattedDeliveryDate = deliveryDate.format(formatter);
		// System.out.println(formattedDeliveryDate);
	     
		scrollToView(dateInPut);
		Thread.sleep(1000);
	    dateInPut.clear();
	    Thread.sleep(1000);
	    dateInPut.sendKeys(formattedDeliveryDate);
	}
	
	public void btnAddToCart() throws InterruptedException
    {
	   scrollToView(btnAddTocart);
	   Thread.sleep(1500);
	   btnAddTocart.click();
    	
    }
		
	public boolean isAddToCartAlertDisplayed()
	{
		return alert_success.getText().contains("Success");
	}
		
	public void iconAddToWish() throws InterruptedException
	{
		scrollToView(wishlistIcon);
		Thread.sleep(1500);
		wishlistIcon.click();
		
	}
	
	  public boolean isWishListAlertDisplayed()
	{
		return wishList_Alert.getText().contains("Success");
		
		
	}
	  
	  public void clickBtnCheckOut() throws InterruptedException
	  {
		  scrollToView(btnChekOut);
		  Thread.sleep(500);
		  btnChekOut.click();
	  }
		public void scrollToView(WebElement element) {
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	      //a[normalize-space()='Affiliate']
	    }
		
		
		
	}
