import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentJavaScriptExecutor {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600)");

        int rows = driver.findElements(By.cssSelector("table[name='courses'] tr")).size();
        int columns = driver.findElements(By.cssSelector("table[name='courses'] tr th")).size();
        String secondRow = driver.findElements(By.cssSelector("table[name='courses'] tr")).get(2).getText();

        System.out.println("Number of Rows: " + rows);
        System.out.println("Number of Columns: " + columns);
        System.out.println("Content of Second Row: " + secondRow);

        driver.close();
    }
}
