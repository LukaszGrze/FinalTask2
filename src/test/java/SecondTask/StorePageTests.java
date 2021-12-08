package SecondTask;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class StorePageTests extends StorePageBase{


    @Test
    public void storePageTest() throws IOException {
        loginPage = mainPage.signIn();
        yourAccountPage = loginPage.loginAs(username,password);
        clothesPage = yourAccountPage.selectClothes();
        clothesPage.selectProduct();
        Assert.assertEquals(expectedDiscount, clothesPage.checkDiscount());
        Assert.assertNotEquals(clothesPage.checkCurrent(), clothesPage.checkRegular());
        clothesPage.selectSizeAndQuanity("M", "5");
        cartPage = clothesPage.addToCard();
        checkoutPage = cartPage.setSecondProceedButton();
        Assert.assertEquals(expectedAddress, checkoutPage.checkAddress());
        checkoutPage.selectAddress();
        checkoutPage.setShippingMethod();
        checkoutPage.paymentOptions();
        checkoutPage.getScreenshot();
        checkoutPage.setPriceBox();
        checkoutPage.setReferenceBox();
        yourAccountPage = checkoutPage.selectAccountButton();
        historyPage = yourAccountPage.selectHistory();
        Assert.assertTrue(checkoutPage.getPriceBox().contains(historyPage.checkPrice()));
        Assert.assertTrue(checkoutPage.getReferenceBox().contains(historyPage.checkReference()));
        Assert.assertTrue(expectedStatus.contains(historyPage.checkStatus()));
    }
}
