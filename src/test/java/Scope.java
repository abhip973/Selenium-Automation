import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Iterator;
import java.util.Set;

public class Scope {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        //Count number of links on the web page

        System.out.println(driver.findElements(By.tagName("a")).size());

        //Count number of links in the footer section
        WebElement footerDriver = driver.findElement(By.id("gf-BIG")); // Limiting the scope of driver
        System.out.println(footerDriver.findElements(By.tagName("a")).size());

        //Count number of links in the first section in the footer
        WebElement firstSection = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        int firstSectionSize = firstSection.findElements(By.tagName("a")).size();

        Actions a = new Actions(driver);
        //Click on each link in first section and check if pages are opening
        for (int i = 1; i < firstSectionSize; i++) {
            String clickOnLinkNewTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
            firstSection.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkNewTab);
            Thread.sleep(3000);
        }

        Set<String> tabs = driver.getWindowHandles();
        Iterator it = tabs.iterator();

        while (it.hasNext()) {

            driver.switchTo().window((String) it.next());
            System.out.println(driver.getTitle());

        }

        driver.quit();
    }
}
