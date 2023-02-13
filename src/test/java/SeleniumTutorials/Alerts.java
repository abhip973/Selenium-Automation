package SeleniumTutorials;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Alerts {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String name = "Abhi";
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        driver.findElement(By.cssSelector("#name")).sendKeys(name);
        driver.findElement(By.xpath("//input[@id='alertbtn']")).click();

        //Handling alert with single option
        String actualAlert = driver.switchTo().alert().getText();
        Assert.assertTrue(actualAlert.contains("Hello Abhi, share this practice page and share your knowledge"));

        driver.switchTo().alert().accept();

        //Handling alert with multiple option
        driver.findElement(By.cssSelector("#name")).sendKeys(name);
        driver.findElement(By.xpath("//input[@id='confirmbtn']")).click();

        String confirmAlert = driver.switchTo().alert().getText();
        Assert.assertTrue(confirmAlert.contains("Hello Abhi, Are you sure you want to confirm?"));

        driver.switchTo().alert().dismiss();

        driver.close();


    }
}
