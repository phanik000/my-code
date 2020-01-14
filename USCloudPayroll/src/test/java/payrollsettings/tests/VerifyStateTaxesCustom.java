package payrollsettings.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.baseclass.BaseClass;
import com.relevantcodes.extentreports.LogStatus;

import payrollsettings.pages.StateTaxes;

public class VerifyStateTaxesCustom extends BaseClass {
	String Path="C:\\Users\\User\\Desktop\\StateTaxCustom.xlsx";
	String SheetName="TaxParamEdits";
	@Test
	public void EditStateTaxVals()throws Exception{
		test = report.startTest("Verify Federal Taxes Test");
		test.log(LogStatus.INFO, "Test Started" + test.getStartedTime());
		StateTaxes st= PageFactory.initElements(driver, StateTaxes.class);
		iwait(10);
		st.CompanySetupDropdown.click();
		st.PayrollSettingDashboard.click();
		st.StateTaxesTab.click();
		int rows=excel.getRowCount(Path, SheetName);
		for(int i=1;i<rows;i++) {
			String Decision=excel.getCellData(Path, SheetName, i, 1);
			if(Decision.equalsIgnoreCase("Yes")) {
				String StateThatNeedsEdit=excel.getCellData(Path, SheetName, i, 0);
				Select sel= new Select(st.ListOfStatesDropDown);
				List<WebElement> AllStates=sel.getOptions();
				for(WebElement State:AllStates) {
					try {
					String StateInApp=State.getText();
					System.out.println("State Name from app is :"+StateInApp);
					if(StateThatNeedsEdit.equals(StateInApp)) {
						iwait(10);
						State.click();
						System.out.println("Clicked State is :"+State.getText());
						String txtAnnualExempt =excel.getCellData(Path, SheetName, i, 2);
						st.AnnualExempAmountTextBox.clear();
						st.AnnualExempAmountTextBox.sendKeys(txtAnnualExempt);
						String txtAnnualtaxCAmnt =excel.getCellData(Path, SheetName, i, 3);
						st.AnnualTaxCredTextBox.clear();
						st.AnnualTaxCredTextBox.sendKeys(txtAnnualtaxCAmnt);
						String txtMinSTDAmnt=excel.getCellData(Path, SheetName, i, 4);
						st.MinSTDTextBox.clear();
						st.MinSTDTextBox.sendKeys(txtMinSTDAmnt);
						String txtMaxSTDAmnt =excel.getCellData(Path, SheetName, i, 5);
						st.MaxSTDTextBox.clear();
						st.MaxSTDTextBox.sendKeys(txtMaxSTDAmnt);
						String txtSTDDedGrss =excel.getCellData(Path, SheetName, i, 6);
						st.STDDeducAsPerofGrowth.clear();
						st.STDDeducAsPerofGrowth.sendKeys(txtSTDDedGrss);
						String txtFedWHLAmnt =excel.getCellData(Path, SheetName, i, 7);
						st.FedWHlimitTextBox.clear();
						st.FedWHlimitTextBox.sendKeys(txtFedWHLAmnt);
						String txtFedWHLimitPer =excel.getCellData(Path, SheetName, i, 8);
						st.FedWHlimitPerTextBox.clear();
						st.FedWHlimitPerTextBox.sendKeys(txtFedWHLimitPer);
						String txtLowIncExemtAmnt =excel.getCellData(Path, SheetName, i, 9);
						st.LowIncomeExempTextBox.clear();
						st.LowIncomeExempTextBox.sendKeys(txtLowIncExemtAmnt);
						String txtStateId =excel.getCellData(Path, SheetName, i, 10);
						st.StateIDTextBox.clear();
						st.StateIDTextBox.sendKeys(txtStateId);
						String txtSutaPer =excel.getCellData(Path, SheetName, i,11);
						st.SUTAPercentTextBox.clear();
						st.SUTAPercentTextBox.sendKeys(txtSutaPer);
						String txtSutaWage =excel.getCellData(Path, SheetName, i, 12);
						st.MaxSUTATextBox.clear();
						st.MaxSUTATextBox.sendKeys(txtSutaWage);
						Thread.sleep(2000);
						st.SaveButtonStatetaxes.click();
						Thread.sleep(1500);
						driver.findElement(By.xpath(".//*[@class='confirm']")).click();
					}
				}catch (Exception e) {
					System.out.println(e.getMessage());
					State=driver.findElement(By.xpath("//*[@id=\"dropCategoryBindList\"]/option["+i+"]"));
				}
			}
			}
		}
	}
}