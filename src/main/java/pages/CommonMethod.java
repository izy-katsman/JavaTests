package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethod {
    private static WebDriver driver;

    public CommonMethod(WebDriver driver){
        this.driver = driver;
    }

    public static void waiter(By element){
        WebDriverWait waitForOne = new WebDriverWait(driver, 20);
        waitForOne.until(ExpectedConditions.presenceOfElementLocated(element));
    }
}
