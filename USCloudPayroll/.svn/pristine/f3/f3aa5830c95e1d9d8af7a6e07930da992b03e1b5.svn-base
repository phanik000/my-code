package payrollscreens.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.baseclass.BaseClass;
import com.relevantcodes.extentreports.LogStatus;
import com.utilities.Utility;

import junit.framework.Assert;
import payrollscreens.pages.EnterHours;

public class VerifyEnterHours extends BaseClass{
public EnterHours eh;
public String expectedtitle="Enter Hours";
public String path=System.getProperty("user.dir") +readconfig.getEnterHoursDataExcelpath();


@Test(priority=1,enabled=false)
public void verifyEnterHoursLaunch() {
	test = report.startTest("Verify Enter Hours Launch Test");
	test.log(LogStatus.INFO, "Test Started" + test.getStartedTime());
	eh=PageFactory.initElements(driver, EnterHours.class);
	eh.PayrollDashboard.click();
	eh.EnterHoursDashboard.click();
	String actual=eh.EnterHoursPageTitle.getText();
	Assert.assertEquals(expectedtitle, actual);
	System.out.println(actual);
	
}

@Test(priority=2,enabled=false)
public void verifyEnterHoursToEdit() throws Exception {
	test = report.startTest("Verify Enter Hours Edit Test");
	test.log(LogStatus.INFO, "Test Started" + test.getStartedTime());
	eh=PageFactory.initElements(driver, EnterHours.class);
	eh.PayrollDashboard.click();
	eh.EnterHoursDashboard.click();
	String actual=eh.EnterHoursPageTitle.getText();
	Assert.assertEquals(expectedtitle, actual);
	System.out.println(actual);
	int excelrow=excel.getRowCount(path, "EnterHoursEdit");
	for(int row=1;row<=excelrow;row++) {
		List<WebElement> tablevalues=driver.findElements(By.xpath("//*[@id='EnterHourstablepagingText']/tbody/tr["+row+"]/td/input[@class='tdClick']"));
		int table=tablevalues.size();
		System.out.println(table);
    for(int cel=0;cel<table;cel++) {
       List<WebElement> tablevaluescels=driver.findElements(By.xpath("//*[@id='EnterHourstablepagingText']/tbody/tr["+row+"]/td/input[@class='tdClick']"));
	   WebElement celedit=tablevaluescels.get(cel);
	   String data=excel.getCellData(path,"EnterHoursEdit",row,cel+1);
	   celedit.sendKeys(data);
			}
		}
	}

@Test(priority=3,enabled=true)
public void verifyEnterHoursImport() throws Exception {
	test = report.startTest("Verify Importing Enter Hours Test");
	test.log(LogStatus.INFO, "Test Started" + test.getStartedTime());
	eh=PageFactory.initElements(driver, EnterHours.class);
	eh.PayrollDashboard.click();
	eh.EnterHoursDashboard.click();
	String actual=eh.EnterHoursPageTitle.getText();
	Assert.assertEquals(expectedtitle, actual);
	System.out.println(actual);
	eh.ImportHoursBtn.click();
	Thread.sleep(1000);
	eh.ChooseFileHoursBtn.click();
	Utility.chooseFileWithRobot("C:\\Users\\Phani\\Downloads\\Import hrs.txt");
	eh.ImportHoursOKBtn.click();

}










}
