package day04_mavenProjeKullanimi;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_OzelWebDriverVerilirse {

    public static void main(String[] args) {

        // sirket tarafindan verilen WebDriver'i kullanarak
        // asagidaki testi yapalim

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // testotomasyonu anasayfaya gidin


        // phone icin arama yapin


        // ilk urune tiklayin


        // acilan ilk urun sayfasindaki urun isminde
        // case sensitive olmadan "phone " gectigini test edin


        // sayfayi kapatin


    }

}
