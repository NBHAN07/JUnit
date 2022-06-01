package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C04_DropDownMenu {
    /*
    amazona gidip
    dropDown dan books secenegini secip
    Java aratalim
    ve arama sonuclarinin java icerdigini test edelim
     */
    static WebDriver driver;

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
        //dropdown dan bir option secmek icin 3 adim vardir
        //1- dropdown i locate edelim

        WebElement dropDownMenu=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        //2-bir select objesi olusturup
        //parametre olarak az once olusturdugumuz ddm yu girelim

        Select select=new Select(dropDownMenu);

        //3-DropDown da var olan optionlardan bir tanesini secelim

       // select.selectByIndex(5);
       // select.selectByValue("search-alias=stripbooks-intl-ship");
        select.selectByVisibleText("Books");


        // arama kutusuna java yazalim
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java"+ Keys.ENTER);

        //ve arama sonuclarinin java icerdigini test edelim
        WebElement sonucYazisiElementi=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String sonucYazisiStr=sonucYazisiElementi.getText();
        String arananKelime="Java";

        Assert.assertTrue(sonucYazisiStr.contains(arananKelime));



    }

}
