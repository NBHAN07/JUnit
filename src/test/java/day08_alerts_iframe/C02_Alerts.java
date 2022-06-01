package day08_alerts_iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Alerts {
    /*
    -"https://the-internet.herokuapp.com/javascript_alerts" adresine gidin
    -bir method olusturun: acceptAlert
     1. uyariya tiklayin sonra cikan OK tusuna tiklayin ve result mesajinin
     "You successfully clicked an alert" oldugunu test edin
    -bir metod olusturun: dismissAlert
    2. uyariyya tiklayin sonra cikan cancel tusuna tiklayin ve result mesajinin
    "successfuly" icermedigini test edin
    -bir metod olusturun: sendKeysAlert
    3. butona tiklayin cikan metin kutusuna isminizi yazin
    OK butonuna tiklayin ve result mesajinda isinizin goruntulendigini dogrulayin

     */
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");


    }
    @AfterClass
    public static void tearDown(){
        //driver.close();
    }

    @Test
    public void acceptAlert(){
        //1. uyariya tiklayin sonra cikan OK tusuna tiklayin ve result mesajinin
        //     "You successfully clicked an alert" oldugunu test edin
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        driver.switchTo().alert().accept();
        String expectedResult="You successfully clicked an alert";
        WebElement sonucYaziElementi= driver.findElement(By.xpath("//p[@id='result']"));
        String actualResult=sonucYaziElementi.getText();
        Assert.assertEquals(expectedResult,actualResult);

    }
    @Test
    public void dismissAlert(){
        //-bir metod olusturun: dismissAlert
        //    2. uyariyya tiklayin sonra cikan cancel tusuna tiklayin ve result mesajinin
        //    "successfuly" icermedigini test edin

        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        driver.switchTo().alert().dismiss();

        String istenmeyenKElime="successfuly";
        WebElement sonucYazisiElementi= driver.findElement(By.xpath("//p[@id='result']"));
        String actualSonucYAzisi=sonucYazisiElementi.getText();
        Assert.assertFalse(actualSonucYAzisi.contains(istenmeyenKElime));


    }
    @Test
    public void sendKeysAlert(){
        //3. butona tiklayin cikan metin kutusuna isminizi yazin
        //    OK butonuna tiklayin ve result mesajinda isinizin goruntulendigini dogrulayin
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        driver.switchTo().alert().sendKeys("NBH");
        driver.switchTo().alert().accept();
        WebElement sonucYazisiElementi= driver.findElement(By.xpath("//p[@id='result']"));
        String sonucYazisiStr=sonucYazisiElementi.getText();
        String girilenIsim="NBH";
        Assert.assertTrue(sonucYazisiStr.contains(girilenIsim));
    }






}
