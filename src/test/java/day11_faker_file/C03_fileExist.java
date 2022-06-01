package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_fileExist {

    @Test
    public void test01() {

        System.out.println(System.getProperty("user.dir"));
        //bana icinde oldugum projenin dosya yolunu (path) verir
        //C:\Users\lenova\IdeaProjects\com.Batch59Unit

        System.out.println(System.getProperty("user.home"));
        //C:\Users\lenova yani benim bilgisayarimin bana ozel kismini verdi

        //masa ustumuzdeki text dosyasinin varligini test edin
        //"C:\Users\lenova\Desktop\text.txt"

        String dosyaYolu=System.getProperty("user.home")+"\\Desktop\\text.txt";
        System.out.println(dosyaYolu);

        /*
        bilgisayarimizdaki bir dosyanin varligini test etmek icin
         once o dosyaya ulasmamiz gerekir
         java da dosyaya erisim icin dosya yoluna (path) ihtiyac vardir
         her bilgisayarin kullanici adi farkli olacagindan
         masaustu dosya adi da birbirinden farkli olacaktir
         testlerimizin tum bilgisayarlarda calismasi icin dosya yolunu DİNAMİK yapmak zorundayiz

         bunun icin
         her bilgisayarin birbirinden farkli dosya yolunu bulmak icin
         */

        String farkliKisim=System.getProperty("user.home");

        //herkesin bilgisayarinda ortak olan kisim ise
        String ortakKisim="\\Desktop\\text.txt";

        String masaUstuDosyaYolu=farkliKisim+ortakKisim;

        Assert.assertTrue(Files.exists(Paths.get(masaUstuDosyaYolu)));//testi burdan yapiyoruz

        System.out.println(Files.exists(Paths.get(masaUstuDosyaYolu)));//yazdirmak istersek


    }

}
