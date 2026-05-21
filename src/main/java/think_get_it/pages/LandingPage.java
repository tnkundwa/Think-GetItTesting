package think_get_it.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LandingPage extends BasePage {
    private final Locator signInBtn;
    private final Locator getStartedBtn;
    private final Locator createAccountBtn;

    public LandingPage(Page page) {
        super(page);
        this.signInBtn = page.getByText("Sign in");
        this.getStartedBtn = page.getByText("Get started");
        this.createAccountBtn = page.getByText("Create account");
    }

    public Locator getSignInBtn() {
        return signInBtn;
    }
    public Locator getLoginPage() {
        return signInBtn;
    }
    public void goToLoginPage(){
        getLoginPage().click();
    }
    public Locator getGetStartedBtn() {
        return getStartedBtn;
    }
    public Locator getCreateAccountBtn() {
        return createAccountBtn;
    }
    public void goToCreateAccountPage() {
        getCreateAccountBtn().click();
    }
}
