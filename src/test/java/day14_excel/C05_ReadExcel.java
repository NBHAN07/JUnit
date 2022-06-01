package day14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C05_ReadExcel {

    @Test
    public void readExcel() throws IOException {
        //Dosya yolunu bir stringe atayalim
        String dosyaYolu="src/resources/ulkeler.xlsx";


        //FileInputStream objesini olusturup parametre olarak dosya yolunu girelim

        FileInputStream fis=new FileInputStream(dosyaYolu);


        //Workbook objesi olusturalim, parametre olarak fileInputStream objesini girelim

        Workbook workbook= WorkbookFactory.create(fis);

        //sayfa2 ye gidip
        //satir sayisinin 17 , kullanilan satir sayisinin 14 oldugunu test edelim

        int satirsayisi=workbook.
                getSheet("Sayfa2").
                getLastRowNum();
        System.out.println(satirsayisi);
        int expectedSatirSayisi=17;
        Assert.assertEquals(expectedSatirSayisi,satirsayisi);


        int kullanilanSatirSayisi=workbook.
                getSheet("Sayfa2").
                getPhysicalNumberOfRows();
        System.out.println(kullanilanSatirSayisi);
        int expectedkullanilanSatirSayisi=14;
        Assert.assertEquals(expectedkullanilanSatirSayisi,kullanilanSatirSayisi);








    }
}
