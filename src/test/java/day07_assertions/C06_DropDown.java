package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C06_DropDown {
    /*
    -https://the-internet.herokuapp.com/dropDown adresine git
    -index kullanarak Secenek1'i secin ve yazdirin
    -value kullanarak Secenek2'i secin ve yazdirin
    -Visible Text(gounen metin) kullanarak kullanarak Secenek1'i secin ve yazdirin
    -tum dropdown degerleri(value) ve yazdirin
    -Dropdown un boyutunu bulun, dd da 4 oge varsa konsolda true
     4 ten farkliysa false yazdirin
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
      //  driver.quit();

    }
    @Test
    public void test(){
        driver.get("https://the-internet.herokuapp.com/dropdown");

        WebElement ddm=driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select=new Select(ddm);
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());

        //value kullanarak Secenek2'i secin ve yazdirin
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());

        //Visible Text(gounen metin) kullanarak kullanarak Secenek1'i secin ve yazdirin
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());

        //tum dropdown optionslari yazdirin
        List<WebElement> tumopsiyonlar=select.getOptions();
        for (WebElement each:tumopsiyonlar
             ) {
            System.out.println(each.getText());
        }
        //Dropdown un boyutunu bulun, dd da 4 oge varsa konsolda true
        //     4 ten farkliysa false yazdirin

        int dropdownBoyut= tumopsiyonlar.size();
        if (dropdownBoyut==4){
            System.out.println("true");
        }else {
            System.out.println("false");
        }


    }
}
