package swagLabsTests.cart;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import swagLabsTests.BaseTests;

import java.util.Arrays;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.testng.Assert.assertEquals;

public class CartTest extends BaseTests {
    @BeforeClass
    public void beforeClass(){
        loginPage.navigate("baseUrl");
        loginPage.login("standard_user", "secret_sauce");
    }
    @Test
    public void addtoCart(){
        productPage.addToCart("Sauce Labs Backpack");
//        productPage.addToCartProto(Arrays.asList("Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt", "Sauce Labs Fleece Jacket"));
        assertEquals(productPage.getCartCount(), "1");
    }
    @Test
    public void goToCart(){
        productPage.goToCart();
        assertEquals(cartPage.getTitle(),"Your Cart");
        assertEquals(cartPage.continueShoppingText(),"Continue Shopping");
        assertEquals(cartPage.goToCheckout(),"Checkout");
        assertEquals(cartPage.getItemsInCart(), 1);
    }
}
