package day06_JUnitAssertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.AssertionFailedError;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C01_BeforeAfterNotasyonlari {

    // 3 farkli test methodu olusturarak
    // asagidaki testleri yapin
    // 1- testotomasyonu.com sitesine gidin
    // 2- phone, shoes ve dress icin arama yapin
    // 3- arama sonucunda urun bulunabildigini test edin
    // 4- sayfayi kapatin


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
        driver.quit();
    }

    @Test
    public void phoneTesti(){
        driver.get("https://www.testotomasyonu.com");

        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone"+ Keys.ENTER);

        WebElement aramaSonuElementi = driver.findElement(By.className("product-count-text"));
        String aramaSonucSayisiStr = aramaSonuElementi.getText().replaceAll("\\D","");
        int aramaSonucSayisi = Integer.parseInt(aramaSonucSayisiStr);
        if (aramaSonucSayisi>0){
            System.out.println("phone testi PASSED");
        }else {
            System.out.println("phone testi FAILED");
            throw new AssertionFailedError();
        }
        ReusableMethods.bekle(2);
    }
    @Test
    public void shoesTesti(){
        driver.get("https://www.testotomasyonu.com");

        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("shoes"+ Keys.ENTER);

        WebElement aramaSonuElementi = driver.findElement(By.className("product-count-text"));
        String aramaSonucSayisiStr = aramaSonuElementi.getText().replaceAll("\\D","");
        int aramaSonucSayisi = Integer.parseInt(aramaSonucSayisiStr);
        if (aramaSonucSayisi>0){
            System.out.println("shoes testi PASSED");
        }else {
            System.out.println("shoes testi FAILED");
            throw new AssertionFailedError();
        }
        ReusableMethods.bekle(2);

    }
    @Test
    public void dressTesti(){
        driver.get("https://www.testotomasyonu.com");

        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("dress"+ Keys.ENTER);

        WebElement aramaSonuElementi = driver.findElement(By.className("product-count-text"));
        String aramaSonucSayisiStr = aramaSonuElementi.getText().replaceAll("\\D","");
        int aramaSonucSayisi = Integer.parseInt(aramaSonucSayisiStr);
        if (aramaSonucSayisi>0){
            System.out.println("dress testi PASSED");
        }else {
            System.out.println("dress testi FAILED");
            throw new AssertionFailedError();
        }
        ReusableMethods.bekle(2);

    }

}
