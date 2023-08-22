package ekarDemoApp.pages;
import ekarDemoApp.EkarTestBase;


public class MyPages extends EkarTestBase {

    public static HomePage homePage;
    public static DocumentsUploadPage documentsUploadPage;

    public static void initializeAllPages(){
        homePage = new HomePage(getAndroidDriver());
        documentsUploadPage = new DocumentsUploadPage(getAndroidDriver());
    }

}
