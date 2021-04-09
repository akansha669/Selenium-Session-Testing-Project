import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Ques2 {
    public static void main(String[] args) throws IOException {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://accounts.lambdatest.com/register");
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            Properties prop = new Properties();
            File f= new File("application.properties");
            FileInputStream fip = new FileInputStream(f);
            prop.load(fip);

            driver.findElement(By.cssSelector("input[name='name']")).sendKeys(prop.getProperty("name"));
            driver.findElement(By.cssSelector("input[name='email']")).sendKeys(prop.getProperty("email"));
            driver.findElement(By.cssSelector("input[name='password']")).sendKeys(prop.getProperty("password"));
            driver.findElement(By.cssSelector("input[name='phone']")).sendKeys(prop.getProperty("phone"));



        }
}
