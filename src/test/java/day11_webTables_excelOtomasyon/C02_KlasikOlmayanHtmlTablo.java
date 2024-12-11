package day11_webTables_excelOtomasyon;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilies.ReusableMethods;
import utilies.TestBaseEach;

import java.util.List;

public class C02_KlasikOlmayanHtmlTablo extends TestBaseEach {

    @Test
    public void test01() {

        // 1. “https://testotomasyonu.com/webtables2” sayfasina gidin
        driver.get("https://testotomasyonu.com/webtables2");

        // 2. Headers'da bulunan basliklari yazdirin
        List<WebElement> baslikElementleriList = driver.findElements(By.xpath("//*[@role='hdata']"));

        System.out.println("Basliklar listesi : " + ReusableMethods.stringListeyeDonustur(baslikElementleriList));

        // 3. 3.sutunun basligini yazdirin
        System.out.println("3.sutun basligi : " + baslikElementleriList.get(2).getText());

        // 4. Tablodaki tum datalari yazdirin
        List<WebElement> tumDataElementleriList = driver.findElements(By.xpath("//*[@role='trow']//div[@role='tdata']"));

        System.out.println("Tum body : \n" + ReusableMethods.stringListeyeDonustur(tumDataElementleriList));

        // 5. Tabloda kac tane cell (data) oldugunu yazdirin
        System.out.println("Tablodaki data sayisi : " + tumDataElementleriList.size());

        // 6. Tablodaki satir sayisini yazdirin
        List<WebElement> satirElementleriList = driver.findElements(By.xpath("//div[@role='trow']"));

        System.out.println("Tablodaki satir sayisi : " + satirElementleriList.size());

        // 7. Tablodaki sutun sayisini yazdirin
        System.out.println("Tablodaki sutun sayisi : " + baslikElementleriList.size());

        // 8. Tablodaki 3.kolonu yazdirin
        List<WebElement> ucuncuKolonElementleriList = driver.findElements(By.xpath("//div[@role='trow']/div[@role='tdata'][3]"));

        System.out.println("Ucuncu sutun : " + ReusableMethods.stringListeyeDonustur(ucuncuKolonElementleriList));

        // 9. Bir method olusturun,
        // Test method'undan satir ve sutun verildiginde datayi dondursun
        System.out.println(getHucreData(1, 1)); // DELL Core I3 11th Gen

        System.out.println(getHucreData(2, 2)); // Electronics

        System.out.println(getHucreData(3, 4)); // Go

        // 10. Tabloda "Category" si Furniture olan urunun fiyatini yazdirin
        for (int i = 1; i <= satirElementleriList.size(); i++) {

            String satirdakiCategoryDegeri = getHucreData(i, 2);
            String satirdakiUrunFiyati = getHucreData(i, 3);

            if (satirdakiCategoryDegeri.equalsIgnoreCase("Furniture")) {
                System.out.println(satirdakiUrunFiyati);
            }

        }

    }

    public String getHucreData(int satir, int sutun) {

        // //*[@role='trow'][3]/div[@role='tdata'][3]

        String dinamikXpath = "//*[@role='trow'][" + satir + "]/div[@role='tdata'][" + sutun + "]";

        WebElement hedefHucreElementi = driver.findElement(By.xpath(dinamikXpath));

        return hedefHucreElementi.getText();

    }

}
