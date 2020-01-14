package payrollsettings.tests;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.baseclass.BaseClass;
import com.relevantcodes.extentreports.LogStatus;

import payrollsettings.pages.FederalTaxes;

public class VerifyFederalTaxesCustom extends BaseClass {
	@Test
	public void editExistingValues() throws Exception{
		String path="C:\\Users\\User\\Desktop\\FederalCustom.xlsx";
		String sheetname="FedEdits";
	test = report.startTest("Verify Federal Taxes Test");
	test.log(LogStatus.INFO, "Test Started" + test.getStartedTime());
	iwait(10);
	FederalTaxes ft= PageFactory.initElements(driver, FederalTaxes.class);
	ft.CompanySetupDropdown.click();
	ft.PayrollSettingDashboard.click();
	int rows=excel.getRowCount(path, sheetname);
	for(int r=1;r<=rows;r++) {
		String Decision=excel.getCellData(path, sheetname, r, 1);		
		if(Decision.equals("Yes")) {
			String XLid=excel.getCellData(path, sheetname, r, 0);
			List<WebElement> allBoxes=ft.AllTextBoxesFederal;
			for(WebElement Box: allBoxes) {
				String AppId=Box.getAttribute("id");
				if(XLid.contains(AppId)) {
					Box.click();
					Box.sendKeys(Keys.chord(Keys.CONTROL,"a"));;
					Box.sendKeys(Keys.BACK_SPACE);
					String NewValue=excel.getCellData(path, sheetname, r, 2);
					Thread.sleep(1000);
					Box.sendKeys(NewValue);
				}
			}
		}
	}
	Thread.sleep(1000);
	ft.SaveButtonFedTax.click();
	}

}
