package day09_actionsClass_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilies.ReusableMethods;
import utilies.TestBaseEach;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C08_DosyaIndirmeTesti extends TestBaseEach {

    @Test
    public void test01() {

        // 1. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");

        // 2. Checklist.pdf dosyasını indirelim
        driver.findElement(By.xpath("//*[text()='Checklist.pdf']"))
                .click();
        ReusableMethods.bekle(2);

        // 3. Dosyanın başarıyla indirilip indirilmediğini test edelim
        String dinamikDosyayolu = System.getProperty("user.home") + "\\Downloads\\Checklist.pdf";

        Assertions.assertTrue(Files.exists(Paths.get(dinamikDosyayolu)));

    }

}
