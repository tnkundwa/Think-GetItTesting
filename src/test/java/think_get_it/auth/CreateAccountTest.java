package think_get_it.auth;

import org.testng.annotations.BeforeMethod;
import think_get_it.BaseTests;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CreateAccountTest extends BaseTests {
    @BeforeMethod
    public void beforeMethod(){
        landingPage.navigate("baseUrl");
        landingPage.goToCreateAccountPage();
    }
    @Test
    public void testCreateAccountValidCredentials(){
        assertEquals(createAccountPage.getPageTitle(),  "Create account");
        createAccountPage.enterFirstName("John");
        createAccountPage.enterLastName("Doe");
        createAccountPage.enterEmail("you@example.com");
        createAccountPage.enterPassword("min8characters");
        createAccountPage.clickCreateAccountBtn();
        assertThat(page).hasTitle("Think & Get It — Shop Smart");
        assertEquals(createAccountPage.getPageTitle(), "Create account");
    }


    @Test
    public void testCreateAccountInvalidEmail(){
        createAccountPage.enterFirstName("John");
        createAccountPage.enterLastName("Doe");
        createAccountPage.enterEmail("you");
        createAccountPage.enterPassword("min8characters");
        createAccountPage.clickCreateAccountBtn();
        assertEquals(createAccountPage.getPageTitle(),  "Create account");
        assertTrue(loginPage.getEmailText().contains("Please include an '@' in the email address"));
    }

    @Test
    public void testCreateAccountInvalidPassword(){
        createAccountPage.enterFirstName("John");
        createAccountPage.enterLastName("Doe");
        createAccountPage.enterEmail("you@example.com");
        createAccountPage.enterPassword("yy");
        createAccountPage.clickCreateAccountBtn();
        assertEquals(createAccountPage.getPageTitle(),  "Create account");
        assertEquals(createAccountPage.getAlertText(),  "Password must be at least 8 characters");
    }
}
