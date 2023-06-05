package setUp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumSetUp {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver-v112.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
    }

    public static void end(){
        driver.quit();
    }

}
