package day11_webTables_excelOtomasyon;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilies.TestBaseEach;

import java.util.List;

public class C02_KlasikOlmayanHtmlTablo extends TestBaseEach {

    @Test
    public void test01(){

        // 1. “https://testotomasyonu.com/webtables2” sayfasina gidin
        driver.get("https://testotomasyonu.com/webtables2");

        // 2. Headers'da bulunan basliklari yazdirin
        List<WebElement> headersElementleri = driver.findElements(By.xpath("//*[@role='hdata']"));

        for (WebElement eachElement : headersElementleri){
            System.out.println(eachElement.getText());
        }

        // 3. 3.sutunun basligini yazdirin


        // 4. Tablodaki tum datalari yazdirin


        // 5. Tabloda kac tane cell (data) oldugunu yazdirin


        // 6. Tablodaki satir sayisini yazdirin


        // 7. Tablodaki sutun sayisini yazdirin


        // 8. Tablodaki 3.kolonu yazdirin


        // 9. Tabloda " Category" si Furniture olan urunun fiyatini yazdirin


        // 10. Bir method olusturun, Test sayfasindan satir ve sutun verildiginde datayi yazdirsin



    }

}
