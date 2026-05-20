package think_get_it.auth;


import static  com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import think_get_it.BaseTests;

public class AuthenticationTest extends BaseTests {
    @Test
    public void testLoginValidCredentials(){
        landingPage.navigate("baseUrl");
        landingPage.goToLoginPage();
        loginPage.login(loginPage.getEmail(), loginPage.getPassword());
        assertThat(page).hasTitle("Think & Get It — Shop Smart");
        assertEquals(homePage.getHomePageTitle(), "Dress forYour Story");
        assertThat(homePage.shopLinkVisible()).isVisible();
        assertThat(homePage.homeLinkVisible()).isVisible();
        homePage.hoverProfileIcon();
        assertEquals(homePage.getLoginEmail(), "admin@thinkandgetit.com");
        assertThat(homePage.isSignedInAs()).isVisible();
        assertThat(homePage.profileLinkVisible()).isVisible();
        assertThat(homePage.signOutLinkVisible()).isVisible();
    }

    @Test
    public void testLoginInvalidEmail(){
        landingPage.navigate("baseUrl");
        landingPage.goToLoginPage();
        loginPage.login("something", "Admin@123456");
        assertTrue(loginPage.getEmailText().contains("Please include an '@' in the email address"));
    }

    @Test
    public void testLoginEmptyEmail(){
        landingPage.navigate("baseUrl");
        landingPage.goToLoginPage();
        loginPage.login("", "Admin@123456");
        assertEquals(loginPage.getEmailText(), ("Please fill out this field."));
    }

    @Test
    public void testLoginEmptyPassword(){
        landingPage.navigate("baseUrl");
        landingPage.goToLoginPage();
        loginPage.login("admin@thinkandgetit.com", "");
        assertEquals(loginPage.getPasswordText(), ("Please fill out this field."));
    }
}
