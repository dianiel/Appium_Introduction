package NativeApp_05;

import io.appium.java_client.android.AndroidDriver;
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

public class TextMatches_and_click_1_2 {

    //alternative for driver.scrollTo()

    AndroidDriver driver;

    @Test
    public void TextMatches_and_click_1_2() throws MalformedURLException {
        File appDir = new File("src/apk");

        File app = new File(appDir, "ApiDemos-debug.apk");

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);

        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "20");
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        driver.findElementByAndroidUIAutomator("new UiSelector().textMatches(\"Preference\")").click();

        List<WebElement>a = driver.findElements(By.id("android:id/text1"));
        System.out.println(a.get(8).getText());
    }
}
