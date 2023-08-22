package ekarDemoApp.utilities;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitsUtils {

    public static void waitForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void waitForElementPresence(AndroidDriver driver, int timeLimitInSeconds, By elementLocator){

        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeLimitInSeconds));
            wait.until(ExpectedConditions.presenceOfElementLocated(elementLocator));
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
