package day08_windowSwitch_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilies.ReusableMethods;
import utilies.TestBaseEach;

public class C05_WindowDegistirme extends TestBaseEach {

    @Test
    public void test01() {

        // https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        // sayfadaki elemental selenium linkini tiklayin
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']"))
                .click();

        // acilan yeni window'da buyuk basligin "Elemental Selenium" oldugunu test edin
        ReusableMethods.urlIleWindowDegistir(driver, "https://elementalselenium.com/");

        String expectedTitle = "Elemental Selenium";
        String actualTitle = driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).getText();

        Assertions.assertEquals(expectedTitle, actualTitle);

        // ilk window'a geri donun
        ReusableMethods.urlIleWindowDegistir(driver, "https://the-internet.herokuapp.com/windows");

        // "Opening a new window" yazisinin gorunur oldugunu test edin
        WebElement yaziElementi = driver.findElement(By.xpath("//*[text()='Opening a new window']"));

        Assertions.assertTrue(yaziElementi.isDisplayed());

        // Click here'a basin
        driver.findElement(By.xpath("//*[.='Click Here']"))
                .click();

        // Acilan yeni window'a gecip, oradaki yazinin "New Window" oldugunu test edin
        ReusableMethods.urlIleWindowDegistir(driver, "https://the-internet.herokuapp.com/windows/new");

        String expectedYazi = "New Window";
        String actualYazi = driver.findElement(By.tagName("h3")).getText();

        Assertions.assertEquals(expectedYazi, actualYazi);

        // Elemental selenium'un acik oldugu window'a gecin
        ReusableMethods.urlIleWindowDegistir(driver, "https://elementalselenium.com/");

        // Tips linkinin erisilebilir oldugunu test edin
        WebElement tipsLinki = driver.findElement(By.xpath("//*[text()='Tips']"));

        Assertions.assertTrue(tipsLinki.isEnabled());

    }

}
