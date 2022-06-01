package day07_assertions;

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

public class C02_BestBuyAssertions {
    /*
    -https://www.bestbuy.com/ adresine gidin
    -farkli test methodlari olusturarark asagidaki methodlari yapin
    1-url nin https://www.bestbuy.com/ oldugunu test edin
    2-titleTest-->sayfa basliginin Rest icermedigini(Contains) test edinn
    3-logoTest-->BestBuy logosunun gorundugunu test edin
    4-FrancaisLinkTest-->fransizca linkin goruntulendigini test edin
     */

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //-https://www.bestbuy.com/ adresine gidin
        driver.get("https://www.bestbuy.com");


    }

    @AfterClass
    public static void tearDown(){
        //driver.close();

    }
    @Test
    public void test01(){
        //1-url nin https://www.bestbuy.com/ oldugunu test edin
        String expectedUrl="https://www.bestbuy.com/";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);

    }
    @Test
    public void test02(){
        //2-titleTest-->sayfa basliginin Rest icermedigini(Contains) test edinn
        String istenmeyenKelime="Reset";
        String actualTitle= driver.getTitle();
        Assert.assertFalse(actualTitle.contains(istenmeyenKelime));

    }
    @Test
    public void test03(){
        //3-logoTest-->BestBuy logosunun gorundugunu test edin
        WebElement logoTesti= driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue(logoTesti.isDisplayed());
    }
    @Test
    public void test04(){
        //4-FrancaisLinkTest-->fransizca linkin goruntulendigini test edin
        WebElement butonTest= driver.findElement(By.xpath("//*[text()='Français']"));
        Assert.assertTrue(butonTest.isDisplayed());

    }


























}
