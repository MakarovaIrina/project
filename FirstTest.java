
        package CdekFront;

import com.sun.javafx.scene.EnteredExitedHandler;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class FirstTest {
    private static WebDriver driver;
    public int OrdNum;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "C://Users//user//Desktop//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://lknew.qa.cdek.ru");
    }

    @Test
    public void Test01() {
        WebElement login = driver.findElement(By.id("loginform-login"));
        login.clear();
        login.sendKeys("ma.shishkin");
        WebElement Passwd = driver.findElement(By.id("loginform-password"));
        Passwd.clear();
        Passwd.sendKeys("hhhhh");
        WebElement LoginButton = driver.findElement(By.name("login-button"));
        LoginButton.click();
        String ErrTxt = driver.findElement(By.cssSelector("#login-form > div.form-group.field-loginform-password.required.has-error > p")).getText();
        assertEquals("Неверное сочетание логина и пароля.", ErrTxt);
    }

    @Test
    public void Test02() {
        WebElement login = driver.findElement(By.id("loginform-login"));
        login.clear();
        login.sendKeys("ma.shishkin");
        WebElement Passwd = driver.findElement(By.id("loginform-password"));
        Passwd.clear();
        Passwd.sendKeys("192168113");
        WebElement LoginButton = driver.findElement(By.name("login-button"));
        LoginButton.click();
    }

    @Test
    public void Test03() {
        String ErrorTxt = driver.findElement(By.cssSelector("body > footer > div > div > div:nth-child(3) > span")).getText();
        assertEquals("По вопросам работы ЛК:", ErrorTxt);
    }

    @Test
    public void Test04() {
        WebElement page = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div[1]/div/ul/li[3]/a"));
        page.click();
        driver.manage().window().maximize();
    }

    @Test
    public void Test05() {
        WebElement Order = driver.findElement(By.xpath("//*[@id=\"tabnewOrder\"]/a"));
        Order.click();
        WebElement NewOrder = driver.findElement(By.xpath("//*[@id=\"tabnewOrder\"]/a"));
        NewOrder.click();}




    @Test//с ошибкой
    public void Test06() {

        WebElement FromCityErr = driver.findElement(By.id("dFromCity"));
        FromCityErr.sendKeys("123");
        WebElement TariffCalc = driver.findElement(By.linkText("Рассчитать стоимость"));
        TariffCalc.click();
        String ErrTx = driver.findElement(By.cssSelector("#tarif-error")).getText();
        assertEquals("Пожалуйста, заполните все необходимые поля", ErrTx);
    }

    @Test
    public void Test08() {


        WebElement FromCityName = driver.findElement(By.id("dFromCity"));
        FromCityName.sendKeys("Новосиб");
        FromCityName.sendKeys(Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//ul[@id='ui-id-1']/li")).click();
        WebElement ToCityName = driver.findElement(By.id("dToCity"));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        ToCityName.sendKeys("Новосиб");
        ToCityName.sendKeys(Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//ul[2]/li")).click();
    }

    @Test
    public void Test09() {
        WebElement Length = driver.findElement(By.name("Package[1][length]"));
        Length.sendKeys("80");
        WebElement Width = driver.findElement(By.name("Package[1][width]"));
        Width.sendKeys("80");
        WebElement Height = driver.findElement(By.name("Package[1][height]"));
        Height.sendKeys("200");
        WebElement Description = driver.findElement(By.name("Package[1][description]"));
        Description.sendKeys("Холодильник");
    }


    @Test
    public void Test10() {
        WebElement RB = driver.findElement(By.xpath("//*[@id=\"payment-conditions-container\"]/div/label[1]"));
        RB.click();
        WebElement TariffCalc = driver.findElement(By.linkText("Рассчитать стоимость"));
        TariffCalc.click();
    }


    @Test
    public void Test11() {
    WebElement SenderStreet = driver.findElement(By.id("dSenderStreet"));
        SenderStreet.sendKeys("Русс");
    WebElement ss = (new WebDriverWait(driver, 50)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/ul[5]/li[contains(text(), 'РУССКАЯ УЛ')]")));
        ss.click();
        }



    @Test //Телефон
    public void Test12() {
        WebElement SenderPhone = driver.findElement(By.xpath("//*[@id=\"sender-block\"]/div[3]/div/input[1]"));
        SenderPhone.sendKeys("79639854412");
    }
    @Test //Дом от кого

    public void Test13() {
        WebElement SenderHause = driver.findElement(By.id("dSenderHouse"));
        SenderHause.sendKeys("145");
    }
    @Test //Кв от кого
    public void Test14() {
        WebElement SenderRoom = driver.findElement(By.id("dSenderRoom"));
        SenderRoom.sendKeys("26");
    }
    @Test //ФИО от кого
    public void Test15() {
        WebElement ReceiverFIO = driver.findElement(By.id("dReceiverName"));
        ReceiverFIO.sendKeys("Петров Павел Рюрикович");
    }
    @Test //ФИО кому
    public void Test16() {
    WebElement ReceiverStreet = driver.findElement(By.id("dReceiverStreet"));
        ReceiverStreet.sendKeys("Иван");
    WebElement rs = (new WebDriverWait(driver, 50)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/ul[6]/li[contains(text(), 'ИВАНОВА УЛ')]")));
        rs.click();}

    @Test //Тел кому
    public void Test17() {
        WebElement ReceiverPhone = driver.findElement(By.xpath("//*[@id=\"receiver-block\"]/div[3]/div/input[1]"));
        ReceiverPhone.sendKeys("79639854412");
    }
    @Test //Дом кому
    public void Test18() {
        WebElement ReceiverHause = driver.findElement(By.id("dReceiverHouse"));
        ReceiverHause.sendKeys("15");
    }
    @Test //Кв кому
    public void Test19() {
        WebElement ReceiverRoom = driver.findElement(By.id("dReceiverRoom"));
        ReceiverRoom.sendKeys("6");
    }
    @Test //NewOrder_delivery-confirm
    public void Test20() {
        WebElement DeliveryConfirm = driver.findElement(By.id("delivery-confirm"));
        DeliveryConfirm.sendKeys(Keys.ENTER);
    }
    @Test //
    public void Test21() {
        WebElement DeliverySend = driver.findElement(By.id("delivery-send"));
        DeliverySend.sendKeys(Keys.ENTER);
    }
    @Test //Проверка заказа
    public void Test22() {
        String Txt = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div[2]/div/div/h4/span[@class='text-success']")).getAttribute("innerHTML");
        Pattern pat = Pattern.compile("\\d{10}");
        Matcher mat = pat.matcher(Txt);
        int start = 0;
        while (mat.find(start)) {
            String value = Txt.substring(mat.start(), mat.end());
            int result = Integer.parseInt(value);
            System.out.println(result);
            OrdNum = result;
            start = mat.end();
        }
        String ON = String.valueOf(OrdNum);
        System.out.println(ON);
        WebElement OrderHistory = driver.findElement(By.xpath("//*[@id=\"tabOrderHistory\"]/a"));
        OrderHistory.sendKeys(Keys.ENTER);
        WebElement OrderNumber = driver.findElement(By.name("OrderHistoryForm[order_number]"));
        OrderNumber.sendKeys(ON);//номер накладной
        WebElement Fil = driver.findElement(By.xpath("//*[@id=\"filter_form\"]/table/tbody/tr[6]/td[1]/button"));
        Fil.sendKeys(Keys.ENTER);
    }





    @AfterClass
    public static void tearDown() {
        //driver.quit();
    }
}
