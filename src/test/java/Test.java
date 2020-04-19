import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import layout.AddExpenseLayout;
import layout.ExpensesLayout;
import layout.LoginLayout;
import layout.RegisterLayout;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.util.concurrent.TimeUnit;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Test {

    static AndroidDriver<MobileElement> driver;
    static AndroidDriverManager driverManager;
    private LoginLayout loginLayout;

    private static final String userName = "Kappa";
    private static final String password = "kappakappahey";
    private static final String email = "kappa@kappa.com";

    @BeforeClass
    public static void prepareTest() {
        driverManager = new AndroidDriverManager();
        driver = driverManager.getDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

   // @After
    //public void teardownDriver() {
     //   driverManager.quitDriver();
    //}

    @Before
    public void initPageObject() {
        driver.launchApp();
        loginLayout = new LoginLayout(driver);
    }

    @AfterClass
    public static void closeApp() {
        driver.closeApp();
    }

    @org.junit.Test
    public void registerTest() {
        registerNewUser();
        Assert.assertEquals(LoginLayout.getActivityName(), driver.currentActivity());
    }

    @org.junit.Test
    public void loginTest() {
        registerNewUser();//из-за постоянных вылетов
        loginLayout.enterEmailAndPassword(email, password);
        Assert.assertEquals(ExpensesLayout.getActivityName(), driver.currentActivity());
    }


    @org.junit.Test
    public void AndAddExpenseTest() {
        registerNewUser();//из-за постоянных вылетов
        ExpensesLayout expensesLayout = loginLayout.enterEmailAndPassword(email, password);
        Assert.assertEquals(ExpensesLayout.getActivityName(), driver.currentActivity());

        AddExpenseLayout addExpenseLayout = expensesLayout.pressAddExpense();

        expensesLayout = addExpenseLayout.addExpense("123", "123", "12/04/0000", "аааааааа");

        Assert.assertTrue(expensesLayout.containsExpense("аааааааа"));
    }

    private void registerNewUser() {
        RegisterLayout registerLayout = loginLayout.pressRegisterNewAccount();
        loginLayout = registerLayout.fillFields(email, userName, password);
        Assert.assertEquals(ExpensesLayout.getActivityName(), driver.currentActivity());
    }
}
