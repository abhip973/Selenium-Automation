import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Calendar {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.path2usa.com/travel-companion/");

        String selectedDate = "23";
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0,1100)");

        Thread.sleep(3000);

        driver.findElement(By.cssSelector("input[id*='travel_comp_date']")).click();


        List<WebElement> dates = driver.findElements(By.cssSelector(".flatpickr-day"));

        for (int i = 0; i < dates.size(); i++) {

            String date = driver.findElements(By.cssSelector(".flatpickr-day")).get(i).getText();
            if (date.equalsIgnoreCase(selectedDate)) {
                driver.findElements(By.cssSelector(".flatpickr-day")).get(i).click();
            }

        }

    }
}
