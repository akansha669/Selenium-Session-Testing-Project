import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Registration {
    public static void main(String [] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        WebElement box = driver.findElement(new By.ById("email_create"));
        box.sendKeys("ad18@b.com");
        driver.findElement(new By.ById("SubmitCreate")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //Validate that the title is  - "Login - My Store"
        String expectedTitle= "Login - My Store";
        String actualTitle=driver.getTitle();
        System.out.println(actualTitle.equals(expectedTitle));
        //Validate the text on the page. "CREATE AN ACCOUNT"
        String expectedText= "CREATE AN ACCOUNT";
        String actualText=driver.findElement(By.id("create-account_form"))
                .findElement(By.className("page-subheading")).getText();
        System.out.println(actualText.equals(expectedText));
        //gender
        driver.findElement(new By.ById("id_gender1")).click();
        //firstname
        driver.findElement(By.name("customer_firstname")).sendKeys("Akansha");
        //lastname
        driver.findElement(By.name("customer_lastname")).sendKeys("Singh");
        //Password
        driver.findElement(new By.ByXPath("//*[@id=\"passwd\"]")).sendKeys("eep@123");
        //Date Of Birth
        Select dob=new Select(driver.findElement(By.name("days")));
        dob.selectByIndex(7);
        Select dob2=new Select(driver.findElement(By.name("months")));
        dob2.selectByIndex(1);
        Select dob3=new Select(driver.findElement(By.name("years")));
        dob3.selectByValue("1996");
        //company
        driver.findElement(By.name("company")).sendKeys("None");
        //Address1
        driver.findElement(By.name("address1")).sendKeys("H.No-74,hdhdsah street");
        //Address2
        driver.findElement(By.name("address2")).sendKeys("New Goregaon,Mahuli");
        //city
        driver.findElement(new By.ById("city")).sendKeys("Mahuli");
        //state
        Select state=new Select(driver.findElement(By.name("id_state")));
        state.selectByIndex(1);
        //zipcode
        driver.findElement(new By.ById("postcode")).sendKeys("12345");
        //Additional info
        driver.findElement(new By.ById("other")).sendKeys("Nothing");
        //Home Phone
        driver.findElement(new By.ById("phone")).sendKeys("963523764");
        //mobile Phone
        driver.findElement(new By.ById("phone_mobile")).sendKeys("963523764");
        //Alias
        driver.findElement(new By.ById("alias")).sendKeys("nothing");
        //Register
        Thread.sleep(2000L);
        driver.findElement(new By.ByXPath("//*[@id=\"submitAccount\"]/span")).click();
        //Validating Home Page
        String expectedHeading="MY ACCOUNT";
        String actualHeading=driver.findElement(By.xpath("//div[@id=\"center_column\"]/h1")).getText();
        System.out.println(actualHeading.equals(expectedHeading));
        //Thread.sleep(3000L);
        driver.quit();



    }
}
