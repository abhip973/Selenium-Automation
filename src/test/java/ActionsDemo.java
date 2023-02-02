import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.in/");

        Actions a = new Actions(driver);

        WebElement move = driver.findElement(By.cssSelector("a#nav-link-accountList"));

        a.moveToElement(move).build().perform();

        //Key Press
        a.moveToElement(driver.findElement(By.cssSelector("#twotabsearchtextbox"))).click().
                keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();

        //Right Click on specific element
        a.moveToElement(move).contextClick().build().perform();

//        driver.close();
    }
}
