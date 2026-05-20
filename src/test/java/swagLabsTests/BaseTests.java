package swagLabsTests;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import swagLabs.pages.CartPage;
import swagLabs.pages.LoginPage;
import swagLabs.pages.ProductPage;
import swagLabs.utils.ConfigReader;

import java.util.Arrays;

public class BaseTests {
    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;

    protected LoginPage loginPage;
    protected ProductPage productPage;
    protected CartPage cartPage;

    @BeforeClass
    public void setUp(){
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(Boolean.parseBoolean(ConfigReader.getProperty("headless"))).setArgs(Arrays.asList("--start-maximized")));
        context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
        page = context.newPage();

        loginPage = new LoginPage(page);
        productPage = new ProductPage(page);
        cartPage = new CartPage(page);
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
