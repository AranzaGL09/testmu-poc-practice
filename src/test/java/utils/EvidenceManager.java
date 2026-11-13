package utils;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class EvidenceManager {

    public static void createArtifactsFolder() {

        File folder = new File("artifacts");

        if (!folder.exists()) {
            folder.mkdir();
        }
    }
	

   /* public static void saveResult(String result)
            throws Exception {

        createArtifactsFolder();

        FileWriter writer =
                new FileWriter("artifacts/result.txt");

        writer.write(result);

        writer.close();
    }*/
    
    public static void saveResult(
            String fileName,
            String result)
            throws Exception {

        createArtifactsFolder();

        FileWriter writer =
                new FileWriter(
                        "artifacts/" + fileName);

        writer.write(result);

        writer.close();
    }

    public static void saveSessionId(String sessionId)
            throws Exception {

        createArtifactsFolder();

        FileWriter writer =
                new FileWriter("artifacts/session.txt");

        writer.write(sessionId);

        writer.close();
    }

    public static void saveScreenshot(
    		WebDriver driver,
    	    String fileName)
            throws Exception {

        createArtifactsFolder();

        File source =
                ((TakesScreenshot) driver)
                        .getScreenshotAs(
                                OutputType.FILE);

        File destination =
                new File(
                        "artifacts/screenshot.png");

        Files.copy(
                source.toPath(),
                destination.toPath(),
                StandardCopyOption.REPLACE_EXISTING);
    }
}