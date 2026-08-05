package swagLabs.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage extends BasePage {
    private final Locator usernameInput;
    private final Locator passwordInput;
    private  final Locator loginBtn;
    private final Locator errorMsg;

    public LoginPage(Page page){
        super(page);
        this.usernameInput = page.getByPlaceholder("Username");
        this.passwordInput = page.getByPlaceholder("Password");
        this.loginBtn = page.locator("#login-button");
        this.errorMsg = page.locator(".error-button");
    }

    public void loginValid(String username, String password){
        usernameInput.fill(username);
        passwordInput.fill(password);
    }
    public void loginInvalid(String username, String password){
        usernameInput.fill(username);
        passwordInput.fill(password);
    }
    public Locator errorElement(){
        return errorMsg;
    }
    public String errorMsg(){
        return errorMsg.textContent();
    }
    public void clickLoginBtn(){
        loginBtn.click();
    }
}
