package day08_alerts_iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Iframe {
    /*
    https://the-internet.herokuapp.com/iframe adresine gidin
    bir method olusturun  :  iframeTest
    "An Iframe containing..." textinin erisilebilir oldugunu test edin
    ve konsolda yazdirin
    Text Box' "Merhaba Dünya" yazdirin
    Text Box in altinda bulunan "Elemental Selenium"
    linkinin textinin göorunur oldugunu dogrulayin ve konsolda yazdirin
     */

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown(){
        //driver.close();
    }
    @Test
    public void test(){
        //https://the-internet.herokuapp.com/iframe adresine gidin
        driver.get("https://the-internet.herokuapp.com/iframe");

        // "An Iframe containing..." textinin erisilebilir oldugunu test edin ve konsolda yazdirin
        WebElement baslikElementi=driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(baslikElementi.isEnabled());
        System.out.println(baslikElementi.getText());


        // Text Box' "Merhaba Dünya" yazdirin
        // text box i dogru locate etmemize ragmen driver bulamadik
        //bunun üzerine html kodlarini inceleyince
        //text box in aslinda bir iframe icinde oldugunu görduk
        //bu durumda once iframe i locate edip
        //switchTo() ile iframe e gecmeliyiz

        WebElement iframeElementi=driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframeElementi);



        WebElement textKutusu=driver.findElement(By.xpath("//body[@id='tinymce']"));

        textKutusu.clear();

        textKutusu.sendKeys("Hello World");


        // Text Box in altinda bulunan "Elemental Selenium"
        // linkinin textinin göorunur oldugunu dogrulayin ve konsolda yazdirin


        //link yazi elementini dogru locate etmemize ragmen yazdirmadi
        //cunku yukarida iframe e gecis yapmistik
        //once oradan cikmamiz lazim  :driver.switchTo().defaultContent(); ile
        driver.switchTo().defaultContent();


        WebElement linkYaziTesti= driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(linkYaziTesti.isDisplayed());
        System.out.println(linkYaziTesti.getText());





    }
}
