import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;

import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pages.*;

@FixMethodOrder(MethodSorters.JVM)
public class TestVk {
    static WebDriver driver;
    VkLogin objLogin;
    MainVkPage objHomePage;
    MessagePage objMessagePage;
    Grups objGrups;
    static boolean isLogin = false;

    public void setup() {
        System.setProperty("webdriver.gecko.driver", "E:\\Tests\\POM\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://vk.com/");
        CommonMethod await = new CommonMethod(driver);
    }

    @Test
    public void Login() {
        if(isLogin)
            Assert.assertTrue(true);

        setup();
        //Create pages.MainVkPage Page object
        objLogin = new VkLogin(driver);
        //login to application
        objLogin.loginToVk("89110918216", "Vfrcbvjd11121973-");
        // go the next page
        objHomePage = new MainVkPage(driver);
        isLogin = true;
        //Verify home page
        Assert.assertTrue(objHomePage.getNameFromMainPage().toLowerCase().contains("izy"));
    }

    @Test
    public void AllMessages(){
        if(isLogin == false)
            Login();

        objMessagePage = new MessagePage(driver);
        Assert.assertTrue(objMessagePage.getAllMessages().toLowerCase().contains("все сообщения"));
    }

    @Test
    public void UnreadMessages(){
        if(isLogin == false)
            Login();

        objMessagePage = new MessagePage(driver);
        Assert.assertTrue(objMessagePage.getUnreadMessage().toLowerCase().contains("непрочитанные"));
    }

    @Test
    public void Grups(){
        if(isLogin == false)
            Login();

        objGrups = new Grups(driver);
        Assert.assertTrue(objGrups.getGrups().toLowerCase().contains("все сообщества"));
    }

    @Test
    public void Neko(){
        if(isLogin == false)
            Login();
        objGrups = new Grups(driver);
        Assert.assertTrue(objGrups.getNekoGrup().toLowerCase().contains("nekotopia"));
    }

    @Test
    public void NekoProduct(){
        boolean flag;
        if(isLogin == false)
            Login();

        objGrups = new Grups(driver);
        flag = objGrups.getNekoProduct().toLowerCase().contains("обычная");
        driver.quit();
        Assert.assertTrue(flag);
    }
}
