package day12_webTables_excelOtomasyon;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_ReadExcelTesti {

    Sheet sayfa1;
    @Test
    public void readExceltesti() throws IOException {

        String dosyaYolu = "src/test/java/day12_webTables_excelOtomasyon/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
         sayfa1 = workbook.getSheet("Sayfa1");

        // - 1.satirdaki 2.hucreye gidelim ve yazdiralim
        System.out.println(sayfa1.getRow(0).getCell(1));
        // - 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
        String istenenHucreStr = sayfa1.getRow(0).getCell(1).toString();
        System.out.println("String olarak: " + istenenHucreStr);
        // - 2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim

        String expectedHucreBilgisi = "Kabil";
        String actualHucreBilgisi = sayfa1.getRow(1).getCell(3).toString();
        Assert.assertEquals(expectedHucreBilgisi,actualHucreBilgisi);
        // - Satir sayisini bulalim
        int satirSayisi = sayfa1.getLastRowNum();
        System.out.println("satir sayisi: " + (satirSayisi+1));

        // - Samoa'nin baskent isminin Apia oldugunu test edin
        String expectedBaskent = "Apia";
        String actualBaskent = "";
        for (int i = 0; i <=satirSayisi; i++) {
            String ulkeIsmi = sayfa1.getRow(i).getCell(0).toString();
            if (ulkeIsmi.equals("Samoa")){
                actualBaskent = sayfa1.getRow(i).getCell(1).toString();

            }
        }
        Assert.assertEquals(expectedBaskent,actualBaskent);

        // - Verdigimiz ingilizce ulke ismi ve dil tercihine gore
        //   baskent ismini bize donduren bir method olusturun

        System.out.println(baskentBul("Peru", "Turkce"));
        // - Fiziki olarak kullanilan satir sayisini bulun
        //  bu method index degil gercekten kullanilan satir sayisini verir

        System.out.println(sayfa1.getPhysicalNumberOfRows());


        // - Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim
    }

    public String baskentBul(String ulkeAdi, String dilTercihi){

        String satirdakiUlkeAdi;
        String baskentIsmi = "";

        for (int i = 0; i <=sayfa1.getLastRowNum() ; i++) {

            satirdakiUlkeAdi = sayfa1.getRow(i).getCell(0).toString();
            if (satirdakiUlkeAdi.equalsIgnoreCase(ulkeAdi)){

                if (dilTercihi.equalsIgnoreCase("Ingilizce")){
                    baskentIsmi = sayfa1.getRow(i).getCell(1).toString();
                }else {
                    baskentIsmi = sayfa1.getRow(i).getCell(3).toString();
                }
            }
        }

        return baskentIsmi;
    }
}
