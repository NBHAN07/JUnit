package day13_cookies_webtables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class C02_WebTables extends TestBase {

    @Test
    public void webTable(){

        //login() metodu olusturun ve oturum acin
        // https://www.hotelmycamp.com admin/HotelRoomAdmin adresine gidin
        //        Username: manager
        //        Password: Manager1!
        girisYap();



        //table() metodu olusturun
        //        tum table body sinin boyutunu(sutun sayisi) bulun /tbody

        List<WebElement> sutunBaslik=driver.findElements(By.xpath("//thead//tr[1]//th"));
        System.out.println("Sutun sayisi "+ sutunBaslik.size());


        //        Table daki tum body'i ve basliklari (headers) konsola yazdirin

        WebElement tumBody= driver.findElement(By.xpath("//tbody"));
        System.out.println(tumBody.getText());

        /*
        tum body i bir string olarak yazdirmak istersek
        body webelementii locate edip gettext() motodu ile yazdirabiliriz.
        ama bu sefer kocaman bir stringimiz olacagi icin 1. satir56. sutun gibi islemler yapamayiz
         */



        //printRows() metodu olusturun //tr
        //        table body sinde bulunan toplam satir(row) sayisini bulun
        List<WebElement> satirlarList=driver.findElements(By.xpath("//thead//tr[1]//th"));
        System.out.println("Satir sayisi: "+satirlarList.size());



        //        table body sinde bulunan satirlari(rows) konsolda yazdirin

        for (WebElement each: satirlarList
             ) {
            System.out.println(each.getText());
        }


        //        4. satirdaki (row) elementleri konsolda yazdirin

        List<WebElement> cellList=driver.findElements(By.xpath("//tbody//tr[4]//td"));

        //        Email basligindaki tum elementleri (sütun) konsolda yazdirin
        //        once email basliginin kacinci sutunda oldugunu bulalim

        List<WebElement> basliklarList=driver.findElements(By.xpath("//thead//tr[1]//th"));

        int emailSutunNo=0;
        for (int i = 0; i < basliklarList.size() ; i++) {

            if (basliklarList.get(i).getText().equals("Email")){
                emailSutunNo=i;
            }

        }



        List<WebElement> emailSutunListesi=
                driver.findElements(By.xpath("//tbody//td["+(emailSutunNo+1)+"]"));

        for (WebElement each:emailSutunListesi
             ) {
            System.out.println(each.getText());
        }



    }

    public void girisYap() {
        driver.get("https://www.hotelmycamp.com");
        driver.findElement(By.linkText("Log in")).click();
        Actions actions=new Actions(driver);
        WebElement userName=driver.findElement(By.id("UserName"));
        actions.click(userName)
                .sendKeys("manager")
                .sendKeys(Keys.TAB)
                .sendKeys("Manager1!")
                .sendKeys(Keys.ENTER)
                .perform();









    }


}
