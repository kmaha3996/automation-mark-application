package testcases;

import org.testng.annotations.Test;

import common.BaseTestCase;
import pages.AppearTestLocators;
import pages.HamburgerLocator;
import pages.LoginLocators;
import pages.MarksheetLocators;

public class TC3_MarksheetPage extends BaseTestCase {
	
	LoginLocators login; 
	AppearTestLocators homepage;
	HamburgerLocator hamburger;
	MarksheetLocators marksheet;
	
	@Test(description="To verify whether the teacher admin is able to upload marks using CSV.")
	public void markSheetUploadVerify() throws InterruptedException {
		login = new LoginLocators(driver);
		hamburger = new HamburgerLocator(driver, wait);
		marksheet = new MarksheetLocators(driver, wait);
		
		login.loginTeacher();
		hamburger.hamburgerClick();
		marksheet.marksheetPageLoad();
		marksheet.markSheetDialogBox();
		marksheet.importCsvMarksheet();
		marksheet.uploadCsvMarsksheet();
	}

	@Test(description="To verify whether the teacher admin is able to export School GAPS analysis.")
	public void schoolGapsExportVerify() throws InterruptedException {
		login = new LoginLocators(driver);
		hamburger = new HamburgerLocator(driver, wait);
		marksheet = new MarksheetLocators(driver, wait);
		
		login.loginTeacher();
		hamburger.hamburgerClick();
		marksheet.marksheetPageLoad();
		marksheet.schoolGapExport();
	}
}