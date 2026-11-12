package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import driver.DriverFactory;
import pages.LoginPage;
import utils.EvidenceManager;

public class AgregarProductoTest {

    @Test
    public void POC_W005_Agregar_Producto()
            throws Exception {

        WebDriver driver =
                DriverFactory.getDriver();

        driver.get(
                "https://www.saucedemo.com");

        LoginPage login =
                new LoginPage(driver);

        login.loginValido();

        driver.findElement(
                By.id(
                        "add-to-cart-sauce-labs-backpack"))
                .click();

        String badge =
                driver.findElement(
                        By.className(
                                "shopping_cart_badge"))
                        .getText();

        assertEquals(
                "1",
                badge);

        EvidenceManager.saveResult(
                "POC-W005.txt",
                "Producto agregado");

        driver.quit();
    }
}
