package org.seleniumInteractionBasic;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class monTestLeMonde {

	WebDriver driver;

	@Before

	public void setup() {

		System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
		driver = new ChromeDriver();

	}

	@Test
	public void test() throws InterruptedException {

		driver.get("https://lemonde.fr");
		// driver.getTitle();
		assertEquals("Le Monde.fr - Actualités et Infos en France et dans le monde", driver.getTitle());
		assertTrue(driver.getTitle().equals("Le Monde.fr - Actualités et Infos en France et dans le monde"));
		driver.close();

	}

	@After
	public void teardown() {

		driver.quit();

	}

}
