package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static pages.CommonMethod.waiter;

public class MainVkPage {
    WebDriver driver;
    By personPageName = By.xpath("/html/body/div[11]/div/div/div[1]/div[2]/div/div/div[1]/div[4]/a/div[1]");

   public MainVkPage(WebDriver driver){
        this.driver = driver;
    }


    /**
     * Get person name from main page
     * @return
     */
    public String getNameFromMainPage(){
        waiter(personPageName);
        return	driver.findElement(personPageName).getText();
    }
}
