package testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;
import utilities.RetryAnalyzer;

public class TC02_Login extends BaseClass {

    private static final Logger logger = LogManager.getLogger(TC02_Login.class);

    @Test(
        groups = {"sanity", "regression", "datadriven"},
        dataProvider = "LoginData",
        dataProviderClass = DataProviders.class,
        retryAnalyzer = utilities.RetryAnalyzer.class
    )
    void testLogin(String email, String pwd) {

        logger.info("===== TC02_Login Test Started =====");
        logger.debug("Test data used → Email: {}", email);

        try {
            // Home Page actions
            logger.debug("Navigating to Login page");
            HomePage hp = new HomePage(getDriver());
            hp.clickMyaccount();
            hp.clickLogin();

            // Login Page actions
            logger.debug("Entering login credentials");
            LoginPage lp = new LoginPage(getDriver());
            lp.setEmail(email);
            lp.setPwd(pwd);
            lp.click_Login();

            // Account Page validation
            logger.debug("Validating My Account confirmation");
            AccountPage ap = new AccountPage(getDriver());
            boolean status = ap.getMyAccountConfirmation().isDisplayed();

            if (status) {
                logger.info("Login successful for user: {}", email);

                // Logout steps
                logger.debug("Performing logout steps");
                ap.clickMyAccountDropDown();
                ap.clickLogout();

                Assert.assertTrue(status, "Login verification passed");

            } else {
                logger.error("Login failed for user: {}", email);
                Assert.fail("Login verification failed");
            }

        } catch (AssertionError ae) {
            logger.error("Assertion failure in TC02_Login for user: {}", email, ae);
            Assert.fail(ae.getMessage());

        } catch (Exception e) {
            logger.error("Exception occurred during TC02_Login execution", e);
            Assert.fail("Test failed due to unexpected exception");

        } finally {
            logger.info("===== TC02_Login Test Finished =====");
        }
    }
}
