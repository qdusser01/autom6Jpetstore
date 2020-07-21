package org.seleniumInteractionBasic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AbstractPageBandeau {

	@FindBy (name= "keyword")
	WebElement champ_search;
	
	@FindBy (xpath="//input[contains(@src,'search.gif')]")
	WebElement bouton_search;
	
	@FindBy (name="img_signin")
	WebElement bouton_signin;
	
	@FindBy (name="img_signout")
	WebElement bouton_signout;
	
	@FindBy (name="img_myaccount")
	WebElement lien_myaccount;
	
	public PageLogin clicSignIn(WebDriver driver) {
		bouton_signin.click();
		return PageFactory.initElements(driver, PageLogin.class);
	}
	
	public PageAccueil clicSignOut(WebDriver driver) {
		bouton_signout.click();
		return PageFactory.initElements(driver, PageAccueil.class);
	}
	
	public PageMyAccount clicMyAccount(WebDriver driver) {
		lien_myaccount.click();
		return PageFactory.initElements(driver, PageMyAccount.class);
		
	}
	
	public PageResultatRecherche rechercher(WebDriver d, String mot_clef) {
		SocleTechnique.renseignerChamps(champ_search, mot_clef);
		bouton_search.click();
		return PageFactory.initElements(d, PageResultatRecherche.class);
	}
}
