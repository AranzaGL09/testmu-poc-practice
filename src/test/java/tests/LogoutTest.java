package tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import driver.DriverFactory;
import pages.LoginPage;
import utils.EvidenceManager;

public class LogoutTest {

    @Test
    public void POC_W004_Logout() throws Exception {

        WebDriver driver =
                DriverFactory.getDriver();

        driver.get("https://www.saucedemo.com");

        LoginPage login =
                new LoginPage(driver);

        login.loginValido();

        driver.findElement(
                By.id("react-burger-menu-btn"))
                .click();

        Thread.sleep(1000);

        driver.findElement(
                By.id("logout_sidebar_link"))
                .click();

        assertTrue(
                driver.getCurrentUrl()
                      .contains("saucedemo"));

        EvidenceManager.saveResult(
                "POC-W004.txt",
                "Logout exitoso");

        driver.quit();
    }
}