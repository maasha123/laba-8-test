import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
    @FindBy(xpath = "//*[@id='root']/div/header/div/div/div[4]/button")
    private WebElement languageButton;
    @FindBy(xpath = "/html/body/div[4]/div[3]/ul/li[1]")
    private WebElement englishLanguage;

    @FindBy(xpath = "//*[@id='root']/div/header/div/div/button[2]/span[1]")
    private WebElement Themes;
    @FindBy(xpath = "/html/body/div[4]/div[3]/ul/li[3]")
    private WebElement lightTheme;

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement changeLanguage(){
        languageButton.click();
        englishLanguage.click();
        return languageButton;
    }

    public WebElement changeTheme(){
        Themes.click();
        lightTheme.click();
        return lightTheme;
    }
}
