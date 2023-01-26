import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class AutoSuggestiveDropdowns {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.id("autosuggest")).sendKeys("ind");
        Thread.sleep(2000);

        List<WebElement> elements = driver.findElements(By.xpath("//li[@class='ui-menu-item']"));

        for(WebElement element: elements){

            System.out.println(element.getText());

            if(element.getText().equals("India")){
                element.click();
                break;
            }
        }

        //To count number of checkboxes

        System.out.println(driver.findElements(By.cssSelector("div[class*='home-Discount']")).size());

        System.out.println(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
        driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
        System.out.println(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());

        //Selecting round trip radio button
        driver.findElement(By.xpath("(//table[@id='ctl00_mainContent_rbtnl_Trip']/tbody/tr/td)[2]")).click();


        //Verifying if on clicking round trip return date gets enabled
        String styleAttr = driver.findElement(By.xpath("//input[@id='ctl00_mainContent_view_date2']/parent::div")).getAttribute("style");
        String[] opacity = styleAttr.split("opacity: ");
        String[] opacityValue = opacity[1].split(";");
        Assert.assertEquals(opacityValue[0],"1");

        Thread.sleep(1000);
        //Selecting current date
        driver.findElement(By.cssSelector("#ctl00_mainContent_view_date1")).click();
        driver.findElement(By.xpath("//a[contains(@class,'ui-state-highlight')]")).click();

        driver.close();
    }
}
