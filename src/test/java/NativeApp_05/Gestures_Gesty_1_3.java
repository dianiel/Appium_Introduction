package NativeApp_05;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Gestures_Gesty_1_3 {

    AndroidDriver driver;

    @Test
    public void Gestures() throws MalformedURLException {
        File appDir = new File("src/apk");

        File app = new File(appDir, "meetfaces_preprod.apk");

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);

        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "20");
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.id("com.meetface:id/accept")).click();

        WebElement loginLinkElement = driver.findElement(By.id("com.meetface:id/login"));
        loginLinkElement.click();

        List<WebElement>a = driver.findElements(By.className("android.widget.EditText"));
        a.get(0).sendKeys("testmobitouch1@gmail.com");
        a.get(1).sendKeys("Raporty1");

        WebElement loginButtonElement = driver.findElement(By.id("com.meetface:id/login"));
        loginButtonElement.click();

        driver.findElement(By.id("com.meetface:id/global_im")).click();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.id("android:id/search_src_text")).sendKeys("Adam");
        driver.findElement(By.id("android:id/search_mag_icon")).click();

          /*
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        MobileElement abc = (MobileElement) driver.findElement(By.className("android.widget.TextView"));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        abc.swipe(SwipeElementDirection.UP, 6000);
        abc.zoom();
        */

        System.out.println(driver.isLocked()); //Locked condition
        System.out.println(driver.getContext());
        //driver.installApp();
        driver.closeApp();
        //driver.currentActivity();
        //driver.context("name")
        //driver.zoom();



        //TouchAction action = new TouchAction(driver);
        //action.tap(el);


    }
}
