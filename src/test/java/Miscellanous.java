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

        //To take screenshot
        TakesScreenshot screenshot = ((TakesScreenshot) driver);

        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);

        File destFile = new File("src/screenshot/test.png");

        FileUtils.copyFile(srcFile,destFile);

        driver.close();

    }
}
