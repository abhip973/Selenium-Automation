package SeleniumTutorials;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;


import java.io.File;
import java.io.IOException;

public class Miscellanous {
    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //To maximize the window
        driver.manage().window().maximize();

        //To delete all cookies
        driver.manage().deleteAllCookies();

        //To delete specific cookie
        driver.manage().deleteCookieNamed("TestCookie");

        driver.get("https://www.google.com/");

        //Steps to take screenshot

        //Casting driver object to TakeScreenshot method
        TakesScreenshot screenshot = ((TakesScreenshot) driver);

        //Now, we'll capture our screenshot and store it in our source file
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);

        //Now, we'll create a new file in our destination folder
        File destFile = new File("src/screenshot/test.png");

        //Now, we'll copy our source file to our destination, so we can see it in the folder
        FileUtils.copyFile(srcFile,destFile);

        driver.close();

    }
}
