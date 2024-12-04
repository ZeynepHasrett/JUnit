package day08_windowSwitch_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilies.TestBaseEach;

import java.util.Set;

public class C04_HedefUrlIleWindowDegistirme extends TestBaseEach {

    @Test
    public void test01() {

        // https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        // sayfadaki Elemental Selenium linkini tiklayin
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']"))
                .click();

        // acilan yeni window'a gecin
        String hedefUrl = "https://elementalselenium.com/";

        // acik olan tum window'larin whd'lerini kaydedelim
        Set<String> tumWindowWhdSeti = driver.getWindowHandles();

        // bir for-each loop ile tum whd'lerini gozden gecirip
        // her windowhandle degerinin sayfasina gecelim
        // eger gectigimiz sayfada url hedefUrl'e esit ise
        // loop'u bitirelim
        for (String eachWhd : tumWindowWhdSeti) {
            driver.switchTo().window(eachWhd);
            if (driver.getCurrentUrl().equals(hedefUrl)) {
                break;
            }
        }

        // buyuk basligin "Elemental Selenium" oldugunu test edin
        String expectedBaslikYazisi = "Elemental Selenium";
        String actualBaslikYazisi = driver.findElement(By.tagName("h1")).getText();

        Assertions.assertEquals(expectedBaslikYazisi, actualBaslikYazisi);

    }

}
