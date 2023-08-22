package ekarDemoApp.utilities;


import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.util.Arrays;

import static ekarDemoApp.EkarTestBase.getAndroidDriver;
import static java.time.Duration.ofMillis;
import static org.openqa.selenium.interactions.PointerInput.Kind.TOUCH;
import static org.openqa.selenium.interactions.PointerInput.MouseButton.LEFT;
import static org.openqa.selenium.interactions.PointerInput.Origin.viewport;

public class GestureUtils {

    public static void scroll(AndroidDriver driver) {
        PointerInput FINGER = new PointerInput(TOUCH, "finger");

        Dimension dimensions = getAndroidDriver().manage().window().getSize();
        Dimension endDimension = new Dimension((int) (dimensions.getWidth() * 0.5), (int)(dimensions.getHeight() * 0.5));
        int duration = 1000;

        Sequence swipe = new Sequence(FINGER, 1)
                .addAction(FINGER.createPointerMove(ofMillis(0), viewport(), dimensions.getHeight(), dimensions.getWidth()))
                .addAction(FINGER.createPointerDown(LEFT.asArg()))
                .addAction(FINGER.createPointerMove(ofMillis(duration), viewport(), endDimension.getHeight(), endDimension.getWidth()))
                .addAction(FINGER.createPointerUp(LEFT.asArg()));

        driver.perform(Arrays.asList(swipe));
    }
}
