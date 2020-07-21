package org.seleniumInteractionBasic;

import java.util.List;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PageMyAccount extends AbstractPageBandeau {

	String TITRE1 = "User Information";
	String TITRE2 = "Account Information";
	String TITRE3 = "Profile Information";

	@FindBy(tagName = "h3")
	private List<WebElement> liste_de_titres;
	
	@FindBy (name="account.languagePreference")
	private WebElement menu_langue;
	
	@FindBy (name="account.favouriteCategoryId")
	private WebElement menu_categorie;
	
	@FindBy (xpath = "//input[@type = 'checkbox']")
	private List<WebElement> liste_checkbox;

	public boolean verificationTitre() {
		return liste_de_titres.get(0).getText().equals(TITRE1) 
				&& liste_de_titres.get(1).getText().equals(TITRE2)
				&& liste_de_titres.get(2).getText().equals(TITRE3);

	}
	
	public void choixLangue (String l) {
		Select selectLangue = new Select(menu_langue);		
		selectLangue.selectByValue(l);
		
	}
	
	public void choixCategorie (String c) {
		Select selectCategorie = new Select(menu_categorie);		
		selectCategorie.selectByValue(c);
		
	}
	public String getLanguageSelectionne () {
		Select selectLangue = new Select(menu_langue);
		return selectLangue.getFirstSelectedOption().getAttribute("value");
	}
	
	public String getCategorieSelectionne () {
		Select selectCategorie = new Select(menu_categorie);
		return selectCategorie.getFirstSelectedOption().getAttribute("value");
	}
	public boolean isCheckboxSelectionne () {
		return liste_checkbox.get(0).isSelected()&&
			   liste_checkbox.get(1).isSelected();
		}
	
	public boolean deselectionCheckbox (int i) {
		if (liste_checkbox.get(i).isSelected()) {
			liste_checkbox.get(i).click();
		}
		else {
		}
	    return !(liste_checkbox.get(i).isSelected());
	}
	}
	

