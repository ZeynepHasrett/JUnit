package day06_assertions_dropdownMenu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilies.TestBaseEach;

public class C08_DropdownMenu extends TestBaseEach {

    @Test
    public void test01() {

        // 1. http://zero.webappsecurity.com/ adresine gidin
        driver.get("http://zero.webappsecurity.com/");

        // 2. Sign in butonuna basin
        driver.findElement(By.id("signin_button")).click();

        // 3. Login kutusuna “username” yazin
        WebElement loginKutusu = driver.findElement(By.id("user_login"));
        loginKutusu.sendKeys("username");

        // 4. Password kutusuna “password” yazin
        WebElement passwordKutusu = driver.findElement(By.id("user_password"));
        passwordKutusu.sendKeys("password");

        // 5. Sign in tusuna basin, back tusuna basarak sayfaya donun
        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
        driver.navigate().back();

        // 6. Online banking menusunden Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//*[@id='onlineBankingMenu']")).click();
        driver.findElement(By.id("pay_bills_link")).click();

        // 7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.linkText("Purchase Foreign Currency")).click();

        // 8. “Currency” drop down menusunden Eurozone’u secin
        WebElement ddm = driver.findElement(By.id("pc_currency"));
        Select select = new Select(ddm);
        select.selectByValue("EUR");

        // 9. “amount” kutusuna bir sayi girin
        WebElement amountKutusu = driver.findElement(By.id("pc_amount"));
        amountKutusu.sendKeys("100");

        // 10.“US Dollars” in secilmedigini test edin
        WebElement checkBox = driver.findElement(By.id("pc_inDollars_true"));
        Assertions.assertFalse(checkBox.isSelected());

        // 11.“Selected currency” butonunu secin
        driver.findElement(By.id("pc_inDollars_false")).click();

        // 12.“Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.id("pc_calculate_costs")).click();
        driver.findElement(By.id("purchase_cash")).click();

        // 13.“Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.
        WebElement sonucYazisi = driver.findElement(By.id("alert_content"));

        String expectedSonucYazisi = "Foreign currency cash was successfully purchased.";
        String actualSonucYazisiStr = sonucYazisi.getText();

        Assertions.assertEquals(expectedSonucYazisi, actualSonucYazisiStr);

    }

}
