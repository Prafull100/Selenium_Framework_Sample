package Utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Helper {

    //screenShots, Alerts, Windows, Frames, Sync issues, javaScript Executor

    public static String captureScreenShots(WebDriver driver) {

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenShotPath = System.getProperty("user.dir") + "/ScreenShots/DMP" + getCurrentDateTime() + ".png";
        try {
            FileHandler.copy(src, new File(screenShotPath));
            System.out.println("ScreenShot Captured");
        } catch (Exception e) {
            System.out.println("Enable to capture ScreenShot" + e.getMessage());
        }
        return screenShotPath;
    }

    public static String getCurrentDateTime() {

        DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
        Date currentDate = new Date();
        return customFormat.format(currentDate);
    }
}
