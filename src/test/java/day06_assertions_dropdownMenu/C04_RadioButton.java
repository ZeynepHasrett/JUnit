package day06_assertions_dropdownMenu;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import utilies.ReusableMethods;

import java.time.Duration;

public class C04_RadioButton {

    //    a. Verilen web sayfasına gidin.
    //       https://testotomasyonu.com/form
    //    b. Cinsiyet Radio button elementlerini locate edin
    //    c. Iki farkli test method’u oluşturup yazidan veya direkt buton’dan size uygun olani secin
    //    d. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin


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
    public void yazidanSecimTesti() {
        driver.get("https://testotomasyonu.com/form");

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        // Cinsiyet Radio button elementlerini locate edin
        WebElement kadinButon = driver.findElement(By.id("inlineRadio1"));
        WebElement erkekButon = driver.findElement(By.id("inlineRadio2"));
        WebElement digerButon = driver.findElement(By.id("inlineRadio3"));

        WebElement kadinButonYazisi = driver.findElement(By.xpath("//*[@for='inlineRadio1']"));

        // Iki farkli test method’u oluşturup yazidan veya direkt buton’dan size uygun olani secin
        kadinButonYazisi.click();

        // Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin
        Assertions.assertTrue(kadinButon.isSelected());
        Assertions.assertFalse(erkekButon.isSelected());
        Assertions.assertFalse(digerButon.isSelected());
    }

    @Test
    public void butondanSecimTesti() {
        driver.get("https://testotomasyonu.com/form");

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        // Cinsiyet Radio button elementlerini locate edin
        WebElement kadinButon = driver.findElement(By.id("inlineRadio1"));
        WebElement erkekButon = driver.findElement(By.id("inlineRadio2"));
        WebElement digerButon = driver.findElement(By.id("inlineRadio3"));

        kadinButon.click();

        Assertions.assertTrue(kadinButon.isSelected());
        Assertions.assertFalse(erkekButon.isSelected());
        Assertions.assertFalse(digerButon.isSelected());
    }

}
