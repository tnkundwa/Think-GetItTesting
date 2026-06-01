package think_get_it.checkout;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import think_get_it.BaseTests;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CheckoutTest extends BaseTests {
    @BeforeMethod
    public void beforeMethod(){
        landingPage.navigate("baseUrl");
        landingPage.goToLoginPage();
        loginPage.login(loginPage.getEmail(), loginPage.getPassword());
        homePage.addProductToCart("Cargo Utility Shorts");
        cartPage.goToCheckoutPage();
    }

    @Test
<<<<<<< Updated upstream
    public void testCheckout(){
        checkoutPage.continueToPayment();
        checkoutPage.paymentMode("Cash");
        checkoutPage.reviewOrder();
        assertThat(checkoutPage.isPlaceOrder()).isVisible();
        checkoutPage.placeOrder();
        assertThat(checkoutPage.orderPlaced()).isVisible();
        assertThat(checkoutPage.orderPlaced()).containsText("Order placed successfully!");
        assertTrue(singleOrderPage.getTitle().contains("Order"));
        assertThat(singleOrderPage.getAllProducts()).not().hasCount(0);
        assertThat(singleOrderPage.getCancelOrder()).isVisible();
        assertThat(singleOrderPage.getSummary()).isVisible();
    }

    @Test
=======
>>>>>>> Stashed changes
    public void testCheckoutWithNewAddress(){
        assertEquals(checkoutPage.getTitle(), "Checkout");
        assertThat(checkoutPage.orderSummary()).isVisible();
        checkoutPage.addNewAddress();
        checkoutPage.addDetails("first", "last", "078888", "kk222", "Kayoyo", "muka", "Rwanda");
        checkoutPage.continueToPayment();
        checkoutPage.paymentMode("Cash");
        checkoutPage.reviewOrder();
        assertThat(checkoutPage.isPlaceOrder()).isVisible();
        checkoutPage.placeOrder();
        assertThat(checkoutPage.orderPlaced()).isVisible();
        assertThat(checkoutPage.orderPlaced()).containsText("Order placed successfully!");
        assertTrue(singleOrderPage.getTitle().contains("Order"));
        assertThat(singleOrderPage.getAllProducts()).not().hasCount(0);
        assertThat(singleOrderPage.getCancelOrder()).isVisible();
        assertThat(singleOrderPage.getSummary()).isVisible();
    }

<<<<<<< Updated upstream
=======
    @Test
    public void testCheckoutWithoutNewAddress(){
        assertEquals(checkoutPage.getTitle(), "Checkout");
        checkoutPage.chooseAddress(3);
        checkoutPage.continueToPayment();
        checkoutPage.paymentMode("Cash");
        checkoutPage.reviewOrder();
        assertThat(checkoutPage.orderSummary()).isVisible();
        assertThat(checkoutPage.isPlaceOrder()).isVisible();
        checkoutPage.placeOrder();
    }
>>>>>>> Stashed changes

}
