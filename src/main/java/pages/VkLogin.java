package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VkLogin {
    WebDriver driver;
    By userNameText = By.xpath("//*[@id=\"index_email\"]");
    By passwordText = By.xpath("//*[@id=\"index_pass\"]");
    By loginBtn = By.xpath("//*[@id=\"index_login_button\"]");

    public VkLogin(WebDriver driver){
        this.driver = driver;
    }

    //Set user name in textbox
    public void setUserName(String strUserName) {
                driver.findElement(userNameText).sendKeys(strUserName);
    }

    //Set password in password textbox
    public void setPassword(String strPassword){
        driver.findElement(passwordText).sendKeys(strPassword);
    }

    //Click on login button
    public void clickLogin(){
        driver.findElement(loginBtn).click();
    }

    /**
     *login in the vk by name/phone and pass
     * @param strUserName
     * @param strPasword
     * @return
     */
    public void loginToVk(String strUserName,String strPasword) {
        //Fill user name
        this.setUserName(strUserName);
        //Fill password
        this.setPassword(strPasword);
        //Click Login button
        this.clickLogin();
    }
}
