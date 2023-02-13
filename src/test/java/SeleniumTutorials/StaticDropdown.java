package SeleniumTutorials;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropdown {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        WebElement element = driver.findElement(By.cssSelector("select[id*='DropDownListCurrency']"));
        Select dropdown = new Select(element);

        dropdown.selectByIndex(3);
        System.out.println(dropdown.getFirstSelectedOption().getText());

        dropdown.selectByValue("AED");
        System.out.println(dropdown.getFirstSelectedOption().getText());

        dropdown.selectByVisibleText("INR");
        System.out.println(dropdown.getFirstSelectedOption().getText());


        System.out.println(driver.findElement(By.cssSelector("#divpaxinfo")).getText());

        driver.findElement(By.cssSelector("#divpaxinfo")).click();
        Thread.sleep(2000);

        int i = 1;
        while (i < 5) {
            driver.findElement(By.id("hrefIncAdt")).click();
            i++;
        }

        System.out.println(driver.findElement(By.cssSelector("#divpaxinfo")).getText());

    }
}
