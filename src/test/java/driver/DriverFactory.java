package driver;

import java.net.URI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    public static WebDriver getDriver() throws Exception {

        String executionTarget =
                System.getProperty(
                        "EXECUTION_TARGET",
                        "local");

        String username =
                System.getProperty("LT_USERNAME");

        String accessKey =
                System.getProperty("LT_ACCESS_KEY");

        String projectName =
                System.getProperty("LT_PROJECT");

        String buildName =
                System.getProperty("LT_BUILD_NAME");
        

        if(executionTarget.equalsIgnoreCase("local")) {

            System.out.println("Ejecución LOCAL");

            return new ChromeDriver();
        }

        
        if(executionTarget.equalsIgnoreCase("testmu")) {

            System.out.println("Ejecución TESTMU");
            System.out.println("Usuario: " + username);
            System.out.println("Proyecto: " + projectName);
            System.out.println("Build: " + buildName);
            
            
            ChromeOptions options =
                    new ChromeOptions();

            options.setBrowserVersion("latest");
            options.setPlatformName("Windows 11");
            
            Map<String, Object> ltOptions =
                    new HashMap<>();

            ltOptions.put(
                    "project",
                    projectName);

            ltOptions.put(
                    "build",
                    buildName);

            ltOptions.put(
                    "name",
                    "POC-W01 Login válido");
            
            options.setCapability(
                    "LT:Options",
                    ltOptions);


            String hubUrl =
                    "https://"
                    + username
                    + ":"
                    + accessKey
                    + "@hub.lambdatest.com/wd/hub";
        
            System.out.println("Hub URL configurado");
            
            return new RemoteWebDriver(
                    URI.create(hubUrl)
                       .toURL(),
                    options);
        }

        throw new RuntimeException(
                "EXECUTION_TARGET inválido");
    }
}