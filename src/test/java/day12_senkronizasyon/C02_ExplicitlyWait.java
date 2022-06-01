package day12_senkronizasyon;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_ExplicitlyWait extends TestBase {

    @Test
    public void test1() {
        //"https://the-internet.herokuapp.com/dynamic_controls" adresine gidelim
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //Textbox'in etkin olmadigini(Enabled) dogrulayin
        WebElement enableKutusu=driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertFalse(enableKutusu.isEnabled());

        //Enable butonuna tiklayin textbox etkin oluncaya kadar bekleyin
        driver.findElement(By.xpath("//button[text()='Enable']")).click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(enableKutusu));

        //"It's enabled!" mesajinin goruntulendigini dogrulayin
        WebElement itsEnabledYaziElementi= driver.findElement(By.xpath("//p[text()=\"It's enabled!\"]"));
        Assert.assertTrue(itsEnabledYaziElementi.isDisplayed());

        //TextBox in etkin oldugunu dogrulayin
        Assert.assertTrue(enableKutusu.isEnabled());



    }
}
