package pages;

import setUp.Interactions;

public class CheckOutPage extends Interactions {
    public static void fillingForm(){
        typeIn("//*[@id=\"first-name\"]","Andriana" );
        typeIn("//*[@id=\"last-name\"]","Chichonovska");
        typeIn("//*[@id=\"postal-code\"]","1000" );
        clickOn("//*[@id=\"continue\"]");
        clickOn("//*[@id=\"finish\"]");
    }
    public static String confirmationMessage(){
        HomePage.addToCard();
        fillingForm();
        return getText("//*[@id=\"checkout_complete_container\"]/h2");
    }
    public static void proceedToCheckOut(){
        clickOn("//*[@id=\"shopping_cart_container\"]/a");
        clickOn("//*[@id=\"checkout\"]");
        fillingForm();
    }
}
