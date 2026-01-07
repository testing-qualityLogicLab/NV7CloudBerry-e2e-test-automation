package testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;
import utilities.RetryAnalyzer;

public class TC01_LaunchApplication extends BaseClass {

    private static final Logger logger = LogManager.getLogger(TC01_LaunchApplication.class);

    @Test(
    		groups = {"sanity", "regression"}, 
    		retryAnalyzer = utilities.RetryAnalyzer.class)
    void testLaunchApplication() {

        logger.info("===== TC01_LaunchApplication Test Started =====");

        try {
            logger.debug("Creating HomePage object");
            HomePage hp = new HomePage(getDriver());

            logger.debug("Fetching page title");
            String actualTitle = getDriver().getTitle();
            logger.info("Actual page title: {}", actualTitle);

            logger.debug("Validating page title");
            Assert.assertEquals(actualTitle, "Your store of fun");

            logger.info("Page title validation PASSED");

        } catch (AssertionError ae) {
            logger.error("Assertion failed: Page title did not match expected value", ae);
            Assert.fail("Test failed due to assertion error");

        } catch (Exception e) {
            logger.error("Unexpected exception occurred during test execution", e);
            Assert.fail("Test failed due to unexpected exception");

        } finally {
            logger.info("===== TC01_LaunchApplication Test Finished =====");
        }
    }
}
