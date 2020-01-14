package payrollsettings.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.baseclass.BaseClass;
import com.relevantcodes.extentreports.LogStatus;

import payrollsettings.pages.Deductions;

public class VerifyDeductionsCustom extends BaseClass {
	public Deductions ded;
	public String expectedtitle = "Deductions";
	public String path = System.getProperty("user.dir") + readconfig.getDeductionsExcelPath();

	@Test(priority = 1, enabled =false)
	public void verfiyToAddDeductions() throws Exception {
		// Generating Extent report for lines(21,22) 
		test = report.startTest("Verify Hour Category LoadFromList Test");
		test.log(LogStatus.INFO, "Test Started" + test.getStartedTime());
		// Page Factory Initilization using binary class of Hour Category
		ded = PageFactory.initElements(driver, Deductions.class);
		// Click on Company Setup and do some actions to get into Deductions screen
		ded.CompanySetupDropdown.click();
		iwait(20);
		ded.PayrollSettingDashboard.click();
		ded.DeductionsTab.click();
		// Get the text/Title of Deductions to verify that we are in Deductions Screen
		String actualtitle = ded.DeductionsPageTitle.getText();
		// Verifying with expected and actual text/Title of Deductions screen
		Assert.assertEquals(actualtitle, expectedtitle);
		System.out.println("Page title is: " + actualtitle);
		int deducsize = excel.getRowCount(path, "Add Deductions");
		for (int i = 0; i < deducsize; i++) {
			ded.DeductionsCreateNew.click();
			String deducname = excel.getCellData(path, "Add Deductions", i + 1, 0);
			ded.DeductionsAddTextboxName.sendKeys(deducname);
			ded.SaveAddButtonDeduc.click();
			Thread.sleep(1500);
			ded.ConfirmPopupBtn.click();
			Thread.sleep(1000);

		/*	String canceltext = ded.CancelNewButtonDeduc.getAttribute("value");

			if (canceltext.equalsIgnoreCase("Cancel")) {
				try {
					ded.CancelNewButtonDeduc.click();
					Thread.sleep(1000);
					System.out.println("Deductions Already Exists");
				} catch (Exception e) {
					System.out.println("Deductions Added Successfully");
				}
			}*/

		}
	}

	@Test(priority = 2,enabled=false)
	public void verifyToEdit() throws Exception {
		// Generating Extent report for lines(21,22)
		test = report.startTest("Verify Hour Category LoadFromList Test");
		test.log(LogStatus.INFO, "Test Started" + test.getStartedTime());
		// Page Factory Initilization using binary class of Hour Category
		ded = PageFactory.initElements(driver, Deductions.class);
		// Click on Company Setup and do some actions to get into Deductions screen
		ded.CompanySetupDropdown.click();
		iwait(20);
		ded.PayrollSettingDashboard.click();
		ded.DeductionsTab.click();
		int deduccnt = excel.getRowCount(path, "Edit Deductions");
		for (int i = 0; i < deduccnt; i++) {
			String deducname = excel.getCellData(path, "Edit Deductions", i + 1, 0);
			String deducnameedit = excel.getCellData(path, "Edit Deductions", i + 1, 1);
			String deducnamecalmethod = excel.getCellData(path, "Edit Deductions", i + 1, 2);
			String deduccalmethodfixedamt = excel.getCellData(path, "Edit Deductions", i + 1, 3);
			String deduccalmethodfixedamtdrpdwn = excel.getCellData(path, "Edit Deductions", i + 1,4);
			String deduccalmethodfixedpercentdrpdwn = excel.getCellData(path, "Edit Deductions", i + 1,5);

			Select s = new Select(ded.DeductionsDropDown);
			List<WebElement> deduclist = s.getOptions();
			int sizededuc = deduclist.size();
			for (int j = 0; j < sizededuc; j++) {
				WebElement e = deduclist.get(j);
				try {
					String appdeducname = e.getText();
					if (appdeducname.equalsIgnoreCase(deducname)) {
						e.click();
						Thread.sleep(1000);
						ded.DeductionsEditTextboxName.clear();
						Thread.sleep(1000);
						ded.DeductionsEditTextboxName.sendKeys(deducnameedit);
						
						
						if(deducnamecalmethod.contains("Variable Amount")) {
							dropdownSelect(ded.DeducCalcMethodDropDown, deducnamecalmethod);
							System.out.println("Variable Amount Selected");
							List<WebElement> chk= driver.findElements(By.xpath("//*[@class='checkbox']"));
							int size=chk.size();

							for(int c=0;c<size;c++) {
								WebElement a= chk.get(c);
								String box=a.getText();
								System.out.println(box);
								String ExcelVal=excel.getCellData(path,"Edit Deductions", i+1, 6);
								String[] arrOfStr=ExcelVal.split(",");
								for(String st:arrOfStr) {	
							if(st.contains(box)) {
								
								if(a.isSelected()) {
									System.out.println("checkbox already checked");
								}else {
									a.click();
									System.out.println("checkbox checked is: "+box);
								}
							}
									
							}
						}					
							}
					
						if (deducnamecalmethod.contains("Fixed Amount")) {
							Thread.sleep(1000);
							dropdownSelect(ded.DeducCalcMethodDropDown, deducnamecalmethod);
							System.out.println("Fixed Amount Selected");
							Thread.sleep(1000);
							ded.DeducCalcMethodAmountTextbox.clear();
							ded.DeducCalcMethodAmountTextbox.sendKeys(deduccalmethodfixedamt);
							Thread.sleep(1000);
							dropdownSelect(ded.DeducCalcMethodPerDropdown, deduccalmethodfixedamtdrpdwn);
							exemptionCheckBoxes(path, "Edit Deductions", i+1, 6);
						}
						if (deducnamecalmethod.contains("Fixed % of Sales")) {
							Thread.sleep(1000);
							dropdownSelect(ded.DeducCalcMethodDropDown, deducnamecalmethod);
							System.out.println("Fixed % of Sales Selected");
							Thread.sleep(1000);
							ded.DeducCalcMethodAmountTextbox.clear();
							ded.DeducCalcMethodAmountTextbox.sendKeys(deduccalmethodfixedamt);
							Thread.sleep(1000);
							dropdownSelect(ded.DeducCalcMethodApplyToDropdown, deduccalmethodfixedpercentdrpdwn);
							exemptionCheckBoxes(path, "Edit Deductions", i+1, 6);
						}
						
					/*	List<WebElement> chk= driver.findElements(By.xpath("//*[@class='Checked']"));	
						int chksize=chk.size();
						for(int c=0;c<chksize;c++) {
							WebElement box=chk.get(c);
							String boxname=box.getAttribute("name");
							String ExcelVal=excel.getCellData(path,"Edit Deductions", i+1, 6);
							String[] arrOfStr=ExcelVal.split(",");
							for(String st:arrOfStr) {
								if(st.contains(boxname)) {
									System.out.println(boxname);
									box.click();
								}else {
									System.out.println("not matched with excel");
								}
							}
						}*/
						
						ded.SaveButtonDeduc.click();
						Thread.sleep(1500);
						ded.ConfirmPopupBtn.click();
					}

					
				} catch (Exception e1) {
					int k = j + 1;
					e = driver.findElement(By.xpath("//*[@id='categoryId']//option[" + k + "]"));
					String appdeducname = e.getText();
					if (appdeducname.equalsIgnoreCase(deducname)) {
						e.click();
						Thread.sleep(1000);
						ded.DeductionsEditTextboxName.clear();
						Thread.sleep(1000);
						ded.DeductionsEditTextboxName.sendKeys(deducnameedit);
						
						if(deducnamecalmethod.contains("Variable Amount")) {
							dropdownSelect(ded.DeducCalcMethodDropDown, deducnamecalmethod);
							System.out.println("Variable Amount Selected");
							List<WebElement> chk= driver.findElements(By.xpath("//*[@class='checkbox']"));
							int size=chk.size();

							for(int c=0;c<size;c++) {
								WebElement a= chk.get(c);
								String box=a.getText();
								System.out.println(box);
								String ExcelVal=excel.getCellData(path,"Edit Deductions", i+1, 6);
								String[] arrOfStr=ExcelVal.split(",");
								for(String st:arrOfStr) {	
							if(st.contains(box)) {
								
								if(a.isSelected()) {
									System.out.println("checkbox already checked");
								}else {
									a.click();
									System.out.println("checkbox checked is: "+box);
								}
							}
									
							}
						}	
							
						}
						

						if (deducnamecalmethod.equalsIgnoreCase("Fixed Amount")) {
							Thread.sleep(1000);
							dropdownSelect(ded.DeducCalcMethodDropDown, deducnamecalmethod);
							System.out.println("Fixed Amount Selected");
							Thread.sleep(1000);
							ded.DeducCalcMethodAmountTextbox.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
							Thread.sleep(1000);
							ded.DeducCalcMethodAmountTextbox.sendKeys(deduccalmethodfixedamt);
							Thread.sleep(1000);
							dropdownSelect(ded.DeducCalcMethodPerDropdown, deduccalmethodfixedamtdrpdwn);
							exemptionCheckBoxes(path, "Edit Deductions", i+1, 6);
						}
						
						if (deducnamecalmethod.contains("Fixed % of Sales")) {
							Thread.sleep(1000);
							dropdownSelect(ded.DeducCalcMethodDropDown, deducnamecalmethod);
							System.out.println("Fixed % of Sales Selected");
							Thread.sleep(1000);
							ded.DeducCalcMethodAmountTextbox.clear();
							ded.DeducCalcMethodAmountTextbox.sendKeys(deduccalmethodfixedamt);
							Thread.sleep(1000);
							dropdownSelect(ded.DeducCalcMethodApplyToDropdown, deduccalmethodfixedpercentdrpdwn);
							exemptionCheckBoxes(path, "Edit Deductions", i+1, 6);
						}
					
						ded.SaveButtonDeduc.click();
						Thread.sleep(1500);
					}
					}
					
				}
			}
		}
	

	@Test(priority = 3, enabled =true)
	public void verifyToDeleteDeductions() throws IOException, Exception {
		// Generating Extent report for lines(21,22)
		test = report.startTest("Verify Deductions Delete Test");
		test.log(LogStatus.INFO, "Test Started" + test.getStartedTime());
		// Page Factory Initilization using binary class of Hour Category
		ded = PageFactory.initElements(driver, Deductions.class);
		// Click on Company Setup and do some actions to get into Deductions screen
		ded.CompanySetupDropdown.click();
		iwait(20);
		ded.PayrollSettingDashboard.click();
		ded.DeductionsTab.click();
		int rowsize = excel.getRowCount(path, "Delete Deductions");
		for (int j = 0; j < rowsize; j++) {
			String exceldeducdel = excel.getCellData(path, "Delete Deductions", j + 1, 0);

			Select s = new Select(ded.DeductionsDropDown);
			List<WebElement> deduclist = s.getOptions();
			int sizededuc = deduclist.size();
			for (int i = 0; i < sizededuc; i++) {
				WebElement e = deduclist.get(i);
				try {
					String appdeducname = e.getText();
					if (appdeducname.equalsIgnoreCase(exceldeducdel)) {
						e.click();
						Thread.sleep(1000);
						ded.DeductionsDelete.click();
						Thread.sleep(1000);
						ded.ConfirmPopupBtn1.click();
						Thread.sleep(1000);
						ded.ConfirmPopupBtn.click();
						
					}
				} catch (Exception e1) {
					e = driver.findElement(By.xpath("//*[@id='categoryId']//option[" + i + "]"));
					String appdeducname = e.getText();
					if (appdeducname.equalsIgnoreCase(exceldeducdel)) {
						e.click();
						Thread.sleep(1000);
						ded.DeductionsDelete.click();
						Thread.sleep(1000);
						ded.ConfirmPopupBtn1.click();
						Thread.sleep(1000);
						ded.ConfirmPopupBtn.click();
						

					}
				}
			}
		}

	}

	
	public void exemptionCheckBoxes(String XlPath, String Sheetname,int RowNum, int ColNum) throws IOException {
		List<WebElement> chk= driver.findElements(By.xpath("//*[@class='Checked']"));
		int size=chk.size();

		for(int i=0;i<size;i++) {
			WebElement a= chk.get(i);
			String ExcelVal=excel.getCellData(XlPath, Sheetname, RowNum, ColNum);
			String[] arrOfStr=ExcelVal.split(",");
			for (String b : arrOfStr)
				if(b.contains(a.getAttribute("name"))) {
					a.click();
				}
		}
	}
}
