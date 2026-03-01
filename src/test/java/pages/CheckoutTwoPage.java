package pages;

import org.openqa.selenium.By;

import base.BasePage;

public class CheckoutTwoPage extends BasePage {
	
	//Locators
	private By checkoutTwoTitle = By.className("title");
	private By finishButton = By.id("finish");
	//Estos elementos son dinamicos y estan ubicados dentro del contenedor.
	
	private By itemName = By.className("inventory_item_name");
	private By itemPrice = By.className("inventory_item_price");
	
	//Estos elementos son dinamicos y estan ubicados en el esumen de la compra.
	private By itemTotal = By.className("summary_subtotal_label");
	private By taxPrice = By.className("summary_tax_label");
	private By totalPrice = By.className("summary_total_label");
	
	//Locators action
	public String getTitle() {
		return getText(checkoutTwoTitle);
	}
	
	public void clickOnFinish() {
		clickElement(finishButton);
	}
	
	public String getItemName() {
		return getText(itemName);
	}
	
	public String getItemPrice() {
		return getText(itemPrice);
	}
	
	public String getTotalPriceText() {
		return getText(totalPrice);
	}
	
	public String getTaxPriceText() {
		return getText(taxPrice);
	}
	
	public String getItemTotalText() {
		return getText(itemTotal);
	}
	
	//Metodo para extraer el valor numerico de un texto que contiene el precio.
	//Borra tolo lo que no sea numero o punto decimal.
	private double extractAmount(String text) {
		return Double.parseDouble(text.replaceAll("[^0-9.]", ""));
	}
	
	public double getItemTotalAmount() {
		return extractAmount(getItemTotalText());
	}
	
	public double getTaxAmount() {
		return extractAmount(getTaxPriceText());
	}
	
	public double getTotalAmount() {
		return extractAmount(getTotalPriceText());
	}
		
}
