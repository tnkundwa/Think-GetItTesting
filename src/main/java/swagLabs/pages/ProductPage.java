package swagLabs.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.List;

public class ProductPage extends BasePage{
    private final Locator pageTitle;
    private final Locator shoppingCart;
    private final Locator sortDropdown;
    private final Locator inventoryItems;

    public ProductPage(Page page){
        super(page);
        this.pageTitle = page.locator(".title");
        this.shoppingCart = page.locator("#shopping_cart_container");
        this.sortDropdown = page.locator(".product_sort_container");
        this.inventoryItems = page.locator(".inventory_list");
    }

    public String getTitle(){
        return pageTitle.textContent();
    }
//    public void addItemToCart(String productName){
//        inventoryItems.filter(new Locator.FilterOptions().setHasText(productName)).
//                locator("button:has-text('Add to cart')").click();
//    }

    public String getCartCount(){
        return shoppingCart.locator(".shopping_cart_badge").innerText();
    }
    public Locator isCartDisplayed(){
        return page.locator("#shopping_cart_container");
    }
    public Locator isSortDisplayed(){
        return page.locator(".product_sort_container");
    }
    public void goToCart(){
        shoppingCart.click();
    }
    public void sortItems(String value){
        sortDropdown.selectOption(value);
    }
    public List<String> getAllItemsNames(){
        return inventoryItems.locator(".inventory_item_name").allInnerTexts();
    }
    public List<Double> getAllItemsPrices(){
        return inventoryItems.locator(".inventory_item_price").allInnerTexts()
                .stream().map(p -> Double.parseDouble(p.replace("$", ""))).toList();
    }
    public void addToCart(String itemName){
        String officialName = itemName.trim().toLowerCase().replace(" ", "-");
        String selector = String.format("#add-to-cart-%s", officialName);
        page.locator(selector).click();
    }
    public void removeFromCart(String itemName){
        String officialName = itemName.trim().toLowerCase().replace(" ", "-");
        String selector = String.format("#remove-%s", officialName);
        page.locator(selector).click();
    }
    public String removeFromCartString(String itemName){
        String officialName = itemName.trim().toLowerCase().replace(" ", "-");
        String selector = String.format("#remove-%s", officialName);
        return page.locator(selector).textContent();
    }

    public void addToCartProto(List<String> itemName){
        itemName.stream().map(product -> String.format("#add-to-cart-%s", product.trim().toLowerCase().replace(" ", "-"))).forEach(item -> page.locator(item).click());
    }
    public void removeFromCartProto(List<String> itemName){
        itemName.stream().map(product -> String.format("#remove-%s", product.trim().toLowerCase().replace(" ", "-"))).forEach(item -> page.locator(item).click());
    }

}
