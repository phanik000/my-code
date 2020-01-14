package signin.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.baseclass.BaseClass;
import com.relevantcodes.extentreports.LogStatus;

public class VerifySignInPage extends BaseClass{
	public String expectedSignpage = "ERP - Payroll Services";

	
	@Test(priority=1)
	public void VerifySigninpage() {
		test = report.startTest("Verify To SignIn Test");
		test.log(LogStatus.INFO, "Test Started" + test.getStartedTime());
		String dashboardTitle = driver.getTitle();
		Assert.assertEquals(expectedSignpage, dashboardTitle);
		System.out.println("The title after signin is: "+dashboardTitle);
		
	}	
	
	
	
	
	
	
	
}
