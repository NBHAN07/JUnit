package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_YanlisEmailTesti {
    /*
    -https://automationpractice.com/index.php sayfasina gidelim
    -sign in butonuna basalim
    -Email kutusuna @ olmayan bir mail yazalim ve enter a bastigimizda
    -"Invalid email address"uyarisi ciktigini test edelim
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
        //-https://automationpractice.com.index.php adresine gidin
        driver.get("http://automationpractice.com/index.php");

        //sign in butonuna basalim
        driver.findElement(By.xpath("//a[@class='login']")).click();

        //Email kutusuna @ olmayan bir mail yazalim ve enter a bastigimizda
        //"Invalid email address"uyarisi ciktigini test edelim

        WebElement mailKutusu=driver.findElement(By.xpath("//input[@id='email_create']"));

        mailKutusu.sendKeys("nbh.gmail.com"+ Keys.ENTER);


        WebElement uyariYazisiElementi= driver.findElement(By.xpath("//*[text()='Invalid email address.']"));
        Assert.assertTrue(uyariYazisiElementi.isDisplayed());

    }

}
