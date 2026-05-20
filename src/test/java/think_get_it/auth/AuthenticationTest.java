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
}
