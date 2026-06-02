package think_get_it.checkout;

import net.datafaker.Faker;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import think_get_it.BaseTests;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CheckoutTest extends BaseTests {
    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String number = faker.number().digits(10);
    String street = faker.address().streetAddress();
    String city = faker.address().city();
    String state = faker.address().state();
    String country = faker.address().country();

    @BeforeMethod
    public void beforeMethod(){
        landingPage.goToLoginPage();
        loginPage.login(loginPage.getEmail(), loginPage.getPassword());
        homePage.addProductToCart("Cargo Utility Shorts");
        cartPage.goToCheckoutPage();
    }

    @Test
    public void testCheckoutWithNewAddress(){
        assertEquals(checkoutPage.getTitle(), "Checkout");
        assertThat(checkoutPage.orderSummary()).isVisible();
        checkoutPage.addNewAddress();
        checkoutPage.addDetails(firstName, lastName, number, street, city, state, country);
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
}
