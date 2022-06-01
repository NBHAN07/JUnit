package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C05_DropDownOptions {
    /*
    amazon anasayfaya gidip
    dropdown menuden books u secelim
    sectigimiz option u yazdiralim

    dropdown daki option sayisinin
    toplam 20 oldugunu test edelim
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
        driver.get("https://www.amazon.com");
        WebElement ddm= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select=new Select(ddm);
        select.selectByVisibleText("Books");


        //bir dropdown ile calisiyorken, son secilen optiona ulasmak istersek
        //select.getFirstSelectedOption() methodunu kullamalisiniz
        //bu method bize webelement dondurur
        //uzerindeki yaziyi yazdirmak icin gettext() unutulmamalidir

        System.out.println(select.getFirstSelectedOption().getText());

        //dropdown daki option sayisinin
        //    toplam 28 oldugunu test edelim

       List<WebElement> optionsList= select.getOptions();

       int actualOptionSaysi=optionsList.size();
       int expectedOptionSayisi=28;

        Assert.assertEquals(expectedOptionSayisi,actualOptionSaysi);





    }









}

