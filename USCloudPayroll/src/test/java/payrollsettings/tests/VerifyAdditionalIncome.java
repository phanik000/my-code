package payrollsettings.tests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.baseclass.BaseClass;
import com.relevantcodes.extentreports.LogStatus;

import payrollsettings.pages.AdditionalIncome;

public class VerifyAdditionalIncome extends BaseClass {
public AdditionalIncome addinc;
public String expectedtitle="Additional Income";
public String path=System.getProperty("user.dir") +readconfig.getAdditionalIncomeExcelPath();


	@Test(priority = 11)
	public void verifyWithPredefinedValues() throws Exception {
		// Generating Extent report for lines(26,27)
		test = report.startTest("Verify Hour Category LoadFromList Test");
		test.log(LogStatus.INFO, "Test Started" + test.getStartedTime());
		// Page Factory Initilization using binary class of Additional Income
		addinc = PageFactory.initElements(driver, AdditionalIncome.class);
		@SuppressWarnings("unused")
		ArrayList<String> appstr=new ArrayList<String>();
		 @SuppressWarnings("unused")
		ArrayList<String> excelstr=new ArrayList<String>();
		// Click on Company Setup and do some actions to get into Additional Income screen
		addinc.CompanySetupDropdown.click();
		iwait(20);
		addinc.PayrollSettingDashboard.click();
		addinc.AdditionalIncomeTab.click();
		// Get the text/Title of Additional Income to verify that we are in Additional Screen
		String actualtitle = addinc.AdditionalIncomePageTitle.getText();
		// Verifying with expected and actual text/Title of Additional Income screen
		Assert.assertEquals(actualtitle, expectedtitle);
		System.out.println("Page title is: " + actualtitle);
		Thread.sleep(1000);
		// click on to Load from List Button
		addinc.LoadFromListAI.click();
		Thread.sleep(1000);
		// selecting categories to add into Additional Income
		loadFromList(addinc.LoadFromListSelectDropdown);
		Thread.sleep(1000);
		// click 'OK' Button to add to list
		addinc.LoadFromListOkButtonAddinc.click();
		Thread.sleep(1000);
		// click confirm OK Button
		addinc.ConfirmPopupBtn.click();
		// Here we used to Iterate list that we added from 'Load From List' Button.
		Select s = new Select(addinc.AdditionalIncomeDropDown);
		List<WebElement> addlist = s.getOptions();
		// Getting size of Additional Income from listbox
		int addlistsize = addlist.size();
		System.out.println("Additional income Category size is: " + addlistsize);
		// Here we used to iterate and click on element
		for (int j = 0; j < addlistsize; j++) {
			WebElement addincclick = addlist.get(j);
			//Getting text of element
			String addincapptext = addincclick.getText();
			addincclick.click();
			Thread.sleep(1500);
			//Getting text of element from excel
			String addincexceltext = excel.getCellData(path, "Additional income sample test", j + 1, 0);
		    //Getting text of Additional income textbox name
			String addinctext = addinc.AINameTextBox.getAttribute("value");

			//Getting Dropdown text of calculation method type
			Select s1 = new Select(addinc.AICalcMethodDropDown);
			WebElement e1 = s1.getFirstSelectedOption();
			String caltext = e1.getText();
			String addincmethodtype = excel.getCellData(path, "Additional income sample test", j + 1, 1);
            //Getting text of Calculation method Fixed amount textbox
			String addincFixedamtandFixedpercenttext = addinc.AICalcMethodFixedAmountText.getAttribute("value");
			@SuppressWarnings("unused")
			String exceladdincpercentvlaues = excel.getCellData(path, "Additional income sample test", j + 1, 2);

			String addincPieceamtandMileageamttext = addinc.AICalcMethodPieceAmountText.getAttribute("value");
			@SuppressWarnings("unused")
			String exceladdincfixedamtvlaues = excel.getCellData(path, "Additional income sample test", j + 1, 3);
			@SuppressWarnings("unused")
			String exceladdincmileagevlaues = excel.getCellData(path, "Additional income sample test", j + 1, 4);
			@SuppressWarnings("unused")
			String exceladdincpieceworkvlaues = excel.getCellData(path, "Additional income sample test", j + 1, 5);
			//Getting Dropdown text of calculation method type for Fixed amount
			Select s2 = new Select(addinc.AICalcMethodPerDropdown);
			WebElement e2 = s2.getFirstSelectedOption();
			String FixedamtDrpdwntext = e2.getText();
			//Getting text of Fixed amount Dropdown from excel
			@SuppressWarnings("unused")
			String excelFixedamtDrpdwntext = excel.getCellData(path, "Additional income sample test", j + 1, 6);
			
			
			
           //comparing additional income category name with excel,if it satisfies it will print Additional income name
			if (addinctext.equalsIgnoreCase(addincexceltext)) {
				System.err.println("****************************************");
				Thread.sleep(500);
				System.out.println("Dropdown text is: " + "**" + addincapptext + "**");
				System.out.println("Textbox name: " + addinctext);
			}
           //comapring Calculation method type with excel
			if (caltext.equals(addincmethodtype)) {
				System.out.println("Calculation Method type is: " + caltext);
				System.out.println("Compared");
				checkBoxesverify(j+1);
			excel.setCellData(path, "Additional income sample test", j+1, 8, "Pass");
			}else {
				excel.setCellData(path, "Additional income sample test", j+1, 8, "Fail");
			}
			
			
			if (caltext.equals(addincmethodtype)) {
				System.out.println("Calculation Method type is: " + caltext);
				System.out.println(caltext+" value is: " + addincFixedamtandFixedpercenttext);
				System.out.println("Fixed Per Drop Down is: " + FixedamtDrpdwntext);
				System.out.println("Compared");
				checkBoxesverify(j+1);
				excel.setCellData(path, "Additional income sample test", j+1, 8, "Pass");
			}else {
				excel.setCellData(path, "Additional income sample test", j+1, 8, "Fail");
			}
			if (caltext.equals(addincmethodtype)) {
				System.out.println("Calculation Method type is: " + caltext);
				System.out.println(caltext+" value is: " + addincFixedamtandFixedpercenttext);
				System.out.println("Compared");
				checkBoxesverify(j+1);
			excel.setCellData(path, "Additional income sample test", j+1, 8, "Pass");
			}else {
				excel.setCellData(path, "Additional income sample test", j+1, 8, "Fail");
			}
			
			if (caltext.equals(addincmethodtype)) {
				System.out.println("Calculation Method type is: " + caltext);
				System.out.println(caltext+" value is: " + addincPieceamtandMileageamttext);
				System.out.println("Compared");
				checkBoxesverify(j+1);
				excel.setCellData(path, "Additional income sample test", j+1, 8, "Pass");
			}else {
				excel.setCellData(path, "Additional income sample test", j+1, 8, "Fail");
			}
			
			if (caltext.equals(addincmethodtype)) {
				System.out.println("Calculation Method type is: " + caltext);
				System.out.println(caltext+" value is: " + addincPieceamtandMileageamttext);
				System.out.println("Compared");
				checkBoxesverify(j+1);
				excel.setCellData(path, "Additional income sample test", j+1, 8, "Pass");
			}else {
				excel.setCellData(path, "Additional income sample test", j+1, 8, "Fail");
			}
		
		}
	}

	
	
	public void checkBoxesverify(int checkboxesrowno) throws Exception {
		List<WebElement> chk= driver.findElements(By.xpath("//*[contains(@class,'Checked')]"));	
		int chksize=chk.size();
		for(int i=0;i<chksize;i++) {
			WebElement box=chk.get(i);
			String boxname=box.getAttribute("name");
			String ExcelVal=excel.getCellData(path,"Additional income sample test", checkboxesrowno, 7);
			String[] arrOfStr=ExcelVal.split(",");
			for(String st:arrOfStr) {
				if(st.contains(boxname)) {
					System.out.println("check boxes matched with excel");
			if(box.isSelected()) {
				System.out.println(boxname+" is Checked");
				//excel.setCellData(path, "DeductionSampleTest", j+1, 10, "pass");
			}else {
				System.err.println(boxname+" is Unchecked");
				//excel.setCellData(path, "DeductionSampleTest", j+1, 10, "fail");
								}
							}
						}
					}
	}
	
	
	
	
	
	
	
}