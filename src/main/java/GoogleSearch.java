import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class GoogleSearch {
    public static void main(String [] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.google.com/");
        WebElement search=driver.findElement(By.xpath("//input[@title='Search']"));
        search.sendKeys("Phone Cases");
        Thread.sleep(2000L);
        search.sendKeys(Keys.ENTER);
        Thread.sleep(2000L);
        driver.navigate().back();
        Thread.sleep(2000L);
        driver.quit();

    }
}
