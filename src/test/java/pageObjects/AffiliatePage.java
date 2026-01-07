package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AffiliatePage extends BasePage{

	//Constructor
	public AffiliatePage(WebDriver driver) //created method
	{
		super(driver);
		
	}
	
	
	//Locators
	@FindBy(xpath="//h1[normalize-space()='Your Affiliate Information']")
	WebElement affiliatePageHeader;
	
	@FindBy(xpath="//input[@id='input-company'][@name='company']")
	WebElement companyNameInput;
	
	@FindBy(xpath="//input[@id='input-website']")
	WebElement enterWebSite;
	
	@FindBy(xpath="//input[@id='input-tax'][@name='tax']")
	WebElement enterTaxID;
	
	@FindBy(xpath="//input[@id='input-cheque'][@name='cheque']")
	WebElement enterChequePyee;
	
	@FindBy(xpath="//button[@class='btn btn-primary'][@type='submit']")
	WebElement continueBtn;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement successAlert;
	
	//Actions	
	public boolean clickOnAffiliate()
	{
		return affiliatePageHeader.isDisplayed();
		
	}
      
	public void fillAffiliateDetails(String company, String website, String tax, String chequeName)
            throws InterruptedException {
        companyNameInput.clear();
        companyNameInput.sendKeys(company);

        enterWebSite.clear();
        enterWebSite.sendKeys(website);
        
        enterTaxID.clear();
        enterTaxID.sendKeys(tax);
        
        scrollToView(enterChequePyee);
        Thread.sleep(300);
        
       enterChequePyee.clear();
       enterChequePyee.sendKeys(chequeName);
       
       scrollAndClick(continueBtn);
    }
	
	    public boolean isSuccessAlertDisplay()
	    {
	    	return successAlert.isDisplayed();
	    }
	
	private void scrollToView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
	
	private void scrollAndClick(WebElement element) throws InterruptedException {
        scrollToView(element);
        Thread.sleep(500);
        element.click();
    }
}
