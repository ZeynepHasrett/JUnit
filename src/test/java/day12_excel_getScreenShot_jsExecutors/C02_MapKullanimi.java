package day12_excel_getScreenShot_jsExecutors;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class C02_MapKullanimi {

    @Test
    public void test01() throws IOException {

        // Gerekli ayarlamalari yapip, ulkeler excelindeki Sayfa1’e gidin
        String dosyaYolu = "src/test/java/day11_webTables_excelOtomasyon/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sayfa1 = workbook.getSheet("Sayfa1");

        // Eger Ingilizce ulke isimleri ve Turkce baskent isimleri ile
        // birden fazla test varsa
        // her seferinde for loop yapmak yerine
        // data'lara daha rahat ulasabilecegimiz bir Java objesi olan Map'e kaydedebiliriz

        Map<String, String> ulkelerBaskentlerMapi = new TreeMap<>();

        for (int i = 1; i <= sayfa1.getLastRowNum(); i++) {

            String ingilizceUlkeIsmi = sayfa1.getRow(i).getCell(0).getStringCellValue();
            String turkceBaskentIsmi = sayfa1.getRow(i).getCell(3).getStringCellValue();

            ulkelerBaskentlerMapi.put(ingilizceUlkeIsmi, turkceBaskentIsmi);
        }

        // Ingilizce ismi Netherlands olan ulkenin baskentinin turkce Amsterdam oldugunu test edin
        String istenenbaskent = ulkelerBaskentlerMapi.get("Netherlands");
        String expectedBaskent = "Amsterdam";

        Assertions.assertEquals(expectedBaskent, istenenbaskent);

        // Turkce baskent isimlerinde Ankara bulundugunu test edin
        Assertions.assertTrue(ulkelerBaskentlerMapi.containsValue("Ankara"));

        // Ulkeler Excel'inde Ghana var mi test edin
        Assertions.assertTrue(ulkelerBaskentlerMapi.containsKey("Ghana"));

    }

}
