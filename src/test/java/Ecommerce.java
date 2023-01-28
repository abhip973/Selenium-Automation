import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

public class Ecommerce {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String[] vegetables = {"Cucumber", "Brocolli", "Apple"};

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

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

        driver.close();
    }
}
