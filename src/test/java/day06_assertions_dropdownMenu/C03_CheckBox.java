package day06_assertions_dropdownMenu;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import utilies.ReusableMethods;

import javax.swing.*;
import java.time.Duration;

public class C03_CheckBox {

    //    a. Verilen web sayfasına gidin.
    //       https://testotomasyonu.com/form
    //    b. Sirt Agrisi ve Carpinti checkbox’larini secin
    //    c. Sirt Agrisi ve Carpinti checkbox’larininin seçili olduğunu test edin
    //    d. Seker ve Epilepsi checkbox’larininin seçili olmadigini test edin

    static WebDriver driver;

    @BeforeAll
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterAll
    public static void teardown() {
        driver.quit();
    }

    @Test
    public void checkBoxTesti() {
        // Verilen web sayfasına gidin.
        // https://testotomasyonu.com/form
        driver.get("https://testotomasyonu.com/form");

        // Sirt Agrisi ve Carpinti checkbox’larini secin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        WebElement sirtAgrisiCheckBox = driver.findElement(By.id("gridCheck5"));
        sirtAgrisiCheckBox.click();

        WebElement carpintiCheckBox = driver.findElement(By.id("gridCheck4"));
        carpintiCheckBox.click();

        // Sirt Agrisi ve Carpinti checkbox’larininin seçili olduğunu test edin
        Assertions.assertTrue(sirtAgrisiCheckBox.isSelected());
        Assertions.assertTrue(carpintiCheckBox.isSelected());

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        // Seker ve Epilepsi checkbox’larininin seçili olmadigini test edin
        WebElement sekerCheckBox = driver.findElement(By.id("hastalikCheck2"));
        WebElement epilepsiCheckBox = driver.findElement(By.id("hastalikCheck7"));

        Assertions.assertFalse(sekerCheckBox.isSelected());
        Assertions.assertFalse(epilepsiCheckBox.isSelected());
    }

}
