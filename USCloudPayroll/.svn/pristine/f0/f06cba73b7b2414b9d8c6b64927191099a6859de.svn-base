package payrollscreens.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.baseclass.BaseClass;
import com.relevantcodes.extentreports.LogStatus;
import com.utilities.Utility;

import junit.framework.Assert;
import payrollscreens.pages.DistributeHours;

public class VerifyDistributeHours extends BaseClass {
public DistributeHours dh;
public String expectedtitle="Distribute Hours";
public String path=System.getProperty("user.dir") +readconfig.getDistributeHoursDataExcelpath();


@Test(priority=1,enabled=true)
public void verifyDistributeHoursLaunch() {
	test = report.startTest("Verify Distribute Hours Launch Test");
	test.log(LogStatus.INFO, "Test Started" + test.getStartedTime());
	dh=PageFactory.initElements(driver, DistributeHours.class);
	dh.PayrollDashboard.click();
	dh.DistributeHoursDashboard.click();
	String actual=dh.DistributeHoursPageTitle.getText();
	Assert.assertEquals(expectedtitle, actual);
	System.out.println(actual);
	
}
@Test(priority=2,enabled=true)
public void verifyDistributeHoursEdit() throws Exception {
	test = report.startTest("Verify Distribute Hours Edit Test");
	test.log(LogStatus.INFO, "Test Started" + test.getStartedTime());
	dh=PageFactory.initElements(driver, DistributeHours.class);
	dh.PayrollDashboard.click();
	dh.DistributeHoursDashboard.click();
	String actual=dh.DistributeHoursPageTitle.getText();
	Assert.assertEquals(expectedtitle, actual);
	System.out.println(actual);
	int row=excel.getRowCount(path, "DistributeHoursAdd");
	Select s=new Select(dh.DistributeHoursEmpList);
	List<WebElement>empsel=s.getOptions();
	int empsiz=empsel.size();
		
		try {
			for(int i=0;i<row;i++) {
				int k=i+1;
				String exceltext=excel.getCellData(path, "DistributeHoursAdd", k, i);
				WebElement el=empsel.get(i);
				String apptext=el.getText();
					el.click();
				
					Thread.sleep(1500);
					for(int l=1;l<=3;l++) {
					Utility.javaScriptToClickElement(dh.DistributeHoursAddNewBtn);
					
					List<WebElement> tablevalues=driver.findElements(By.xpath("//*[@id='mytable12']/tbody/tr["+l+"]"));
					int size=tablevalues.size();
					
					String hrs=	excel.getCellData(path, "DistributeHoursAdd", l, 1);
					String hrcat=excel.getCellData(path, "DistributeHoursAdd", l, 2);
					String dept=excel.getCellData(path, "DistributeHoursAdd", l, 3);
				
					dh.DistributeHoursTextbox.sendKeys(hrs);
					Thread.sleep(2000);
					try {
						dropdownSelect(dh.DistributeHoursCategorydrpdwn, hrcat);
					} catch (Exception e) {
						dropdownSelect(driver.findElement(By.xpath("(//*[@id='DhCatList'])["+l+"]")),hrcat);
						System.out.println(e.getMessage());
					}
					Thread.sleep(2000);
					try {
						dropdownSelect(dh.DistributeHoursDeptdrpdwn, dept);
					} catch (Exception e) {
						dropdownSelect(driver.findElement(By.xpath("(//*[@id='DhDeptList'])["+l+"]")), dept);
						System.out.println(e.getMessage());
					}
					Thread.sleep(1500);
					try {
						dh.DistributeHoursTableEditDone.click();
					} catch (Exception e) {
						driver.findElement(By.xpath("(//*[@id='btnCheck'])["+l+"]")).click();
						System.out.println(e.getMessage());
					}
					}
					dh.DistributeSaveBtn.click();
					Thread.sleep(2000);
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}
}




