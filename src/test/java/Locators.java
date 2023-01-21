import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Locators {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //implicit wait implemented
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys("dummyUserName");
        driver.findElement(By.name("inputPassword")).sendKeys("dummyPassword");
        driver.findElement(By.className("submit")).click();
        String errorText = driver.findElement(By.cssSelector("p.error")).getText();
        System.out.println(errorText);
        driver.quit();
    }
}
