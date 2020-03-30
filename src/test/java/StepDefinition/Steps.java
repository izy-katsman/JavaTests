package StepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.CommonMethod;
import pages.MainVkPage;
import pages.VkLogin;

import java.util.Map;

public class Steps {

    WebDriver driver;
    VkLogin objLogin;

    @Given("^launch firefox  and navigate to the vk$")
    public void openTheFirefoxAndNavigateToTheVk() throws Throwable
    {
        System.setProperty("webdriver.gecko.driver", "E:\\Tests\\POM\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://vk.com/");
        objLogin = new VkLogin(driver);
    }

    @When("^I try to login \"([^\"]*)\" with Password \"([^\"]*)\"$")
    public void LoginInVk(String login, String password) throws Throwable
    {
        objLogin.loginToVk(login, password);
        System.out.println("This step enter the Username and Password on the login page.");
    }

    @Then("^I should see that I logged in$")
    public void ResetTheStatus() throws Throwable
    {
        CommonMethod await = new CommonMethod(driver);
        MainVkPage objHomePage = new MainVkPage(driver);

        System.out.println("You login - " + objHomePage.getNameFromMainPage().toLowerCase().contains("izy"));
    }

}