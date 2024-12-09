package practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilies.TestBaseEach;

public class Q08_Iframe extends TestBaseEach {

    @Test
    public void iframeTest() {
        // 1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");

        // 2 ) Bir metod olusturun: iframeTest
        //     - “An IFrame containing….” textinin erisilebilir oldugunu test edin ve
        //       konsolda yazdirin.
        WebElement textElementi = driver.findElement(By.tagName("h3"));

        Assertions.assertTrue(textElementi.isEnabled());

        System.out.println(textElementi.getText());

        //     - Text Box’a “Merhaba Dunya!” yazin.
        WebElement iframe = driver.findElement(By.id("mce_0_ifr"));

        driver.switchTo().frame(iframe);

        WebElement textBox = driver.findElement(By.className("mce-content-body mce-content-readonly"));

        textBox.sendKeys("Merhaba Dunya!");

        //     - TextBox’in altinda bulunan “Elemental Selenium” linkini textinin
        //       gorunur oldugunu dogrulayin ve konsolda yazdirin.
        WebElement elementalSeleniumYazisi = driver.findElement(By.xpath("//*[.='Elemental Selenium']"));

        Assertions.assertTrue(elementalSeleniumYazisi.isDisplayed());

        System.out.println(elementalSeleniumYazisi.getText());

    }

}
