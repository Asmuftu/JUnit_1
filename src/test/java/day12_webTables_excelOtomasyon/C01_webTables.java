package day12_webTables_excelOtomasyon;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.List;

public class C01_webTables extends TestBase {

    @Test
    public void test01(){

        // 1. “https://testotomasyonu.com/webtables2” sayfasina gidin
        driver.get("https://testotomasyonu.com/webtables2");
        //  2. Headers da bulunan basliklari yazdirin
        List<WebElement> baslikElementleriList = driver.findElements(By.xpath("//div[@role='hdata']"));
        // bu liste webelementlerden olustugu icin hemen yazdiramayiz
        List<String> baslikYazilariList = ReusableMethods.stringListeDonustur(baslikElementleriList);
        System.out.println("Basliklar : " + baslikYazilariList);
        //  3. 3.sutunun basligini yazdirin
        System.out.println("3. sutun Basligi: " + baslikElementleriList.get(2));
        //  4. Tablodaki tum datalari yazdirin
        List<WebElement> tabloDataElementleriList = driver.findElements(By.xpath("//*[@role='tdata']"));
        List<String> tabloDataYazilarList = ReusableMethods.stringListeDonustur(tabloDataElementleriList);
        System.out.println("tum tabloda bulunan datalar : " + tabloDataYazilarList);
        //  5. Tabloda kac tane cell (data) oldugunu yazdirin
        System.out.println("Tablodaki data Sayisi : " + tabloDataElementleriList.size());
        //  6. Tablodaki satir sayisini yazdirin
        List<WebElement> satirElementleriList = driver.findElements(By.xpath("//*[@role='trow']"));
        System.out.println("Tablodaki urun satirlari sayisi: " + satirElementleriList.size());
        //  7. Tablodaki sutun sayisini yazdirin
        System.out.println("Tablodaki sutun sayisi: " + baslikElementleriList.size());
        //  8. Tablodaki 3.kolonu yazdirin
        List<WebElement> ucuncuSutunElementleriList = driver.findElements(By.xpath("//*[@role='trow']/*[@role='tdata'][3]"));
        List<String> ucuncuSutunYaziList = ReusableMethods.stringListeDonustur(ucuncuSutunElementleriList);
        System.out.println("3. Sutun : " + ucuncuSutunYaziList);
        //  9. Tabloda " Category" si Furniture olan urunun fiyatini yazdirin
        // Bir loop ile her bi satiri tek tek inceleyelim
        // kategori degeri (yani 2. data) Furniture olan satirdaki
        // fiyat degerini (yani 3. data) yazdiralim
        String satirdakiKategoriXpath = "";
        String satirdakiFiyatXpath = "";
        for (int i = 1; i <satirElementleriList.size() ; i++) {

            // i. satirdaki kategori elementinin locate'i

            satirdakiKategoriXpath = "((//*[@role='trow'])["+i+"]/*[@role='tdata'])[2]";
            satirdakiFiyatXpath = "((//*[@role='trow'])["+i+"]/*[@role='tdata'])[3]";
            if (driver.findElement(By.xpath(satirdakiKategoriXpath)).getText().equals("Furniture")){

                System.out.println("Istenen urunun fiyati : " +
                        driver.findElement(By.xpath(satirdakiFiyatXpath)).getText());
            }
        }
        //10. Bir method olusturun, Test sayfasindan satir ve sutun sayisini girdigimde bana datayi yazdirsin
        istenenHucredekiDatayiYazdir(2,3);

        // yukaridaki gorevi method'u kullanarak yapalim

        // tabloda " Category" si Furniture olan urunun fiyatini yazdirin

        String satirdakiKategoriDegeri = "";
        String satirdakiFiyatDegeri = "";
        for (int i = 1; i <= satirElementleriList.size() ; i++) {

             satirdakiKategoriDegeri = istenenHucredekiDatayiDondur(i,2);
             satirdakiFiyatDegeri = istenenHucredekiDatayiDondur(i,3);

            if (satirdakiKategoriDegeri.equals("Furniture")){
                System.out.println(satirdakiFiyatDegeri);
            }
        }

        ReusableMethods.bekle(2);
    }

    public void istenenHucredekiDatayiYazdir(int satirNo, int sutunNo){

        String dinamikXpath = "((//*[@role='trow'])["+ satirNo +"]/*[@role='tdata'])["+ sutunNo +"]";
        System.out.println("Istenen hucredeki Data : " +
                driver.findElement(By.xpath(dinamikXpath)).getText());
    }

    public String istenenHucredekiDatayiDondur(int satirNo, int sutunNo){

        String dinamikXpath = "((//*[@role='trow'])["+ satirNo +"]/*[@role='tdata'])["+ sutunNo +"]";

                 return driver.findElement(By.xpath(dinamikXpath)).getText();

    }
}
