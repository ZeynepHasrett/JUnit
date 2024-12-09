package practice;

import com.github.javafaker.Faker;
import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.ScriptTimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilies.ReusableMethods;
import utilies.TestBaseEach;

public class Q03_FacebookActions extends TestBaseEach {

    @Test
    public void test01() {

        // 1. "https://facebook.com" Adresine gidin
        driver.get("https://facebook.com");

        // 2. “create new account” butonuna basin
        driver.findElement(By.xpath("//*[text()='Yeni hesap oluştur']"))
                .click();

        // 3. “firstName” giris kutusuna bir isim yazin
        // 4. “surname” giris kutusuna bir soyisim yazin
        // 5. Tarih icin gun secin
        // 6. Tarih icin ay secin
        // 7  Tarih icin yil secin
        Actions actions = new Actions(driver);
        ReusableMethods.bekle(1);

        WebElement firstNameKutusu = driver.findElement(By.xpath("//*[text()='Adın']"));

        Faker faker = new Faker();

        actions.click(firstNameKutusu)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).perform();

        ReusableMethods.bekle(2);

        WebElement gunDropDownBox = driver.findElement(By.id("day"));
        WebElement ayDropDownBox = driver.findElement(By.id("month"));
        WebElement yilDropDownBox = driver.findElement(By.id("year"));

        actions.click(gunDropDownBox)
                .sendKeys("3")
                .sendKeys(Keys.TAB)
                .click(ayDropDownBox)
                .sendKeys("Şub")
                .sendKeys(Keys.TAB)
                .click(yilDropDownBox)
                .sendKeys("2010")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .perform();

        ReusableMethods.bekle(2);

        // 8. Cinsiyeti secin
        WebElement kadinCheckBox = driver.findElement(By.xpath("(//*[@*='_8esa'])[1]"));
        WebElement erkekCheckBox = driver.findElement(By.xpath("(//*[@*='_8esa'])[2]"));
        WebElement ozelCheckBox = driver.findElement(By.xpath("(//*[@*='_8esa'])[3]"));

        actions.click(kadinCheckBox)
                .sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.ARROW_LEFT).perform();

        ReusableMethods.bekle(2);

        // 9. Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin
        Assertions.assertTrue(kadinCheckBox.isSelected());
        Assertions.assertFalse(erkekCheckBox.isSelected());
        Assertions.assertFalse(ozelCheckBox.isSelected());

        // 10. “email” giris kutusuna bir email yazin
        // 11. Bir sifre girin
        WebElement emailKutusu = driver.findElement(By.xpath("//*[text()='Cep telefonu numarası veya e-posta']"));

        actions.click(emailKutusu)
                .sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password()).perform();

        ReusableMethods.bekle(2);

        // 12. Kaydol butonuna tiklayin
        driver.findElement(By.xpath("(//*[text()='Kaydol'])[1]"))
                .click();

        ReusableMethods.bekle(2);

    }

}
