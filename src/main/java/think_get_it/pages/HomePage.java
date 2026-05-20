package thinkgetit.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class HomePage extends BasePage {
    private final Locator homePageTitle;
    private final Locator profileIcon;
    private final Locator homeLink;
    private final Locator shopLink;
//    private final Locator flashLink;
//    private final Locator featuredLink;
    private final Locator signedInAs;
    private final Locator signInEmail;
    private final Locator profileLink;
//    private final Locator adminPanelLink;
//    private final Locator ordersLink;
    private final Locator signOutLink;

    public HomePage(Page page) {
        super(page);
        this.homePageTitle = page.locator(".max-w-2xl h1");
        this.homeLink = page.locator("//nav//a[text()='Home']");
        this.profileIcon = page.locator("header .btn-icon").nth(3);
        this.shopLink = page.locator("//nav//a[text()='Shop']");
//        this.flashLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Flash"));
//        this.featuredLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Featured"));
        this.signedInAs = page.getByText("Signed in as");
        this.signInEmail = page.getByText("admin@thinkandgetit.com");
        this.profileLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Profile"));
        this.signOutLink = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign Out"));
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
}
