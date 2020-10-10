package org.testinium.sample.traning.test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.Random;

public class BaseTestKeyword extends BaseTest {
public int index;

    public void signUp(String ad, String soyad, String email, String sifre, String telefon) {
        driver.get("https://www.gittigidiyor.com/kayit-ol");
        sendByName("name", ad);
        sendByName("surname", soyad);
        sendByName("email", email);
        sendByName("passwd", sifre);
        sendByName("gsmData", telefon);
        clickByXpath("//*[@class='checkmark']");
        //clickById("SubmitForm");
    }

    public void signIn(String mail,String sifre) {
        driver.get("https://www.gittigidiyor.com/uye-girisi");
        sendById("L-UserNameField", mail);
        sendById("L-PasswordField", sifre);
        clickById("gg-login-enter");
    }

    public void SearchAndAddtoCart(String keyword) throws InterruptedException {
        sendByDataCy("header-search-input", keyword);
        clickByDataCy("search-find-button");
        driver.get("https://www.gittigidiyor.com/arama/?k="+keyword); //aranan ürünün sayfasına gider.
        int productCount=Integer.parseInt(driver.findElement(By.xpath("//*[@class='result-count']")).getText());
        // System.out.println(productCount); aranan üründen kaç adet olduğunu gösterir.
        Random rnd =new Random();
        // Bir sayfada en fazla 48 ürün yer alabilir.
        if (productCount>48){
            //sayfa dolu anlamındadır. Herhangi birini seçer.
            index= rnd.nextInt(49);
        }
        else{
            index= rnd.nextInt(productCount);
        }
        Thread.sleep(2000);
        //ratgele seçtiği ürüne tıklar ve sayfasına gider.
        clickByXpath("//*[@product-index='"+index+"']");
        String strUrl = driver.getCurrentUrl();
        driver.get(strUrl);
        Thread.sleep(1000);
        WebElement element=driver.findElement(By.xpath("//button[@class='control-button gg-ui-button plr10 gg-ui-btn-default']"));
        element.submit();
        //sepet iconuna tıklar
        clickByXpath("//*[text()='Sepet']");
        //callHomePage();
    }


    public void addAddress() {

    }

}