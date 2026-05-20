package swagLabs.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.List;

public class CartPage extends BasePage{
    private final Locator pageTitle;
    private final Locator continueShopping;
    private final Locator checkout;
    private final Locator rowsInCart;

    public CartPage(Page page){
        super(page);
        this.pageTitle = page.locator(".title");
        this.continueShopping = page.locator("#continue-shopping");
        this.checkout = page.locator("#checkout");
        this.rowsInCart = page.locator(".cart_item");
    }
    public String getTitle(){
        return pageTitle.textContent();
    }
    public void removeFromCartPage(String itemName){
        String officialName = itemName.trim().toLowerCase().replace(" ", "-");
        String selector = String.format("#remove-%s", officialName);
        page.locator(selector).click();
    }
    public void removeFromCartPageProto(List<String> itemName){
        itemName.stream().map(product -> String.format("#remove-%s", product.trim().toLowerCase().replace(" ", "-"))).forEach(item -> page.locator(item).click());
    }
    public String continueShoppingText(){
        return  continueShopping.textContent();
    }
    public String goToCheckout(){
        return  checkout.textContent();
    }
    public int getItemsInCart(){
        return rowsInCart.count();
    }
}
