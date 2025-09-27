package Utilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Collections;



public class Utility {
    public static void Assert (AppiumDriver driver,By locator,Boolean Expected,String Message) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Assert.assertEquals(
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator)).isEmpty(),
                Expected,Message);

    }



    public static void Click_On_Element(AppiumDriver driver, By locator) {

        new WebDriverWait(driver, Duration.ofSeconds(45)).until(ExpectedConditions.visibilityOfElementLocated(locator));

        new WebDriverWait(driver, Duration.ofSeconds(45)).until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();

    }

    public static void Element_Appears(AppiumDriver driver, By locator) {


        new WebDriverWait(driver, Duration.ofSeconds(45)).until(ExpectedConditions.elementToBeClickable(locator));


    }


    /// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void Send_Data(AppiumDriver driver, By locator, String Text) {


        new WebDriverWait(driver, Duration.ofSeconds(45)).until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).sendKeys(Text);
    }

    /// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void Scroll_Down(AppiumDriver driver) {
        Dimension size = driver.manage().window().getSize();
        int centerX = size.getWidth() / 2;
        int startY = (int) (size.getHeight() * 0.8);
        int endY = (int) (size.getHeight() * 0.2);



        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence scroll = new Sequence(finger, 4);

        scroll.addAction(finger.createPointerMove(Duration.ZERO,
                PointerInput.Origin.viewport(), centerX, startY));
        scroll.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        scroll.addAction(finger.createPointerMove(Duration.ofMillis(800), // Slightly slower scroll
                PointerInput.Origin.viewport(), centerX, endY));
        scroll.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(scroll));

        // Wait for scroll to complete using expected conditions
        try {
            new WebDriverWait(driver, Duration.ofMillis(500))
                    .until(d -> {
                        try {
                            // Check if scroll animation might still be running
                            return (Boolean) ((AppiumDriver) d).executeScript(
                                    "return document.readyState === 'complete' || " +
                                            "!window.$(':animated').length");
                        } catch (Exception e) {
                            return true; // Fallback if JavaScript check fails
                        }
                    });
        } catch (Exception e) {
            // Continue even if wait fails
        }
    }

    /// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    public static void scroll_To_Text(AppiumDriver driver, String targetText) {
        String scrollCommand =
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().descriptionContains(\"" + targetText + "\"))";

        driver.findElement(AppiumBy.androidUIAutomator(scrollCommand));
    }



    /// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void Return_To_Previous_App(AppiumDriver driver, String appPackage) {
        try {
            // Cast the driver to AndroidDriver (if using Android)
            if (driver instanceof AndroidDriver) {
                AndroidDriver androidDriver = (AndroidDriver) driver;
                androidDriver.activateApp(appPackage); // Activate the previous app
                System.out.println("Returned to the previous app: " + appPackage);
            } else {
                System.out.println("This method is only supported for Android.");
            }
        } catch (Exception e) {
            System.out.println("Failed to return to the previous app: " + e.getMessage());
        }

    }

    /// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void Custom_Scrolling_Horizontal(AppiumDriver driver, boolean scrollRight) throws InterruptedException {
        Thread.sleep(5000);
        Dimension size = driver.manage().window().getSize();
        int centerY = size.getHeight() / 2;
        int startX, endX;

        if (scrollRight) {
            // Scroll to the right (finger moves from left to right)
            startX = (int) (size.getWidth() * 0.2);
            endX = (int) (size.getWidth() * 0.8);
        } else {
            // Scroll to the left (finger moves from right to left)
            startX = (int) (size.getWidth() * 0.8);
            endX = (int) (size.getWidth() * 0.2);
        }

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence scroll = new Sequence(finger, 4);

        scroll.addAction(finger.createPointerMove(Duration.ZERO,
                PointerInput.Origin.viewport(), startX, centerY));
        scroll.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        scroll.addAction(finger.createPointerMove(Duration.ofMillis(800),
                PointerInput.Origin.viewport(), endX, centerY));
        scroll.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(scroll));

        // Wait for scroll to complete
        try {
            new WebDriverWait(driver, Duration.ofMillis(500))
                    .until(d -> {
                        try {
                            return (Boolean) ((AppiumDriver) d).executeScript(
                                    "return document.readyState === 'complete' || " +
                                            "!window.$(':animated').length");
                        } catch (Exception e) {
                            return true;
                        }
                    });
        } catch (Exception e) {
            // Continue even if wait fails
        }
    }

    /// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    public static void Scroll_Horizontal_Until_Element(AppiumDriver driver, boolean scrollRight, By elementLocator, int maxSwipes) {
        for (int i = 0; i < maxSwipes; i++) {
            try {
                if (driver.findElement(elementLocator).isDisplayed()) {
                    System.out.println("Element found after " + i + " swipes!");
                    return;
                }
            } catch (NoSuchElementException e) {
                // Perform horizontal scroll directly
                Dimension size = driver.manage().window().getSize();
                int centerY = size.getHeight() / 2;
                int startX = scrollRight ? (int)(size.getWidth() * 0.2) : (int)(size.getWidth() * 0.8);
                int endX = scrollRight ? (int)(size.getWidth() * 0.8) : (int)(size.getWidth() * 0.2);

                PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
                Sequence scroll = new Sequence(finger, 0);

                scroll.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, centerY));
                scroll.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
                scroll.addAction(finger.createPointerMove(Duration.ofMillis(800), PointerInput.Origin.viewport(), endX, centerY));
                scroll.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

                driver.perform(Collections.singletonList(scroll));
            }
        }
        throw new RuntimeException("Element not found after " + maxSwipes + " swipes!");
    }
    /// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    public static void Scroll_Vertical_To_Element(AppiumDriver driver, boolean scrollDown, By elementLocator, int maxSwipes) {
        for (int i = 0; i < maxSwipes; i++) {
            try {
                // Check if element is visible
                if (driver.findElement(elementLocator).isDisplayed()) {
                    System.out.println("Element found after " + i + " swipes!");
                    return;
                }
            } catch (NoSuchElementException e) {
                // Element not found - perform vertical swipe
                Dimension size = driver.manage().window().getSize();
                int centerX = size.getWidth() / 2;
                int startY = scrollDown ? (int)(size.getHeight() * 0.8) : (int)(size.getHeight() * 0.2);
                int endY = scrollDown ? (int)(size.getHeight() * 0.2) : (int)(size.getHeight() * 0.8);

                PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
                Sequence scroll = new Sequence(finger, 0);

                scroll.addAction(finger.createPointerMove(Duration.ZERO,
                        PointerInput.Origin.viewport(), centerX, startY));
                scroll.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
                scroll.addAction(finger.createPointerMove(Duration.ofMillis(800),
                        PointerInput.Origin.viewport(), centerX, endY));
                scroll.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

                driver.perform(Collections.singletonList(scroll));

                // Small delay between swipes
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        throw new RuntimeException("Element not found after " + maxSwipes + " swipes!");
    }

    public static void Searching (AppiumDriver driver,By locator,String Search_Data) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        new WebDriverWait(driver, Duration.ofSeconds(45)).until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
        driver.findElement(locator).sendKeys(Search_Data);


    }

}





