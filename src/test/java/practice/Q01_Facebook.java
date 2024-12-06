package practice;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilies.ReusableMethods;
import utilies.TestBaseEach;

import javax.swing.*;

public class Q01_Facebook extends TestBaseEach {

    @Test
    public void test01(){

        // 1. "https://facebook.com" Adresine gidin
        driver.get("https://facebook.com");

        // 2. “create new account” butonuna basin
        driver.findElement(By.xpath("//*[@*='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']"))
                .click();

        // 3. “firstName” giris kutusuna bir isim yazin
        Actions actions = new Actions(driver);
        ReusableMethods.bekle(1);

        WebElement firstNameElementi = driver.findElement(By.xpath("//*[text()='Adın']"));

        actions.click(firstNameElementi).sendKeys("Nazli").perform();

        // 4. “surname” giris kutusuna bir soyisim yazin
        WebElement surnameElementi = driver.findElement(By.xpath("//*[text()='Soyadın']"));

        actions.click(surnameElementi).sendKeys("Can").perform();

        // 5. “email” giris kutusuna bir email yazin
        WebElement emailElementi = driver.findElement(By.xpath("//*[text()='Cep telefonu numarası veya e-posta']"));

        actions.click(emailElementi).sendKeys("nazli@hotmail.com").perform();

        // 7. Bir sifre girin
        WebElement sifreElementi = driver.findElement(By.xpath("//*[text()='Yeni şifre']"));

        actions.click(sifreElementi).sendKeys("12345").perform();

        // 8. Tarih icin gun secin
        WebElement gunElementi = driver.findElement(By.xpath("//*[@id='day']"));

        Select selectGun = new Select(gunElementi);
        selectGun.selectByValue("30");

        // 9. Tarih icin ay secin
        WebElement ayElementi = driver.findElement(By.id("month"));

        Select selectAy = new Select(ayElementi);
        selectAy.selectByVisibleText("Ağu");

        // 10. Tarih icin yil secin
        WebElement yilElementi = driver.findElement(By.id("year"));

        Select selectYil = new Select(yilElementi);
        selectYil.selectByIndex(13);

        // 11. Cinsiyeti secin
        WebElement kadinButonu = driver.findElement(By.xpath("(//*[@*='_8esa'])[1]"));
        WebElement erkekButonu = driver.findElement(By.xpath("(//*[@*='_8esa'])[2]"));
        WebElement ozelButonu = driver.findElement(By.xpath("(//*[@*='_8esa'])[3]"));

        actions.click(kadinButonu).perform();

        // 12. Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
        Assertions.assertTrue(kadinButonu.isSelected());
        Assertions.assertFalse(erkekButonu.isSelected());
        Assertions.assertFalse(ozelButonu.isSelected());

    }

}
