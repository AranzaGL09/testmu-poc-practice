package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import driver.DriverFactory;
import pages.LoginPage;
import utils.EvidenceManager;

public class LoginTest {

    @Test
    public void validarLogin() throws Exception {

        WebDriver driver = null;

        try {

            driver =
                    DriverFactory.getDriver();

            String sessionId =
                    ((RemoteWebDriver) driver)
                            .getSessionId()
                            .toString();

            EvidenceManager.saveSessionId(
                    sessionId);

            driver.get(
                    "https://www.saucedemo.com");

            LoginPage login =
                    new LoginPage(driver);

            login.loginValido();
            
            /*Thread.sleep(2000);*/

            String titulo =
                    driver.findElement(
                            By.className("title"))
                            .getText();

            System.out.println(
                    "Título encontrado: "
                            + titulo);

            assertEquals(
                    "Products",
                    titulo);

            EvidenceManager.saveResult(
            		"POC-W001.txt",
                    "LOGIN EXITOSO - Products");

        } catch (Exception e) {

            if(driver != null) {

                EvidenceManager.saveScreenshot(
                        driver);
            }

            EvidenceManager.saveResult(
            		"POC-W002.txt",
                    "LOGIN INVÁLIDO - Epic sadface");

            throw e;

        } finally {

            if(driver != null) {
                driver.quit();
            }
        }
    }
}