package think_get_it.cart;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import think_get_it.BaseTests;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.testng.Assert.assertEquals;

public class CartTest extends BaseTests {
    @BeforeClass
    public void beforeClass(){
        loginPage.navigate("baseUrl");
        loginPage.login("standard_user", "secret_sauce");
    }
}
