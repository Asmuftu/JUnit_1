package day04_mavenIlkTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_MavenlikIlkTest {

    public static void main(String[] args) throws InterruptedException {

        /*
        Mahserin 4 atlisindan ilki webdriver ayarlarini yapmakti
        Ama bu adim mecburi degildir
        Selenium 4.8 ile kendi webdriver'ini olusturdugundan
        biz disaridan webdriver tanimlamasak da
        Selenium kendi driver'ini kullanacaktir
         */

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // testotomasyonu.com anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");
        // url'in testotomasyonu icerdigini test edin
        Thread.sleep(3000);
        // sayfayi kapatin
        driver.quit();
    }
}
