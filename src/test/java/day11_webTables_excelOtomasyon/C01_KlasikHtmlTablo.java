package day11_webTables_excelOtomasyon;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilies.ReusableMethods;
import utilies.TestBaseEach;

import java.util.List;

public class C01_KlasikHtmlTablo extends TestBaseEach {

    @Test
    public void test01() {

        // 1."https://testotomasyonu.com/webtables" adresine gidin
        driver.get("https://testotomasyonu.com/webtables");

        // 2.Web table tum body’sini yazdirin
        WebElement tumBodyElementi = driver.findElement(By.tagName("tbody"));

        System.out.println("Tum body : \n" + tumBodyElementi.getText());

        System.out.println("=========================================");

        // 3. Web tablosunda "Comfortable Gaming Chair" bulundugunu test edin
        String expectedUrun = "Comfortable Gaming Chair";
        String actualUrun = tumBodyElementi.getText();

        Assertions.assertTrue(actualUrun.contains(expectedUrun));

        // 4. Web table’daki satir sayisinin 5 oldugunu test edin
        List<WebElement> satirElementleriList = driver.findElements(By.xpath("//tbody/tr"));

        int expectedSatirSayisi = 5;
        int actualSatirSayisi = satirElementleriList.size();

        Assertions.assertEquals(expectedSatirSayisi, actualSatirSayisi);

        // 5. Tum satirlari yazdirin
        int satirNo = 1;

        for (WebElement eachElement : satirElementleriList) {
            System.out.println(satirNo + ". satir : \n" + eachElement.getText());
            satirNo++;
        }

        System.out.println("=========================================");

        // 6. Web table’daki sutun sayisinin 4 olduğunu test edin
        //   Web tablolarinda sutun olarak gruplama yoktur
        //   body / satirlar / datalar vardir
        //   eger sutun sayisini bulmak isterseniz
        //   herhangi bir satirdaki data sayisina bakabiliriz
        //  ornegin 1.satirdaki datalara bakalim
        List<WebElement> birinciSatirDataElementleriList = driver.findElements(By.xpath("//tbody/tr[1]/td"));

        int expectedSutunSayisi = 4;
        int actualSutunSayisi = birinciSatirDataElementleriList.size();

        Assertions.assertEquals(expectedSutunSayisi, actualSutunSayisi);

        // 7. 3.sutunu yazdirin
        //   Web tablolarinda sutun olarak gruplama yoktur
        //   3.sutun diyemedigimiz icin
        //   her satirdaki 3.datayi alip sutunu olustururuz
        List<WebElement> ucuncuSutunElementleriList = driver.findElements(By.xpath("//tbody/tr[*]/td[3]"));

        System.out.println("Ucuncu sutun elementleri : " + ReusableMethods.stringListeyeDonustur(ucuncuSutunElementleriList));

        // 8. Tablodaki basliklari yazdirin
        WebElement baslikSatirElementi = driver.findElement(By.xpath("//thead/tr"));

        System.out.println("Baslik satiri : " + baslikSatirElementi.getText());

        // 9. Satir ve sutunu parametre olarak alip, hucredeki bilgiyi döndüren bir method olusturun
        System.out.println(getHucreData(3, 1)); // Medium 25 L Laptop Backpack
        // For Office/College/Travel (Black, Yellow)
        System.out.println(getHucreData(1, 3)); // $399.00

        // 10. 4.satirdaki category degerinin "Furniture" oldugunu test edin
        String expectedData = "Furniture";
        String actualData = getHucreData(4, 2);

        Assertions.assertEquals(expectedData, actualData);

    }

    public String getHucreData(int satir, int sutun) {

        //              //tbody/tr[  3   ]/td[   1   ]

        String dinamikXpath = "//tbody/tr[" + satir + "]/td[" + sutun + "]";

        WebElement hedefHucreElementi = driver.findElement(By.xpath(dinamikXpath));

        return hedefHucreElementi.getText();

    }

}
