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

import payrollsettings.pages.LocalTaxes;

public class VerifyLocalTaxesCustom extends BaseClass{

	public LocalTaxes loc;
	public String expectedtitle = "Local Taxes";
	public String path = System.getProperty("user.dir") + readconfig.getLocalTaxesDataExcelpath();
    public WebElement e;
	@Test(priority = 9,enabled=false)
	public void verifyToAddLocaltax() throws Exception {
		test = report.startTest("Verify To Add Local tax Test");
		test.log(LogStatus.INFO, "Test Started" + test.getStartedTime());
		loc = PageFactory.initElements(driver, LocalTaxes.class);
		loc.CompanySetupDropdown.click();
		iwait(20);
		loc.PayrollSettingDashboard.click();
		loc.LocalTaxesTab.click();
		String actualtitle = loc.LocalTaxesPageTitle.getText();
		Assert.assertEquals(actualtitle, expectedtitle);
		System.out.println("Page title is: " + actualtitle);
		int locsize = excel.getRowCount(path, "Add Localtax");

   for(int i=0;i<locsize;i++) {	
	iwait(20);   
	loc.NewTaxCreationButton.click();
	String locexcelname=excel.getCellData(path, "Add Localtax", i+1, 0);
	loc.EnterNewNameTextBox.sendKeys(locexcelname);
	Thread.sleep(1000);
	loc.LocalTaxSaveNewButton.click();
	Thread.sleep(1000);
	loc.ConfirmPopupBtn.click();
}
	}
	
	@Test(priority=1,enabled=false)
	public void VerifyToDeleteLocalTaxes() throws Exception {
		test = report.startTest("Verify To Delete Local tax Test");
		test.log(LogStatus.INFO, "Test Started" + test.getStartedTime());
		loc = PageFactory.initElements(driver, LocalTaxes.class);
		loc.CompanySetupDropdown.click();
		iwait(20);
		loc.PayrollSettingDashboard.click();
		loc.LocalTaxesTab.click();
	int lcnt=excel.getRowCount(path, "Delete local tax");
	for(int i=0;i<lcnt;i++) {
	String excellocname=	excel.getCellData(path, "Delete local tax", i+1, 0);
	Select s=new Select(loc.LocalTaxesDropDown);
	List<WebElement> list=s.getOptions();
	int listsize=list.size();
	for(int j=0;j<listsize;j++) {
	e=	list.get(j);
	try {
		String applocname= e.getText();
		if(excellocname.contains(applocname)) {
			e.click();
			loc.DeleteLocalTaxButton.click();
			Thread.sleep(1000);
			loc.ConfirmPopupBtn1.click();
			Thread.sleep(1000);
			loc.ConfirmPopupBtn.click();
			Thread.sleep(1000);
		}
	} catch (Exception e2) {
	int k=i+1;
		e = driver.findElement(By.xpath("//*[@id='dropLocalList']//option[" +k+ "]"));
		String applocname= e.getText();
		if(excellocname.contains(applocname)) {
			e.click();
			loc.DeleteLocalTaxButton.click();
			Thread.sleep(1000);
			loc.ConfirmPopupBtn1.click();
			Thread.sleep(1000);
			loc.ConfirmPopupBtn.click();
			Thread.sleep(1000);
			
					}
				}
			}
		}
	}
@Test(priority=3,enabled=true)
	public void VerifyToEditLocal() throws Exception {
	test = report.startTest("Verify To Delete Local tax Test");
	test.log(LogStatus.INFO, "Test Started" + test.getStartedTime());
	loc = PageFactory.initElements(driver, LocalTaxes.class);
	loc.CompanySetupDropdown.click();
	iwait(20);
	loc.PayrollSettingDashboard.click();
	loc.LocalTaxesTab.click();
int lcnt=excel.getRowCount(path, "Edit Local Tax");
for(int i=0;i<lcnt;i++) {
	String excellocalname=excel.getCellData(path, "Edit Local Tax", i+1, 0);
	String excelocalnameEdit=excel.getCellData(path, "Edit Local Tax", i+1, 1);
	String excelcalcmethodEdit=excel.getCellData(path, "Edit Local Tax", i+1, 2);
	String excelFixedamt_FixedpercentvalueEdit=excel.getCellData(path, "Edit Local Tax", i+1, 3);
	String excelFixedpercntWagelimitvalueEdit=excel.getCellData(path, "Edit Local Tax", i+1, 4);
	String excelFixedamtDrpdwnedit=excel.getCellData(path, "Edit Local Tax", i+1, 5);
	
	String excelexemptamtEdit=excel.getCellData(path, "Edit Local Tax", i+1, 6);
	String exceltaxcreditEdit=excel.getCellData(path, "Edit Local Tax", i+1, 7);
	String excelMinstrdDeducEdit=excel.getCellData(path, "Edit Local Tax", i+1, 8);
	String excelstrdDeducGrossEdit=excel.getCellData(path, "Edit Local Tax", i+1, 9);
	String excelMaxstrdDeducEdit=excel.getCellData(path, "Edit Local Tax", i+1, 10);
	
	Select s=new Select(loc.LocalTaxesDropDown);
	List<WebElement> list=s.getOptions();
	int listsize=list.size();
	for(int j=0;j<listsize;j++) {
	e=list.get(j);
	String applocalname=e.getText();
	if(applocalname.contains(excellocalname)) {
		e.click();
		loc.TaxCategorynameTextBox.click();
		loc.TaxCategorynameTextBox.sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
		Thread.sleep(1000);
		loc.TaxCategorynameTextBox.sendKeys(excelocalnameEdit);
		Thread.sleep(1500);
	
	
	if(excelcalcmethodEdit.contains("Fixed Amount")) {
		Select scal= new Select(loc.LocalTaxCalculationMethodDropDown);
		scal.selectByVisibleText(excelcalcmethodEdit);
		loc.FixedAmountTextBox.sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
		loc.FixedAmountTextBox.sendKeys(excelFixedamt_FixedpercentvalueEdit);
		Thread.sleep(1000);
		Select sel=new Select(loc.FixedAmountPerDropdown);
		sel.selectByVisibleText(excelFixedamtDrpdwnedit);
		Thread.sleep(1000);
		System.out.println("@Fixed Amount Vlaues Modified@");
	}else {
		System.out.println("failed to edit Fixed Amount ");
	}
	if(excelcalcmethodEdit.contains("Fixed %")) {
		Select scal= new Select(loc.LocalTaxCalculationMethodDropDown);
		scal.selectByVisibleText(excelcalcmethodEdit);
		Thread.sleep(1000);
		loc.FixedPerTextBox.sendKeys(excelFixedamt_FixedpercentvalueEdit);
		loc.WagelimitTextBox.sendKeys(excelFixedpercntWagelimitvalueEdit);
		System.out.println("@Fixed % Vlaues Modified@");
	}
	if(excelcalcmethodEdit.contains("Tax Table")) {
		Select scal= new Select(loc.LocalTaxCalculationMethodDropDown);
		scal.selectByVisibleText(excelcalcmethodEdit);
		Thread.sleep(1000);
		loc.ExemptionAmountTextBox.sendKeys(excelexemptamtEdit);
		loc.TaxCreditAmountTextBox.sendKeys(exceltaxcreditEdit);
		loc.MinSTDDeducTextBox.sendKeys(excelMinstrdDeducEdit);
		loc.STDDeducAsPerofGrowthLocaltax.sendKeys(excelstrdDeducGrossEdit);
		loc.MaxStdDeducAmount.sendKeys(excelMaxstrdDeducEdit);
		Thread.sleep(1000);
		System.out.println("@Tax Table Vlaues Modified@");
	}
	}else {
		System.out.println("App Text_box name not matched with excel");
				}
loc.LocalTaxSaveButton.click();
			}

		}
	}
	
	
	
	
	
	
	
}
