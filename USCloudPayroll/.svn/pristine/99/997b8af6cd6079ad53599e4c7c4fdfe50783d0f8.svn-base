package payrollsettings.tests;

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

import payrollsettings.pages.HourCategories;

public class VerifyHourCategories extends BaseClass {
	public HourCategories hrcat;
	String expectedtitle = "Hour Category";
	public String path = System.getProperty("user.dir") + readconfig.getHourCategoryExcelpath();

	// Used to compare Predefined values with Super Admin
	@Test(priority = 2)
	public void VerifyHourCategoryPredefinedTest() throws Exception {
		// Generating Extent report for lines(26,27)
		test = report.startTest("Verify Hour Category Predefined Test");
		test.log(LogStatus.INFO, "Test Started" + test.getStartedTime());
		// Page Factory Initilization using binary class of Hour Category
		hrcat = PageFactory.initElements(driver, HourCategories.class);
		// clicking on Company setup link
		hrcat.CompanySetupDropdown.click();
		iwait(50);
		// clicking on Payroll Settings link
		hrcat.PayrollSettingDashboard.click();
		// Then move on to click Hourcategory tab
		hrcat.HourCategoriesTab.click();
		// Get the text/Title of hour category to verify that we are in Hour category
		String actualtitle = hrcat.HourCategoryPageTitle.getText();
		// Verifying with expected and actual text/Title of hour category
		Assert.assertEquals(actualtitle, expectedtitle);
		System.out.println("Page title is: " + actualtitle);
		// click on to Load from List Button
		hrcat.LoadFromListButton.click();
		Thread.sleep(1000);
		// selecting categories to add into hour category
		loadFromList(hrcat.LoadFromListSelectDropdwn);
		Thread.sleep(1000);
		// click 'OK' Button to add to list
		hrcat.LoadFromListOkButton.click();
		Thread.sleep(1500);
		// click confirm OK Button
		hrcat.ConfirmPopupBtn.click();

		// Here we used to Iterate list that we added from 'Load From List' Button.
		Select s = new Select(hrcat.HourCategoryDropDown);
		List<WebElement> hrlist = s.getOptions();
		int hrlistsize = hrlist.size();// Getting size of list of Hour Categories
		System.out.println("Hr cat size is: " + hrlistsize);
		for (int j = 0; j < hrlistsize; j++) {
			WebElement hrcatclick = hrlist.get(j);

			// If we normally iterate we used to get Stale Element Exception that's why,
			// here we used Try&Catch Block to get rid of from Stale Element, in this we
			// used to compare every element from application with its predefined from Excel
			try {
				String hrcatexceltext = excel.getCellData(path, "Hour Categories Predefined", j + 1, 0);
				String hrtext = hrcatclick.getText();
				// Comparing Category text with application text in list if it satisfies
				// condition then click on element
				if (hrtext.equalsIgnoreCase(hrcatexceltext)) {
					hrcatclick.click();
					Thread.sleep(1000);
					// Getting text name in the list of each category
					System.err.println("**" + hrtext + "**");
					String hrcattextboxname = hrcat.HourCategoryTextBox.getAttribute("value");
					// Getting textbox name of category seleted in the list of each category
					System.out.println("Hour Category Text is: " + hrcattextboxname);
				}
				// Getting hourrate text from excel
				String hrcatrateexceltext = excel.getCellData(path, "Hour Categories Predefined", j + 1, 1);
				// Getting text name of Dropdown for Hour rate
				Select s1 = new Select(hrcat.EmpHourRateDropDown);
				WebElement hrratecattext = s1.getFirstSelectedOption();
				String apphrratecattext = hrratecattext.getText();
				// Comparing Hour rate text with application text in list if it satisfies it
				// will get the text of Hour rate
				if (apphrratecattext.equalsIgnoreCase(hrcatrateexceltext)) {
					System.out.println("Hour rate text is: " + apphrratecattext);
				}
				// Getting text name of Dropdown for Multiplier
				Select s2 = new Select(hrcat.EmpMultiplierDropDown);
				WebElement multipliertext = s2.getFirstSelectedOption();
				String appmultipliertext = multipliertext.getText();
				// Getting Multiplier text from excel
				String hrcatmultiplierexceltext = excel.getCellData(path, "Hour Categories Predefined", j + 1, 2);
				// Comparing Multiplier text with application text in list if it satisfies it
				// will get the text of Multiplier
				if (appmultipliertext.equalsIgnoreCase(hrcatmultiplierexceltext)) {
					System.out.println("Hour Rate Multiplier is: " + appmultipliertext);
				}
		   // The below Catch Block will follows same actions as done in Try Block
			} catch (Exception e) {
				int k = j + 1;
				hrcatclick = driver.findElement(By.xpath("//*[@id='listItems']//option[" + k + "]"));
				String hrtext = hrcatclick.getText();
				String hrcatexceltext = excel.getCellData(path, "Hour Categories Predefined", j + 1, 0);
				if (hrtext.equalsIgnoreCase(hrcatexceltext)) {
					hrcatclick.click();
					Thread.sleep(1000);
					System.err.println("**" + hrtext + "**");
					String hrcattextboxname = hrcat.HourCategoryTextBox.getAttribute("value");
					System.out.println("Hour Category Text is: " + hrcattextboxname);
				}
				String hrcatrateexceltext = excel.getCellData(path, "Hour Categories Predefined", j + 1, 1);

				Select s1 = new Select(hrcat.EmpHourRateDropDown);
				WebElement hrratecattext = s1.getFirstSelectedOption();
				String apphrratecattext = hrratecattext.getText();
				if (apphrratecattext.equalsIgnoreCase(hrcatrateexceltext)) {
					System.out.println("Hour rate text is: " + apphrratecattext);
				}
				String hrcatmultiplierexceltext = excel.getCellData(path, "Hour Categories Predefined", j + 1, 2);

				Select s2 = new Select(hrcat.EmpMultiplierDropDown);
				WebElement multipliertext = s2.getFirstSelectedOption();
				String appmultipliertext = multipliertext.getText();
				if (appmultipliertext.equalsIgnoreCase(hrcatmultiplierexceltext)) {
					System.out.println("Hour Rate Multiplier is: " + appmultipliertext);
				}

			}

		}

	}

}
