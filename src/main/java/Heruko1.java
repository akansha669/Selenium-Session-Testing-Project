import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class Heruko1 {
    public static void main(String [] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//div[@id='content']//li[13]/a")).click();
        WebElement checkbox=driver.findElement(By.xpath("//input"));
        checkbox.click();
        //validating if the checkbox is checked
        System.out.println("Checkbox is checked: "+checkbox.isSelected());

        driver.findElement(By.xpath("//form[@id='checkbox-example']/button")).click();
        //validating It's gone
        String actual=driver.findElement(By.id("message")).getText();
        Thread.sleep(2000L);
        String expected="It's gone!";
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(actual,expected);
        System.out.println("It's gone! message matched");
        driver.findElement(By.xpath("//form[@id='checkbox-example']/button")).click();
        //validating It's back
        String actual2=driver.findElement(By.id("message")).getText();
        Thread.sleep(2000L);
        String expected2="It's back!";
        softAssert.assertEquals(actual2,expected2);
        System.out.println("It's back! message matched");
        Thread.sleep(2000L);



        WebElement textBox=driver.findElement(By.xpath("//form[@id='input-example']/input"));
        System.out.println("TextBox is enabled: "+textBox.isEnabled());//false
        driver.findElement(By.xpath("//form[@id='input-example']/button")).click();
        System.out.println("TextBox is enabled: "+textBox.isEnabled());
        //validating its Enabled
        String actual_Enabled=driver.findElement(By.id("message")).getText();
        Thread.sleep(2000L);
        String expected_Enabled="It's enabled!";
        softAssert.assertEquals(actual_Enabled,expected_Enabled);
        System.out.println("It's Enabled! message matched");
        driver.findElement(By.xpath("//form[@id='input-example']/input")).sendKeys("This is enabled");
        //Validating Disabled
        driver.findElement(By.xpath("//form[@id='input-example']/button")).click();
        String actual_Disabled=driver.findElement(By.id("message")).getText();
        Thread.sleep(2000L);
        String expected_Disabled="It's disabled!";
        softAssert.assertEquals(actual_Disabled,expected_Disabled);
        System.out.println("It's Disabled! message matched");


        softAssert.assertAll();
        driver.quit();

    }
}
