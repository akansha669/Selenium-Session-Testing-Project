import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class ContactSupport {
    public static void main(String [] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //sign-in
        driver.findElement(By.cssSelector("input[id='email']")).sendKeys("akansha.singh@tothenew.com");
        driver.findElement(By.cssSelector("input[id='passwd']")).sendKeys("eep@123");
        driver.findElement(By.cssSelector("button[id='SubmitLogin']")).click();

        driver.findElement(By.cssSelector("a[title='Contact Us']")).click();
        //heading
        Select heading= new Select(driver.findElement(By.id("id_contact")));
        heading.selectByValue("2");
        //order reference
        Select orederef= new Select(driver.findElement(By.cssSelector("select[name='id_order']")));
        orederef.selectByValue("300462");
        // select product
        Select product= new Select(driver.findElement(By.id("300462_order_products")));
        product.selectByVisibleText("Blouse - Color : Black, Size : S");
        //file upload
        WebElement element=driver.findElement(By.xpath("//div[@id='uniform-fileUpload']/input[@id='fileUpload']"));
        element.sendKeys("/home/ttn/Downloads/Selenium_session-master/Hello.txt");
        //message
        driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys("I want color: White");
        driver.findElement(By.xpath("//button[@name='submitMessage']")).click();
        Thread.sleep(2000L);


    }
}
