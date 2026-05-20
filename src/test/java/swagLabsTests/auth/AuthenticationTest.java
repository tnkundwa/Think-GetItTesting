package swagLabsTests.auth;


import static  com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import swagLabsTests.BaseTests;

public class AuthenticationTest extends BaseTests {
    @Test
    public void testLoginValidCredentials(){
        loginPage.navigate("baseUrl");
        loginPage.login("standard_user", "secret_sauce");
        assertThat(page).hasTitle("Swag Labs");
        assertEquals(productPage.getTitle(), "Products");
        assertThat(productPage.isCartDisplayed()).isVisible();
        assertThat(productPage.isSortDisplayed()).isVisible();
        assertThat(productPage.isSortDisplayed()).not().hasCount(0);
    }
}
