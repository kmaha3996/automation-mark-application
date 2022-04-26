package common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotFunctions {
	WebDriver driverObj;
	TakesScreenshot screenshot;
	Boolean mountDrive;
	String screenShotFolderName;

	public ScreenshotFunctions(WebDriver driver) {
		driverObj = driver;
		screenshot = (TakesScreenshot) driver;
	}

	public String saveAndReturnScreenshot() {
		String retFile = null;
		String fileName = null;
		try {
			createUniqueFolderForSavingScreenShot();
			File src = screenshot.getScreenshotAs(OutputType.FILE);
			retFile = getBase64(src);
			// Copy files to specific location
			String methodName = BaseTestCase.currentRunningMethod;
			System.out.println(methodName);
			fileName = screenShotFolderName + methodName + ".png";
			FileUtils.copyFile(src, new File(fileName));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception while taking screenshot " + e.getMessage());
		}
		return retFile;
	}

	private void createUniqueFolderForSavingScreenShot() {
		if (screenShotFolderName == null) {
			DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
			Date date = new Date();
			String dateAndTime = dateFormat.format(date);
			String baseDir = "./test-output/failedTest/";
			screenShotFolderName = "smoke-test";
			screenShotFolderName = baseDir + dateAndTime + "/" + screenShotFolderName + "/";
			createFolder(screenShotFolderName);
			System.out.println("Saving failed test screenShots at: " + screenShotFolderName);
		}
	}

	private void createFolder(String folderNameAndPath) {
		File directory = new File(folderNameAndPath);
		if (!directory.exists() && !directory.isDirectory()) {
			directory = new File(folderNameAndPath);
			if (directory.mkdir()) {
				System.out.println("Directory Created: " + folderNameAndPath);
			} else {
				System.out.println("Directory not created: " + folderNameAndPath);
			}
		}
	}

	private String getBase64(File srcFile) throws IOException {
		String retVal = null;
		FileInputStream fileStream = new FileInputStream(srcFile);
		byte[] byts = new byte[(int) srcFile.length()];
		fileStream.read(byts);
		retVal = new String(Base64.getEncoder().encodeToString(byts));
		fileStream.close();
		return retVal;
	}
}