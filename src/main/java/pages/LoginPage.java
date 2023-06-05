package pages;

import setUp.Interactions;

// This is a test class for the login page
public class LoginPage extends Interactions {
    public static String logMeIn(){
        typeIn("//*[@id=\"user-name\"]", "standard_user");
        typeIn("//*[@id=\"password\"]", "secret_sauce");
        clickOn("//*[@id=\"login-button\"]");
        return driver.getCurrentUrl();
    }
    public static String invalidUser(){
        typeIn("//*[@id=\"user-name\"]","abababa");
        clickOn("//*[@id=\"login-button\"]");
        return getText("//*[@id=\"login_button_container\"]/div/form/div[3]/h3");
    }
    public static String invalidPassword(){
        typeIn("//*[@id=\"password\"]","abababa");
        clickOn("//*[@id=\"login-button\"]");
        return getText("//*[@id=\"login_button_container\"]/div/form/div[3]/h3");
    }
    public static String lockedUser(){
        navigateTo("https://www.saucedemo.com/");
        typeIn("//*[@id=\"user-name\"]","locked_out_user");
        typeIn("//*[@id=\"password\"]","secret_sauce");
        clickOn("//*[@id=\"login-button\"]");
        return getText("//*[@id=\"login_button_container\"]/div/form/div[3]/h3");
    }

}
