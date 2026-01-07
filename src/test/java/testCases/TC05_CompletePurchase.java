package testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CheckOutPage;
import pageObjects.HomePage;
import pageObjects.LaptopNotbbokPage;
import pageObjects.LoginPage;
import pageObjects.OrderConfirmtionPage;
import pageObjects.ProductDetailPage;
import testBase.BaseClass;
import utilities.RetryAnalyzer;

public class TC05_CompletePurchase extends BaseClass {

    private static final Logger logger = LogManager.getLogger(TC05_CompletePurchase.class);

    @Test(groups = {"sanity", "regression"}, retryAnalyzer = utilities.RetryAnalyzer.class)
    public void testCompletePurchase() {

        logger.info("===== TC05_CompletePurchase Test Started =====");

        try {
            // Navigate to Laptop & Notebook
            logger.debug("Navigating to Laptop & Notebook section");
            HomePage hp = new HomePage(getDriver());
            hp.clickLapTopNote();
            hp.clickShowAll();

            // Select product
            logger.debug("Validating Laptop & Notebook page");
            LaptopNotbbokPage lnp = new LaptopNotbbokPage(getDriver());
            boolean pageStatus = lnp.confirmLaptopNotebook().isDisplayed();
            Assert.assertTrue(pageStatus, "Laptop & Notebook page is not displayed");

            logger.debug("Selecting product");
            lnp.seletProduct();

            // Product details & add to cart
            ProductDetailPage pd = new ProductDetailPage(getDriver());
            logger.debug("Setting delivery date");
            pd.deliveryDate();

            logger.debug("Adding product to cart");
            pd.btnAddToCart();

            logger.debug("Validating Add to Cart alert");
            Assert.assertTrue(pd.isAddToCartAlertDisplayed(),
                    "Add to Cart success alert not displayed");

            logger.debug("Proceeding to Checkout");
            pd.clickBtnCheckOut();

            // Checkout & login
            CheckOutPage cot = new CheckOutPage(getDriver());
            logger.debug("Clicking Checkout login button");
            cot.clickLoginbtn();

            logger.debug("Logging in during checkout");
            LoginPage lp = new LoginPage(getDriver());
            lp.setEmail("s_dc7@yahoo.com");
            lp.setPwd("enter_password"); // password not logged
            lp.click_Login();

            // Complete checkout
            logger.debug("Completing checkout steps");
            cot.completeCheckout();

            // Order confirmation validation
            OrderConfirmtionPage ocp = new OrderConfirmtionPage(getDriver());
            logger.debug("Validating order confirmation");
            Assert.assertTrue(ocp.isOrderConfirmation(),
                    "Order confirmation message not displayed");

            logger.info("Order placed successfully");

        } catch (AssertionError ae) {
            logger.error("Assertion failed in TC05_CompletePurchase", ae);
            Assert.fail(ae.getMessage());

        } catch (Exception e) {
            logger.error("Unexpected exception occurred in TC05_CompletePurchase", e);
            Assert.fail("Test failed due to unexpected exception");

        } finally {
            logger.info("===== TC05_CompletePurchase Test Finished =====");
        }
    }
}
