package SeleniumTutorials;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;


public class JavaScriptExecutionDemo {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Scroll the window
        js.executeScript("window.scrollBy(0,500)");

        Thread.sleep(3000);

        //Scroll specific table inside DOM
        js.executeScript("document.querySelector('.tableFixHead').scrollTop = 500");

        List<WebElement> values = driver.findElements(By.cssSelector("div[class='tableFixHead'] tr td:nth-child(4)"));

        int total = 0;
        for (WebElement value : values) {

            total = total + Integer.parseInt(value.getText());
        }

        String amountCollected = driver.findElement(By.cssSelector("div.totalAmount")).getText();
        int amount = Integer.parseInt(amountCollected.split(":")[1].trim());

        Assert.assertEquals(amount, total);


        driver.close();
    }
}
