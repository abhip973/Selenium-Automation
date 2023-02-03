import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AssignmentDynamic {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        driver.findElement(By.xpath("//div[@id='checkbox-example']//label[3]/input")).click();
        String label = driver.findElement(By.xpath("//div[@id='checkbox-example']//label[3]")).getText();
        
        WebElement drp = driver.findElement(By.cssSelector("select#dropdown-class-example"));
        drp.click();
        Select dropdown = new Select(drp);

        dropdown.selectByVisibleText(label);

        driver.findElement(By.cssSelector("input#name")).sendKeys(label);
        driver.findElement(By.cssSelector("input#alertbtn")).click();

        String alertText = driver.switchTo().alert().getText();
        Assert.assertTrue(alertText.contains(label));


    }
}
