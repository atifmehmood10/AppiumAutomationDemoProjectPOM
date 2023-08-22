package ekarDemoApp.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static ekarDemoApp.EkarTestBase.getAndroidDriver;
import static ekarDemoApp.utilities.WaitsUtils.waitForElementPresence;
import static ekarDemoApp.utilities.WaitsUtils.waitForSeconds;

public class DocumentsUploadPage {

    private static AndroidDriver driver;

    By frontSideImage = By.id("in.testdemo.map:id/front_img");
    By backSideImage = By.id("in.testdemo.map:id/back_img");
    By rightSideImage = By.id("in.testdemo.map:id/left_img");
    By leftSideImage = By.id("in.testdemo.map:id/right_img");

    By commentBoxLocator = By.id("in.testdemo.map:id/cmd_txt");

    By submitButtonLocator = By.id("in.testdemo.map:id/next_btn");
    By errorMessageImagesMissing = By.xpath("/hierarchy/android.widget.Toast");


    public DocumentsUploadPage(AndroidDriver androidDriver){
        this.driver = androidDriver;
        PageFactory.initElements(androidDriver, this);
    }

    @Step("Wait for second screen to load")
    public void waitForScreenToLoad(){
        waitForElementPresence(getAndroidDriver(), 15,frontSideImage);
    }

    @Step("Get image icons")
    public boolean getImagesUploadIcons(){
        WebElement frontImageElem = driver.findElement(frontSideImage);
        WebElement backImageElem = driver.findElement(backSideImage);
        WebElement rightImageElem = driver.findElement(rightSideImage);
        WebElement leftImageElem = driver.findElement(leftSideImage);

        if( frontImageElem.isDisplayed() &&
            backImageElem.isDisplayed() &&
            rightImageElem.isDisplayed() &&
            leftImageElem.isDisplayed()){
            return true;
        }else{
            return false;
        }

    }

    @Step("Click submit button")
    public void clickSubmitButton(){
        getAndroidDriver().findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"NEXT\").instance(0))"));
        WebElement submitButton = getAndroidDriver().findElement(submitButtonLocator);
        submitButton.click();
    }

    @Step("Add comment")
    public void addComment(){
        WebElement commentBox = getAndroidDriver().findElement(commentBoxLocator);
        commentBox.sendKeys("Should give error if no images are passed");
    }


    @Step("Verify Error message")
    public String getErrorMessage(){
        clickSubmitButton();
        WebElement toastMessage = getAndroidDriver().findElement(errorMessageImagesMissing);
        return toastMessage.getText();
    }

    @Step("Upload all photos")
    public void uploadAllPhotos(){
        uploadImage(frontSideImage);
        waitForScreenToLoad();
        uploadImage(backSideImage);
        waitForScreenToLoad();
        uploadImage(rightSideImage);
        waitForScreenToLoad();
        uploadImage(leftSideImage);
        waitForScreenToLoad();
    }

    private void uploadImage(By imageSideLocator){
        WebElement imageSideElem = getAndroidDriver().findElement(imageSideLocator);
        imageSideElem.click();
        By galleryLocator = By.xpath("//android.widget.FrameLayout//android.widget.TextView[@text='Select image from gallery']");
        waitForElementPresence(getAndroidDriver(), 5,galleryLocator);

        WebElement getFromGallery = getAndroidDriver().findElement(galleryLocator);
        getFromGallery.click();
        waitForSeconds(2);

        By folderLocator = By.xpath("//android.widget.TextView[@text='sdk_gphone64_x86_64']");
        WebElement folderElem = getAndroidDriver().findElement(folderLocator);
        folderElem.click();
        waitForSeconds(3);

        By imageLocator = By.xpath("//android.view.ViewGroup[contains(@content-desc,'Photo taken on ')]");
        WebElement imageElem = getAndroidDriver().findElement(imageLocator);
        imageElem.click();
        waitForSeconds(3);
    }

}
