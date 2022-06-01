package day14_excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {

    @Test
    public void readExcelTest() throws IOException {
        //Dosya yolunu bir stringe atayalim
        String dosyaYolu="src/resources/ulkeler.xlsx";

        //FileInputStream objesini olusturup parametre olarak dosya yolunu girelim

        FileInputStream fis=new FileInputStream(dosyaYolu);

        //Workbook objesi olusturalim, parametre olarak fileInputStream objesini girelim

        Workbook workbook= WorkbookFactory.create(fis);

        //Sheet objesi olusturun. workbook.getSheetAt(index)
        Sheet sheet=workbook.getSheet("Sayfa1");

        //Row objesi olusturun sheet.getRow(index)
        Row row= sheet.getRow(3);

        //cell objesi olusturun row.getCell(index)
        Cell cell= row.getCell(3);

        System.out.println(cell);

        //3. index indeki satirin 3. indexindeki datanin cezayir oldugunu test edin

        String expectedData="Cezayir";
        String actualData=cell.toString();

        Assert.assertEquals(expectedData,actualData);














    }
}
