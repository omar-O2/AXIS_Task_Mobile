package Utilities;
import io.appium.java_client.*;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.appium.java_client.AppiumDriver;


public class Slider {



        public static void setSeekBarPercentage(AppiumDriver driver,int targetPercentage) {
            // Locate the seekbar using accessibility ID
            WebElement seekBar = driver.findElement(By.xpath("//android.widget.SeekBar[@content-desc=\"100%\"]"));

            // Get seekbar dimensions
            int startX = seekBar.getLocation().getX();
            int endX = startX + seekBar.getSize().getWidth();
            int yPos = seekBar.getLocation().getY() + (seekBar.getSize().getHeight() / 2);

            // Calculate target position (ensure percentage is 0-100)
            targetPercentage = Math.max(0, Math.min(100, targetPercentage));
            int targetX = startX + ((endX - startX) * targetPercentage / 100);

            // Perform the slide action
            new TouchAction<>((PerformsTouchActions) driver)
                    .press(PointOption.point(startX, yPos))
                    .waitAction() // small pause
                    .moveTo(PointOption.point(targetX, yPos))
                    .release()
                    .perform();
        }
}



