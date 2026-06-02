package think_get_it;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
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
    protected ShopPage shopPage;
    protected CheckoutPage checkoutPage;
    protected OrdersPage  ordersPage;
    protected SingleOrderPage singleOrderPage;

    @BeforeClass
    public void setUpClass(){
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(Boolean.parseBoolean(ConfigReader.getProperty("headless"))).setArgs(Arrays.asList("--start-maximized")));
    }

    @BeforeMethod
    public void setUpMethod(){
        context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
        page = context.newPage();
        homePage = new  HomePage(page);
        landingPage = new LandingPage(page);
        loginPage = new LoginPage(page);
        productPage = new ProductPage(page);
        cartPage = new CartPage(page);
        createAccountPage = new CreateAccountPage(page);
        shopPage = new ShopPage(page);
        checkoutPage = new CheckoutPage(page);
        ordersPage = new OrdersPage(page);
        singleOrderPage = new SingleOrderPage(page);
        landingPage.navigate("baseUrl");
    }

    @AfterMethod
    public void tearDownMethod(){
        if (page != null) page.close();
        if (context != null) context.close();
    }

    @AfterClass
    public void tearDownClass(){
        if(browser != null){
            browser.close();
        }
        if(playwright  != null){
            playwright.close();
        }
    }
}
