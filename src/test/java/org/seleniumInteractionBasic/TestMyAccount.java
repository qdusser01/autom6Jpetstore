package org.seleniumInteractionBasic;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestMyAccount {
	
	String jdd_langue="japanese";
	String jdd_categorie="REPTILES";
    int jdd_indexcheckbox=1;
    
	WebDriver driver;
	static Logger logger = LoggerFactory.getLogger(TestMyAccount.class);
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@After
	public void teardown() {
		driver.quit();
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
		
		// Instanciation PageMyAccount --> appel méthodes de selection
		
		PageMyAccount page_myaccount = page_accueil.clicMyAccount(driver);
		assertTrue(page_myaccount.verificationTitre());
		
		page_myaccount.choixLangue(jdd_langue);
		page_myaccount.choixCategorie(jdd_categorie);
		assertEquals(jdd_langue, page_myaccount.getLanguageSelectionne());
		assertEquals(jdd_categorie, page_myaccount.getCategorieSelectionne());
		assertTrue(page_myaccount.isCheckboxSelectionne());
		assertTrue(page_myaccount.deselectionCheckbox(jdd_indexcheckbox));
		
	}
}
