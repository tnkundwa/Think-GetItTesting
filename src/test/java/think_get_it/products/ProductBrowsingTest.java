package think_get_it.products;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import think_get_it.BaseTests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProductBrowsingTest extends BaseTests {
    @BeforeClass
    public void beforeClass(){
        landingPage.navigate("baseUrl");
        landingPage.goToLoginPage();
        loginPage.login(loginPage.getEmail(), loginPage.getPassword());
        homePage.goToProductPage("Portable Bluetooth Speaker");
    }
    @Test
    public void testProductBrowsing(){
        assertTrue(page.url().endsWith("portable-bluetooth-speaker"));
        assertEquals(productPage.getProductName(), "Portable Bluetooth Speaker");
        productPage.increaseProductQuantity(4);
        assertEquals(productPage.getProductQuantity(), 4);
        productPage.decreaseProductQuantity(3);
        assertEquals(productPage.getProductQuantity(), 1);
        assertThat(productPage.getDescription()).isVisible();
        assertThat(productPage.getShippingInfo()).isVisible();
        assertThat(productPage.getReturnPolicy()).isVisible();
    }
}