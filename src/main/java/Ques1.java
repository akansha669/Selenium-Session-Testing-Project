import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class Ques1 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(" https://www.ultimateqa.com/simple-html-elements-for-automation/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,900)", "");
        int tablenum=2;
        String text="Quality";
        int index=2;
        WebElement value=driver.findElement(By.xpath("(//table)['"+tablenum+"']//tr//td[contains(text(),'"+text+"')]//following-sibling::td[2]"));
        String rowText=value.getText();
        System.out.println("Salary of the Quality Assurance Engineer is: "+rowText);
       driver.quit();
    }
}
