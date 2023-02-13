package SeleniumTutorials;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class BrokenLinks {
    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        //Soft Assertion declaration
        SoftAssert a = new SoftAssert();

        //Broken links are nothing but broken URLs

        List<WebElement> links = driver.findElements(By.xpath("//li[@class='gf-li']/a"));

        for (WebElement link : links) {

            String url = link.getAttribute("href");
            URL conn = new URL(url);
            HttpURLConnection urlConnection = (HttpURLConnection) conn.openConnection();
            urlConnection.connect();

            int respCode = urlConnection.getResponseCode();

            a.assertTrue(respCode < 400, "The link with broken URL is " + link.getText() + " with status code " + respCode);

        }

        //To view our soft assertion failures at the end
        a.assertAll();

        driver.close();
    }
}
