package think_get_it.auth;

import net.datafaker.Faker;
import org.testng.annotations.BeforeMethod;
import think_get_it.BaseTests;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CreateAccountTest extends BaseTests {
    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String password = faker.internet().password(8, 16, true, true, true);

    @BeforeMethod
    public void beforeMethod(){
        landingPage.goToCreateAccountPage();
    }

    @Test
    public void testCreateAccountValidCredentials(){
        assertEquals(createAccountPage.getPageTitle(),  "Create account");
        createAccountPage.enterFirstName(firstName);
        createAccountPage.enterLastName(lastName);
        createAccountPage.enterEmail(email);
        createAccountPage.enterPassword(password);
        createAccountPage.clickCreateAccountBtn();
        assertThat(page).hasTitle("Think & Get It — Shop Smart");
        assertEquals(createAccountPage.getPageTitle(), "Create account");
    }


    @Test
    public void testCreateAccountInvalidEmail(){
        createAccountPage.enterFirstName(firstName);
        createAccountPage.enterLastName(lastName);
        createAccountPage.enterEmail("you");
        createAccountPage.enterPassword(password);
        createAccountPage.clickCreateAccountBtn();
        assertEquals(createAccountPage.getPageTitle(),  "Create account");
        assertTrue(loginPage.getEmailText().contains("Please include an '@' in the email address"));
    }

    @Test
    public void testCreateAccountInvalidPassword(){
        createAccountPage.enterFirstName(firstName);
        createAccountPage.enterLastName(lastName);
        createAccountPage.enterEmail(email);
        createAccountPage.enterPassword("");
        createAccountPage.clickCreateAccountBtn();
        assertEquals(createAccountPage.getPageTitle(),  "Create account");
        assertEquals(createAccountPage.getAlertText(),  "Password must be at least 8 characters");
    }
}
