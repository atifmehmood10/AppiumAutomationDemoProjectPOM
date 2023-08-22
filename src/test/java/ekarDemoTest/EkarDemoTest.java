package ekarDemoTest;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import static ekarDemoApp.pages.MyPages.documentsUploadPage;
import static ekarDemoApp.pages.MyPages.homePage;

@Epic("Demo Tests")
@Feature("Ekar Demo")
public class EkarDemoTest extends BaseTest{

    @Test(priority = 4, testName = "User Location", description = "Image upload scenario")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Description: User navigates to image upload screen and uploads images")
    @Story("User navigates to image upload screen")
    public static void verifyUserLocation(){
        String location = homePage.getLocationFromLocatedPin();
        Assert.assertEquals(location, "Google Building 43, Mountain View, CA 94043, USA. ");
    }

    @Test(priority = 3, testName = "Verify 4 image icons are showing")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Description: User is able to see 4 image icons")
    @Story("User verifies 4 image icons")
    public static void userVerifiesImageIcons(){
        homePage.tapOnLocatedPin();
        documentsUploadPage.waitForScreenToLoad();
        boolean imagesTiles = documentsUploadPage.getImagesUploadIcons();
        Assert.assertEquals(imagesTiles, true);
    }

    @Test(priority = 2, testName = "Verify user cannot proceed without uploading images")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Description: User cannot proceed without uploading images")
    @Story("User cannot proceed without uploading images")
    public static void userCannotProceedWithoutUploadingImages(){
        homePage.tapOnLocatedPin();
        documentsUploadPage.waitForScreenToLoad();
        documentsUploadPage.addComment();
        String errorMessage = documentsUploadPage.getErrorMessage();
        Assert.assertEquals(errorMessage, "Please choose front Image");
    }

    @Test(priority = 1, testName = "Verify user can upload photos and process")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Description: Verify user can upload photos and process")
    @Story("Verify user can upload photos and process")
    public static void userUploadsPhotosAndSubmit(){
        homePage.tapOnLocatedPin();
        documentsUploadPage.waitForScreenToLoad();
        documentsUploadPage.uploadAllPhotos();
        documentsUploadPage.addComment();
        documentsUploadPage.clickSubmitButton();
        String successToast = homePage.getSuccessToastAfterImageUpload();
        Assert.assertEquals(successToast, "Complaint Accepted");
    }
    
}
