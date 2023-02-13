package SeleniumTutorials;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.support.locators.RelativeLocator.with;


public class RelativeLocators {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/angularpractice/");

        //Using above relative locator
        WebElement nameEditBox = driver.findElement(By.xpath("//input[@name='name']"));

        String nameText = driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText();

        System.out.println(nameText);

        //Using below relative locator
        WebElement dob = driver.findElement(By.xpath("//label[@for='dateofBirth']"));

        driver.findElement(with(By.xpath("//input[@name='bday']")).below(dob)).sendKeys("08-07-1998");

        //Using left relative locator
        WebElement iceCreamLabel = driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));

        driver.findElement(with(By.tagName("input")).toLeftOf(iceCreamLabel)).click();

        //Using right relative locator
        WebElement studentRadioBtn = driver.findElement(By.id("inlineRadio1"));

        System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(studentRadioBtn)).getText());

        driver.close();
    }
}
