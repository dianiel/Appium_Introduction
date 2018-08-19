package NativeApp_05;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class UI_Select_1_5 {

    AndroidDriver driver;

    @Test
    public void UI_Select() throws MalformedURLException {
        File appDir = new File("src/apk");

        File app = new File(appDir, "ApiDemos-debug.apk");

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android device"); //jeśli używam fizycznego urządzenia pisze device
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);

        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "20");
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        List<WebElement>count=driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(true)");
        System.out.println(count.size());

        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Preference\")").click();
    }
}
