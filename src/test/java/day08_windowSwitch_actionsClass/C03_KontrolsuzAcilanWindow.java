package day08_windowSwitch_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v128.page.model.SecureContextType;
import utilies.TestBaseEach;

import java.util.Set;

public class C03_KontrolsuzAcilanWindow extends TestBaseEach {

    @Test
    public void test01() {

        // https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        String ilkWindowWhd = driver.getWindowHandle();

        // sayfadaki Elemental Selenium linkini tiklayin
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']"))
                .click();

        // acilan yeni window'a gecin
        Set<String> acikTumWindowlarinWhd = driver.getWindowHandles();

        String ikinciWindowWhd = "";

        for (String eachWhd : acikTumWindowlarinWhd) {
            if (!eachWhd.equals(ilkWindowWhd)) {
                ikinciWindowWhd = eachWhd;
            }
        }

        driver.switchTo().window(ikinciWindowWhd);

        // buyuk basligin "Elemental Selenium" oldugunu test edin.
        String expectedYazi = "Elemental Selenium";
        String actualYazi = driver.findElement(By.tagName("h1")).getText();

        Assertions.assertEquals(expectedYazi, actualYazi);

    }

}
