package SeleniumTutorials;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class DynamicDropdown {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        driver.findElement(By.xpath("(//span[contains(@id,'originStation')])[1]")).click();
        driver.findElement(By.linkText("Amritsar (ATQ)")).click();

        Thread.sleep(2000);

        driver.findElement(By.linkText("Guwahati (GAU)")).click();

    }
}
