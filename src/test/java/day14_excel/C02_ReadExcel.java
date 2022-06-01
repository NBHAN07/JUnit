package day14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcel {
    @Test
    public void readExcelTesti() throws IOException {

        //Dosya yolunu bir stringe atayalim
        String dosyaYolu="src/resources/ulkeler.xlsx";


        //FileInputStream objesini olusturup parametre olarak dosya yolunu girelim

        FileInputStream fis=new FileInputStream(dosyaYolu);


        //Workbook objesi olusturalim, parametre olarak fileInputStream objesini girelim

        Workbook workbook= WorkbookFactory.create(fis);

        //Sheet objesi olusturun. workbook.getSheetAt(index)
        //Row objesi olusturun sheet.getRow(index)
        //cell objesi olusturun row.getCell(index)

        String actualData=workbook
                                .getSheet("Sayfa1")
                                .getRow(3)
                                .getCell(3)
                                .toString();



    }
}
