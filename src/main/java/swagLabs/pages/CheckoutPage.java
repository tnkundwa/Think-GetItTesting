package swagLabs.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CheckoutPage extends BasePage {
    private final Locator firstNameInput;
    private final Locator lastNameInput;
    private final Locator postalCodeInput;
    private final Locator continueButton;
    private final Locator finishButton;

    public CheckoutPage(Page page) {
        super(page);
        this.firstNameInput = page.locator("[data-test='firstName']");
        this.lastNameInput = page.locator("[data-test='lastName']");
        this.postalCodeInput = page.locator("[data-test='postalCode']");
        this.continueButton = page.locator("[data-test='continue']");
        this.finishButton = page.locator("[data-test='finish']");
    }

    public void fillCheckoutInformation(String firstName, String lastName, String postalCode) {
        firstNameInput.fill(firstName);
        lastNameInput.fill(lastName);
        postalCodeInput.fill(postalCode);
        continueButton.click();
    }

    public void clickFinish() {
        finishButton.click();
    }
}