package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage 
{
	//constructor
		WebDriver driver;
		//this is the constructor for the class
		//It takes a webDriver object as an argument, which is used to interact with the browser
		public BasePage(WebDriver driver)   //created method
		{
			this.driver = driver;
			//The passed driver is assigned to the instance variable driver. This allows the class and its subclasses to use it for browser interaction. 
			
			PageFactory.initElements(driver, this);
			//The above line initializes the web elements defined in the class using Selenium pageFactory.
			//PageFactory.initElements() tells Selenium to scan the current class (this) for any @FindBy annotations
			//and connect them to actual elements on the page using the provided driver.
			
			// TODO Auto-generated constructor stub
		}

}
