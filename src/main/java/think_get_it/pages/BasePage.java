package thinkgetit.pages;

import com.microsoft.playwright.Page;
import thinkgetit.utils.ConfigReader;

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
