package day14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C04_ReadExcel {

    @Test
    public void readExcelTest() throws IOException {

        //Dosya yolunu bir stringe atayalim
        String dosyaYolu="src/resources/ulkeler.xlsx";


        //FileInputStream objesini olusturup parametre olarak dosya yolunu girelim

        FileInputStream fis=new FileInputStream(dosyaYolu);


        //Workbook objesi olusturalim, parametre olarak fileInputStream objesini girelim

        Workbook workbook= WorkbookFactory.create(fis);


        //ingilizce baskentler sutununu yazdiralim
        int sonSatir=workbook.getSheet("Sayfa1").getLastRowNum();

        System.out.println(sonSatir);

        String satirdakiData="";

        for (int i = 0; i <= sonSatir; i++) {

            satirdakiData=C03_ReadExcel.banaDataGetir(i,1);
            System.out.println(satirdakiData);

        }
    }
}
