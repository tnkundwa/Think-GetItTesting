package swagLabs.pages;

import com.microsoft.playwright.Page;
import swagLabs.utils.ConfigReader;

public class BasePage {
    protected Page page;
    public BasePage(Page  page){
        this.page = page;
    }
    public void navigate(String path){
        page.navigate(ConfigReader.getProperty(path));
    }
}
