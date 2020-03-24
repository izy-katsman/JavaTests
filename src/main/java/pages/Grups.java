package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static pages.CommonMethod.waiter;

public class Grups {
    WebDriver driver;
    By grupsBtn = By.xpath("/html/body/div[11]/div/div/div[2]/div[1]/div/nav/ol/li[5]/a/span/span[3]");
    By grupsText = By.xpath("/html/body/div[11]/div/div/div[2]/div[2]/div[2]/div/div/div/div/div[2]/div/div[1]/h2/ul/li[1]/a");
    By neko = By.xpath("/html/body/div[11]/div/div/div[2]/div[2]/div[2]/div/div/div/div/div[2]/div/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/a");
    By nekoTitle = By.xpath("/html/body/div[11]/div/div/div[2]/div[2]/div[2]/div/div/div/div/div[1]/div[2]/div[2]/h1");
    By nekoProduct = By.xpath("/html/body/div[11]/div/div/div[2]/div[2]/div[2]/div/div/div/div/div[2]/div[2]/div/div[2]/aside/div/div[2]/div/div/a[1]/img");
    By nekoProductType = By.xpath("/html/body/div[13]/div/div[1]/div[1]/div[3]/div/div[1]/div[2]/div[1]/div[2]");

    public Grups(WebDriver driver){
        this.driver = driver;
    }

    public void navigateGrupsPage(){
        waiter(grupsBtn);
        driver.findElement(grupsBtn).click();
    }

    public String getGrups(){
        navigateGrupsPage();
        waiter(grupsText);
        return driver.findElement(grupsText).getText();
    }

    public String getNekoGrup(){
        navigateGrupsPage();
        waiter(grupsText);
        driver.findElement(grupsText).click();

        waiter(neko);
        driver.findElement(neko).click();

        waiter(nekoTitle);
        return driver.findElement(nekoTitle).getText();
    }

    public void navigateProductNeko(){
        getNekoGrup();

        waiter(nekoProduct);
        driver.findElement(nekoProduct).click();

    }

    public String getNekoProduct(){
        navigateProductNeko();
        waiter(nekoProductType);
        return driver.findElement(nekoProductType).getText();
    }
}
