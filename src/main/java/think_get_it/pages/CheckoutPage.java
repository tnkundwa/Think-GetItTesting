package think_get_it.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class CheckoutPage extends BasePage {
    private final Locator pageTitle;
    private final Locator addNewAddress;
    private final Locator firstName;
    private final Locator lastName;
    private final Locator phone;
    private final Locator street;
    private final Locator city;
    private final Locator state;
    private final Locator country;
    private final Locator saveAddress;
    private final Locator continueToPayment;
    private final Locator modeOfPayment;
    private final Locator reviewOrder;
    private final Locator orderSummary;
    private final Locator placeOrder;
    private String mode;
    private Locator orderPlaced;

    public CheckoutPage(Page page) {
        super(page);
        this.pageTitle = page.locator("div h1");
        this.addNewAddress = page.getByText("Add new address");
        this.continueToPayment = page.getByText("Continue to Payment");
        this.modeOfPayment = page.locator("//label[contains(.,"  + mode + ")]");
        this.reviewOrder = page.getByText("Review Order");
        this.placeOrder = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Place Order"));
        this.firstName = page.getByPlaceholder("First Name");
        this.lastName = page.getByPlaceholder("Last Name");
        this.phone = page.getByPlaceholder("Phone number");
        this.street = page.getByPlaceholder("Street address");
        this.city = page.getByPlaceholder("City");
        this.state = page.getByPlaceholder("State / Region");
        this.country = page.getByPlaceholder("Country");
        this.saveAddress = page.getByText("Save Address");
        this.orderSummary = page.locator("div h3");
        this.orderPlaced = page.getByText("Order Placed Successfully");
    }

    public String getTitle(){
        return pageTitle.innerText();
    }
    public void addNewAddress(){
        addNewAddress.click();
    }
    public void addDetails(String first, String last, String num, String streetNum, String cityName, String stateName, String countryName){
        firstName.fill(first);
        lastName.fill(last);
        phone.fill(num);
        street.fill(streetNum);
        city.fill(cityName);
        state.fill(stateName);
        country.fill(countryName);
        saveAddress.click();
    }
    public void continueToPayment(){
        continueToPayment.click();
    }
    public void paymentMode(String mode){
        modeOfPayment.filter(new Locator.FilterOptions().setHasText(mode)).click();
    }
    public void reviewOrder(){
        reviewOrder.click();
    }
    public Locator orderSummary(){
        return orderSummary;
    }
    public Locator isPlaceOrder(){
        return placeOrder;
    }
    public void placeOrder(){
        placeOrder.click();
    }
    public Locator orderPlaced(){
        return orderPlaced;
    }
}
