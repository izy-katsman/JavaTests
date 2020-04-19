import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AndroidDriverManager {
    static AppiumDriverLocalService appiumDriverLocalService = null;

    public static AndroidDriver driver;

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public AndroidDriver getDriver() {
        if (driver == null) {
            startService();
            setup();
        }
        return driver;
    }

    public void setup(){
        DesiredCapabilities capabilities = new DesiredCapabilities();//.android();
        capabilities.setCapability(CapabilityType.PLATFORM_NAME, "android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy A5 (2017)");
        capabilities.setCapability(CapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("appPackage", "platkovsky.alexey.epamtestapp");
        capabilities.setCapability("appActivity", "platkovsky.alexey.epamtestapp.activities.LoginActivity");
        capabilities.setCapability("udid", "52100385589ba379");
        capabilities.setCapability("--local-timezone", "false");
        capabilities.setCapability("autoGrantPermissions", "true");
        capabilities.setCapability("orientation", "PORTRAIT");
        capabilities.setCapability("appWaitDuration", 30000);
        capabilities.setCapability("disabledAndroidWatchers", "true");
        //capabilities.setCapability(MobileCapabilityType.APP, "src\\main\\resources\\app\\app-debug.apk");
        //capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        driver = new AndroidDriver<>(appiumDriverLocalService.getUrl(), capabilities);



        driver = new AndroidDriver<MobileElement>(appiumDriverLocalService.getUrl(), capabilities);
    }

    protected void startService() {
        AppiumServiceBuilder builder = new AppiumServiceBuilder().withIPAddress("127.0.0.1").usingAnyFreePort();
        builder.withAppiumJS(new File("C:\\Program Files\\Appium\\resources\\app\\node_modules\\appium\\build\\lib\\main.js"));
        builder.withArgument(GeneralServerFlag.LOG_LEVEL, "error");
        AppiumDriverLocalService appiumDriverLocalService = builder.build();
        AndroidDriverManager.appiumDriverLocalService = appiumDriverLocalService;
        appiumDriverLocalService.start();
    }


    private void launchDriverWithStartedAppium(Capabilities capabilities) {
        try {
            driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
