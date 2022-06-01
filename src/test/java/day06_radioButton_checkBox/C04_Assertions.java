package day06_radioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Assertions {

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
        driver.close();

    }

    @Test
    public void test01(){
        /*
        eger bir test methodumuzda hiçbir test yoksa, test calistiktan sonra hic bir problemle karsilasilmadigini
        raporlamak icin 'test passed' yazisi cıkar.

        eger testleri if ile yaparsak
        test failed olsa bile kodlar problemsiz calistigi icin
        kod calismasi bittiginde
        ekranin sol alt kisminda test passed cikacaktir
         */
        driver.get("https://www.amazon.com");

        //url nin www.facebook.com oldugunu test edelim
       /* if (driver.getCurrentUrl().equals("https://www.facebook.com")){
            System.out.println("url testi passed");
        }else {
            System.out.println("url testi failed");
        }

        */

        String expectedUrl="https://www.facebook.com";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals("url beklenenden farkli",expectedUrl,actualUrl);

        /*
        Assert ile yaptigimiz testlerde assertion failed olursa
         Java kodlarin calismasini durdurur ve Assert class'i
         bizi hata konusunda bilgilendirir.

         org.junit.ComparisonFailure: url beklenenden farkli
         Expected :https://www.facebook.com
         Actual   :https://www.amazon.com/

         boylece hatani ne oldugunu arastirmaya gerek kalmadan
         JUnit bize raporlamis olacak
         */
















    }







}
