package day09_actionsClass_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilies.ReusableMethods;
import utilies.TestBaseEach;

public class C02_FormDoldurma extends TestBaseEach {

    @Test
    public void test01() {

        // 1- https://www.testotomasyonu.com adresine gidelim
        driver.get("https://www.testotomasyonu.com");

        //2- Account linkine tiklayin
        driver.findElement(By.xpath("(//span[@class='menu-icon-text'])[1]"))
                .click();

        //3- Sign Up linkine basalim
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        WebElement signUpButonElementi = driver.findElement(By.xpath("//*[@*='sign-up ']"));

        signUpButonElementi.click();

        //4- Ad, soyad, mail ve sifre kutularina deger yazalim
        // ve Sign Up butonuna basalim
        WebElement firstNameButonu = driver.findElement(By.xpath("//*[@id='firstName']"));

        firstNameButonu.sendKeys("Nazli" + Keys.TAB + "Can" + Keys.TAB + "nazlican@gmail.com" + Keys.TAB + "12345" + Keys.TAB + "12345");

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        driver.findElement(By.id("btn-submit-form"))
                .click();

        //5- Kaydin olusturuldugunu test edin
        WebElement emailElementi = driver.findElement(By.xpath("//*[@id='email']"));

        emailElementi.sendKeys("nazlican@gmail.com" + Keys.TAB + "12345");

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        driver.findElement(By.id("submitlogin"))
                .click();

        WebElement logOutButonElementi = driver.findElement(By.xpath("//span[.='Logout']"));

        Assertions.assertTrue(logOutButonElementi.isDisplayed());

    }

}
