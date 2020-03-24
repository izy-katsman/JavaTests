package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static pages.CommonMethod.waiter;

public class MessagePage {
    WebDriver driver;

    By messageBtn = By.xpath("/html/body/div[11]/div/div/div[2]/div[1]/div/nav/ol/li[3]/a/span/span[3]");
    By allMessageBtn = By.xpath("//*[@id=\"ui_rmenu_all\"]");
    By importantMessageBtn = By.xpath("//*[@id=\"ui_rmenu_fav\"]");
    By importantText = By.xpath("/html/body/div[6]/div/div[2]/div/div[2]/div/div[1]/div/div/h2/ul/li/div");
    By unreadMessagesBtn = By.xpath("//*[@id=\"ui_rmenu_unread\"]");

    public MessagePage(WebDriver driver){
        this.driver = driver;
    }

    public void navigateMessagePage(){
        waiter(messageBtn);
        driver.findElement(messageBtn).click();
    }

    public String getUnreadMessage(){
        navigateMessagePage();
        waiter(unreadMessagesBtn);
        driver.findElement(unreadMessagesBtn).click();
        return driver.findElement(unreadMessagesBtn).getText();
    }

    public String getAllMessages(){
        navigateMessagePage();
        waiter(allMessageBtn);
        driver.findElement(allMessageBtn).click();
        return	driver.findElement(allMessageBtn).getText();
    }
}
