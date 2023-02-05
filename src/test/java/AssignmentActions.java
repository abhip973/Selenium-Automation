import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentActions {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        driver.findElement(By.cssSelector("input#autocomplete")).sendKeys("ind");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input#autocomplete")).sendKeys(Keys.DOWN);
        driver.findElement(By.cssSelector("input#autocomplete")).sendKeys(Keys.DOWN);
        driver.findElement(By.cssSelector("input#autocomplete")).sendKeys(Keys.ENTER);


        System.out.println(driver.findElement(By.cssSelector("input#autocomplete")).getAttribute("value"));

        driver.close();
    }
}
