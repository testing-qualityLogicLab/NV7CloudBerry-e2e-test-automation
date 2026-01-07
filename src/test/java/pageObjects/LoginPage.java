package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage
{
	
	//Constructor
	public LoginPage(WebDriver driver)
	{
		super(driver);
		
	}
	
	//Locators
	
	@FindBy(xpath="//input[@type='email'][@id='input-email']")
	WebElement text_Email;
	
	
	@FindBy(xpath="//input[@type='password'][@id='input-password']")
	WebElement text_Password;
	
	@FindBy(xpath="//button[@type='submit'][@class=\"btn btn-primary\"]")
	WebElement btn_Login;
	
	
	//Action
	public void setEmail(String email)
	{
		text_Email.sendKeys(email);
	}
	
	
	public void setPwd(String pwd)
	{
		text_Password.sendKeys(pwd);
	}
	
	public void click_Login()
	{
		btn_Login.click();
	}

}
