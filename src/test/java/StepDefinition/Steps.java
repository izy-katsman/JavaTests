package StepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.MainVkPage;
import pages.VkLogin;

public class Steps {

    WebDriver driver;
    VkLogin objLogin;

    @Given("^Open the Firefox and launch the application$")
    public void openTheFirefoxAndNavigateToTheVk() throws Throwable
    {
        System.setProperty("webdriver.gecko.driver", "E:\\Tests\\POM\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://vk.com/");
        objLogin = new VkLogin(driver);
    }

    @When("^ Login with login'' and password$")
    public void LoginInVk(String login, String password) throws Throwable
    {
        objLogin.loginToVk(login, password);
        System.out.println("This step enter the Username and Password on the login page.");
    }

    @Then("^Reset the credential$")
    public void ResetTheStatus() throws Throwable
    {
        MainVkPage objHomePage = new MainVkPage(driver);

        System.out.println("This step click on the Reset button." + objHomePage.getNameFromMainPage().toLowerCase().contains("izy"));
    }

}