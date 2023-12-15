package day09_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C08_KullaniciOlusturma extends TestBase {

    @Test
    public void kullaniciOlusturmaTesti(){

        //1- https://www.testotomasyonu.com adresine gidelim
        driver.get("https://www.testotomasyonu.com");
        //2- Account linkine tiklayin
        driver.findElement(By.xpath("(//span[text()='Account'])[1]")).click();
        //3- Sign Up linkine basalim
        driver.findElement(By.xpath("//*[text()=' Sign Up']")).click();
        //4- Ad, soyad, mail ve sifre kutularina deger yazalim ve Sign Up butonuna basalim
        WebElement firstNameKutusu = driver.findElement(By.xpath("//*[@id='firstName']"));
        Actions actions = new Actions(driver);
        actions.click(firstNameKutusu)
                .sendKeys("Ahmed")
                .sendKeys(Keys.TAB)
                .sendKeys("Muftu")
                .sendKeys(Keys.TAB)
                .sendKeys("bulut@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("1234567890")
                .sendKeys(Keys.TAB)
                .sendKeys("1234567890")
                .perform();
        ReusableMethods.bekle(2);
        driver.findElement(By.id("btn-submit-form")).click();
        //5- Kaydin olusturuldugunu test edin
        // Kayit olusturulunca bizi sign-in sayfasina yonlendiriyor
        // kaydin olusturuldugunu test etmek icin
        // girdigimiz bilgilerle log-in olabildigimizi test edelim

        WebElement emailKutusu = driver.findElement(By.id("email"));
        WebElement passwordKutusu = driver.findElement(By.id("password"));
        WebElement signInButonu = driver.findElement(By.id("submitlogin"));

        emailKutusu.sendKeys("bulut@gmail.com");
        passwordKutusu.sendKeys("1234567890");
        signInButonu.click();

        WebElement logOutLinki = driver.findElement(By.xpath("//span[text()='Logout']"));
        Assert.assertTrue(logOutLinki.isDisplayed());

        ReusableMethods.bekle(3);
    }
}
