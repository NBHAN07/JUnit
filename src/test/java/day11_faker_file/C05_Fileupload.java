package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05_Fileupload extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //dosya sec butonuna basalim
        //yuklemek istedigimiz dosyayi gonderelim

        /*
        bu islemi selenium ile yapma sansimiz yok cunku web tabanli bir uygulama degil
        bu durumda sendKeys() metodu imdadimiza yetisir

        eger dosya sec butonuna var olan bir dosyanin dosya yolunu yollarsak secme islemi otomatik
        olarak yapilmis olacaktir
         */

        //1. adim dosya sec butonunu locate edelim

        WebElement dosyaSecButonu= driver.findElement(By.id("file-upload"));

        //2. adim yuklenecek yolun dosya yolunu bulalim
        //biz masa ustundeki text.txt dosyasini gonderelim

        String farkliKisim=System.getProperty("user.home");
        String ortakKisim="\\Desktop\\text.txt";

        String yuklenecekDosya=farkliKisim+ortakKisim;

        //3. adim sendKeys ile dosya yolunu secme butonuna yollayalim
        dosyaSecButonu.sendKeys(yuklenecekDosya);



        //Upload butonuna basalim
        driver.findElement(By.xpath("//input[@id='file-submit']")).click();

        //"File Uploaded!" textinin goruntulendigini test edelim

        WebElement yaziElementi=driver.findElement(By.tagName("h3"));
        Assert.assertTrue(yaziElementi.isDisplayed());


        Thread.sleep(5000);
    }
}
