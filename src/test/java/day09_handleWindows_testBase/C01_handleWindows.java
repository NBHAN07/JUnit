package day09_handleWindows_testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_handleWindows {

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
       // driver.close();

    }

    @Test
    public void test(){
        //1- amazon ana sayfaya gidin
        driver.get("https://www.amazon.com");
       String ilkSayfahandleDegeri= driver.getWindowHandle();

        //2-nutella icin arama yapin

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("nutella"+ Keys.ENTER);

         /*
    CDwindow-1F15DFA08DC3099B66EEA3590DF20359
    bu kod acilan sayfanin uniqe hash kodudur.
    selenium sayfalar arasi geciste bu window handle degerini kullanir

    eger sayfalar arasinda driver imizi gezdiriyorsak ve herhangi bir sayfadan
    suanda bulundugumuz sayfaya gecmek istiyorsak
    driver.switchTo().window("CDwindow-1F15DFA08DC3099B66EEA3590DF20359");
    bu sayfanin window handle degerini girerek bu sayfaya gecisi saglayabiliriz
     */

        //3- ilk urunun resmini tiklayarak farkli bir tag olarak acin

        WebElement ilkUrunResmi=driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]"));
        driver.switchTo().newWindow(WindowType.TAB);
        /*
        bu komutu kullandigimizda driver otomatik olarak oolusturlan
        new taba gecer
        yeni tab da gorevi gerceklestirmek icin
        adimlari bastan almamiz gerekir
         */
        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("nutella"+ Keys.ENTER);
        driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]")).click();

        //4- yeni tagda acilan urunun tittle ini yazdirin

        WebElement urunTitle=driver.findElement(By.xpath("//span[@id='productTitle']"));
        System.out.println(urunTitle.getText());

        System.out.println(driver.getCurrentUrl()); //2. sayfanin url i bu da


        //5- ilk sayfaya gecip url i yazdiralim
        driver.switchTo().window(ilkSayfahandleDegeri);
        System.out.println(driver.getCurrentUrl());
















    }





}
