package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_fileDownload extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        //https://the-internet.herokuapp.com/download adresine gidelim
        driver.get("https://the-internet.herokuapp.com/download");


        //LambdaTest.txt dosyasini indirelim
        WebElement lambdalinki=driver.findElement(By.xpath("//a[text()='LambdaTest.txt']"));
        lambdalinki.click();
        Thread.sleep(3000);


        //dosyanin basariyla indirilip indirilmedigini test edelim
        //dosya downloads a indirilecektir bize downloads un path i lazim

        String farkliKisim=System.getProperty("user.home");
        String ortakKisim="\\Downloads\\LambdaTest.txt";

        String arananDosyaYolu=farkliKisim+ortakKisim;

        //geriye o dosya yolundaki dosyanin var oldugunu assert edelim
        Assert.assertTrue(Files.exists(Paths.get(arananDosyaYolu)));



    }


}
