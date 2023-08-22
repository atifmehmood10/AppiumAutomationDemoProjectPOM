package ekarDemoApp;

import ekarDemoApp.utilities.PropertiesUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static ekarDemoApp.constants.StringConstants.*;
import static ekarDemoApp.pages.MyPages.initializeAllPages;
import static ekarDemoApp.utilities.PropertiesUtils.properties;

public abstract class EkarTestBase {

    public static AndroidDriver androidDriver;


    public static void createAndroidDriver(){
        properties = PropertiesUtils.getConfig();
        //Set up desired capabilities and pass the Android app-activity and app-package to Appium

        File rootPath = new File(System.getProperty("user.dir"));
        File appFolder = new File(rootPath, properties.getProperty(ANDROID_APP_PATH));
        File app = new File(appFolder, "ekar-app-demo.apk");

        UiAutomator2Options options = new UiAutomator2Options();
        options.setUdid((String) properties.get(DEVICE_UDID));
        options.setCapability("appium:app", app.getAbsolutePath());

        options.setCapability("appium:appPackage", "in.testdemo.map");
        options.setCapability("appium:appActivity", "in.testdemo.map.MainActivity");
        options.setCapability("appium:automationName", "uiautomator2");
        options.setCapability("appium:autoGrantPermissions", true);
        options.fullReset();
        options.setCapability("platformName", properties.get(PLATFORM_NAME));
        options.setCapability("appium:platformVersion", properties.get(PLATFORM_VERSION));
        File imageFile = new File(rootPath, properties.getProperty(SAMPLE_IMAGE_PATH));
        try {
            androidDriver = new AndroidDriver(new URL(LOCAL_APPIUM_URL), options);
            androidDriver.pushFile("/sdcard/demo.png",imageFile);
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }catch (IOException ioException){
            ioException.printStackTrace();
        }


        initializeAllPages();
    }

    public static AndroidDriver getAndroidDriver(){
        return androidDriver;
    }

    public static void quitAndroidDriver(){
        getAndroidDriver().quit();
    }

}
