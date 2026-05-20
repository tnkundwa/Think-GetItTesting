package think_get_it.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage extends BasePage {
    private final Locator usernameInput;
    private final Locator passwordInput;
    private  final Locator loginBtn;

    public LoginPage(Page page){
        super(page);
        this.usernameInput = page.getByPlaceholder("you@example.com");
        this.passwordInput = page.getByPlaceholder("••••••••");
        this.loginBtn = page.locator(".btn-primary");
    }

    public void login(String username, String password){
        usernameInput.fill(username);
        passwordInput.fill(password);
        loginBtn.click();
    }

    public String getEmailText(){
        return (String) usernameInput.evaluate("element => element.validationMessage");
    }
    public String getPasswordText(){
        return (String) passwordInput.evaluate("element => element.validationMessage");
    }
}
