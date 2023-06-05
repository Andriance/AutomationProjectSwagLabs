import pages.CheckOutPage;
import pages.HomePage;
import pages.LoginPage;
import setUp.Interactions;
import setUp.SeleniumSetUp;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Tests {
    @BeforeClass
    public void setUp(){
        SeleniumSetUp.setup();
    }

    @Test(priority = 2)
    public void verifyIfYouAreOnTheRightPage() {
        Assert.assertEquals(Interactions.navigateTo("https://www.saucedemo.com/"), "https://www.saucedemo.com/");
    }
    @Test (priority = 3)
    public void verifyLogInWithCorrectCredentials() {
        Assert.assertEquals(LoginPage.logMeIn(), "https://www.saucedemo.com/inventory.html");
    }
    @Test (priority = 4)
    public void verifyConfirmationMessageForSuccessfulOrder(){
        Assert.assertEquals(CheckOutPage.confirmationMessage(),"Thank you for your order!");
    }
    @Test (priority = 5)
    public void verifyTheUrlOfCheckoutPage(){
        Assert.assertEquals(Interactions.getUrl(),"https://www.saucedemo.com/checkout-complete.html");
    }
    @Test(priority = 6)
    public void verifyIfThePriceOfTheThirdProductIsGreaterThan$15() {
        Assert.assertTrue(HomePage.sortByPriceInAscendingOrder());
    }
    @Test(priority = 7)
    public void verifyIfTheForthProductIsAddedToTheBasket(){
        Assert.assertEquals(HomePage.sortByNameInDescendingOrder(),"forthProduct");
    }
    @Test(priority = 8)
    public void verifyErrorMessagesForNoUsername(){
        Assert.assertEquals(LoginPage.errorMessage(), "Epic sadface: Username is required");
    }
    @Test(priority = 9)
    public void verifyErrorMessageForInvalidUsername(){
        Assert.assertEquals(LoginPage.invalidUser(),"Epic sadface: Password is required");
    }
    @Test(priority = 10)
    public void verifyErrorMessageForInvalidPassword(){
        Assert.assertEquals(LoginPage.invalidPassword(),"Epic sadface: Username and password do not match any user in this service");
    }
    @Test(priority = 11)
    public void verifyErrorMessageForLockedUser(){
        Assert.assertEquals(LoginPage.lockedUser(), "Epic sadface: Sorry, this user has been locked out.");
    }
    @Test(priority = 1)
    public void verifyIfTheBadgeGivesCorrectResult(){
        Assert.assertEquals(HomePage.badgeOfBasketWithProduct(), "1");
    }
    @Test(priority = 12)
    public  void verifyIfTheBasketIconHaveBadge(){
        Assert.assertEquals(HomePage.badgeOfEmptyBasket(), "");
    }
    @Test(priority = 13)
    public void testForVerifyingPriceOfFirstProductInDescendingOrder() {
        Assert.assertEquals(HomePage.sortItemsByPriceInDescendingOrder(),"$49.99");
    }
    @Test(priority = 14)
    public void testForVerifyingPriceOfFirstProductInAscendingOrder() {
        Assert.assertEquals(HomePage.sortItemsByPriceInAscendingOrder(),"$7.99");
    }

    @AfterClass
    public void end() {
        SeleniumSetUp.end();
    }
}
