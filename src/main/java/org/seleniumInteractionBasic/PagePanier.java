package org.seleniumInteractionBasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PagePanier extends AbstractPageBandeau{

@FindBy (name="update")
WebElement btn_update_cart;

@FindBy (xpath="//td/input[contains(@name,'EST')]")
WebElement champ_qte;

@FindBy (xpath="//td[6][contains(.,'$')]")
WebElement cellule_prix_unitaire;

@FindBy (xpath="//td[7][contains(.,'$')]")
WebElement cellule_prix_total;

public void editerQuantite(String qte) {
	
	SocleTechnique.renseignerChamps(champ_qte,qte );
	btn_update_cart.click();
}

public boolean isPrixTotalConformeQuantite(int qte) {
	
	String PrixU = cellule_prix_unitaire.getText().substring(1).replace("," ,".");
	String Total = cellule_prix_total.getText().substring(1).replace(",",".");
	
	float prixunitaire = Float.parseFloat(PrixU);
	float totaltotal = Float.parseFloat(Total);
	return totaltotal==prixunitaire*qte;
	
}

}
