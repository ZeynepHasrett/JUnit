package practice;

import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import utilies.TestBaseEach;

import java.util.Set;

public class Q11_Cookies extends TestBaseEach {

    @Test
    public void test01() {

        // 1- amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        // 2- tum cookie’leri listeleyin
        Set<Cookie> tumCookieSeti = driver.manage().getCookies();

        // 3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        int actualCookiesSayisi = tumCookieSeti.size();

        Assertions.assertTrue(actualCookiesSayisi > 5);

        // 4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        String expectedDeger = "USD";
        String actualDeger = driver.manage().getCookieNamed("i18n-prefs").getValue();

        Assertions.assertEquals(expectedDeger, actualDeger);

        // 5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie
        //    olusturun ve sayfaya ekleyin
        Cookie benimCookie = new Cookie("en sevdigim cookie", "cikolatali");

        driver.manage().addCookie(benimCookie);

        // 6- eklediginiz cookie’nin sayfaya eklendigini test edin
        tumCookieSeti = driver.manage().getCookies();

        Assertions.assertTrue(tumCookieSeti.contains(benimCookie));


        // 7- ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");

        tumCookieSeti = driver.manage().getCookies();

        boolean skinVarMi = false;

        for (Cookie eachCookie : tumCookieSeti) {
            if (eachCookie.getName().equals("skin")) {
                skinVarMi = true;
            }

        }

        Assertions.assertFalse(skinVarMi);

        // 8- tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();

        tumCookieSeti = driver.manage().getCookies();

        Assertions.assertEquals(0, tumCookieSeti.size());

    }

}
