import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Iterator;
import java.util.Set;

public class AssignmentWindowHandle {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//a[text()='Multiple Windows']")).click();

        driver.findElement(By.xpath("//a[text()='Click Here']")).click();

        Set<String> tabs = driver.getWindowHandles();
        Iterator<String> it = tabs.iterator();
        String parentWindow = it.next();
        String childWindow = it.next();

        driver.switchTo().window(childWindow);

        System.out.println(driver.findElement(By.cssSelector("div.example")).getText());

        driver.switchTo().window(parentWindow);

        System.out.println(driver.findElement(By.xpath("//div/h3")).getText());

        driver.quit();


    }
}
