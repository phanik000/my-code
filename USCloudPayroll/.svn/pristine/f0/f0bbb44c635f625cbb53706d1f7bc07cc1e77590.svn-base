package companyinfo.dashboard.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.baseclass.BaseClass;
import com.relevantcodes.extentreports.LogStatus;
import com.utilities.Utility;

import companyinfo.dashboard.pages.DepartmentsAndJobs;

public class VerifyDepartmentsAndJobs extends BaseClass{
	public DepartmentsAndJobs dj;
	public String path = System.getProperty("user.dir") + readconfig.getDepartmentsAndJobsExcelpath();
	String expectedtitle="Department / Jobs";

	@Test(priority = 1,enabled=false)
	public void VerifyToAddDepts() throws Exception {
		test = report.startTest("Verify To Add Departments Test");
		test.log(LogStatus.INFO, "Test Started" + test.getStartedTime());
		dj = PageFactory.initElements(driver, DepartmentsAndJobs.class);
		dj.CompanySetupDropdown.click();
		dj.CompanyInformation.click();
		Thread.sleep(1000);
		dj.DeptandJobsTab.click();
		int deptsize = excel.getRowCount(path, "Add Department");
		for (int i = 0; i < deptsize; i++) {
			dj.CreateNewDeptButton.click();
			Thread.sleep(1000);
			String deptname = excel.getCellData(path, "Add Department", i + 1, 0);
			dj.DepartmentNameAddTxtBox.sendKeys(deptname);
			dj.SaveAddDeptButton.click();
			Thread.sleep(1500);
			dj.ConfirmPopupBtn.click();
			Thread.sleep(1000);
			/*String canceltext = dj.CancelAddDepButton.getAttribute("value");
			if (canceltext.equalsIgnoreCase("Cancel")) {
				try {
					dj.CancelAddDepButton.click();
					Thread.sleep(1000);
					System.out.println("Department Already Exists");
				} catch (Exception e) {
					System.out.println("Department Added Successfully");
				}
			}*/
		}
	}
	@Test(priority=2,enabled=false)
	public void VerifyToEditMultipleDepartment() throws Exception {
		test = report.startTest("Verify To Edit Departments Test");
		test.log(LogStatus.INFO, "Test Started" + test.getStartedTime());
		dj = PageFactory.initElements(driver, DepartmentsAndJobs.class);
		dj.CompanySetupDropdown.click();
		dj.CompanyInformation.click();
		Thread.sleep(1000);
		dj.DeptandJobsTab.click();
		Select s=new Select(dj.AllDeptNamesDropDown);
	   /* s.selectByIndex(1);
	    dj.DepartmentNameEditTxtBox.clear();
		dj.DepartmentNameEditTxtBox.sendKeys("Deptone");
		Thread.sleep(2000);
		WebElement ele=driver.findElement(By.xpath("//*[@name='editDept' and @value='Save']"));
		ele.click();
		Thread.sleep(2500);
		
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(dj.ConfirmPopupBtn)).click();
		
		dj.ConfirmPopupBtn.click();
		Thread.sleep(2500);
		*/
	List<WebElement> deptdrpdwn=s.getOptions();
	int deptsize=deptdrpdwn.size();
	System.out.println("Dept Dropdown Size is: "+deptsize);
	for(int i=0;i<deptsize;i++) {
		WebElement deptclick=deptdrpdwn.get(i);
		deptclick.click();
		Thread.sleep(2000);
		String depttext=deptclick.getText();
	    String exceldeptedit=excel.getCellData(path, "Edit Department", i+1, 0);
	    
	    dj.DepartmentNameEditTxtBox.clear();
		dj.DepartmentNameEditTxtBox.sendKeys(exceldeptedit);
		Thread.sleep(2000);
		dj.SaveEditDeptButton.click();
		Thread.sleep(2500);
		
		if(dj.ConfirmPopupBtn.isEnabled()) {
			dj.ConfirmPopupBtn.click();
			System.out.println("confirm Btn enabled");

		}else {
			System.out.println("confirm Btn Disabled");
		}
		
		
		
	   /* if(!depttext.equals(exceldeptedit)) {
	    dj.DepartmentNameEditTxtBox.clear();
		dj.DepartmentNameEditTxtBox.sendKeys(exceldeptedit);
		dj.SaveEditDeptButton.click();
		dj.ConfirmPopupBtn.click();
		System.out.println("Department Updated Successfully");
	    }else{
	    	System.out.println("Not updated Dept");
	    }*/
	}
	
	}
	@Test(priority=3,enabled=true)
	public void VerifyToDeleteDept() throws Exception {
		test = report.startTest("Verify To Delete Departments Test");
		test.log(LogStatus.INFO, "Test Started" + test.getStartedTime());
		dj = PageFactory.initElements(driver, DepartmentsAndJobs.class);
		dj.CompanySetupDropdown.click();
		dj.CompanyInformation.click();
		Thread.sleep(1000);
		dj.DeptandJobsTab.click();
		
		int excelcnt=excel.getRowCount(path, "Delete Department");
		for(int j=0;j<excelcnt;j++){
		String exceltext=	excel.getCellData(path, "Delete Department", j+1, 0);
		Select s=new Select(dj.AllDeptNamesDropDown);
		List<WebElement> deptdrpdwn=s.getOptions();
		int deptsize=deptdrpdwn.size();
		System.out.println("Dept Dropdown Size is: "+deptsize);
		for(int i=0;i<deptsize;i++) {
			
			WebElement deptclick=deptdrpdwn.get(i);
			try {
				String apptext=deptclick.getText();
				if(apptext.equalsIgnoreCase(exceltext)) {
				deptclick.click();
				dj.DeleteDeptButton.click();
				Thread.sleep(1000);
				dj.ConfirmPopupBtn1.click();
				Thread.sleep(1000);
				dj.ConfirmPopupBtn.click();
				Thread.sleep(1000);
				
				}	
			} catch (Exception e) {
				deptclick = driver.findElement(By.xpath("//*[@id='dropDeptList']//option["+i+"]"));
				String apptext=deptclick.getText();
					//int k=i+1;
				if(apptext.equalsIgnoreCase(exceltext)) {
					
					deptclick.click();
					dj.DeleteDeptButton.click();
					Thread.sleep(1000);
					dj.ConfirmPopupBtn1.click();
					Thread.sleep(1000);
					dj.ConfirmPopupBtn.click();
					Thread.sleep(1000);
					
				}
			}
			
		}
		}
	}
	@Test(priority=4,enabled=false)
	public void verifyToAddJobs() throws Exception {
		test = report.startTest("Verify To Add Jobs Test");
		test.log(LogStatus.INFO, "Test Started" + test.getStartedTime());
		dj = PageFactory.initElements(driver, DepartmentsAndJobs.class);
		dj.CompanySetupDropdown.click();
		Thread.sleep(1000);
		dj.CompanyInformation.click();
		Thread.sleep(1000);
		dj.DeptandJobsTab.click();
		dj.JobsTabPage.click();
		int jobsize = excel.getRowCount(path, "Add Jobs");
for(int i=0;i<jobsize;i++) {
	dj.CreateNewJobsBtn.click();
	Thread.sleep(1500);
	String jonname=excel.getCellData(path, "Add Jobs", i+1, 0);
	String jobnum=excel.getCellData(path, "Add Jobs", i+1, 1);

	dj.JobNameAddTextBox.sendKeys(jonname);
	dj.JobNumberAddTextBox.sendKeys(jobnum);
	Thread.sleep(1000);
	dj.SaveAddJobButton.click();
	Thread.sleep(1500);
	dj.ConfirmPopupBtn.click();
	Thread.sleep(1500);
}

	}
	
	@Test(priority=5,enabled=false)
	public void verifyToEditJobs() throws Exception {
		test = report.startTest("Verify To Edit Jobs Test");
		test.log(LogStatus.INFO, "Test Started" + test.getStartedTime());
		dj = PageFactory.initElements(driver, DepartmentsAndJobs.class);
		dj.CompanySetupDropdown.click();
		Thread.sleep(1000);
		dj.CompanyInformation.click();
		Thread.sleep(1000);
		dj.DeptandJobsTab.click();
		dj.JobsTabPage.click();
		Select s=new Select(dj.AlljobsNamesDropDown);
List<WebElement>jobsdrpdwn=s.getOptions();
int jobsize=jobsdrpdwn.size();
for(int i=0;i<jobsize;i++) {
	WebElement jobclick=jobsdrpdwn.get(i);
	jobclick.click();
	String jobeditname=excel.getCellData(path, "Edit Jobs", i+1, 0);
	String jobeditnum=excel.getCellData(path, "Edit Jobs", i+1, 0);
	dj.JobNameEditTextBox.clear();
	dj.JobNameEditTextBox.sendKeys(jobeditname);
	dj.JobNumberEditTextBox.clear();
	dj.JobNumberEditTextBox.sendKeys(jobeditnum);
	Thread.sleep(1500);
	dj.SaveEditJobButton.click();
	Thread.sleep(3000);
	dj.ConfirmPopupBtn.click();
	Thread.sleep(2000);
	
}
	}
	@Test(priority=6,enabled=false)
	public void verifyToDeleteJob() throws Exception {
		test = report.startTest("Verify To Delete Jobs Test");
		test.log(LogStatus.INFO, "Test Started" + test.getStartedTime());
		dj = PageFactory.initElements(driver, DepartmentsAndJobs.class);
		dj.CompanySetupDropdown.click();
		Thread.sleep(1000);
		dj.CompanyInformation.click();
		Thread.sleep(1000);
		dj.DeptandJobsTab.click();
		dj.JobsTabPage.click();
		Select s=new Select(dj.AlljobsNamesDropDown);
List<WebElement>jobsdrpdwn=s.getOptions();
int jobsize=jobsdrpdwn.size();
for(int i=0;i<jobsize;i++) {
	WebElement jobclick=jobsdrpdwn.get(i);
	try {
		jobclick.click();
	} catch (Exception e) {
		int k=i++;
		jobclick= driver.findElement(By.xpath("//*[@id='dropJobList']//option["+i+"]"));
		jobclick.click();
	}
	dj.DeleteJobButton.click();
	Thread.sleep(1500);
	dj.ConfirmPopupBtn.click();
	Thread.sleep(1500);
	dj.ConfirmPopupBtn.click();
	Thread.sleep(1500);
}
	}
	
	
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

