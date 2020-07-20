package org.seleniumInteractionBasic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PageAccueil extends AbstractPageBandeau {

	static Logger logger = LoggerFactory.getLogger(PageAccueil.class);

	@FindBy(xpath = "//font")
	private WebElement message_bienvenue;
//	
//	@FindBy(xpath = "//a[contains(@href,'categoryId=FISH')]")
//	private WebElement lien_categorie_fish;
//	
//	@FindBy(xpath = "//a[contains(@href,'categoryId=DOGS')]")
//	private WebElement lien_categorie_dog;

	public boolean isMessagePresent() {
		boolean resultat = SocleTechnique.isElementPresent(message_bienvenue, logger);
		return resultat;
	}
	
	

//	private PageCategorie clickCategorie(WebDriver driver, WebElement cat) {
//		cat.click();
//		return PageFactory.initElements(driver, PageCategorie.class);
//	}
//	
//	public PageCategorie clickCategorieFish(WebDriver driver) {
//		return clickCategorie(driver, lien_categorie_fish);
//	}
//	
//	public PageCategorie clickCategorieDog(WebDriver driver) {
//		return clickCategorie(driver, lien_categorie_dog);
//	}
	
	public PageCategorie clicCategorie(WebDriver driver, String cat) {
		driver.findElement(By.xpath("//a[contains(@href,'categoryId="+cat+"')]")).click();
		return PageFactory.initElements(driver, PageCategorie.class);
	}
	
	
}
