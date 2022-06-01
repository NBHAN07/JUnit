package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C06_KeywordActions extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        //facebook anasayfaya gidip
        driver.get("https://facebook.com");

        //yeni kayit olustura bas
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

        //isim kutusunu locate edip
        WebElement isimKutusu= driver.findElement(By.xpath("//input[@name='firstname']"));

        //kalani tab ile dolasarak
        // formu doldur

        Actions actions=new Actions(driver);
        actions.click(isimKutusu)
                .sendKeys("NB")
                .sendKeys(Keys.TAB)
                .sendKeys("H")
                .sendKeys(Keys.TAB)
                .sendKeys("acb@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("acb@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("1236ilk")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("13")
                .sendKeys(Keys.TAB)
                .sendKeys("May")
                .sendKeys(Keys.TAB)
                .sendKeys("2000")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_DOWN)  //bu kadina tiklamiyor???*
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();





        Thread.sleep(5000);






    }
}
