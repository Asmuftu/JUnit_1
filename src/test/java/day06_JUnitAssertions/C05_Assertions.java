package day06_JUnitAssertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_Assertions {

    /*
    Bize verilen gorevde
    birden fazla assertion varsa
    tumunu tek test methodunda yapmak
    bize is yuku acisindan daha pratik gelebilir
    AMA
    bir test method'unda birden fazla assertion oldugunda
    - her bir assertion ayri ayri raporlanmamis olur
    - bir assertion failed oldugunda kod calismasi durur
    kalan assertion'lar sonucunu bilemeyiz
    once hata veren assertion'i duzeltip sonra tekrar calistirmamiz gerekir
     */

    //  https://www.bestbuy.com/ Adresine gidin
    //  farkli test method’lari olusturarak asagidaki testleri yapin
    //    ○ Sayfa URL’inin https://www.bestbuy.com/ ’a esit oldugunu test edin
    //    ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
    //    ○ logoTest => BestBuy logosunun görüntülendigini test edin
    //    ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin

    // 1- kac kisinin oy verdigi gorunsun
    // 2- degerlendirme 5 uzerinden olsun
        // A- urune baktigimda 0 ile 5 arasinda mi
        // B- urune puan verirken istenmeyen harf, negatif deger gibi degerler verebiliyor muyum
        //
    // 3- ondalikli kisim tek rakam olsun
    // 4- yildiz seklinde gosterim olsun


    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.bestbuy.com/");
    }

    @AfterClass
    public static void teardown(){
        driver.quit();
    }

    @Test
    public void bestBuyTesti(){

        String expectedUrl = "https://www.bestbuy.com/";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl,actualUrl);

        String unexpectedIcerik = "Rest";
        String actualTitle = driver.getTitle();

        Assert.assertFalse(actualTitle.contains(unexpectedIcerik));

        WebElement logoElementi = driver.findElement(By.xpath("(//img[@class='logo'])[1]"));

        Assert.assertTrue(logoElementi.isDisplayed());

        WebElement linkElementi = driver.findElement(By.xpath("//*[text()='Français']"));

        Assert.assertTrue(linkElementi.isDisplayed());
    }
}
