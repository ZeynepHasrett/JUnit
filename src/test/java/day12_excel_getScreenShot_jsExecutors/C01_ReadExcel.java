package day12_excel_getScreenShot_jsExecutors;

import dev.failsafe.internal.util.Assert;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {

    @Test
    public void test01() throws IOException {

        // Gerekli ayarlamalari yapip, ulkeler excelindeki Sayfa1’e gidin
        String dosyaYolu = "src/test/java/day11_webTables_excelOtomasyon/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sayfa1Obj = workbook.getSheet("Sayfa1");

        // 1.satirdaki 2.hucreye gidin ve yazdirin
        System.out.println(sayfa1Obj.getRow(0).getCell(1)); // Başkent (İngilizce)

        // 1.satirdaki 2.hucreyi bir string degiskene atayin
        //   ve degerinin “Başkent (İngilizce)” oldugunu test edin
        String expectedHucreDegeri = "Başkent (İngilizce)";
        String satir1Hucre2 = sayfa1Obj.getRow(0).getCell(1).getStringCellValue();

        Assertions.assertEquals(expectedHucreDegeri, satir1Hucre2);

        // 2.satir 4.cell’in Afganistan’in baskenti “Kabil” oldugunu test edin
        String expectedData = "Kabil";
        String actualData = sayfa1Obj.getRow(1).getCell(3).getStringCellValue();

        Assertions.assertEquals(expectedData, actualData);

        // Ulke sayisinin 190 oldugunu test edin
        int expectedUlkeSayisi = 190;
        int actualUlkeSayisi = sayfa1Obj.getLastRowNum() + 1 - 1;
        // +1  method bize index getiriyor, satir sayisini bulmak icin +1 ekliyoruz
        // -1  basta baslik satiri oldugundan satir sayisindan 1 cikartarak ulke sayisini bulabiliriz

        Assertions.assertEquals(expectedUlkeSayisi, actualUlkeSayisi);

        // Fiziki olarak kullanilan satir sayisinin 191 oldugunu test edin
        int expectedKullanilanSatirSayisi = 191;
        int actualKullanilanSatirSayisi = sayfa1Obj.getPhysicalNumberOfRows();

        Assertions.assertEquals(expectedKullanilanSatirSayisi, actualKullanilanSatirSayisi);

        // Ingilizce ismi Netherlands olan ulkenin baskentinin Turkce Amsterdam oldugunu test edin
        for (int i = 1; i <= sayfa1Obj.getLastRowNum(); i++) {
            String satirdakiUlkeIsmi = sayfa1Obj.getRow(i).getCell(0).getStringCellValue();

            if (satirdakiUlkeIsmi.equals("Netherlands")) {
                String actualTurkceBaskentIsmi = sayfa1Obj.getRow(i).getCell(3).getStringCellValue();
                Assertions.assertEquals("Amsterdam", actualTurkceBaskentIsmi);
                break;
            }
        }

        // Turkce baskent isimlerinde Ankara bulundugunu test edin
        boolean ankaraVarmi = false;

        for (int i = 1; i <= sayfa1Obj.getLastRowNum(); i++) {
            String satirdakiTurkceBaskentIsmi = sayfa1Obj.getRow(i).getCell(3).getStringCellValue();

            if (satirdakiTurkceBaskentIsmi.equals("Ankara")) {
                ankaraVarmi = true;
                break;
            }

        }

        Assertions.assertTrue(ankaraVarmi);

        // Turkce baskent isminde buyuk A olan ulke sayisini bulun
        int sayac = 0;

        for (int i = 1; i <= sayfa1Obj.getLastRowNum() ; i++) {

            if (sayfa1Obj.getRow(i).getCell(3).getStringCellValue().contains("A")){
                sayac++;
            }
        }

        System.out.println("Turkce baskent isminde buyuk A olan ulke sayisi : " + sayac);

        // Ingilizce ismi B ile baslayan kac ulke oldugunu bulun
        sayac = 0;

        for (int i = 1; i <= sayfa1Obj.getLastRowNum(); i++) {

            if (sayfa1Obj.getRow(i).getCell(0).getStringCellValue().startsWith("B")){
                sayac++;
            }

        }

        System.out.println("Ingilizce ismi B ile baslayan ulke sayisi : " + sayac);

    }

}
