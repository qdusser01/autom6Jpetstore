package org.seleniumInteractionBasic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AbstractPageBandeau {

	@FindBy (name= "search")
	WebElement champ_search;
	
	@FindBy (name="img_signin")
	WebElement bouton_signin;
	
	@FindBy (name="img_signout")
	WebElement bouton_signout;
	
	public PageLogin clicSignIn(WebDriver driver) {
		bouton_signin.click();
		return PageFactory.initElements(driver, PageLogin.class);
	}
	
	public PageAccueil clicSignOut(WebDriver driver) {
		bouton_signout.click();
		return PageFactory.initElements(driver, PageAccueil.class);
	}
}
