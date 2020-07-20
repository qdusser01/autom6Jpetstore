package org.seleniumInteractionBasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageCategorie extends AbstractPageBandeau{
	
	@FindBy (tagName="h2") 
	WebElement titre_categorie;

	public boolean isTitreConforme (String cat) {
		return titre_categorie.getText().toUpperCase().equals(cat);		
	}
	
	public PageProduit clicProduit (WebDriver driver, String pdt) {
		driver.findElement(By.xpath("//a[contains(@href, 'productId="+pdt+"')]")).click();
		return PageFactory.initElements(driver, PageProduit.class);
	}
	
}
