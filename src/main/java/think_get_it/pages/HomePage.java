package think_get_it.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.WaitForSelectorState;

import java.util.List;

public class HomePage extends BasePage {
    private final Locator homePageTitle;
    private final Locator profileIcon;
    private final Locator homeLink;
    private final Locator shopLink;
    private final Locator signedInAs;
    private final Locator signInEmail;
    private final Locator profileLink;
    private final Locator signOutLink;
    private final Locator allProducts;
    private final Locator cartIcon;
    private final Locator cartCount;
    private final Locator confirmAlert;

    public HomePage(Page page) {
        super(page);
        this.homePageTitle = page.locator(".max-w-2xl h1");
        this.homeLink = page.locator("//nav//a[text()='Home']");
        this.shopLink = page.locator("//nav//a[text()='Shop']");
        this.profileIcon = page.locator("header .btn-icon").nth(3);
        this.cartIcon = page.locator("header .btn-icon").nth(2);
        this.signedInAs = page.getByText("Signed in as");
        this.signInEmail = page.getByText("admin@thinkandgetit.com");
        this.profileLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Profile"));
        this.signOutLink = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign Out"));
        this.allProducts = page.locator("div.grid a.group");
        this.cartCount = page.locator("button span");
        this.confirmAlert = page.getByText("Added to cart");
    }

    public String getHomePageTitle() {
        return homePageTitle.textContent();
    }
    public String getLoginEmail(){
        return signInEmail.textContent();
    }
    public Locator isSignedInAs(){
        return this.signedInAs;
    }
    public Locator homeLinkVisible(){
        return this.homeLink;
    }
    public Locator shopLinkVisible(){
        return this.shopLink;
    }
    public Locator profileLinkVisible(){
        return this.profileLink;
    }
    public Locator signOutLinkVisible(){
        return this.signOutLink;
    }
    public void hoverProfileIcon(){
        profileIcon.click();
    }
    public void addProductToCart(String productName){
        Locator targetProduct = allProducts.filter(new Locator.FilterOptions().setHas(page.locator("h3", new Page.LocatorOptions().setHasText(productName))));
        targetProduct.hover();
        targetProduct.getByText("Quick Add").click();
        confirmAlert.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
    }
    public void goToProductPage(String productName){
        Locator targetProduct = allProducts.filter(new Locator.FilterOptions().setHas(page.locator("h3", new Page.LocatorOptions().setHasText(productName))));
        targetProduct.click();
    }
    public void goToShopPage(){
        shopLink.click();
    }
    public void goToCartPage(){
        cartIcon.click();
    }
    public Integer getCartCount(){
        return Integer.parseInt(cartCount.innerText());
    }
}
