package think_get_it.products;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import think_get_it.BaseTests;



import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProductBrowsingTest extends BaseTests {
    @BeforeClass
    public void beforeClass(){
        landingPage.navigate("baseUrl");
        landingPage.goToLoginPage();
        loginPage.login(loginPage.getEmail(), loginPage.getPassword());
    }
    @Test
    public void testProductBrowsing(){
        homePage.goToProductPage("Cargo Utility Shorts");
        assertTrue(page.url().contains("cargo-utility-shorts"));
        assertEquals(productPage.getProductName(), "Cargo Utility Shorts");
        productPage.increaseProductQuantity(4);
        assertEquals(productPage.getProductQuantity(), 5);
        productPage.decreaseProductQuantity(3);
        assertEquals(productPage.getProductQuantity(), 2);
        assertThat(productPage.getDescription()).isVisible();
        assertThat(productPage.getShippingInfo()).isVisible();
        assertThat(productPage.getReturnPolicy()).isVisible();
        assertThat(productPage.getConfirmAlert()).isVisible();
        productPage.addToCart();
        assertEquals(productPage.getConfirmAlert().textContent(), "Added to cart");
    }

    @Test
    public void testShopPage(){
        homePage.goToShopPage();
        assertTrue(page.url().contains("products"));
        assertEquals(shopPage.getPageTitle(), "All Products");
        assertThat(shopPage.isAllProducts()).isVisible();
    }

    @Test
    public void testBrowseByCategory(){
        homePage.goToShopPage();
        shopPage.selectCategory("Bags & Luggage");
        assertTrue(shopPage.isProductsFilteredCategory().stream().allMatch(cat -> cat.equals("Bags & Luggage")));
    }

    @Test
    public void testBrowseByPrice(){
        double min = 1.0;
        double max = 5.0;
        homePage.goToShopPage();
        shopPage.selectPrice("$.price");
        assertTrue(shopPage.isProductsFilteredPrice().stream().allMatch(n -> n >= min && n <= max));
    }

    @Test
    public void testBrowseByPriceRange(){
        double minValue = 1.0;
        double maxValue = 5.0;
        homePage.goToShopPage();
        shopPage.minPriceRange(minValue, maxValue);
        assertTrue(shopPage.isProductsFilteredPrice().stream().allMatch(n -> n >= minValue && n <= maxValue));
    }
}