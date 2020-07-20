package org.seleniumInteractionBasic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageProduit extends AbstractPageBandeau {

	@FindBy(xpath = "//a[contains(@href,'addItemToCart')]")
	WebElement bouton_add_to_cart;

	public PagePanier ajouterAuPanier(WebDriver driver) {
		bouton_add_to_cart.click();
		return PageFactory.initElements(driver, PagePanier.class);
	}

}
