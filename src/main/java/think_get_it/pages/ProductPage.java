package think_get_it.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import java.util.regex.Pattern;

public class ProductPage extends BasePage{
    private final Locator productName;
//    private final Locator productPrice;
    private final Locator addToCart;
    private final Locator addProductQuantity;
    private final Locator reduceProductQuantity;
    private final Locator productQuantity;
    private final Locator description;
    private final Locator shippingInfo;
    private final Locator returnPolicy;
    private final Locator confirmAlert;
    private final Locator size;
    private final Locator color;

    public ProductPage(Page page){
        super(page);
        this.productName = page.locator("div h1");
//        this.productPrice = page.locator("p");
        this.addToCart = page.getByText("Add to Cart");
        this.addProductQuantity = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("+"));
        this.reduceProductQuantity = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("−"));
        this.productQuantity = page.locator("div.flex span.w-12");
        this.description = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Description"));
        this.shippingInfo = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Shipping Info"));
        this.returnPolicy = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Returns Policy"));
        this.confirmAlert = page.getByText("Added to cart");
        this.size = page.locator("div.flex button.px-4.rounded-xl");
        this.color = page.locator("//button[@title]");
    }

    public String getProductName(){
        return productName.textContent();
    }
    public void addToCart(){
        addToCart.click();
    }
    public void increaseProductQuantity(int quantity){
        for(int i = 0; i < quantity; i++){
            addProductQuantity.click();
        }
    }
    public void decreaseProductQuantity(int quantity){
        for(int i = 0; i < quantity; i++){
            reduceProductQuantity.click();
        }
    }
    public Integer getProductQuantity(){
        return Integer.parseInt(productQuantity.textContent());
    }
    public Locator getDescription(){
        return description;
    }
    public Locator getShippingInfo(){
        return shippingInfo;
    }
    public Locator getReturnPolicy(){
        return returnPolicy;
    }
    public void selectSize(String sizeValue){
        size.getByText(sizeValue, new Locator.GetByTextOptions().setExact(true)).click();
    }
    public void selectColor(String colorValue){
        if (colorValue.equals("Navy")){
            color.nth(0).click();
        } else  {
            color.nth(1).click();
        }
    }
    public Locator getConfirmAlert(){
        return confirmAlert;
    }
}
