package day10_waits_cookies;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import utilies.TestBaseEach;

public class C03_OlmayanElementiTestEtme extends TestBaseEach {

    @Test
    public void test01() {

        /*
            Olmayan veya gorunmeyen bir WebElementi test etmek icin
            olusacak exception'i belirleyip
            exception olusmasini TESTIN PASSED olmasi icin bir basamak yapmaliyiz

            exception olusmamasi durumunda ise TEST FAILED olmalidir
         */

        // 1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // 2. Remove butonuna basin
        WebElement chexboxElementi = driver.findElement(By.xpath("(//*[@*='checkbox'])[2]"));

        WebElement removeButonElementi = driver.findElement(By.xpath("(//*[@*='button'])[1]"));

        removeButonElementi.click();

        // it's gone yazisi gorununceye kadar bekleyin
        WebElement itsGoneYaziElementi = driver.findElement(By.id("message"));

        // 3. checkbox'in gorunur olmadigini test edin

         /*
            checkbox'i daha onceden locate ettigimiz icin
            StaleElementReferenceException verdi,

            eger onceden locate etmemis olsaydik
            bu satirda locate etmeye calissaydik
            implicitlyWait suresi kadar bekler ve sonra
            NoSuchElementException verirdi.
         */

        try {
            chexboxElementi.click();
            Assertions.assertTrue(false, "checkbox gorunur durumda");
            // checkbox kutusunun OLMAMASI gerekiyor
            // var ve click yapildi ise TEST FAILED OLMALIDIR
        } catch (StaleElementReferenceException e) {
            // StaleElementReferenceException olusmasi
            // o elementin gorunur olmadigini ispatlar
            // testin PASSED OLMASI gerekir
            Assertions.assertTrue(true);
        }

        // 4. Add buttonuna basin
        driver.findElement(By.xpath("(//*[@type='button'])[1]"))
                .click();

        // 5. checkbox'in gorunur oldugunu test edin
        chexboxElementi = driver.findElement(By.xpath("//*[@id='checkbox']"));

        Assertions.assertTrue(chexboxElementi.isDisplayed());

    }

}
