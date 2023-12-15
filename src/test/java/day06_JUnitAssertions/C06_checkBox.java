package day06_JUnitAssertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_checkBox {

    // a. Verilen web sayfasına gidin.
    //     https://testotomasyonu.com/form
    // b. Sirt Agrisi ve Carpinti checkbox’larini secin
    // c. Sirt Agrisi ve Carpinti checkbox’larininin seçili
    //    olduğunu test edin
    // d. Seker ve Epilepsi checkbox’larininin seçili
    //    olmadigini test edin

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
    public void checkBoxTesti(){
        driver.get("https://testotomasyonu.com/form");
        WebElement sirtAgrisiCheckBox = driver.findElement(By.id("gridCheck5"));
        sirtAgrisiCheckBox.sendKeys(Keys.PAGE_DOWN);
        sirtAgrisiCheckBox.click();

        WebElement carpintiCheckBox = driver.findElement(By.id("gridCheck4"));
        WebElement carpintiYaziElementi =
                driver.findElement(By.xpath("//*[@for='gridCheck4']"));
        carpintiYaziElementi.click();

        Assert.assertTrue(sirtAgrisiCheckBox.isSelected());
        Assert.assertTrue(carpintiCheckBox.isSelected());

        WebElement sekerCheckBox = driver.findElement(By.id("hastalikCheck2"));
        WebElement epilepsiCheckBox = driver.findElement(By.id("hastalikCheck7"));

        Assert.assertFalse(sekerCheckBox.isSelected());
        Assert.assertFalse(epilepsiCheckBox.isSelected());
    }
}
