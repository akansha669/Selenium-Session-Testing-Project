import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class Login {
    public static void main(String [] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        driver.findElement(By.cssSelector("input[id='email']")).sendKeys("akansha.singh@tothenew.com");
        driver.findElement(By.cssSelector("input[id='passwd']")).sendKeys("eep@123");
        Thread.sleep(1000L);
        driver.findElement(By.cssSelector("button[id='SubmitLogin']")).click();
        //Ordering dress
        driver.findElement(By.xpath("//a[@title='Women']")).click();
        //selecting dress
        driver.findElement(By.xpath("//img[@title='Blouse']")).click();
        //switch to iframe
        driver.switchTo().frame(0);
        //adding to cart
        driver.findElement(By.xpath("//p[@id='add_to_cart']//button")).click();
        //proceed to checkout
        driver.switchTo().defaultContent();
        driver.findElement(By.cssSelector("a[title='Proceed to checkout']")).click();
        driver.findElement(By.xpath("//p/a[@title='Proceed to checkout']")).click();
        driver.findElement(By.xpath("//button[@name='processAddress']//span")).click();
        //agree and continue
        driver.findElement(By.cssSelector("input[name='cgv']")).click();
        driver.findElement(By.xpath("//button[@name='processCarrier']")).click();
        //Payment
        driver.findElement(By.cssSelector("a[class='bankwire']")).click();
        driver.findElement(By.xpath("//p[@id='cart_navigation']/button")).click();
        //Validation order confirmation title
        SoftAssert softAssert=new SoftAssert();
        String expectedTitle="Order confirmation-My Store";
        String actualTitle=driver.getTitle();
        Thread.sleep(2000L);
        softAssert.assertEquals(actualTitle,expectedTitle);
        System.out.println("Order Confirmed!");
        Thread.sleep(2000L);

        driver.quit();
    }
}
