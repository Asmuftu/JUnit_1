package day05_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.AssertionFailedError;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.concurrent.RejectedExecutionException;

public class C07_BeforeAfterNotasyonlari {

    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @After
    public void teardown(){
        ReusableMethods.bekle(1);
        driver.quit();
    }
    @Test
    public void wiseQuarterTest(){

        driver.get("https://www.wisequarter.com");
        // title'in "Wise" icerdigini test edin
        String expectedTitleIcerik = "Wise";
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedTitleIcerik)){
            System.out.println("wise quarter testi Passed");
        }else System.out.println("wise quarter testi Failed");
    }
    @Test
    public void testOtomasyonuTest(){
        /*
        JUnit bir test method'u
        hicbir sorunla karsilasmadan calisip biterse
        o test method'unu PASSED olarak algilar

        JUnit'e gore bir testin FAILED olabilmesi icin
        kodlarin bir sorunla karsilasmasi
        ve kodlarin method'un sonuna kadar calismasi gerekir

        Ornek olmasi icin biz bu method'da
        throw new AssertionFailedError() diyerek
        test failed oldugunda
        kodun calismayi durdurmasini sagladik

        JUnit'de exception olustugu icin
        bu testi failed olarak etiketledi
         */

        // testotomasyonu.com adresine gidin
        driver.get("https://www.testotomasyonu.com");

        // title'in "Test Otomasyon" icerdigini test edin
        String expectedTitleIcerik = "Test Otomasyon";
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedTitleIcerik)){
            System.out.println("Test otomasyonu testi Passed");
        }else {
            System.out.println("Test otomasyonu testi Failed");
            throw new AssertionFailedError();
        }
    }
    @Test @Ignore
    public void googleTest(){

        // google.com adresine gidin
        driver.get("https://www.google.com");
        // url'in "google" icerdigini test edin
        String expectedUrlIcerik = "google";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("google testi Passed");
        }else System.out.println("google testi Failed");
    }

}
