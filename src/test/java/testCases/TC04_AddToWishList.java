package testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LaptopNotbbokPage;
import pageObjects.LoginPage;
import pageObjects.ProductDetailPage;
import testBase.BaseClass;
import utilities.RetryAnalyzer;

public class TC04_AddToWishList extends BaseClass {

    private static final Logger logger = LogManager.getLogger(TC04_AddToWishList.class);

    @Test(groups = {"regression"}, retryAnalyzer = utilities.RetryAnalyzer.class)
    public void testAddToWishList() {

        logger.info("===== TC04_AddToWishList Test Started =====");

        try {
            // Login steps
            logger.debug("Navigating to Login page");
            HomePage hp = new HomePage(getDriver());
            hp.clickMyaccount();
            hp.clickLogin();

            logger.debug("Entering login credentials");
            LoginPage lp = new LoginPage(getDriver());
            lp.setEmail("s_dc7@yahoo.com");
            lp.setPwd("enter_password"); // do NOT log password
            lp.click_Login();

            logger.info("Login completed successfully");

            // Navigate to Laptop & Notebook section
            logger.debug("Navigating to Laptop & Notebook section");
            hp.clickLapTopNote();
            hp.clickShowAll();

            // Select product
            logger.debug("Validating Laptop & Notebook page");
            LaptopNotbbokPage lnp = new LaptopNotbbokPage(getDriver());
            boolean pageStatus = lnp.confirmLaptopNotebook().isDisplayed();
            Assert.assertTrue(pageStatus, "Laptop & Notebook page is not displayed");

            logger.debug("Selecting a product");
            lnp.seletProduct();

            // Add to wishlist
            logger.debug("Clicking Add to Wishlist icon");
            ProductDetailPage pd = new ProductDetailPage(getDriver());
            pd.iconAddToWish();

            logger.debug("Validating Wishlist success alert");
            boolean wishListStatus = pd.isWishListAlertDisplayed();
            Assert.assertTrue(wishListStatus, "Wishlist success alert not displayed");

            logger.info("Product successfully added to Wishlist");

        } catch (AssertionError ae) {
            logger.error("Assertion failed in TC04_AddToWishList", ae);
            Assert.fail(ae.getMessage());

        } catch (Exception e) {
            logger.error("Unexpected exception occurred in TC04_AddToWishList", e);
            Assert.fail("Test failed due to unexpected exception");

        } finally {
            logger.info("===== TC04_AddToWishList Test Finished =====");
        }
    }
}
