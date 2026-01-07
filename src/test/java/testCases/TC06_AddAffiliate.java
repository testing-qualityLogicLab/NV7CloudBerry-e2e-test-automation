package testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AffiliatePage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.RetryAnalyzer;

public class TC06_AddAffiliate extends BaseClass {

    private static final Logger logger = LogManager.getLogger(TC06_AddAffiliate.class);

    @Test(groups = {"regression"}, retryAnalyzer = utilities.RetryAnalyzer.class)
    void testAffiliateFormSubmit() {

        logger.info("===== TC06_AddAffiliate Test Started =====");

        try {
            // Navigate to Affiliate page
            logger.debug("Clicking on Affiliate link from Home page");
            HomePage hp = new HomePage(getDriver());
            hp.clickOnAffiliate();

            // Login step
            logger.debug("Logging in to Affiliate account");
            LoginPage lp = new LoginPage(getDriver());
            lp.setEmail("s_dc7@yahoo.com");
            lp.setPwd("enter_password"); // do not log password
            lp.click_Login();

            // Affiliate page validation
            logger.debug("Validating Affiliate page navigation");
            AffiliatePage ap = new AffiliatePage(getDriver());
            boolean affiliatePageStatus = ap.clickOnAffiliate();
            Assert.assertTrue(affiliatePageStatus,
                    "Affiliate page header not displayed");

            logger.info("Affiliate page loaded successfully");

            // Fill Affiliate details
            logger.debug("Filling Affiliate details form");
            ap.fillAffiliateDetails(
                    "CloudBerry",
                    "cloudberry.services",
                    "643663",
                    "Santoshsingh"
            );

            // Success alert validation
            logger.debug("Validating Affiliate success alert");
            boolean successStatus = ap.isSuccessAlertDisplay();
            Assert.assertTrue(successStatus,
                    "Affiliate success alert not displayed");

            logger.info("Affiliate form submitted successfully");

        } catch (AssertionError ae) {
            logger.error("Assertion failed in TC06_AddAffiliate", ae);
            Assert.fail(ae.getMessage());

        } catch (Exception e) {
            logger.error("Unexpected exception occurred in TC06_AddAffiliate", e);
            Assert.fail("Test failed due to unexpected exception");

        } finally {
            logger.info("===== TC06_AddAffiliate Test Finished =====");
        }
    }
}
