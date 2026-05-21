package think_get_it;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import think_get_it.pages.*;
import think_get_it.utils.ConfigReader;

import java.util.Arrays;

public class BaseTests {
    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;

    protected LandingPage landingPage;
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected ProductPage productPage;
    protected CreateAccountPage createAccountPage;
    protected CartPage cartPage;

    @BeforeClass
    public void setUp(){
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(Boolean.parseBoolean(ConfigReader.getProperty("headless"))).setArgs(Arrays.asList("--start-maximized")));
        context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
        page = context.newPage();

        homePage = new  HomePage(page);
        landingPage = new LandingPage(page);
        loginPage = new LoginPage(page);
        productPage = new ProductPage(page);
        cartPage = new CartPage(page);
        createAccountPage = new CreateAccountPage(page);
    }

    @AfterClass
    public void tearDown(){
        if(browser != null){
            browser.close();
        }
        if(playwright  != null){
            playwright.close();
        }
    }

}
