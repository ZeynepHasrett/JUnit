package day08_windowSwitch_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilies.TestBaseEach;

import java.util.Set;

public class C02_KontrolsuzAcilanWindow extends TestBaseEach {

    @Test
    public void test01() {

        // https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        // Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement yaziElementi = driver.findElement(By.tagName("h3"));

        String expectedYazi = "Opening a new window";
        String actualYazi = yaziElementi.getText();

        Assertions.assertEquals(expectedYazi, actualYazi);

        // Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String ilkWindowWhd = driver.getWindowHandle();

        String expectedTitle = "The Internet";
        String actualTitle = driver.getTitle();

        Assertions.assertEquals(expectedTitle, actualTitle);

        // Click Here butonuna basın.
        driver.findElement(By.xpath("//*[text()='Click Here']"))
                .click();

        // Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu test edin.

        /*
            driver.getWindowHandle();
            method'u icerisinde oldugu window'un window handle degerini bize getirir
            ve biz de kaydedebiliriz

            bir window'un whd'ini kaydettikten sonra
            nerede olursak olalim
            driver.switchTo().window(hedefWindowunWHDi); ile bu window'a gecis yapabiliriz

            Kontrolsuz window acildiginda
            driver beklemedigi bir durum oldugundan
            yeni window'a gecmez, eski window'da kalir

            yeni window'a gecemedigimiz icin
            yeni window'un whd'ini de alamayiz
         */

        Set<String> tumWhdSeti = driver.getWindowHandles();

        System.out.println("Ilk window'un whd : " + ilkWindowWhd);
        System.out.println("Tum window handle degerleri seti : " + tumWhdSeti);

        String ikinciWindowWhd = "";

        for (String eachWhd : tumWhdSeti) {
            if (!eachWhd.equals(ilkWindowWhd)) {
                ikinciWindowWhd = eachWhd;
            }
        }

        driver.switchTo().window(ikinciWindowWhd);

        expectedTitle = "New Window";
        actualTitle = driver.getTitle();

        Assertions.assertEquals(expectedTitle, actualTitle);

        // Sayfadaki textin “New Window” olduğunu doğrulayın.
        yaziElementi = driver.findElement(By.tagName("h3"));

        expectedYazi = "New Window";
        actualYazi = yaziElementi.getText();

        Assertions.assertEquals(expectedYazi, actualYazi);

        // Bir önceki pencereye geri döndükten sonra sayfa başlığının
        // “The Internet” olduğunu test edin.
        driver.switchTo().window(ilkWindowWhd);

        expectedTitle = "The Internet";
        actualTitle = driver.getTitle();

        Assertions.assertEquals(expectedTitle, actualTitle);

    }

}
