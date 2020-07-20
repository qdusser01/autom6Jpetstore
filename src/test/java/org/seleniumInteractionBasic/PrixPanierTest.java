package org.seleniumInteractionBasic;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PrixPanierTest {

	WebDriver driver;
	static Logger logger = LoggerFactory.getLogger(PrixPanierTest.class);

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@After
	public void teardown() {
		driver.quit();
	}

	@Test
	public void test() throws Throwable {
		driver.get("http://192.168.102.36:8090/jpetstore-1.0.5-env2");
		logger.info("Accès au magasin");
		// driver.findElement(By.xpath("//a[@href='shop/signonForm.do']"));
		// driver.findElement(By.xpath("//*[@name='img_signin']"));
		driver.findElement(By.name("img_signin")).click();

		logger.info("Accès à la page de login");
		WebElement champ_username = driver.findElement(By.name("username"));
		WebElement champ_password = driver.findElement(By.name("password"));
		ecrireChampTexte(champ_username,"j2ee");
		ecrireChampTexte(champ_password,"j2ee");
		driver.findElement(By.name("update")).submit();

		logger.info("Accès à la page d'accueil");

		assertTrue(driver.findElement(By.xpath("//font[contains(.,'Welcome ABC')]")).isDisplayed());

		assertTrue(driver.findElement(By.name("img_signout")).isDisplayed());
		driver.findElement(By.xpath("//img[contains(@src, 'fish_icon')]")).click();
		assertTrue(driver.findElement(By.xpath("//font[contains(., 'FI-SW-01')]")).isDisplayed()
				&& driver.findElement(By.xpath("//font[contains(., 'FI-SW-02')]")).isDisplayed()
				&& driver.findElement(By.xpath("//font[contains(., 'FI-FW-01')]")).isDisplayed()
				&& driver.findElement(By.xpath("//font[contains(., 'FI-FW-02')]")).isDisplayed());
		
	//solution verification parcours de liste
//		List <WebElement> liste_produit=driver.findElements(By.xpath("//font[contains(., 'FI-')]"));
//		assertFalse(liste_produit.isEmpty());
//		assertEquals(4,liste_produit.size());
//		for(WebElement prod:liste_produit) {
//			logger.info(prod.getText());
//		}
		driver.findElement(By.xpath("//font[contains(., 'FI-SW-02')]")).click();
		driver.findElement(By.xpath("//a[contains(@href, 'addItemToCart')]")).click();
		
		WebElement titre_panier=driver.findElement(By.xpath("//*[text() = 'Shopping Cart']"));
		
		verifElementAffiche(titre_panier, "mon panier n'est pas affiché");

		//SALUUUUT

		WebElement champ_quantite= driver.findElement(By.xpath("//input[@type='text']"));
		ecrireChampTexte(champ_quantite, "2");
	
		driver.findElement(By.name("update")).click();
		String PrixU = driver.findElement(By.xpath("//td[6][contains(text(),'$')]")).getText().substring(1).replace("," ,".");
		String Total = driver.findElement(By.xpath("//td[7][contains(text(),'$')]")).getText().substring(1).replace(",",".");
		float prixunitaire = Float.parseFloat(PrixU);
		float totaltotal = Float.parseFloat(Total);
		
		try {
			assertTrue("Le prix total n'est pas egal au prix unitaire X 2",totaltotal == prixunitaire*2);
		}
		catch(AssertionError e) {
			logger.error("Le prix total n'est pas egal au prix unitaire X 2");
			throw e;
		}
			
	}
	
	
	public void ecrireChampTexte(WebElement e, String s) {
		e.clear();
		e.sendKeys(s);
	}
	
	public void verifElementAffiche(WebElement e, String msg) {
		try {
		assertTrue(e.isDisplayed());
		}
		
		catch(AssertionError ae) {
			logger.error(msg);
			throw ae;
		}
	}

}
