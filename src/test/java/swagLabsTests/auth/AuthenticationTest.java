package swagLabsTests.auth;


import static  com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import swagLabsTests.BaseTests;

public class AuthenticationTest extends BaseTests {
    @Test
    public void testLoginValidCredentials(){
        loginPage.navigate("baseUrl");
        loginPage.loginValid("standard_user", "secret_sauce");
        loginPage.clickLoginBtn();
        assertThat(page).hasTitle("Swag Labs");
        assertEquals(productPage.getTitle(), "Products");
        assertThat(productPage.isCartDisplayed()).isVisible();
        assertThat(productPage.isSortDisplayed()).isVisible();
        assertThat(productPage.isSortDisplayed()).not().hasCount(0);
    }
    public void testLoginInValidCredentials(){
        loginPage.navigate("baseUrl");
        loginPage.loginInvalid("user", "secret");
        loginPage.clickLoginBtn();
        assertThat(loginPage.errorElement()).isVisible();
        assertTrue(loginPage.errorMsg().contains("Username and password do not match any user"));
    }
}
