package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.CheckoutCompletePage;
import pages.CheckoutPage;
import pages.CheckoutTwoPage;
import pages.LoginPage;
import pages.ProductPage;

public class LoginTest extends BaseTest {
	
	
	String productName = "Sauce Labs Onesie";
	
	@Test
	public void loginSuccesTest() {	
		LoginPage loginPage = new LoginPage();
		ProductPage productPage = new ProductPage();
		
		loginPage.login("standard_user", "secret_sauce");
		Assert.assertEquals(productPage.getTitle(), "Products", "El titulo de la pagina producto no es el correcto se obtiene " + productPage.getTitle());
	}
	
	@Test
	public void e2eTest() throws InterruptedException {	
		
		LoginPage loginPage = new LoginPage();
		ProductPage productPage = new ProductPage();
		CartPage cartPage = new CartPage();
		CheckoutPage checkoutPage = new CheckoutPage();
		CheckoutTwoPage checkoutTwoPage = new CheckoutTwoPage();
		CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage();
		
		loginPage.login("standard_user", "secret_sauce");
		Assert.assertEquals(productPage.getTitle(), "Products", "El titulo de la pagina producto no es el correcto se obtiene " + productPage.getTitle());
		
		String itemSelectedPrice = productPage.getTextItemPrice(productName);
		
		productPage.ClickOnAddToCartButtonSelectedByName(productName);
		Assert.assertEquals(productPage.getTextRemoveButtonSelected(productName), "Remove", "El boton no fue seleccionado correctamente por que no se tiene el texto Remove");
		//Asercion del contador - tarea
		
		productPage.clickOnCartButton();
		Assert.assertEquals(cartPage.getTitle(), "Your Cart", "El titulo de la pagina cart page no es el correcto se obtiene " + productPage.getTitle());
		Assert.assertEquals(cartPage.getCartItemName(), productName, "El nombre del item no es el correcto verificar si se agrego el item al carrito");
		Assert.assertEquals(cartPage.getCartItemPrice(), itemSelectedPrice, "El precio del item no es el correcto");
		
		cartPage.clickOnCheckout();
		
		Assert.assertEquals(checkoutPage.getTitle(), "Checkout: Your Information", "El titulo de la pagina Checkout: Your Information no es el correcto se obtiene " + productPage.getTitle());
		checkoutPage.enterFirstname("Marco");
		checkoutPage.enterLastName("Alfaro");
		checkoutPage.enterZipCode("00000");
		
		
		checkoutPage.clickOnContinue();
		
		Assert.assertEquals(checkoutTwoPage.getTitle(), "Checkout: Overview", "El titulo de la pagina Checkout: Overview no es el correcto se obtiene " + productPage.getTitle());
		Assert.assertEquals(checkoutTwoPage.getItemName(), productName, "El nombre del item no es el correcto verificar si se agrego el item al carrito");
		Assert.assertEquals(checkoutTwoPage.getItemPrice(), itemSelectedPrice, "El precio del item no es el correcto");
		//Agregar assercion del precio Total = Item total + tax
		
		
		
		checkoutTwoPage.clickOnFinish();
		
		Assert.assertEquals(checkoutCompletePage.getTitle(), "Checkout: Complete!", "El titulo de la pagina Checkout: Complete! no es el correcto se obtiene " + productPage.getTitle());
		Assert.assertEquals(checkoutCompletePage.getCheckoutCompleteMessage(), "Your order has been dispatched, and will arrive just as fast as the pony can get there!", "El mensaje de confirmacion no es el correcto verificar si se completo el proceso de compra");
		
		
		attachScreenshot();
		
		Thread.sleep(6000);
		
		
	}
	
	
}
