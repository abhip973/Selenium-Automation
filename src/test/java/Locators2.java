import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locators2 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

//        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        Locators2 locators2 = new Locators2();
        String password = locators2.getPassword(driver);

        String name = "Abhi";
        driver.findElement(By.cssSelector("#inputUsername")).sendKeys(name);
        driver.findElement(By.xpath("//input[contains(@type,'pass')]")).sendKeys(password);

        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#chkboxOne")).click();
        driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
        Thread.sleep(2000);

        String successMsg = driver.findElement(By.tagName("p")).getText();
        Assert.assertEquals(successMsg, "You are successfully logged in.");

        String greetMsg = driver.findElement(By.xpath("//div[@class='login-container']/h2")).getText();
        Assert.assertEquals(greetMsg, "Hello " + name + ",");

        driver.findElement(By.xpath("//button[text()='Log Out']"));

        driver.close();
    }

    public String getPassword(WebDriver driver) throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();

        String pwd = driver.findElement(By.cssSelector("form p")).getText();
        String pwdSplit1[] = pwd.split("'");
        String password = pwdSplit1[1].split("'")[0];
        driver.findElement(By.cssSelector("button[class*='login-btn']")).click();

        return password;

    }

}
