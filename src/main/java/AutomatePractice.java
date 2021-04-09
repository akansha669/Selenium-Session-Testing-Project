import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class AutomatePractice {
    public static void main(String [] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        //adding first vegetable's 2 quantities
        driver.findElement(By.xpath("//div[@class='product'][2]//a[@class='increment']")).click();
        driver.findElement(By.xpath("//div[@class='product'][2]//div[@class='product-action']")).click();
        //adding second vegetables 3 quantities
        driver.findElement(By.xpath("//div[@class='product'][1]//a[@class='increment']")).click();
        driver.findElement(By.xpath("//div[@class='product'][1]//a[@class='increment']")).click();
        driver.findElement(By.xpath("//div[@class='product'][1]//div[@class='product-action']")).click();
        //going to cart
        driver.findElement(By.xpath("//a[@class='cart-icon']//img[@class=' ']")).click();
        //Proceed to checkout
        driver.findElement(By.xpath("//div[@class='action-block']//button[@class=' ']")).click();
        //Validating total Amount
        SoftAssert softAssert=new SoftAssert();
        int actual_Amount= Integer.parseInt(driver.findElement(By.cssSelector("span[class='discountAmt']")).getText());
        Thread.sleep(2000L);
        int expected_Amount=480;
        softAssert.assertEquals(actual_Amount,expected_Amount);
        System.out.println("Total Amount matched");
        //apply promo-code
        driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("abc");
        driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
        driver.findElement(By.xpath("//span[@class='totAmt']//following-sibling::button")).click();
        Thread.sleep(2000L);
        //Select country
        Select select=new Select(driver.findElement(By.xpath("//select")));
        select.selectByValue("India");
        driver.findElement(By.cssSelector("input[class='chkAgree']")).click();
        driver.findElement(By.xpath("//button")).click();
        System.out.println("Your Order in Confirmed");
        driver.quit();
    }
}
