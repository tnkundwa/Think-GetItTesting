package think_get_it.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class ShopPage extends BasePage {
    private final Locator pageTitle;
    private final Locator allProducts;
    private final Locator categories;
    private final Locator productsCategories;
    private final Locator prices;
    private final Locator productsPrices;
    private final Locator minInput;
    private final Locator maxInput;

    public ShopPage(Page page) {
        super(page);
        this.pageTitle = page.locator("div.flex div h1");
        this.allProducts = page.locator("div.grid a.group");
        this.categories = page.locator("main button.w-full");
        this.productsCategories = page.locator("div.grid a.group p");
        this.prices = page.locator("button.text-xs.px-2");
        this.productsPrices = page.locator("div.grid a.group span.font-display");
        this.minInput = page.getByPlaceholder("Min");
        this.maxInput = page.getByPlaceholder("Max");
    }

    public String getPageTitle() {
        return pageTitle.innerText();
    }
    public Locator isAllProducts() {
        return allProducts;
    }
    public void selectCategory(String categoryFilter) {
        categories.filter(new Locator.FilterOptions().setHasText(categoryFilter)).click();
    }
    public List<String> isProductsFilteredCategory() {
        return productsCategories.all().stream().map(Locator::innerText).toList();
    }
    public String[] selectPrice(int priceFilterRange) {
        Locator priceRange = prices.all().get(priceFilterRange);
        priceRange.click();
        return priceRange.innerText().replace("$", "").split("–");
    }
    public List<Double> isProductsFilteredPrice() {
        return productsPrices.all().stream().map(Locator::innerText).map(price -> price.replace("$", "")).map(Double::parseDouble).toList();
    }
    public void minPriceRange(double minValue, double maxValue) {
        minInput.fill(String.valueOf(minValue));
        maxInput.fill(String.valueOf(maxValue));
    }
}
