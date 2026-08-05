package swagLabsTests.e2e;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import swagLabs.pages.CheckoutPage;
import swagLabsTests.checkout.CheckoutTest;
import swagLabsTests.BaseTests;

import java.util.List;

public class EndToEndFlowTest extends BaseTests {
    @Test
    public void testCompleteE2ECheckoutFlow() {
        // 1. Authentication
        loginPage.navigate("baseUrl");
        loginPage.loginValid("standard_user", "secret_sauce");
        assertEquals(productPage.getTitle(), "Products");

        // 2. Add multiple items to cart (using data-test attributes captured via codegen)
        List<String> itemsToAdd = List.of(
                "sauce-labs-backpack",
                "sauce-labs-bike-light",
                "sauce-labs-bolt-t-shirt",
                "sauce-labs-fleece-jacket"
        );

        productPage.addToCartProto(itemsToAdd);

        // 3. Navigate to Cart & Verify Count
        productPage.goToCart(); // Uses your actual method: shoppingCart.click()
        assertEquals(cartPage.getItemsInCart(), 4);

        // 4. Proceed to Checkout
        cartPage.clickCheckout();

        // 5. Fill Checkout Info
        CheckoutPage checkoutPage = new CheckoutPage(page);
        checkoutPage.fillCheckoutInformation("Toussaint", "Nkundwa", "0000");

        // 6. Complete Order
        checkoutPage.clickFinish();

        // 7. Assert Order Completion
        CheckoutTest completePage = new CheckoutTest(page);
        assertThat(completePage.getCompleteHeaderLocator()).isVisible();
        assertEquals(completePage.getCompleteHeader(), "Thank you for your order!");
        assertEquals(completePage.getCompleteText(), "Your order has been dispatched, and will arrive just as fast as the pony can get there!");
    }
}
