package SeleniumTutorials;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentFrames {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/");

        driver.findElement(By.xpath("//a[text()='Nested SeleniumTutorials.Frames']")).click();

        //Control is on top frame
        driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-top']")));

        //Control is moved to inner frame
        driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-middle']")));

        //Gets text from middle frame
        String text = driver.findElement(By.cssSelector("div#content")).getText();
        System.out.println(text);

        driver.close();
    }
}
