package think_get_it.auth;

import think_get_it.BaseTests;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.testng.Assert.assertEquals;

public class CreateAccountTest extends BaseTests {
    @Test
    public void testCreateAccountValidCredentials(){
        landingPage.navigate("baseUrl");
        landingPage.goToCreateAccountPage();
        assertEquals(createAccountPage.getPageTitle(),  "Create account");
        createAccountPage.enterFirstName("John");
        createAccountPage.enterLastName("Doe");
        createAccountPage.enterEmail("you@example.com");
        createAccountPage.enterPassword("min8characters");
        createAccountPage.clickCreateAccountBtn();
        assertThat(page).hasTitle("Think & Get It — Shop Smart");
        assertEquals(homePage.getHomePageTitle(), "Dress forYour Story");
    }
}
