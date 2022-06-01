package day09_handleWindows_testBase;

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
import java.util.Set;

public class C03_windowhandles {

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
     //   driver.quit();

    }

    @Test
    public void test(){
        driver.get("https://the-internet.herokuapp.com/windows");

        //syfadaki textin "opening a new window" oldugunu dogrulayin
        WebElement sayfadakiYaziElementi=driver.findElement(By.xpath("//h3"));

        String expectedText="Opening a new window";

        String actualText=sayfadakiYaziElementi.getText();
        
        Assert.assertEquals(expectedText,actualText);

        //sayfa basliginin (title) "The Internet" oldugunu dogrulayin
        String expectedTitle="The Internet";
        String actualTitle= driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);

        /*
        eger kontrosuz acilan bir tab veya window varsa
        o zaman sayfalarin windowhandle degerlerini elde etmem gerekir
        oncelikle 2. sayfa acilmadan once
        ilk sayfanin windowhandle degerini
        bir stringe atayalim
         */

        String ilkSayfaWindowHandleDegeri=driver.getWindowHandle();
        System.out.println(ilkSayfaWindowHandleDegeri);


        //click here butonun basiniz
        driver.findElement(By.linkText("Click Here")).click();



        /*
        switchTo().newWindow()demeden link tiklayarak yeni tab veya window olustugunda
        biz driver a yeni sayfaya gec demedikce, driver eski sayfada kalir
        ve yeni sayfa ile ilgilil  hicbir islem yapmaz
        yeni sayfada driver i calistirmak istersek
        once driver i yeni sayfaya yollmaliyiz
         */

        /*
        yeni sayfaya gecebilmek icin oncelikle ıkincisayfawindowhandledegerini bulmamiz gerekir
        bunun icin driver.getWindowHandle(); metodunu kullanarak
        acik olan tum sayfalarin window handle degerlerini alip bir sete assign ederiz

        ilk sayfanin wind. hand. degerini zaten biliyoruz
        set deki window handle degerini kontrol edip
        ilk sayfanin handle degerine esit olmayan ikinci ayfanin window handle degeridir deriz
         */

        Set<String> windowHandleSeti=driver.getWindowHandles();
        System.out.println(windowHandleSeti);

        String ikinciSayfaWindowHandleDegeri="";
        for (String each:windowHandleSeti
             ) {
            if (!each.equals(ilkSayfaWindowHandleDegeri)){
                ikinciSayfaWindowHandleDegeri=each;
            }
        }

        //artik 2. sayfanin wh. degerini biliyoruz. sayfalar arasi gecis yapabiliriz

        driver.switchTo().window(ikinciSayfaWindowHandleDegeri);

        //acilan sayfa basliginin (title) "New Window" oldugunu  dogrulayin
        String expectedIkinciTitle="New Window";
        String actualIkinciTitle=driver.getTitle();
        Assert.assertEquals(expectedIkinciTitle,actualIkinciTitle);

        //sayfadaki text in de "New Window" oldugunu dogrulayin
        WebElement ikinciSayfaYaziElementi=driver.findElement(By.xpath("//h3"));
        String expectedIkinciYazi="New Window";
        String actualIkinciYazi=ikinciSayfaYaziElementi.getText();
        Assert.assertEquals(expectedIkinciYazi,actualIkinciYazi);

        //bir onceki pencereye geri dondukten sonra sayfa basliginin
        //"The Internet" oldugunu dogrulayin

        driver.switchTo().window(ilkSayfaWindowHandleDegeri);

        expectedTitle="The Internet";
        actualTitle= driver.getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);





    }
}
