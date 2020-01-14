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

public class VerifyHourCategoriesCustom extends BaseClass {
	public HourCategories hrcat;
	String expectedtitle = "Hour Category";
	public String path = System.getProperty("user.dir") + readconfig.getHourCategoryExcelpath();

	// Used to Add Hour Categories
	@Test(priority = 1, enabled = false)
	public void VerifyHourCategoryToAdd() throws Exception {
		// Generating Extent report for lines(21,22)
		test = report.startTest("Verify Hour Category Add Test");
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

		// Getting size of Hour Category size
		int hrsize = excel.getRowCount(path, "Add Hour Category");
		for (int i = 0; i < hrsize; i++) {
			hrcat.CreateNewHourButton.click();
			Thread.sleep(1500);
			String hrtextname = excel.getCellData(path, "Add Hour Category", i + 1, 0);
			hrcat.NewHourCatNameTextBox.sendKeys(hrtextname);
			Thread.sleep(1000);
			hrcat.SaveNewHourCatButton.click();
			Thread.sleep(1000);
			hrcat.ConfirmPopupBtn.click();

			String canceltext = hrcat.CancelNewButtonHourCat.getAttribute("value");
			if (canceltext.equalsIgnoreCase("Cancel")) {
				try {
					hrcat.CancelNewButtonHourCat.click();
					System.out.println("Hour Category Already Exists");
				} catch (Exception e) {
					System.out.println("Hour Category Added Successfully");
				}
			}

		}
	}

	@Test(priority = 2)
	public void VerifyHourCategoryToEdit() throws Exception {
		// Generating Extent report for lines(74,75)
		test = report.startTest("Verify Hour Category Edit Test");
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
		// Getting row size through excel
		int rowsize = excel.getRowCount(path, "Delete Hour Category");
		// Iterating rows from excel
		for (int j = 0; j < rowsize; j++) {
			// getting data from excel
			String excelhrcatname = excel.getCellData(path, "Edit Hour Category", j + 1, 0);
			String excelhrcatnameedit = excel.getCellData(path, "Edit Hour Category", j + 1, 1);
			String excelhourratedrpdwn = excel.getCellData(path, "Edit Hour Category", j + 1, 2);
			String excelhrcatmultiplier = excel.getCellData(path, "Edit Hour Category", j + 1, 3);
			// Getting size of categories from application
			Select s = new Select(hrcat.HourCategoryDropDown);
			List<WebElement> deduclist = s.getOptions();
			int sizehrcat = deduclist.size();
			// Iterating categories from application
			for (int i = 0; i < sizehrcat; i++) {
				WebElement e = deduclist.get(i);
				String apphrcatname = e.getText();
				// comapring excel category and application if matches able to edit particular
				// category mentioned in excel
				if (apphrcatname.equalsIgnoreCase(excelhrcatname)) {
					e.click();
					// clearing Hour category text to edit
					hrcat.HourCategoryTextBox.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
					hrcat.HourCategoryTextBox.sendKeys(excelhrcatnameedit);
					Thread.sleep(1000);
					dropdownSelect(hrcat.EmpHourRateDropDown, excelhourratedrpdwn);
					dropdownSelect(hrcat.EmpMultiplierDropDown, excelhrcatmultiplier);
					// getting save for edit
					hrcat.SaveButtonHourCat.click();
					Thread.sleep(1500);
					// confirm 'OK' action for edited category
					hrcat.ConfirmPopupBtn.click();
					Thread.sleep(1000);
				}
			}
		}

	}

	@Test(priority = 3, enabled = false)
	public void VerifyHourCategoryToDelete() throws Exception {
		// Generating Extent report for lines()
		test = report.startTest("Verify Hour Category Delete Test");
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
		// Getting excel row size to do iteration
		int rowsize = excel.getRowCount(path, "Delete Hour Category");
		for (int j = 0; j < rowsize; j++) {
			String excelhrcatdel = excel.getCellData(path, "Delete Hour Category", j + 1, 0);
			// Getting application category size to do iterate
			Select s = new Select(hrcat.HourCategoryDropDown);
			List<WebElement> deduclist = s.getOptions();
			int sizehrcat = deduclist.size();
			for (int i = 0; i < sizehrcat; i++) {
				WebElement e = deduclist.get(i);
				try {
					String apphrcatname = e.getText();
					// comapring excel and application categories if matches with excel then do
					// actions to delete categpry
					if (apphrcatname.equalsIgnoreCase(excelhrcatdel)) {
						e.click();
						Thread.sleep(1000);
						hrcat.DeleteButton.click();
						Thread.sleep(1000);
						// confirmation to delete
						hrcat.ConfirmPopupBtn.click();
						Thread.sleep(1000);
					}
					//As per Stale Exception Try/Catch Block has been written to get rid of Stale Exception
				} catch (Exception e1) {
					e = driver.findElement(By.xpath("//*[@id='listItems']//option[" + i + "]"));
					String apphrcatname = e.getText();
					if (apphrcatname.equalsIgnoreCase(excelhrcatdel)) {
						e.click();
						Thread.sleep(1000);
						hrcat.DeleteButton.click();
						Thread.sleep(1000);
						hrcat.ConfirmPopupBtn.click();
						Thread.sleep(1000);

					}
				}
			}

		}

	}
}
