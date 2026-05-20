package think_get_it.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class CreateAccountPage extends BasePage {
    private final Locator pageTitle;
    private final Locator firstName;
    private final Locator lastName;
    private final Locator email;
    private final Locator password;
    private final Locator createAccountBtn;
    private final Locator signIn;
    private final Locator  alertMessage;

    public CreateAccountPage(Page page) {
        super(page);
        this.pageTitle = page.locator("div h1");
        this.firstName = page.getByPlaceholder("John");
        this.lastName = page.getByPlaceholder("Doe");
        this.email = page.getByPlaceholder("you@example.com");
        this.password = page.getByPlaceholder("Min. 8 characters");
        this.createAccountBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Create Account"));
        this.signIn = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Sign In"));
        this.alertMessage = page.getByText("Password must be at least 8 characters");
    }

    public String getPageTitle(){
        return pageTitle.textContent();
    }
    public void enterFirstName(String fName){
        firstName.fill(fName);
    }
    public void enterLastName(String lName){
        lastName.fill(lName);
    }
    public void enterEmail(String emailAddress){
        email.fill(emailAddress);
    }
    public void enterPassword(String newPassword){
        password.fill(newPassword);
    }
    public void clickCreateAccountBtn(){
        createAccountBtn.click();
    }
    public LoginPage clickSignIn(){
        signIn.click();
        return new LoginPage(page);
    }
    public String getAlertText(){
        return alertMessage.innerText();
    }
    public String getEmailText(){
        return (String) email.evaluate("element => element.validationMessage");
    }
}