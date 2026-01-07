package testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LaptopNotbbokPage;
import pageObjects.ProductDetailPage;
import testBase.BaseClass;
import utilities.RetryAnalyzer;

public class TC03_AddToCart extends BaseClass {

    private static final Logger logger = LogManager.getLogger(TC03_AddToCart.class);

    @Test(groups = {"sanity", "regression"}, retryAnalyzer = utilities.RetryAnalyzer.class)
    void testAddToCart() {

        logger.info("===== TC03_AddToCart Test Started =====");

        try {
            // Home Page steps
            logger.debug("Navigating to Laptop & Notebook section");
            HomePage hp = new HomePage(getDriver());
            hp.clickLapTopNote();
            hp.clickShowAll();

            // Laptop & Notebook page validation
            logger.debug("Validating Laptop & Notebook page is displayed");
            LaptopNotbbokPage lnp = new LaptopNotbbokPage(getDriver());
            boolean status = lnp.confirmLaptopNotebook().isDisplayed();
            Assert.assertTrue(status, "Laptop & Notebook page is not displayed");

            logger.info("Laptop & Notebook page validation PASSED");

            // Select product
            logger.debug("Selecting a product from the list");
            lnp.seletProduct();

            // Product Detail page actions
            logger.debug("Setting delivery date");
            ProductDetailPage pd = new ProductDetailPage(getDriver());
            pd.deliveryDate();

            logger.debug("Clicking Add to Cart button");
            pd.btnAddToCart();

            logger.debug("Validating Add to Cart success alert");
            boolean alertStatus = pd.isAddToCartAlertDisplayed();
            Thread.sleep(1000);
            Assert.assertTrue(alertStatus, "Add to Cart success alert not displayed");

            logger.info("Product successfully added to cart");

        } catch (AssertionError ae) {
            logger.error("Assertion failed in TC03_AddToCart", ae);
            Assert.fail(ae.getMessage());

        } catch (Exception e) {
            logger.error("Unexpected exception occurred in TC03_AddToCart", e);
            Assert.fail("Test failed due to unexpected exception");

        } finally {
            logger.info("===== TC03_AddToCart Test Finished =====");
        }
    }
}
