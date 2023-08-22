package ekarDemoTest;

import ekarDemoApp.EkarTestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends EkarTestBase {

    @BeforeMethod(alwaysRun = true)
    public void setup(){
        createAndroidDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        quitAndroidDriver();
    }

}
