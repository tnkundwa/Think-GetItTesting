package think_get_it.products;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import think_get_it.BaseTests;



import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.testng.Assert.*;

public class ProductBrowsingTest extends BaseTests {
    @BeforeClass
    public void beforeClass(){
        landingPage.goToLoginPage();
        loginPage.login(loginPage.getEmail(), loginPage.getPassword());
        page.waitForURL("**/home");
    }
    @Test
    public void testProductBrowsing(){
        homePage.goToProductPage("Cargo Utility Shorts");
        assertTrue(page.url().contains("cargo-utility-shorts"));
        assertEquals(productPage.getProductName(), "Cargo Utility Shorts");
        productPage.selectSize("XL");
        productPage.selectColor("Black");
        productPage.increaseProductQuantity(4);
        assertEquals(productPage.getProductQuantity(), 5);
        productPage.decreaseProductQuantity(3);
        assertEquals(productPage.getProductQuantity(), 2);
        assertThat(productPage.getDescription()).isVisible();
        assertThat(productPage.getShippingInfo()).isVisible();
        assertThat(productPage.getReturnPolicy()).isVisible();
        productPage.addToCart();
        assertThat(productPage.getConfirmAlert()).isVisible();
        assertEquals(productPage.getConfirmAlert().textContent(), "Added to cart!");
    }

    @Test
    public void testShopPage(){
        homePage.goToShopPage();
        assertTrue(page.url().contains("products"));
        assertEquals(shopPage.getPageTitle(), "All Products");
        assertThat(shopPage.isAllProducts()).not().hasCount(0);
    }

    @Test
    public void testBrowseByCategory(){
        homePage.goToShopPage();
        shopPage.selectCategory("Bags & Luggage");
        assertTrue(shopPage.isProductsFilteredCategory().stream().allMatch(cat -> cat.equals("Bags & Luggage")));
    }

    @Test
    public void testBrowseByPrice(){
        homePage.goToShopPage();
        String[] prices = shopPage.selectPrice(1);
        assertTrue(shopPage.isProductsFilteredPrice().stream().allMatch(n -> n >= Double.parseDouble(prices[0]) && n <= Double.parseDouble(prices[1])));
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