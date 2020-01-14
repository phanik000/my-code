package payrollsettings.tests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.baseclass.BaseClass;
import com.utilities.ObjectRepository;

import payrollsettings.pages.StateTaxes;

public class VerifyStateTaxes extends BaseClass {
	public String path = System.getProperty("user.dir") + readconfig.getStateTaxesDataExcelpath();


	//						To verify each state's taxtable						//
	@Test(enabled=false)//6
	public void TaxTables() throws Exception {
		//implicit wait//
		iwait(10);
		//iterating over all the states for getting their taxtable values//
		StateTaxes st= PageFactory.initElements(driver, StateTaxes.class);
		//Arraylists to store the values from app and excel files//
		ArrayList<String> TaxTableValues= new ArrayList<String>();
		ArrayList<String> TaxTableValuesExcel= new ArrayList<String>();
		//click actions//
		Thread.sleep(1000);
		st.CompanySetupDropdown.click();
		st.PayrollSettingDashboard.click();
		st.StateTaxesTab.click();
		Select sel= new Select(st.ListOfStatesDropDown);
		//Getting all the options from the state dropdown//
		List<WebElement> AllStates=sel.getOptions();
		int Size=AllStates.size();
		//iterating over each state to get it's name and also tax values respectively//
		for(int i=0;i<Size;i++) {
			WebElement State=AllStates.get(i);
			String StateName=State.getText();
			State.click();
			System.out.println("**"+StateName+"**");
			excel.setCellData("C:\\Users\\User\\Desktop\\Temp.xlsx", "Sheet1", i+1, 1, StateName);
			String Sheet=excel.getCellData(path, "AK", i+1, 0);
			System.out.println("Sheet Name is: "+Sheet);
			Thread.sleep(1500);
			st.TaxTableButton.click();
			//iterating over the taxtable data//
			List<WebElement> tr=driver.findElements(By.xpath(".//*[@id='tablebody']/tr"));
			for(int a=1;a<=tr.size();a++) {
				//changing the num of rows based on the state clicked//
				List<WebElement> tablevalues=driver.findElements(By.xpath(".//*[@id='tablebody']/tr["+a+"]/td"));
				for(int j=0;j<tablevalues.size();j++) {
					WebElement data= tablevalues.get(j);
					TaxTableValues.add(data.getText());
				}
				//getting data from Excel//
				String Over=excel.getCellData(path, Sheet, a, 1);
				String Percent=excel.getCellData(path, Sheet, a, 2);
				String Basetax=excel.getCellData(path, Sheet, a, 3);
				//Adding it to the created Arraylist//
				TaxTableValuesExcel.add(Over);
				TaxTableValuesExcel.add(Percent);
				TaxTableValuesExcel.add(Basetax);
				System.err.println(TaxTableValuesExcel);
				System.out.println(TaxTableValues);
				//condition to determine the actual and expected and place the result in excel//
				if(TaxTableValues.equals(TaxTableValuesExcel)) {
					excel.setCellData(path, Sheet, a, 4, "Pass!");
				}else {
					excel.setCellData(path, Sheet, a, 4, "Fail!");
					excel.setCellData(path, Sheet, a, 5, TaxTableValues.toString());
				}
				//clearing after a single iteration//
				TaxTableValuesExcel.clear();
				TaxTableValues.clear();

			}
			Thread.sleep(1000);
			//clicking on the close button//
			st.CloseButton.click();
		}
	}

	//**    Test Case for getting the superadmin values from the app     **//

	@Test(priority=7)
	public void DefaultValues() throws Exception {
		iwait(10);
		StateTaxes st= PageFactory.initElements(driver, StateTaxes.class);
		//**Dashboard clicks to navigate to State Taxes**//
		Thread.sleep(1000);
		st.CompanySetupDropdown.click();
		st.PayrollSettingDashboard.click();
		st.StateTaxesTab.click();
		//**   iterating over all the states  **//
		Select sel= new Select(st.ListOfStatesDropDown);
		List<WebElement> AllStates=sel.getOptions();
		int Size=AllStates.size();
		for(int i=0;i<Size;i++) {
			//Defining a webelement using index//
			WebElement State=AllStates.get(i);
			String StateName=State.getText();
			//**clicking individual state//
			State.click();
			System.out.println("** "+StateName+" **");
			String StateNameinApp=st.StateTaxCatTextBox.getAttribute("value");
			System.out.println(StateNameinApp);
			String StateIdinApp=st.StateIDTextBox.getAttribute("value");
			System.out.println(StateIdinApp);
			String SUTAPerApp=st.SUTAPercentTextBox.getAttribute("value");
			System.out.println(SUTAPerApp);
			String MaxSutaApp=st.MaxSUTATextBox.getAttribute("value");
			System.out.println(MaxSutaApp);
			// ** Iterating over the checkboxes and getting its titles if any ** //
			List<WebElement> CHKBXS= driver.findElements(By.xpath(ObjectRepository.PerOfFedTaxChkBox));
			for(WebElement CHK:CHKBXS) {
				Thread.sleep(1500);
				if(CHK.isSelected()==true) {
					String tabindex=CHK.getAttribute("id");
					if(tabindex.contains("chkRtoND")) {
						String chekcboxenabled="Round to Nearest Dollar";
						System.out.println("Enabled Checkbox is :"+chekcboxenabled);
					}else if(tabindex.contains("chkSubFedWHF")) {
						String chekcboxenabled="Subtract Fed W/H First";
						System.out.println("Enabled Checkbox is :"+chekcboxenabled);
					}else if(tabindex.contains("chkFedTaxPer")){
						String chekcboxenabled="% of Federal Tax";
						System.out.println("Enabled Checkbox is :"+chekcboxenabled);
					}
				}else {
					System.out.println("No checkbox");
				}
			}
			//  **  Adding the values to our Arraylist  **  //
			String AnnualExempApp=st.AnnualExempAmountTextBox.getAttribute("value");
			System.out.println(AnnualExempApp);
			String TaxcreditApp=st.AnnualTaxCredTextBox.getAttribute("value");
			System.out.println(TaxcreditApp);
			String MinStdDedApp=st.MinSTDTextBox.getAttribute("value");
			System.out.println(MinStdDedApp);
			String MaxStdApp=st.MaxSTDTextBox.getAttribute("value");
			System.out.println(MaxStdApp);
			String StdDedPerApp=st.STDDeducAsPerofGrowth.getAttribute("value");
			System.out.println(StdDedPerApp);
			String FedWHlimitApp=st.FedWHlimitTextBox.getAttribute("value");
			System.out.println(FedWHlimitApp);
			String FedWHPerApp=st.FedWHlimitPerTextBox.getAttribute("value");
			System.out.println(FedWHPerApp);
			String LowIncExempApp=st.LowIncomeExempTextBox.getAttribute("value");
			System.out.println(LowIncExempApp);
		}
	}

	// **         Test Case for Getting field lengths from the app         ** //
	@Test(priority=8)
	public void fieldValidations() throws Exception {
		iwait(10);
		StateTaxes st= PageFactory.initElements(driver, StateTaxes.class);
		//**Dashboard clicks to navigate to State Taxes**//
		st.CompanySetupDropdown.click();
		st.PayrollSettingDashboard.click();
		st.StateTaxesTab.click();
		List<WebElement> AllBoxes=st.AllTextBoxLengthsStateTaxes;
		//**   iterating over all the states  **//
		for(int i=1;i<AllBoxes.size();i++) {
			WebElement a=AllBoxes.get(i);
			// ** Getting the textboxname using theirs id's  ** //
			String TextBoxName=a.getAttribute("id");
			String SizeFromApp=a.getAttribute("maxlength");
			System.out.println("Length of "+TextBoxName+" is :"+SizeFromApp);
			String FieldLengthExcel=excel.getCellData(path, "Field Length Validations", i, 1);
			System.out.println("Actual Field length of "+TextBoxName+" should be :"+FieldLengthExcel);
			// ** Asserting both the values from app and excel ** //
			if(SizeFromApp.equals(FieldLengthExcel)) {
				excel.setCellData(path, "Field Length Validations", i, 2, "Passed!");
			}else {
				// ** Setting up the differnt value found in the excel ** //
				excel.setCellData(path, "Field Length Validations", i, 2, "Failed!");
				excel.setCellData(path, "Field Length Validations", i, 3, SizeFromApp);
			}
		}

	}
}