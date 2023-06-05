package pages;

import setUp.Interactions;

public class HomePage extends LoginPage {
    public static void addToCard() {
        Interactions.clickOn("//*[@id=\"add-to-cart-sauce-labs-bolt-t-shirt\"]");
        Interactions.clickOn("//*[@id=\"shopping_cart_container\"]/a");
        Interactions.clickOn("//*[@id=\"checkout\"]");
    }
    public static boolean sortByPriceInAscendingOrder(){
        Interactions.navigateTo("https://www.saucedemo.com/");
        LoginPage.logMeIn();
        Interactions.selectByVisibleText("//*[@id=\"header_container\"]/div[2]/div/span/select","Price (low to high)");
        String priceWithDollarSign = Interactions.getText("//*[@id=\"inventory_container\"]/div/div[3]/div[2]/div[2]/div");
        String priceWithoutDollarSign = priceWithDollarSign.substring(1,priceWithDollarSign.length());
        boolean temp = false;
        if (Double.valueOf(priceWithoutDollarSign) > 15.00) {
            temp = true;
        }
        return temp;
    }
    public static String sortByNameInDescendingOrder(){
        Interactions.navigateTo("https://www.saucedemo.com/");
        LoginPage.logMeIn();
        Interactions.selectByVisibleText("//*[@id=\"header_container\"]/div[2]/div/span/select","Name (A to Z)");
        String price = Interactions.getText("//*[@id=\"inventory_container\"]/div/div[2]/div[2]/div[2]/div");
        if(price.equals("$7.99")){
            Interactions.clickOn("//*[@id=\"add-to-cart-sauce-labs-bike-light\"]");
            return "secondProduct";
        } else {
            Interactions.clickOn("//*[@id=\"add-to-cart-sauce-labs-fleece-jacket\"]");
        }
        return "forthProduct";
    }
    public static String badgeOfBasketWithProduct(){
        Interactions.navigateTo("https://www.saucedemo.com/");
        LoginPage.logMeIn();
        Interactions.clickOn("//*[@id=\"add-to-cart-sauce-labs-backpack\"]");
        return Interactions.getText("//*[@id=\"shopping_cart_container\"]/a/span");
    }
    public static String badgeOfEmptyBasket(){
        Interactions.navigateTo("https://www.saucedemo.com/");
        LoginPage.logMeIn();
        Interactions.clickOn("//*[@id=\"add-to-cart-sauce-labs-bike-light\"]");
        CheckOutPage.proceedToCheckOut();
        Interactions.clickOn("//*[@id=\"back-to-products\"]");
        return Interactions.getText("//*[@id=\"shopping_cart_container\"]/a");
    }
    public static String sortItemsByPriceInDescendingOrder() {
        Interactions.navigateTo("https://www.saucedemo.com/");
        LoginPage.logMeIn();
        Interactions.selectByVisibleText("//*[@id=\"header_container\"]/div[2]/div/span/select","Price (high to low)");
        return Interactions.getText("//*[@id=\"inventory_container\"]/div/div[1]/div[2]/div[2]/div");
    }
    public static String sortItemsByPriceInAscendingOrder() {
        Interactions.selectByVisibleText("//*[@id=\"header_container\"]/div[2]/div/span/select","Price (low to high)");
        return Interactions.getText("//*[@id=\"inventory_container\"]/div/div[1]/div[2]/div[2]/div");
    }
}
