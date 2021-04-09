import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SameCityForFlight {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).sendKeys("Goa", Keys.ENTER);
        driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
        //Validating if Goa is present in Arrival's dropdown
        List<WebElement> cities= driver.findElements(new By.ByXPath("(//div[@class='dropdownDiv'])[3]//a"));
        boolean flag = true;
        for(WebElement city : cities) {
            if(city.getText().equals("Goa (GOI)")) {
                flag = false;
                break;
            }
        }
        Assert.assertEquals(flag,true);
        System.out.println("Asserted successfully : Departure and Arrival can't have same location!!");
        driver.quit();

    }
}