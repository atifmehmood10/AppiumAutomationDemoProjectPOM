package ekarDemoApp.pages;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static ekarDemoApp.utilities.WaitsUtils.waitForElementPresence;


public class HomePage extends MyPages {

//    private By locatedPinByLocator = By.xpath("//android.view.View[contains(@content-desc,'Google Building 43, Mountain View, CA 94043, USA. ')]");
    private By locatedPinByLocator = By.xpath("//android.view.View[@content-desc=\"Google Map\"]//android.view.View[1]");

    private By complaintSuccessToast = By.xpath("/hierarchy/android.widget.Toast");

    private AndroidDriver driver;

    public HomePage(AndroidDriver androidDriver){
        this.driver = androidDriver;
        PageFactory.initElements(androidDriver, this);
    }

    @Step("Get Location from Pin")
    public String getLocationFromLocatedPin() {
        waitForElementPresence(getAndroidDriver(), 15,locatedPinByLocator);
        WebElement locatedPin = getAndroidDriver().findElement(locatedPinByLocator);
        return locatedPin.getAttribute("content-desc");
    }

    @Step("Click pin on map")
    public void tapOnLocatedPin() {
        waitForElementPresence(getAndroidDriver(), 30,locatedPinByLocator);
        WebElement locatedPin = getAndroidDriver().findElement(locatedPinByLocator);
        locatedPin.click();
    }


    @Step("Get success toast after image upload")
    public String getSuccessToastAfterImageUpload(){
        waitForElementPresence(getAndroidDriver(),5,complaintSuccessToast);
        WebElement complaintSuccessToastElem = getAndroidDriver().findElement(complaintSuccessToast);
        return complaintSuccessToastElem.getText();
    }


}
