package SeleniumTutorials;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TableSortingUsingStreams {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

        driver.findElement(By.xpath("//a[@href='#/offers']")).click();

        Set<String> windowsHandles = driver.getWindowHandles();
        Iterator<String> iterator = windowsHandles.iterator();

        String parentWindow = iterator.next();
        String childWindow = iterator.next();

        driver.switchTo().window(childWindow);

        //User clicks on column header
        driver.findElement(By.cssSelector("span.sort-icon.sort-descending")).click();

        //User fetches the web elements list
        List<WebElement> fruitNamesElementList = driver.findElements(By.xpath("//table[contains(@class,'table-bordered')]/tbody/tr/td[1]"));

        //User fetches the fruits names list from the table
        List<String> fruitNamesList = fruitNamesElementList.stream().map(s -> s.getText()).collect(Collectors.toList());

        //User performs sorting on our fruitNamesList
        List<String> sortedList = fruitNamesList.stream().sorted().collect(Collectors.toList());
        System.out.println(fruitNamesList);

        //User asserts after sorting the sorted list and our original list collected are same
        Assert.assertTrue(sortedList.equals(fruitNamesList));

        //Print the price of Rice in the output
        //We are do-while loop concept to check if our product is not found in the current page, and if not found we are performing pagination

        List<String> price;
        do {
            /*Creating a duplicate of fruitNamesElementList as the list is declared outside and we need to fetch the elements for new page in a loop, hence
            created fruitNamesElementList1.
             */


            List<WebElement> fruitNamesElementList1 = driver.findElements(By.xpath("//table[contains(@class,'table-bordered')]/tbody/tr/td[1]"));
            price = fruitNamesElementList1.stream().filter(s -> s.getText().equalsIgnoreCase("Rice")).map(s -> getPrice(s)).collect(Collectors.toList());
            price.stream().forEach(s -> System.out.println(s));

            //Performing pagination if the product is not found on current page.
            if (price.size() < 1) {
                driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
                Thread.sleep(1000);
            }
        } while (price.size() < 1);

        driver.quit();
    }

    public static String getPrice(WebElement s) {
        //We are going inside the scope of element to fetch the price of the filtered element
        String price = s.findElement(By.xpath("following-sibling::td[1]")).getText();
        return price;

    }
}
