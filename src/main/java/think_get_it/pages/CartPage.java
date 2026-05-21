package think_get_it.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CartPage extends BasePage{
    public final Locator parentCart;

    public CartPage(Page page){
        super(page);
        this.parentCart = page.locator("div.fixed.top-0");
    }
}
