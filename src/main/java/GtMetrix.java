import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class GtMetrix {
    public static void getRankForGrade(String grades){
        int rank;
        String grade;
        switch (grades){
            case "sprite-grade-A" : { rank=1; grade="A"; break;}
            case "sprite-grade-B" : { rank=2; grade="B"; break; }
            case "sprite-grade-C" : { rank=3; grade="C"; break;}
            case "sprite-grade-D" : { rank=4; grade="D"; break;}
            case "sprite-grade-E" : { rank=5; grade="E"; break;}
            case "sprite-grade-F" : { rank=6; grade="F"; break;}
            case "sprite-grade-G" : { rank=7; grade="g"; break;}
            default :
                rank=0;
                grade="Invalid grade";
        }
        System.out.println("This website has scored "+rank+" with grade "+grade);
    }
    static char getGradeForPercentage(String performance){
        performance= StringUtils.chop(performance);
        int percentage=Integer.parseInt(performance);
        char grade;
        if(percentage >= 90){
            grade='A';
        }else if( percentage < 90 && percentage >= 80){
            grade='B';
        }else if(percentage < 80 && percentage >= 70){
            grade='C';
        }else if(percentage < 70 && percentage >= 60){
            grade='D';
        }else if(percentage < 60 && percentage >= 50){
            grade='E';
        }else if(percentage < 50 && percentage >= 40){
            grade='F';
        }else if(percentage < 40 && percentage >= 30){
            grade='G';
        }else if(percentage < 30 && percentage >= 20){
            grade='H';
        }else if(percentage < 20 && percentage >= 10){
            grade='I';
        }else {
            grade='J';
        }
        return grade;
    }
    public static void main(String [] args){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://gtmetrix.com/");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        String testURL="http://tothenew.com/";
        driver.findElement(By.cssSelector("input[type='url']")).sendKeys(testURL);
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        //applying explicit wait until website is getting analyzed
        WebDriverWait wait=new WebDriverWait(driver,60);
        //geting rank for grades
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='report-score report-score-grade-gtmetrix']/i")));
        String grade=driver.findElement(By.xpath("//div[@class='report-score report-score-grade-gtmetrix']/i")).getAttribute("class");
        getRankForGrade(grade);
        //geting percentage for grades
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='box clear']/div[2]//span[@class='report-score-percent']")));
        String performance=driver.findElement(By.xpath("//div[@class='box clear']/div[2]//span[@class='report-score-percent']")).getText();
        System.out.println("The Performance Percentage is : "+performance+" has its grade as : "+getGradeForPercentage(performance));
        //Structure percentage
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='box clear']/div[3]//span[@class='report-score-percent']")));
        String structure= driver.findElement(By.xpath("//div[@class='box clear']/div[3]//span[@class='report-score-percent']")).getText();
        System.out.println("\nThe Structure percentage is : "+structure+" with grade as : "+getGradeForPercentage(structure));

        driver.close();
    }
}
