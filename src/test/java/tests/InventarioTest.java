package tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import driver.DriverFactory;
import pages.LoginPage;
import utils.EvidenceManager;

public class InventarioTest {

    @Test
    public void POC_W003_Ver_Inventario() throws Exception {

        WebDriver driver = null;

        try {

            driver = DriverFactory.getDriver();

            driver.get("https://www.saucedemo.com");

            LoginPage login =
                    new LoginPage(driver);

            login.loginValido();

            int productos =
                    driver.findElements(
                            By.className("inventory_item"))
                          .size();

            System.out.println(
                    "Productos encontrados: "
                            + productos);

            assertTrue(productos > 0);

            EvidenceManager.saveResult(
                    "POC-W003.txt",
                    "Inventario visible: "
                            + productos
                            + " productos");

        } catch (Exception e) {

            if (driver != null) {

                EvidenceManager.saveScreenshot(
                        driver,
                        "POC-W003.png");
            }

            EvidenceManager.saveResult(
                    "POC-W003.txt",
                    "ERROR: " + e.getMessage());

            throw e;

        } finally {

            if (driver != null) {
                driver.quit();
            }
        }
    }
}