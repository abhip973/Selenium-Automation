import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class Ecommerce {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //Explicit wait declaration
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));

        //Implicit wait
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        String[] vegetables = {"Cucumber", "Brocolli", "Apple"};

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");


        addProducts(driver, vegetables);

        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();

        //Explicit wait usage
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");

        driver.findElement(By.cssSelector("button.promoBtn")).click();

        //Explicit wait usage
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());

        driver.close();
    }

    public static void addProducts(WebDriver driver, String[] vegetables) {
        List<WebElement> elementList = driver.findElements(By.cssSelector("h4.product-name"));
        int index = 0;
        int j = 0;
        for (WebElement element : elementList) {
            String name = element.getText();
            String[] extractedNames = name.split(" -");

            List veggies = Arrays.asList(vegetables);

            if (veggies.contains(extractedNames[0])) {
                j++;
                driver.findElements(By.xpath("(//div[@class='product'])/div[@class='product-action']/button")).get(index).click();
            }
            if (vegetables.length == j) {
                break;
            }
            index++;
        }
    }
}
