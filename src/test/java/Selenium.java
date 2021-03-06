import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Selenium {

    @Test
    public void firstTest(){
            System.setProperty("webdriver.gecko.driver", "E:\\Tests\\geckodriver.exe");
            WebDriver driver = new FirefoxDriver();

            driver.get("http://www.google.com");
            WebElement element = driver.findElement(By.name("q"));
            element.sendKeys("vk");
            element.submit();
            System.out.println("Page title is: " + driver.getTitle());

            (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver d) {
                    return d.getTitle().toLowerCase().startsWith("vk");
                }
            });
            System.out.println("Page title is: " + driver.getTitle());
            // Закрываем браузер
            driver.quit();
    }
}
