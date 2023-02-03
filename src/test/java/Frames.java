import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Frames {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://jqueryui.com/droppable/");

        //Switch control to the frame
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));

        Actions a = new Actions(driver);

        WebElement source = driver.findElement(By.cssSelector("div#draggable"));
        WebElement target = driver.findElement(By.cssSelector("div#droppable"));
        a.dragAndDrop(source, target).build().perform();

        //Switch control back to original window
        driver.switchTo().defaultContent();

        driver.close();

    }
}
