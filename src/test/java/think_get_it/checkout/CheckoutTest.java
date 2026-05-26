package think_get_it.checkout;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import think_get_it.BaseTests;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.testng.Assert.assertEquals;

public class CheckoutTest extends BaseTests {
    @BeforeMethod
    public void beforeClass(){
        landingPage.navigate("baseUrl");
        landingPage.goToLoginPage();
        loginPage.login(loginPage.getEmail(), loginPage.getPassword());
        homePage.addProductToCart("Cargo Utility Shorts");
        cartPage.goToCheckoutPage();
    }

    @Test
    public void testCheckout(){
        assertEquals(checkoutPage.getTitle(), "Checkout");
        checkoutPage.addNewAddress();
        checkoutPage.addDetails("first", "last", "078888", "kk222", "Kayoyo", "muka", "Rwanda");
        checkoutPage.continueToPayment();
        checkoutPage.paymentMode("Cash");
        checkoutPage.reviewOrder();
        assertThat(checkoutPage.orderSummary()).isVisible();
        assertThat(checkoutPage.isPlaceOrder()).isVisible();
        checkoutPage.placeOrder();
    }

}
