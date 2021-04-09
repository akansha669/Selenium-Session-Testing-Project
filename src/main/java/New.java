import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class New {
    static void getValueforGrade(String grade){
        //Values corresponding Grades
        int val; String gr;
        switch(grade){
            case "sprite-grade-A" : {val=1; gr="A"; break;}
            case "sprite-grade-B" : {val=2; gr="B"; break;}
            case "sprite-grade-C" : {val=3; gr="C"; break;}
            case "sprite-grade-D" : {val=4; gr="D"; break;}
            case "sprite-grade-E" : {val=5; gr="E"; break;}
            case "sprite-grade-F" : {val=6; gr="F"; break;}
            default:{val=0; gr="Invalid Grade";}
        }
        System.out.println("\nReceived grade : "+gr+" --> Value : "+val);
    }
    static char getGradeforPercent(String per){
        per= StringUtils.chop(per);
        int val=Integer.parseInt(per);
        char grade;
        if(val >= 90){
            grade='A';
        }else if(val < 90 && val >= 80){
            grade='B';
        }else if(val < 80 && val >= 70){
            grade='C';
        }else if(val < 70 && val >= 60){
            grade='D';
        }else if(val < 60 && val >= 50){
            grade='E';
        }else if(val < 50 && val >= 40){
            grade='F';
        }else if(val < 40 && val >= 30){
            grade='G';
        }else if(val < 30 && val >= 20){
            grade='H';
        }else if(val < 20 && val >= 10){
            grade='I';
        }else {
            grade='J';
        }
        return grade;
    }
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://gtmetrix.com/");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        String url="http://tothenew.com/";
        //String url="http://google.com/";
        driver.findElement(By.cssSelector("input[name='url']")).sendKeys(url);
        driver.findElement(By.cssSelector("div[class='analyze-form-button'] button")).click();

        WebDriverWait wait = new WebDriverWait(driver,60);

        //Overall grade
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='report-score report-score-grade-gtmetrix']/i")));
        String grade= driver.findElement(By.xpath("//div[@class='report-score report-score-grade-gtmetrix']/i"))
                .getAttribute("class");
        getValueforGrade(grade);

        //Performance percentage
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='report-scores']/div/div[2]//span[@class='report-score-percent']")));
        String perf= driver.findElement(By.xpath("//div[@class='report-scores']/div/div[2]//span[@class='report-score-percent']")).getText();
        System.out.println("\nReceived performance percentage : "+perf+" --> Grade : "+getGradeforPercent(perf));

        //Structure percentage
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='report-scores']/div/div[3]//span[@class='report-score-percent']")));
        String str= driver.findElement(By.xpath("//div[@class='report-scores']/div/div[3]//span[@class='report-score-percent']")).getText();
        System.out.println("\nReceived structure percentage : "+str+" --> Grade : "+getGradeforPercent(str));

        driver.close();
    }
}
