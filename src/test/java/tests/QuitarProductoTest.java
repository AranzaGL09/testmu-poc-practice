package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import driver.DriverFactory;
import pages.LoginPage;
import utils.EvidenceManager;

import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QuitarProductoTest {

	@Test
	public void POC_W006_Quitar_Producto()
	        throws Exception {

	    WebDriver driver = null;

	    try {

	        driver = DriverFactory.getDriver();

	        driver.get("https://www.saucedemo.com");

	        LoginPage login =
	                new LoginPage(driver);

	        login.loginValido();

	        WebDriverWait wait =
	                new WebDriverWait(
	                        driver,
	                        Duration.ofSeconds(10));

	        wait.until(
	                ExpectedConditions
	                        .elementToBeClickable(
	                                By.id(
	                                        "add-to-cart-sauce-labs-backpack")))
	                .click();

	        wait.until(
	                ExpectedConditions
	                        .elementToBeClickable(
	                                By.id(
	                                        "remove-sauce-labs-backpack")))
	                .click();

	        String textoBoton =
	                wait.until(
	                        ExpectedConditions
	                                .visibilityOfElementLocated(
	                                        By.id(
	                                                "add-to-cart-sauce-labs-backpack")))
	                .getText();

	        System.out.println(
	                "Texto botón: "
	                        + textoBoton);

	        assertEquals(
	                "Add to cart",
	                textoBoton);

	        EvidenceManager.saveResult(
	                "POC-W006.txt",
	                "Producto eliminado correctamente");

	    } catch (Exception e) {

	        if(driver != null) {
	            EvidenceManager.saveScreenshot(driver);
	        }

	        EvidenceManager.saveResult(
	                "POC-W006.txt",
	                "ERROR: " + e.getMessage());

	        throw e;

	    } finally {

	        if(driver != null) {
	            driver.quit();
	        }
	    }
	}
}