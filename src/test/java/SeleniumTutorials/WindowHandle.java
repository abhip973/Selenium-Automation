package SeleniumTutorials;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class WindowHandle {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/loginpagePractise/");

        driver.findElement(By.xpath("//a[@class='blinkingText']")).click();

        //Gets all the separate tabs present in the driver
        Set<String> windows = driver.getWindowHandles();

        //An Iterator is an object that can be used to loop through collections
        Iterator<String> it = windows.iterator();

        /*We can iterate through set using next function, by default the iterator is out of scope,
        so first time next will be used, it will go inside the set
         */
        String parentWindow = it.next();
        String childWindow = it.next();

        driver.switchTo().window(childWindow);

        String text = driver.findElement(By.cssSelector("p.im-para.red")).getText();

        String email = text.split("at ")[1].split(" with")[0];

        driver.switchTo().window(parentWindow);

        driver.findElement(By.cssSelector("input#username")).sendKeys(email);

    }
}
