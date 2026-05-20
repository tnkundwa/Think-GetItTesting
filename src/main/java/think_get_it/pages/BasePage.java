package think_get_it.pages;

import com.microsoft.playwright.Page;
import think_get_it.utils.ConfigReader;

public class BasePage {
    protected Page page;
    public BasePage(Page  page){
        this.page = page;
    }
    public void navigate(String path){
        page.navigate(ConfigReader.getProperty(path));
    }
    public String getEmail(){
        return ConfigReader.getProperty("userEmail");
    }
    public String getPassword(){
        return ConfigReader.getProperty("userPassword");
    }
}
