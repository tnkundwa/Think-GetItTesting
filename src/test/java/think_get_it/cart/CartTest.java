package think_get_it.cart;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import think_get_it.BaseTests;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.testng.Assert.assertEquals;

public class CartTest extends BaseTests {
    @BeforeMethod
    public void beforeClass(){
        landingPage.navigate("baseUrl");
        landingPage.goToLoginPage();
        loginPage.login(loginPage.getEmail(), loginPage.getPassword());
        homePage.addProductToCart("Cargo Utility Shorts");
    }
    @Test
    public void testCart() {
        assertThat(cartPage.isCheckout()).isVisible();
        assertThat(cartPage.isViewCart()).isVisible();
        assertThat(cartPage.isTotalPrice()).isVisible();
        assertEquals(cartPage.getCartCount(), cartPage.getProductCount(), "The total price of the cart is incorrect");
        assertEquals(cartPage.getProductPrice(), cartPage.getTotalPrice(), "The total product price of the cart is incorrect");
    }
}
