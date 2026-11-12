package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By user =
            By.id("user-name");

    By pass =
            By.id("password");

    By login =
            By.id("login-button");

    public void loginValido() {

        driver.findElement(user)
              .sendKeys("standard_user");

        driver.findElement(pass)
              .sendKeys("secret_sauce");
        
       /* driver.findElement(pass)
        .sendKeys("xxxx");*/

        driver.findElement(login)
              .click();

    }


}
