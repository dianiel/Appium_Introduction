package NativeApp_05;

import io.appium.java_client.TouchAction;
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
import java.util.concurrent.TimeUnit;

public class Gestures007_1_4 {

    AndroidDriver driver;

    @Test
    public void Gestures_1_4() throws MalformedURLException {
        File appDir = new File("src/apk");

        File app = new File(appDir, "ApiDemos-debug.apk");

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);

        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "20");
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //System.out.println(driver.isLocked()); //Locked condition
        System.out.println(driver.getContext());

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        List<WebElement>oneListElement = driver.findElements(By.id("android:id/text1"));
        oneListElement.get(2);

        TouchAction action = new TouchAction(driver);
        action.tap(oneListElement.get(2)).perform();
        //TouchAction action2 = new TouchAction(driver).longPress(e1);
    }
}
