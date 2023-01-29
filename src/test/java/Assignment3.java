import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Assignment3 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/loginpagePractise/");

        driver.findElement(By.cssSelector("#username")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("#password")).sendKeys("learning");
        driver.findElement(By.xpath("//label[@class='customradio']/span[text()=' User']")).click();

        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='okayBtn']")));
        driver.findElement(By.xpath("//button[@id='okayBtn']")).click();

        WebElement role = driver.findElement(By.xpath("//select[@class='form-control']"));
        Select s = new Select(role);
        s.selectByVisibleText("Consultant");

        driver.findElement(By.cssSelector("input#terms")).click();
        driver.findElement(By.cssSelector("input#signInBtn")).click();

        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.btn.btn-info")));
        List<WebElement> products = driver.findElements(By.cssSelector("button.btn.btn-info"));
        System.out.println(products.size());
        for (WebElement product : products) {
            System.out.println(product.getText());
            product.click();
        }

        driver.findElement(By.cssSelector("a.nav-link.btn.btn-primary")).click();
        driver.close();

    }
}
