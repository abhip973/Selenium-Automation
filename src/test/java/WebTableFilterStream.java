import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class WebTableFilterStream {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        //Sending Rice in search field
        driver.findElement(By.id("search-field")).sendKeys("Rice");

        //Getting all products name after filtering
        List<WebElement> veggies = driver.findElements(By.xpath("//tr/td[1]"));

        //Filtering out the items from our veggies list containing Rice
        List<WebElement> filteredList = veggies.stream().filter(veggie -> veggie.getText().contains("Rice")).collect(Collectors.toList());

        //Comparing both our lists sizes in order to ensure we have same size lists, which proves the filter functionality is working as expected
        Assert.assertTrue(veggies.size()==filteredList.size());

        driver.close();
    }
}
