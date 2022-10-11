import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

public class project {
    WebDriver driver;
    @BeforeMethod
    public void firefoxLauncher(){
        System.setProperty("webdriver.gecko.driver", "/Users/superaxis/Downloads/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://qatechhub.com/");
        driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
    }
    @Test
    public void validateTitle(){
        String actualTitle = driver.getTitle();
        String expectedTitle = "QA Automation Tools Trainings and Tutorials | QA Tech Hub";
        Assert.assertEquals(actualTitle, expectedTitle);
    }
    @AfterMethod
    public void gettingUrl() {
        driver.navigate().to("https://www.facebook.com");
        driver.navigate().back();
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current url is " + currentUrl);
    }
    @AfterMethod
    public void operations(){
        driver.navigate().forward();
        driver.navigate().refresh();
        driver.quit();
    }
}



