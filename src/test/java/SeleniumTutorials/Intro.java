package SeleniumTutorials;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;

public class Intro {
    public static void main(String[] args){

        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

//        System.setProperty("webdriver.edge.driver","src/drivers/msedgedriver.exe");
//        WebDriver driver = new EdgeDriver();

//        System.setProperty("webdriver.gecko.driver","src/drivers/geckodriver.exe");
//        WebDriver driver = new FirefoxDriver();

        driver.get("https://rahulshettyacademy.com/");
        String title = driver.getTitle();
        System.out.println(title);
        System.out.println(driver.getCurrentUrl());

        driver.quit();

    }
}
