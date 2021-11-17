import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class MyTests {
    WebDriver driver;
    HomePage homePage;
    @BeforeGroups(groups = "ftx")
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://ftx.com");
        driver.manage().window().maximize();
    }
    @Test(groups = "ftx", priority = 1)
    @Description("Change language from English to Russian")
    public void ChangeLanguage() throws InterruptedException {
        homePage = PageFactory.initElements(driver, HomePage.class);
        Assert.assertEquals(homePage.changeLanguage().getText(), "ENGLISH", "Language is not changed!");
    }

    @Test(groups = "ftx", priority = 2)
    @Description("Change currency from USD to RUB")
    public void ChangeTheme(){
        Assert.assertTrue(homePage.changeTheme().getAttribute("class").contains("selected"), "Theme is not changed!");
    }

    @AfterGroups(groups = "ftx")
    public void close(){driver.close();}
}
