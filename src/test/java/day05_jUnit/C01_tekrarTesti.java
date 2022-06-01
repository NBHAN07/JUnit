package day05_jUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_tekrarTesti {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2-https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");

        //3-cookies uyarisini kabul ederek kapatin(????)

        //4- sayfa basliginin google ifadesi icerdigini dogrulayin
        WebElement sayfaBasligi=driver.findElement(By.xpath("//img[@class='lnXdpd']"));

        if(sayfaBasligi.equals("Google")){
            System.out.println("test PASSED");
        }else {
            System.out.println("test FAİLED");
        }

        //5-arama cubuguna nutela yazip aratin
        WebElement aramaCubugu= driver.findElement(By.xpath("//input[@type='text']"));
        aramaCubugu.sendKeys("nutella");












    }
}
