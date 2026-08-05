package swagLabsTests.checkout;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import swagLabs.pages.BasePage;

public class CheckoutTest extends BasePage {
    private final Locator completeHeader;
    private final Locator completeText;

    public CheckoutTest (Page page) {
        super(page);
        this.completeHeader = page.locator("[data-test='complete-header']");
        this.completeText = page.locator("[data-test='complete-text']");
    }

    public String getCompleteHeader() {
        return completeHeader.textContent();
    }

    public String getCompleteText() {
        return completeText.textContent();
    }

    public Locator getCompleteHeaderLocator() {
        return completeHeader;
    }
}
