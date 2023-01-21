import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Locators {
    public static void main(String[] args) throws InterruptedException {
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

        driver.findElement(By.linkText("Forgot your password?")).click();
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("dummyUserName");
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("dummyEmail");
        driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
        driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("correctDummyEmail");
        driver.findElement(By.xpath("//form/input[3]")).sendKeys("95602");
        driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
        System.out.println(driver.findElement(By.cssSelector("form p")).getText());
        driver.findElement(By.cssSelector("button[class*='login-btn']")).click();

        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#inputUsername")).sendKeys("Abhi");
        driver.findElement(By.xpath("//input[contains(@type,'pass')]")).sendKeys("rahulshettyacademy");

        driver.findElement(By.cssSelector("#chkboxOne")).click();
        driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();

        driver.quit();
    }
}
