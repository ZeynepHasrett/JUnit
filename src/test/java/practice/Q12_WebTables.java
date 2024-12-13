package practice;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilies.ReusableMethods;
import utilies.TestBaseEach;

import java.util.List;

public class Q12_WebTables extends TestBaseEach {

    @Test
    public void test01() {

        // 1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");

        // 2. Headers'da bulunan basliklari yazdirin
        List<WebElement> baslikElementleriList = driver.findElements(By.xpath("//div[@class='rt-tr']/div[@role='columnheader']"));

        System.out.println(ReusableMethods.stringListeyeDonustur(baslikElementleriList));

        // 3. 3.sutunun basligini yazdirin
        System.out.println("3.sutun basligi : " + baslikElementleriList.get(2).getText());

        // 4. Tablodaki tum datalari yazdirin
        List<WebElement> tumDataElementleriList = driver.findElements(By.xpath("//div[@class='rt-tr-group']//div[@role='gridcell']"));

        System.out.println(ReusableMethods.stringListeyeDonustur(tumDataElementleriList));

        // 5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin

        int actionsSutunuBosOlmayanHucrelerSayaci = 0;

        for (WebElement eachElement : tumDataElementleriList) {
            if (eachElement.getText().equals("")) {
                actionsSutunuBosOlmayanHucrelerSayaci++;
            }

        }

        int digerBosOlmayanHucrelerSayaci = 0;

        for (WebElement eachElement : tumDataElementleriList) {
            if (!eachElement.getText().isBlank()) {
                digerBosOlmayanHucrelerSayaci++;
            }

        }

        System.out.println("Bos olmayan cell sayisi : " + (actionsSutunuBosOlmayanHucrelerSayaci + digerBosOlmayanHucrelerSayaci));

        // 6. Tablodaki satir sayisini yazdirin
        List<WebElement> satirElementleriList = driver.findElements(By.xpath("//div[@class='rt-tr-group']"));

        System.out.println("Satir sayisi : " + satirElementleriList.size());

        // 7. Tablodaki sutun sayisini yazdirin
        List<WebElement> sutunElementleriList = driver.findElements(By.xpath("(//div[@class='rt-tr-group'])[1]//div[@role='gridcell']"));

        System.out.println("Sutun sayisi : " + sutunElementleriList.size());

        // 8. Tablodaki 3.kolonu yazdirin
        List<WebElement> ucuncuKolonElementleriList = driver.findElements(By.xpath("(//div[@class='rt-tr-group'])[*]//div[@role='gridcell'][3]"));

        System.out.println(ReusableMethods.stringListeyeDonustur(ucuncuKolonElementleriList));

        // 9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
        WebElement salaryElementi = driver.findElement(By.xpath("(//div[@class='rt-tr-group'])[3]//div[@role='gridcell'][5]"));

        System.out.println("First Name'i Kierra olan kisinin Salary'si : " + salaryElementi.getText());

        // 10. Bir method olusturun,
        //     Test sayfasindan satir ve sutun sayisi girildiginde datayi yazdirsin

        getHucreData(2, 3);

    }

    public void getHucreData(int satir, int sutun) {

        //      (//div[@class='rt-tr-group'])[  3   ]//div[@role='gridcell'][   5   ]

        String dinamikXpath = "(//div[@class='rt-tr-group'])[" + satir + "]//div[@role='gridcell'][" + sutun + "]";

        WebElement hedefHucreElementi = driver.findElement(By.xpath(dinamikXpath));

        System.out.println(hedefHucreElementi.getText());

    }

}
