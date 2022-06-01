package day10_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class C03_Actions extends TestBase {

    @Test
    public void test01(){

        //istenen adrese gidelim
        driver.get("https://admin:admin@the-internet.herokuapp.com/context_menu");

        //cizgili  alan uzerinde sag click yapalim
        Actions actions=new Actions(driver);
        WebElement cizgiliAlanElementi=driver.findElement(By.id("hot-spot"));
        actions.contextClick(cizgiliAlanElementi).perform();

        //Allert de cikan yazinin "You selected a context menu" oldugunu test edelim
        String expectedYazi="You selected a context menu";
        String actualYazi=driver.switchTo().alert().getText();
        Assert.assertEquals(expectedYazi,actualYazi);

        //Tamam diyerek allerti kapatalim
        driver.switchTo().alert().accept();

        //Eemental Selenium linkine tiklayalim

        String ilkSayfaWHDegeri=driver.getWindowHandle();


        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click(); //baska sayfaya gecegi icin bunu
        //yapmadan once ilk sayfanin window handle degerini almaliyiz

        Set<String> handleSeti=driver.getWindowHandles();
        
        String ikinciSayfaWHandledegeri="";
        for (String each:handleSeti
             ) {
            if (!each.equals(ilkSayfaWHDegeri)){
                ikinciSayfaWHandledegeri=each;
            }
        }

        //Acilan sayfada h1 taginda "Elemental Selenium" yazdigini test edelim
        driver.switchTo().window(ikinciSayfaWHandledegeri);
        WebElement yaziElementi=driver.findElement(By.tagName("h1"));
        String expectedIkinciYazi="Elemental Selenium";
        String actualIkinciYazi=yaziElementi.getText();
        Assert.assertEquals(expectedIkinciYazi,actualIkinciYazi);


    }

}
