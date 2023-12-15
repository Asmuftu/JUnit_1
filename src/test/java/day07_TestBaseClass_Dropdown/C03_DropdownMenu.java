package day07_TestBaseClass_Dropdown;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.List;

public class C03_DropdownMenu extends TestBase{

    @Test
    public void dropdowntesti(){
        // https://testotomasyonu.com/form adresine gidin.
        // 1.Dogum tarihi gun seçeneğinden index kullanarak 5’i secin
        // 2. Dogum tarihi ay seçeneğinden value kullanarak Nisan’i secin
        // 3. Dogum tarihi yil seçeneğinden visible text kullanarak 1990’i secin
        // 4. Ay dropdown menüdeki tum değerleri(value) yazdırın
        // 5. Ay Dropdown menusunun boyutunun 30 olduğunu test edin

        driver.get("https://testotomasyonu.com/form");
        WebElement dogumGunuDdm = driver.findElement(By.xpath("(//select[@class='form-control'])[1]"));

        Select selectGun = new Select(dogumGunuDdm);
        selectGun.selectByIndex(5);

        WebElement ayDdm = driver.findElement(By.xpath("(//select[@class='form-control'])[2]"));
        Select selectAy = new Select(ayDdm);selectAy.selectByVisibleText("Nisan");

        WebElement yilDdm = driver.findElement(By.xpath("(//select[@class='form-control'])[3]"));
        Select selectYil = new Select(yilDdm);
        selectYil.selectByVisibleText("1990");

        System.out.print("Secilen Tarih: "+selectGun.getFirstSelectedOption().getText());
        System.out.print(" "+selectAy.getFirstSelectedOption().getText());
        System.out.println(" "+selectYil.getFirstSelectedOption().getText());

        List<WebElement> ayOpsiyonElementleriList = selectAy.getOptions();

        System.out.println(ReusableMethods.stringListeDonustur(ayOpsiyonElementleriList));



        Assert.assertEquals(30, ayOpsiyonElementleriList.size());

        ReusableMethods.bekle(5);
    }
}
