package org.seleniumInteractionBasic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageResultatRecherche extends AbstractPageBandeau {

	@FindBy(xpath = "//table[@align='center'][1]/tbody/tr")
	private List<WebElement> liste_lignes;

	private WebElement getCellule(WebDriver driver, int row, int col) {
		WebElement element = driver.findElement(By.xpath("//table[@align='center']/tbody/tr[" + row + "]/td[" + col + "]//a"));
		return element;
	}

	public PageProduit clicLienProduit(String animal, WebDriver driver) {
		getCellule(driver, SocleTechnique.retournerNumeroDeLigne(liste_lignes,animal), 2).click();
		return PageFactory.initElements(driver, PageProduit.class);
	}



}
