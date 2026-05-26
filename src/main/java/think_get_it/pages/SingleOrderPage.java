package think_get_it.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class SingleOrderPage extends BasePage {
    public final Locator pageTitle;
    public final Locator allProducts;
    public final Locator cancelOrder;
    public final Locator summary;

    public SingleOrderPage(Page page) {
        super(page);
        this.pageTitle = page.locator("div h1");
        this.allProducts = page.locator("div.card div.space-y-4");
        this.cancelOrder = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Cancel Order"));
        this.summary = page.locator("div.card.space-y-2");
    }

    public String getTitle() {
        pageTitle.waitFor();
        return pageTitle.innerText();
    }
    public Locator getAllProducts() {
        return allProducts;
    }
    public Locator getCancelOrder() {
        return cancelOrder;
    }
    public Locator getSummary() {
        return summary;
    }
}
