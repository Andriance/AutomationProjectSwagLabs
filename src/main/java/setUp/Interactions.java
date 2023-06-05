package setUp;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class Interactions extends SeleniumSetUp {
    public static String getUrl(){
        return driver.getCurrentUrl();
    }
    public static String navigateTo(String url){
        driver.get(url);
        return driver.getCurrentUrl();
    }
    public static void typeIn(String elementXpath, String text){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementXpath))).sendKeys(text);
    }
    public static void clickOn(String elementXpath){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementXpath))).click();
    }
    public static void selectByVisibleText(String elementXpath, String visibleText){
        new Select(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementXpath)))).selectByVisibleText(visibleText);
    }
    public static String getText(String elementXpath){
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementXpath))).getText();
    }

}
