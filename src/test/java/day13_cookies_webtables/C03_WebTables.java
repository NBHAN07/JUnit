package day13_cookies_webtables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_WebTables extends TestBase {

    @Test
    public void dinamikYazici() {
        //onceki class daki adrese gidip
        //girisYap methodunu kullanarak sayfaya giris yapin
        //input olarak verilen satir sayisi ve sutun sayisina sahip
        //cell deki text i yazdirin

        int satir = 3;
        int sutun = 5;
        girisYap();

        WebElement aranancell=driver.findElement(By.xpath("//tbody//tr["+satir+"]//td["+sutun+"]"));

        System.out.println(aranancell.getText());









    }

    public void girisYap() {
        driver.get("https://www.hotelmycamp.com");
        driver.findElement(By.linkText("Log in")).click();
        Actions actions = new Actions(driver);
        WebElement userName = driver.findElement(By.id("UserName"));
        actions.click(userName)
                .sendKeys("manager")
                .sendKeys(Keys.TAB)
                .sendKeys("Manager1!")
                .sendKeys(Keys.ENTER)
                .perform();

    }
}