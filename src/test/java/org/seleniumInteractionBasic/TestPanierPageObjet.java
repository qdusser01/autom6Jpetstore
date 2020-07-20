package org.seleniumInteractionBasic;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestPanierPageObjet {
	WebDriver driver;
	static Logger logger = LoggerFactory.getLogger(TestPanierPageObjet.class);
	String jdd_cat = "FISH";
	String jdd_pdt = "FI-SW-01";
	String jdd_qte="2";

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@After
	public void teardown() {
		// driver.quit();
	}

	@Test
	public void test() {
		driver.get("http://192.168.102.36:8090/jpetstore-1.0.5-env2/");

		// Instanciation PageIndex
		PageIndex page_index = PageFactory.initElements(driver, PageIndex.class);

		// Appel méthode clicSignIn() --> instanciation PageLogin
		PageLogin page_login = page_index.clicSignIn(driver);

		// Appel méthode seConnecter() --> instanciation PageAccueil
		PageAccueil page_accueil = page_login.seConnecter(driver, "j2ee", "j2ee");
		assertTrue(page_accueil.isMessagePresent());

		// Appel méthode clickCategorie() --> instanciation PageCategorie
		PageCategorie page_categorie = page_accueil.clicCategorie(driver, jdd_cat);

		assertTrue(page_categorie.isTitreConforme(jdd_cat));

		PageProduit page_produit = page_categorie.clicProduit(driver, jdd_pdt);

		// Appel méthode ajouterAuPanier -- instanciation PagePanier

		PagePanier page_panier = page_produit.ajouterAuPanier(driver);
		
		page_panier.editerQuantite(jdd_qte);
		
		assertTrue(page_panier.isPrixTotalConformeQuantite(Integer.parseInt(jdd_qte)));
		

	}

}
