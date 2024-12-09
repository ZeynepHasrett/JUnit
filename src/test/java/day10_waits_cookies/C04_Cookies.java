package day10_waits_cookies;

import com.sun.source.doctree.SeeTree;
import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import utilies.TestBaseEach;

import java.util.Set;

public class C04_Cookies extends TestBaseEach {

    @Test
    public void test01() {

        // Google'a gidelim
        driver.get("https://www.google.com");

        // cookies cikarsa kabul edin
        // sayfada kac adet cookies bulundugunu yazdirin
        Set<Cookie> tumCookieSeti = driver.manage().getCookies();

        System.out.println("Sayfadaki cookie adedi : " + tumCookieSeti.size());

        // sayfadaki cookie'leri yazdirin
        System.out.println(tumCookieSeti);

        // daha derli toplu yazdiralim
        int siraNo = 1;

        for (Cookie eachCookie : tumCookieSeti) {
            System.out.println(siraNo + ". cookie : " + eachCookie);
            siraNo++;
        }

        System.out.println("=============");
        // cookie'lerin isimlerini yazdirin
        siraNo = 1;

        for (Cookie eachCookie : tumCookieSeti) {
            System.out.println(siraNo + ". cookie : " + eachCookie.getName());
            siraNo++;
        }

        // ismi NID olan cookie'nin degerinin
        // 519 icerdigini test edin

        String expectedDegerIcerik = "519";
        String actualDeger = driver.manage().getCookieNamed("NID").getValue();

        Assertions.assertTrue(actualDeger.contains(expectedDegerIcerik));

        // ismi enSevdigimCookie, degeri cikolataliCookie olan bir cookie olusturup
        // sayfaya ekleyelim
        Cookie benimCookie = new Cookie("enSevdigimCookie", "cikolataliCookie");

        driver.manage().addCookie(benimCookie);

        // tum cookieleri yazdiralim
        tumCookieSeti = driver.manage().getCookies();

        siraNo = 1;

        for (Cookie eachCookie : tumCookieSeti) {
            System.out.println(siraNo + ". cookie : " + eachCookie);
            siraNo++;
        }

        // cookie'yi ekleyebildiginizi test edin
        Assertions.assertTrue(tumCookieSeti.contains(benimCookie));

        // ismi NID olan cookie'yi silin
        driver.manage().deleteCookieNamed("NID");

        System.out.println("=============");
        // cookie'lerin isimlerini yazdirin
        tumCookieSeti = driver.manage().getCookies();

        siraNo = 1;

        for (Cookie eachCookie : tumCookieSeti) {
            System.out.println(siraNo + ". cookie : " + eachCookie.getName());
            siraNo++;
        }

        // ve silindigini test edin
        boolean nidVarmi = false;

        for (Cookie eachCookie : tumCookieSeti) {
            if (eachCookie.getName().equals("NID")) {
                nidVarmi = true;
            }

        }

        // tum cookie'lerin isimlerini kontrol ettik
        // ismi SOCS olan varsa socsVarMi= true,
        // ismi SOCS olan yoksa socsVarMi= false, olacak
        Assertions.assertFalse(nidVarmi);

        // tum cookieleri silin
        driver.manage().deleteAllCookies();

        // ve silindigini test edin
        tumCookieSeti = driver.manage().getCookies();

        Assertions.assertEquals(0, tumCookieSeti.size());

    }

}


