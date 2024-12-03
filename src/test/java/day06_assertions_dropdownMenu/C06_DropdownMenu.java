package day06_assertions_dropdownMenu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilies.ReusableMethods;
import utilies.TestBaseEach;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C06_DropdownMenu extends TestBaseEach {

    @Test
    public void test01() {
        //  https://testotomasyonu.com/form adresine gidin.
        driver.get("https://testotomasyonu.com/form");

        //  1.Dogum tarihi gun seçeneğinden index kullanarak 5’i secin

        // 1.adim : dropdown menuyu locate edip, bir webelement olarak class'da kaydedelim
        WebElement gunDdm = driver.findElement(By.xpath("(//select[@class='form-control'])[1]"));
        ;
        // 2.adim : bir select objesi olusturun ve parametre olarak
        //          kullanmak istediginiz dropdown menuyu girin
        Select selectGun = new Select(gunDdm);
        // 3.adim : olusturdugumuz selectGun objesi sayesinde
        //          Select class'indaki hazir method'lar ile istenen islemleri yapabiliriz
        selectGun.selectByIndex(5);

        //	2. Dogum tarihi ay seçeneğinden value kullanarak Nisan’i secin
        WebElement ayDdm = driver.findElement(By.xpath("(//select[@class='form-control'])[2]"));
        Select selectAy = new Select(ayDdm);
        selectAy.selectByValue("nisan");

        //	3. Dogum tarihi yil seçeneğinden visible text kullanarak 1990’i secin
        WebElement yilddm = driver.findElement(By.xpath("(//select[@class='form-control'])[3]"));
        Select selectYil = new Select(yilddm);
        selectYil.selectByVisibleText("1990");

        //	4. Secilen değerleri konsolda yazdirin
        System.out.println(selectGun.getFirstSelectedOption().getText());
        System.out.println(selectAy.getFirstSelectedOption().getText());
        System.out.println(selectYil.getFirstSelectedOption().getText());

        //	5. Ay dropdown menüdeki tum değerleri(value) yazdırın
        List<WebElement> ayDdmOptionElementleriList = new ArrayList<>(selectAy.getOptions());

        for (WebElement eachElement : ayDdmOptionElementleriList) {
            System.out.println(eachElement.getText());
        }

        // Ay dropdown menusunde "Ocak" degerinin bulundugunu test edin

        //1.yontem : dropdown uzerinden olusturdugumuz ayDdm.getText()
        //           menudeki tum ay isimlerini getirir
        String expectedAyIcerik = "Ocak";
        String actualAyIcerik = ayDdm.getText();
        System.out.println("Actual Ay Icerik : " + actualAyIcerik);
        Assertions.assertTrue(actualAyIcerik.contains(expectedAyIcerik));

        // 2.yontem : tum opsiyonlarin yazilarini olusturdugumuz
        //            String bir listeye ekleyebiliriz
        //            sonra list.contains() ile testimizi yapabiliriz
        List<String> tumListeStr = new ArrayList<>();

        for (WebElement eachBaslik : ayDdmOptionElementleriList) {
            tumListeStr.add(eachBaslik.getText());
        }

        String expectedBaslikIsmi = "Ocak";
        Assertions.assertTrue(tumListeStr.contains(expectedBaslikIsmi));

        // 3.yontem ReusableMethods class'indaki method'u kullanalim
        List<String> ayDropdownMenuMetinleri = ReusableMethods.stringListeyeDonustur(ayDdmOptionElementleriList);
        Assertions.assertTrue(ayDropdownMenuMetinleri.contains("Ocak"));

        //	6. Ay Dropdown menusunun boyutunun 13 olduğunu test edin
        int expectedDropdownBoyutu = 13;
        int actualDropdownBoyutu = ayDdmOptionElementleriList.size();
        Assertions.assertEquals(expectedDropdownBoyutu, actualDropdownBoyutu);

    }

}
