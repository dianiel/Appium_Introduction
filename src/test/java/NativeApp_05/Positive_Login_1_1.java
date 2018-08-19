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
import java.util.concurrent.TimeUnit;

public class Positive_Login_1_1 {

    AndroidDriver driver;

    @Test
    public void PositiveUserLogin() throws MalformedURLException {
        File appDir = new File("src/apk");

        File app = new File(appDir, "meetfaces_preprod.apk");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);

        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.id("com.meetface:id/accept")).click();


        WebElement loginLinkElement = driver.findElement(By.id("com.meetface:id/login"));
        loginLinkElement.click();

        /*
        WebElement userLoginElement = driver.findElement(By.id("com.meetface:id/email"));
        userLoginElement.sendKeys("testmobitouch1@gmail.com");

        WebElement userPasswordElement = driver.findElement(By.id("com.meetface:id/password"));
        userPasswordElement.sendKeys("Raporty1");
        */

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        List<WebElement>a = driver.findElements(By.className("android.widget.EditText"));
        a.get(0).sendKeys("testmobitouch1@gmail.com");
        a.get(1).sendKeys("Raporty1");

        WebElement loginButtonElement = driver.findElement(By.id("com.meetface:id/login"));
        loginButtonElement.click();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        List<WebElement>b = driver.findElements(By.id("com.meetface:id/bottom_navigation_item_icon"));
        b.get(4).click();

        List<WebElement>c = driver.findElements(By.className("android.widget.TextView"));
        c.get(8).click();
    }
}
