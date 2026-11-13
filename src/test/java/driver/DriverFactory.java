package driver;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

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
                System.getProperty(
                        "LT_PROJECT",
                        "testmu-poc-practice");

        String buildName =
                System.getProperty(
                        "LT_BUILD_NAME",
                        "Local-Build");

        System.out.println("===============================");
        System.out.println("EXECUTION_TARGET = "
                + executionTarget);
        System.out.println("===============================");

        if (executionTarget.equalsIgnoreCase("local")) {

            System.out.println("Ejecución LOCAL");

            ChromeOptions options =
                    new ChromeOptions();

            if (System.getenv("GITHUB_ACTIONS") != null) {

                System.out.println(
                        "Ejecución GitHub Actions");

                options.addArguments("--headless=new");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--window-size=1920,1080");
            }

            return new ChromeDriver(options);
        }

        if (executionTarget.equalsIgnoreCase("testmu")) {

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
                    "POC Selenium Execution");

            options.setCapability(
                    "LT:Options",
                    ltOptions);

            String hubUrl =
                    "https://"
                    + username
                    + ":"
                    + accessKey
                    + "@hub.lambdatest.com/wd/hub";

            RemoteWebDriver driver =
                    new RemoteWebDriver(
                            URI.create(hubUrl).toURL(),
                            options);

            System.out.println(
                    "SESSION ID: "
                    + driver.getSessionId());

            return driver;
        }

        throw new RuntimeException(
                "EXECUTION_TARGET inválido: "
                + executionTarget);
    }
}