package tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import driver.DriverFactory;
import utils.EvidenceManager;

public class LoginInvalidoTest {
	
	 @Test
	    public void validarLoginInvalido()
	            throws Exception {

	        WebDriver driver = null;

	        try {

	            driver =
	                    DriverFactory.getDriver();

	            driver.get(
	                    "https://www.saucedemo.com");

	            driver.findElement(
	                    By.id("user-name"))
	                    .sendKeys(
	                            "usuarioIncorrecto");

	            driver.findElement(
	                    By.id("password"))
	                    .sendKeys(
	                            "passwordIncorrecto");

	            driver.findElement(
	                    By.id("login-button"))
	                    .click();

	            String mensajeError =
	                    driver.findElement(
	                            By.cssSelector(
	                                    "h3[data-test='error']"))
	                            .getText();

	            System.out.println(
	                    mensajeError);

	            assertTrue(
	                    mensajeError.contains(
	                            "Epic sadface"));

	            EvidenceManager.saveResult(
	            		"POC-W002.txt",
	                    "LOGIN INVÁLIDO CORRECTO - "
	                            + mensajeError);

	        } catch (Exception e) {

	            if (driver != null) {

	                EvidenceManager.saveScreenshot(
	                        driver, "POC-W002.png");
	            }

	            throw e;

	        } 
	        finally {

	            if (driver != null) {

	                driver.quit();
	            }
	        }
	    }

}
