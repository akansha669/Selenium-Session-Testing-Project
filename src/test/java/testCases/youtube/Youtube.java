package testCases.youtube;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Youtube {

    static String idSearchBox = "search";
    static String idSearchButton = "search-icon-legacy";
    static String xpathFirstResult = "(.//div[@id='contents']/ytd-video-renderer//a)[1]";


    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.youtube.com");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id(idSearchBox)).click();
        driver.findElement(By.id(idSearchBox)).sendKeys("Beagle Puppies");
        driver.findElement(By.id(idSearchButton)).click();
        driver.findElement(By.xpath(xpathFirstResult)).click();
    }
}
