package day08_iFrame_cokluWindows;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.List;

public class C03_IFrame extends TestBase {

    @Test
    public void test01(){
        // 1)http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");
        // 2)Cookies kabul edin
        // cookies de iframe icinde oldugundan
        // once o IFrame'e gecis yapalim
        WebElement cookiesIFrame = driver.findElement(By.xpath("(//iframe)[6]"));
        driver.switchTo().frame(cookiesIFrame);
        driver.findElement(By.xpath("//*[text()='Tümünü Kabul Et']")).click();
        // 3) sayfadaki iframe sayısını bulunuz.

        List<WebElement> iFrameList = driver.findElements(By.tagName("iframe"));
        System.out.println("Sayfadaki iframe sayisi : " + iFrameList.size());

        //4) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        WebElement playIFrame = driver.findElement(By.xpath("(//iframe)[4]"));
        driver.switchTo().frame(playIFrame);

        driver.findElement(By.xpath("//button[@title='Play']")).click();
        ReusableMethods.bekle(2);
        //5) ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.switchTo().defaultContent();


        ReusableMethods.bekle(3);
    }
}
