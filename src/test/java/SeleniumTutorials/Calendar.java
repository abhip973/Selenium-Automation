package SeleniumTutorials;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Calendar {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.path2usa.com/travel-companion/");

        String selectedDate = "23";
        String selectedMonth = "January";
        String year = "2029";

        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0,1100)");

        Thread.sleep(3000);

        driver.findElement(By.cssSelector("input[id*='travel_comp_date']")).click();

        //Setting month
        String month = driver.findElement(By.cssSelector("div.flatpickr-month")).getText();
        for (int i = 0; i < 11; i++) {
            if (month.equalsIgnoreCase(selectedMonth)) {
                break;
            } else {
                driver.findElement(By.xpath("//span[@class='flatpickr-next-month']")).click();
            }
        }


        //Setting year
        driver.findElement(By.cssSelector(".numInput.cur-year")).clear();
        driver.findElement(By.cssSelector(".numInput.cur-year")).sendKeys(year);

        //Setting Date
        List<WebElement> dates = driver.findElements(By.cssSelector(".flatpickr-day"));

        for (int i = 0; i < dates.size(); i++) {

            String date = driver.findElements(By.cssSelector(".flatpickr-day")).get(i).getText();
            if (date.equalsIgnoreCase(selectedDate)) {
                driver.findElements(By.cssSelector(".flatpickr-day")).get(i).click();
            }

        }

        driver.close();
    }
}
