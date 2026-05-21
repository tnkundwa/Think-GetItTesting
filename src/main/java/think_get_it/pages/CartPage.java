package think_get_it.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage{
    public final Locator parentCart;
    public final Locator checkout;
    public final Locator viewCart;
    public final Locator cartCount;
    public final Locator productCount;
    public final Locator productPrice;
    public final Locator totalPrice;

    public CartPage(Page page){
        super(page);
        this.parentCart = page.locator("div.fixed.top-0");
        this.checkout = parentCart.getByRole(AriaRole.LINK,  new Locator.GetByRoleOptions().setName("Checkout"));
        this.viewCart = parentCart.getByRole(AriaRole.LINK,  new Locator.GetByRoleOptions().setName("cart"));
        this.cartCount = parentCart.locator("span.badge-red");
        this.productCount = parentCart.locator("span.w-6");
        this.productPrice = parentCart.locator("span.font-semibold");
        this.totalPrice = parentCart.locator("div.border-brand-border span.font-display");
    }
    public Locator isCheckout(){
        return checkout;
    }
    public void goToCheckoutPage(){
        checkout.click();
    }
    public Locator isViewCart(){
        return viewCart;
    }
    public int getCartCount(){
        return Integer.parseInt(cartCount.innerText().split(" ")[0]);
    }
    public int getProductCount(){
        List<Integer> productCounts = productCount.all().stream().map(price -> Integer.parseInt(price.textContent())).toList();
        return productCounts.stream().mapToInt(Integer::intValue).sum();
    }
    public Double getProductPrice(){
        List<Double> priceList = productPrice.all().stream().map(price -> Double.parseDouble(price.textContent().replace("$", ""))).toList();
        return priceList.stream().mapToDouble(Double::doubleValue).sum();
    }
    public Locator isTotalPrice(){
        return totalPrice;
    }
    public int getTotalPrice(){
        return Integer.parseInt(totalPrice.innerText());
    }
}
