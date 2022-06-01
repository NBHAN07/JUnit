package day12_senkronizasyon;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C01_ExplicitlyWait extends TestBase {



    @Test
    public void implicitwaitTesti() {
        //"https://the-internet.herokuapp.com/dynamic_controls" adresine gidelim
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //remove butonuna basalim
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

        //""It's gone!" mesajinin goruntulendigini dogrulayin
        WebElement itsGoneYaziElementi=driver.findElement(By.xpath("//p[text()=\"It's gone!\"]"));
        Assert.assertTrue(itsGoneYaziElementi.isDisplayed());

        //Add butonuna basin
        driver.findElement(By.xpath("//button[text()=\"Add\"]")).click();

        //It's back mesajinin goruntulendigini test edin
        WebElement itsBackYazisi= driver.findElement(By.xpath("//p[text()=\"It's back!\"]"));
        Assert.assertTrue(itsBackYazisi.isDisplayed());


    }

    @Test
    public void explicitlyWaitTesti() {
        //"https://the-internet.herokuapp.com/dynamic_controls" adresine gidelim
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //remove butonuna basalim
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

        //""It's gone!" mesajinin goruntulendigini dogrulayin
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
        /*
        WebElement itsGoneYaziElementi=driver.findElement(By.xpath("//p[text()=\"It's gone!\"]"));
        wait.until(ExpectedConditions.visibilityOf(itsGoneYaziElementi));
        Assert.assertTrue(itsGoneYaziElementi.isDisplayed());

        yazinin gorunur olmasini beklerken yazinin locate ini kullanmak sorun olusturur
        cunku henuz gorunmeyen bir yazinin locate edilmeis de mumkun olmayabilir
        (html kodlari yazan developer farkli uygulamalar yapabilir)
        bu durumda ekleme islemi ve locate i birlikte yapmaliyiz

         */

        WebElement itsGoneYaziElementi=wait.until(ExpectedConditions.
                                            visibilityOfElementLocated(By.xpath("//p[text()=\"It's gone!\"]")));

        Assert.assertTrue(itsGoneYaziElementi.isDisplayed());

        //Add butonuna basin
        driver.findElement(By.xpath("//button[text()=\"Add\"]")).click();

        //It's back mesajinin goruntulendigini test edin

        WebElement itsBackYazisi=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()=\"It's back!\"]")));
        Assert.assertTrue(itsBackYazisi.isDisplayed());



    }
}
