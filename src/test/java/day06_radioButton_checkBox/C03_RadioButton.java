package day06_radioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_RadioButton {
    /*
    1- gereklli yapiyi olusturun ve gorevi tamamlayin
    2-https://www.facebook.com adresine gidin
    3- cookies i kabul edin
    4-"Create an Account" butonuna basin
    5-"radio buttons" elementlerini locate edin
    6-secili degilse cinsiyet butonunda size uygun olani secin
    */

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void radioButton() throws InterruptedException {

        driver.get("https://www.facebook.com");
        // 4-"Create an Account" butonuna basin
        driver.findElement(By.xpath("//*[text()='Yeni Hesap Oluştur']")).click();

        //5-"radio buttons" elementlerini locate edin
        WebElement kadinButton=driver.findElement(By.xpath("//input[@value='1']"));
        WebElement erkekButton=driver.findElement(By.xpath("//input[@value='2']"));
        WebElement ozelButton=driver.findElement(By.xpath("//input[@value='-1']"));

        //6-secili degilse cinsiyet butonunda size uygun olani secin

        if (!kadinButton.isSelected()){
            kadinButton.click();
        }

        Thread.sleep(3000);

        erkekButton.click();
        Thread.sleep(3000);

        ozelButton.click();
        Thread.sleep(3000);









    }











}
