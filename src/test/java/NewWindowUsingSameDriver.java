import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class NewWindowUsingSameDriver {
    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        /*
        Scenario:
        Navigate to https://rahulshettyacademy.com/angularpractice/
        Fill the "Name" field with the first course name available at https://rahulshettyacademy.com/
         */

        driver.get("https://rahulshettyacademy.com/angularpractice/");

        //This helps us to open new window using our existing driver instance
        driver.switchTo().newWindow(WindowType.TAB);

        /*Now although a new tab is opened, the driver is still present on the existing tab, we'll
        move our driver to new tab using our window handling concept
         */

        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> it = windowHandles.iterator();

        String parentWindow = it.next();
        String childWindow = it.next();

        driver.switchTo().window(childWindow);

        driver.get("https://rahulshettyacademy.com/");

        String firstCourseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();

        driver.switchTo().window(parentWindow);

        WebElement nameField = driver.findElement(By.cssSelector("input[name='name']"));

        nameField.sendKeys(firstCourseName);

        //This is used to take screenshot of a particular element
        File nameFieldScreenshot = nameField.getScreenshotAs(OutputType.FILE);

        File newFile = new File("src/screenshot/nameFieldScreenshot.png");
        FileUtils.copyFile(nameFieldScreenshot, newFile);

        //Get height and width of web element
        System.out.println(nameField.getRect().getDimension().height);
        System.out.println(nameField.getRect().getDimension().width);

        driver.quit();
    }
}
