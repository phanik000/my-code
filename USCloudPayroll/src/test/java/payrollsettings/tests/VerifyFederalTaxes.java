package payrollsettings.tests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.baseclass.BaseClass;
import com.relevantcodes.extentreports.LogStatus;

import payrollsettings.pages.FederalTaxes;

public class VerifyFederalTaxes extends BaseClass {
	public String path = System.getProperty("user.dir") + readconfig.getFederalTaxesExcelpath();

	@Test(enabled=false)
	public void FederalDefaultValues() throws Exception {
		test = report.startTest("Verify Federal Taxes Test");
		test.log(LogStatus.INFO, "Test Started" + test.getStartedTime());
		iwait(10);
		FederalTaxes ft= PageFactory.initElements(driver, FederalTaxes.class);
		ArrayList<String> TaxTableValues= new ArrayList<String>();
		ArrayList<String> TaxTableValuesExcel= new ArrayList<String>();
		ArrayList<String> ExcelData= new ArrayList<String>();
		ArrayList<String> DefaultDataExcel= new ArrayList<String>();
		ft.CompanySetupDropdown.click();
		ft.PayrollSettingDashboard.click();
		//ft.FederalTaxesTab.click();
		Thread.sleep(1000);
		ft.Load2020Button.click();
		Thread.sleep(1000);
		ft.ReplaceYesOption.click();
		Thread.sleep(2000);
		ft.MarriedTaxTable.click();
		List<WebElement> rows = driver.findElements(By.xpath("//*[@id='single']/tbody/tr")) ;
		System.out.println("Table Values are as Follows :");
		for(int i=1;i<=rows.size();i++) {
			List<WebElement> values=driver.findElements(By.xpath("//*[@id='single']/tbody/tr["+i+"]/td"));
			for(int r=0;r<values.size();r++) {
				iwait(10);
				WebElement a= values.get(r);
				Thread.sleep(750);
				String Data=a.getText();
				TaxTableValuesExcel.add(Data);
			}
			String Edata=excel.getCellData(path, "TaxTable values", i, 0);
			String Edata1=excel.getCellData(path, "TaxTable values", i, 1);
			String Edata2=excel.getCellData(path, "TaxTable values", i, 2);
			ExcelData.add(Edata);
			ExcelData.add(Edata1);
			ExcelData.add(Edata2);
			if(TaxTableValuesExcel.equals(ExcelData)) {
				excel.setCellData(path, "TaxTable values", i, 3, "Pass!");
			} else {
				excel.setCellData(path, "TaxTable values", i, 3, "Fail!!");
			}
			System.err.println(ExcelData);
			ExcelData.clear();
			System.out.println(TaxTableValuesExcel);
			TaxTableValuesExcel.clear();
		}
		ft.CloseButtonFedTaxtable.click();
		String FedWithHolding=ft.FederalWithholdingTextBox.getAttribute("value");
		String MaxFutaWagesTextBox=ft.MaxFutaWagesTextBox.getAttribute("value");
		String FUTAperTextBox=ft.FUTAperTextBox.getAttribute("value");
		String MaxSocailSecWagesTextBox=ft.MaxSocailSecWagesTextBox.getAttribute("value");
		String EmployeeSSecPer=ft.EmployeeSSecPer.getAttribute("value");
		String EmployerSSecPer=ft.EmployerSSecPer.getAttribute("value");
		String EmployeeMedicareTextBox=ft.EmployeeMedicareTextBox.getAttribute("value");
		String EmployerMedicareTextBox=ft.EmployerMedicareTextBox.getAttribute("value");
		String WitholdAddtnlMCareTextBox=ft.WitholdAddtnlMCareTextBox.getAttribute("value");
		String EmployeeAddlMedcareTextBox=ft.EmployeeAddlMedcareTextBox.getAttribute("value");
		TaxTableValues.add(FedWithHolding);
		TaxTableValues.add(MaxFutaWagesTextBox);
		TaxTableValues.add(FUTAperTextBox);
		TaxTableValues.add(MaxSocailSecWagesTextBox);
		TaxTableValues.add(EmployeeSSecPer);
		TaxTableValues.add(EmployerSSecPer);
		TaxTableValues.add(EmployeeMedicareTextBox);
		TaxTableValues.add(EmployerMedicareTextBox);
		TaxTableValues.add(WitholdAddtnlMCareTextBox);
		TaxTableValues.add(EmployeeAddlMedcareTextBox);
		int Deflt=excel.getRowCount(path, "Default Values");
		for(int j=0;j<Deflt;j++) {
			String DefData=excel.getCellData(path, "Default Values", j+1, 1);
			DefaultDataExcel.add(DefData);	
			if(TaxTableValues.equals(DefaultDataExcel)) {
				excel.setCellData(path, "Default Values", 1, 2,"Pass!");
			}else {
				excel.setCellData(path, "Default Values", 1, 2,"Fail!");
			}
		}
		System.out.println("Text Box default Values from App :"+TaxTableValues);
		System.out.println("Text Box default Values from Excel :"+DefaultDataExcel);
		DefaultDataExcel.clear();
	}
	@Test(enabled=false)//5
	public void FieldLengthValidation() throws Exception {
		test = report.startTest("Verify Federal Taxes Test");
		test.log(LogStatus.INFO, "Test Started" + test.getStartedTime());
		iwait(10);
		FederalTaxes ft= PageFactory.initElements(driver, FederalTaxes.class);
		Thread.sleep(1000);
		ft.CompanySetupDropdown.click();
		ft.PayrollSettingDashboard.click();
		List<WebElement> TextBoxes=ft.AllTextBoxesFederal;
		for(int i=0;i<TextBoxes.size();i++) {
			WebElement a=TextBoxes.get(i);
			String BoxName=a.getAttribute("id");
			String BoxLength=a.getAttribute("maxlength");
			System.out.println("Max length of "+BoxName+" from App is :"+BoxLength);
			String ExpectedBoxLength=excel.getCellData(path, "Field Length Validations", i+1, 1);
			System.out.println("Actual length of "+BoxName+" is :"+ExpectedBoxLength);
			if(BoxLength.equals(ExpectedBoxLength)) {
				excel.setCellData(path, "Field Length Validations", i+1, 2, "Pass!");
			}else {

				excel.setCellData(path, "Field Length Validations", i+1, 2, "Failed!");
				excel.setCellData(path, "Field Length Validations", i+1, 3, BoxLength);
			}
		}

	}
	@Test(priority=6)
	public void allTaxTables() throws Exception {
		test = report.startTest("Verify respective Tax Table Values with publications");
		test.log(LogStatus.INFO, "Test Started" + test.getStartedTime());
		FederalTaxes ft= PageFactory.initElements(driver, FederalTaxes.class);
		iwait(10);
		ft.CompanySetupDropdown.click();
		ft.PayrollSettingDashboard.click();
		ArrayList<String> TaxTableValuesExcel= new ArrayList<String>();
		ArrayList<String> ExcelData= new ArrayList<String>();
		iwait(10);
		List<WebElement> radios= driver.findElements(By.xpath(".//*[@class='radio']"));
		List<WebElement> rows;
		List<WebElement> values;
		int radSize=radios.size();
		for(int i=0;i<radSize;i++) {
			String SheetName=excel.getCellData(path, "Key", i+1, 0);
			System.out.println("Sheet is "+SheetName);
			WebElement ra= radios.get(i);
			Thread.sleep(1000);
			ra.click();
			WebElement table;
			if(SheetName.contains("Single Tax Table")) {
				table=driver.findElement(By.xpath(".//*[@id='SingleTaxTable']"));
				System.out.println("******Conditional click**********");
				table.click();
			}else {
				table=driver.findElement(By.xpath("//span[contains(@style,'display: inline;')]"));
				table.click();
			}
			if(SheetName.contains("Single Tax Table")) {
				rows = driver.findElements(By.xpath(".//*[@tabindex='23']"));
			}else {
				rows = driver.findElements(By.xpath(".//*[@class='table table-bordered state-tax-table' and @style='display: table;']/tbody/tr")) ;
			}
			System.out.println("Table Values are as Follows :");
			for(int k=1;k<=rows.size();k++) {
				if(SheetName.contains("Single Tax Table")) {
					values=driver.findElements(By.xpath(".//*[@tabindex='23']["+k+"]/td"));
				}else {
					values=driver.findElements(By.xpath(".//*[@class='table table-bordered state-tax-table' and @style='display: table;']/tbody/tr["+k+"]/td"));
				}
				for(int r=0;r<values.size();r++) {
					iwait(10);
					WebElement a= values.get(r);
					Thread.sleep(700);
					String Data=a.getText();
					TaxTableValuesExcel.add(Data);
				}
				String Edata=excel.getCellData(path, SheetName, k, 0);
				String Edata1=excel.getCellData(path, SheetName, k, 1);
				String Edata2=excel.getCellData(path, SheetName, k, 2);
				ExcelData.add(Edata);
				ExcelData.add(Edata1);
				ExcelData.add(Edata2);
				if(TaxTableValuesExcel.equals(ExcelData)) {
					excel.setCellData(path, SheetName, k, 3, "Pass!");
				} else {
					excel.setCellData(path, SheetName, k, 3, "Fail!! "+TaxTableValuesExcel);
				}
				System.err.println(ExcelData);
				ExcelData.clear();
				System.out.println(TaxTableValuesExcel);
				TaxTableValuesExcel.clear();
			}
			ft.CloseButtonFedTaxtable.click();

		}
	}
}
