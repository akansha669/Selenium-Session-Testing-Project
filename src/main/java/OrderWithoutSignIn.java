import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class OrderWithoutSignIn {
    public static void main(String [] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.findElement(By.id("search_query_top")).sendKeys("DRESS", Keys.ENTER);
        //select product
        driver.findElement(By.cssSelector("a[title='Printed Summer Dress']")).click();
        //choose quantity
        driver.findElement(By.cssSelector("i[class='icon-plus']")).click();
        //Choose size
        Select size = new Select(driver.findElement(By.id("group_1")));
        size.selectByValue("2");
        //Choose color
        driver.findElement(By.cssSelector("ul[id='color_to_pick_list'] li:nth-of-type(2)")).click();
        //add to cart
        driver.findElement(By.cssSelector("p[id='add_to_cart'] button")).click();
        //proceed to checkout
        driver.findElement(By.cssSelector("a[title='Proceed to checkout']")).click();
        //checkout summary
        driver.findElement(By.cssSelector("p.cart_navigation a:nth-of-type(1)")).click();
        Thread.sleep(20000L);
        //Validating that now its taken to Log-In page
        String validate=driver.findElement(By.cssSelector("span[class='navigation_page']")).getText();
        String expected="Authentication";
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(validate,expected);
        System.out.println("It is taking to Login Page");
        Thread.sleep(1000L);
        driver.quit();
    }
}
