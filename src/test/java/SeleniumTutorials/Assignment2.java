package SeleniumTutorials;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment2 {
    public static void main(String[] args) {
//        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");

        ChromeOptions options =new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://rahulshettyacademy.com/angularpractice/");

        driver.findElement(By.cssSelector("input[name='name']")).sendKeys("Abhi");
        driver.findElement(By.cssSelector("input[name='email']")).sendKeys("punj.abhi1@gmail.com");
        driver.findElement(By.cssSelector("#exampleInputPassword1")).sendKeys("Password");

        driver.findElement(By.cssSelector("#exampleCheck1")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("#exampleCheck1")).isSelected());

        WebElement genderDropdown = driver.findElement(By.cssSelector("#exampleFormControlSelect1"));
        Select gender = new Select(genderDropdown);

        gender.selectByVisibleText("Male");

        driver.findElement(By.cssSelector("#inlineRadio2")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("#inlineRadio2")).isSelected());

        driver.findElement(By.xpath("//input[@name='bday']")).sendKeys("08-07-1998");

        driver.findElement(By.cssSelector(".btn.btn-success")).click();

        String successAlert = driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText();

        Assert.assertTrue(successAlert.contains("Success! The Form has been submitted successfully!."));

        driver.close();
    }
}
