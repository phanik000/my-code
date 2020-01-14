package payrollsettings.tests;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.baseclass.BaseClass;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.relevantcodes.extentreports.LogStatus;
import com.utilities.Utility;

import payrollsettings.pages.EmployerPayees;

public class VerifyEmployerPayees extends BaseClass{
	public EmployerPayees emprpay;
	public String expectedtitle="Employer Payee";
	public String importactualpagetitle="Import Employer Payee Information";
	public String path=System.getProperty("user.dir") +readconfig.getEmployerpayeesDataExcelpath();
	WebElement emppayclick;
	ArrayList<String> apptext=new ArrayList<String>();
	ArrayList<String> exceltext=new ArrayList<String>();
	public String csvpath="C:\\Users\\Phani\\Downloads\\EmployeeImport.csv";
	@Test(priority=1,enabled=true)
	public void verifytoLaunchEmployerPayees() throws Exception {
				
					test = report.startTest("Verify EmployerPayees creation Test");
					test.log(LogStatus.INFO, "Test Started" + test.getStartedTime());
					
					// Page Factory Initilization using binary class of EmployerPayees Income
					emprpay = PageFactory.initElements(driver, EmployerPayees.class);
					try {
						emprpay.CompanySetupDropdown.click();
						Thread.sleep(1000);
					} catch (Exception e) {
					driver.findElement(By.xpath("//*[@href='#homeSubmenu']")).click();
					Thread.sleep(1000);
					}
					emprpay.PayrollSettingDashboard.click();
	}
	
	
	@Test(priority=2,dataProvider="EmployerPayees",enabled=false)
	public void verifytoAddEmployerPayees(String payment_type,String name) throws Exception {
				try {
					test = report.startTest("Verify EmployerPayees creation Test");
					test.log(LogStatus.INFO, "Test Started" + test.getStartedTime());
					
					emprpay.EmployerPayeeTab.click();
					emprpay.EmployerPayeeAddNewclick.click();
					dropdownSelect(emprpay.Emp_payePaymenttypedrpdwn, payment_type);
					Thread.sleep(1000);
					emprpay.Emp_payeCreateNewtxtbox.sendKeys(name);
					emprpay.EmployerPayeeclickOkButton.click();
					Thread.sleep(1000);
					emprpay.ConfirmPopupBtn.click();
				} catch (Exception e) {
					System.out.println("Exception is: " + e);
				}
	}
	@Test(priority=3,enabled=false)
	public void VerifyToDeleteEmployerPayees() throws Exception {
		test = report.startTest("Verify To Delete Employer Payees Test");
		test.log(LogStatus.INFO, "Test Started" + test.getStartedTime());
		emprpay.EmployerPayeeTab.click();
		
		int excelcnt=excel.getRowCount(path, "DeleteEmployerPayee");
	for(int i=1;i<excelcnt;i++){
		
		String exceltext=excel.getCellData(path, "DeleteEmployerPayee", i, 0);
		Select s=new Select(emprpay.Emp_payeListdrpdwn);
		List<WebElement> emppaydrpdwn=s.getOptions();
		int deptsize=emppaydrpdwn.size();
		System.out.println("Dept Dropdown Size is: "+deptsize);
	for(int j=0;j<deptsize;j++) {
			emppayclick=emppaydrpdwn.get(j);
			
				try {
					String apptext=emppayclick.getText();
					System.out.println("try "+apptext);
					//if(apptext.equalsIgnoreCase(exceltext)) {
						emppayclick.click();
					emprpay.EmployerPayeeDeleteBtn.click();
					Thread.sleep(1000);
					try {
						emprpay.ConfirmPopupBtn1.click();
					} catch (Exception e) {
						driver.findElement(By.xpath("//*[text()='Yes, Delete it!']")).click();
					}
					Thread.sleep(1000);
					emprpay.ConfirmPopupBtn.click();
					Thread.sleep(1000);
					//}
				} catch (Exception e) {
					emppayclick = driver.findElement(By.xpath("//*[@id='listItems']//option["+i+"]"));
					String apptext=emppayclick.getText();
					System.out.println("catch "+apptext);
					//if(apptext.equalsIgnoreCase(exceltext)) {
						emppayclick.click();
					emprpay.EmployerPayeeDeleteBtn.click();
					Thread.sleep(1000);
					try {
						emprpay.ConfirmPopupBtn1.click();
					} catch (Exception e1) {
						driver.findElement(By.xpath("//*[text()='Yes, Delete it!']")).click();
					}
					Thread.sleep(1000);
					emprpay.ConfirmPopupBtn.click();
					Thread.sleep(1000);
					}
				}
			}
		}
//	}
	
	@Test(priority=4,enabled=false)
	public void verifyToEditEmployerPayees() throws Exception {
		test = report.startTest("Verify To Edit Employer Payees Test");
		test.log(LogStatus.INFO, "Test Started" + test.getStartedTime());
		emprpay.EmployerPayeeTab.click();
		int excelcnt=excel.getRowCount(path, "EditEmployerPayees");
	for(int i=0;i<excelcnt;i++) {
		String excelemptext=excel.getCellData(path, "EditEmployerPayees", i+1, 0);
		String excelempname=excel.getCellData(path, "EditEmployerPayees", i+1, 1);
		String excelempadd1=excel.getCellData(path, "EditEmployerPayees", i+1, 2);
		String excelempadd2=excel.getCellData(path, "EditEmployerPayees", i+1, 3);
		String excelempcityname=excel.getCellData(path, "EditEmployerPayees", i+1, 4);
		String excelempstatename=excel.getCellData(path, "EditEmployerPayees", i+1, 5);
		String excelempzipcode=excel.getCellData(path, "EditEmployerPayees", i+1, 6);
		String excelempreference=excel.getCellData(path, "EditEmployerPayees", i+1, 7);
		String excelemprouting=excel.getCellData(path, "EditEmployerPayees", i+1, 8);
		String excelempaccount=excel.getCellData(path, "EditEmployerPayees", i+1, 9);
		String excelemppayment_type=excel.getCellData(path, "EditEmployerPayees", i+1, 10);
		String excelempstatetax=excel.getCellData(path, "EditEmployerPayees", i+1, 11);
		
		Select s=new Select(emprpay.Emp_payeListdrpdwn);
		List<WebElement> emppaydrpdwn=s.getOptions();
		int deptsize=emppaydrpdwn.size();
	for(int j=0;j<deptsize;j++) {
		WebElement el=	emppaydrpdwn.get(j);
			String appemptext=el.getText();
		if(appemptext.equals(excelemptext)) {
		el.click();	
		
		emprpay.Emp_payeNametxtbox.clear();
		emprpay.Emp_payeNametxtbox.sendKeys(excelempname);
		emprpay.Emp_payeAddress1txtbox.sendKeys(excelempadd1);
		emprpay.Emp_payeAddress2txtbox.sendKeys(excelempadd2);
		emprpay.Emp_payeCitytxtbox.sendKeys(excelempcityname);
		emprpay.Emp_payeStatetxtbox.sendKeys(excelempstatename);
		emprpay.Emp_payeZiptxtbox.sendKeys(excelempzipcode);
		emprpay.Emp_payeRefIDtxtbox.sendKeys(excelempreference);
		emprpay.Emp_payeRouting1txtbox.sendKeys(excelemprouting);
		emprpay.Emp_payeAccount1txtbox.sendKeys(excelempaccount);
		dropdownSelect(emprpay.EmprPatment_typedrpdwn, excelemppayment_type);
		dropdownSelect(emprpay.EmprStatetaxdrpdwn, excelempstatetax);
		emprpay.EmployerPayeeSaveBtn.click();
		emprpay.ConfirmPopupBtn.click();
		Thread.sleep(1000);
				}
			}

		}
	
	}
	
	@Test(priority=5,enabled=true)
	public void verifyEmployerpayeesImport() throws Throwable {
		test = report.startTest("Verify To Edit Employer Payees Test");
		test.log(LogStatus.INFO, "Test Started" + test.getStartedTime());
		emprpay.EmployerPayeeTab.click();
		emprpay.EmployerPayeeImportBtn.click();
		String importpageexpectedtitle=emprpay.EmployerPayeeImportpagetitle.getText();
		Assert.assertEquals(importactualpagetitle, importpageexpectedtitle, "Not matched");
		System.out.println("Import title is: "+importpageexpectedtitle);
		loadFromList(emprpay.EmployerPayeeImportAvailableFieldlist);
		emprpay.EmployerPayeeImportCoptBtn.click();
		emprpay.EmployerPayeeImportCSVfileBtn.click();
		Thread.sleep(1500);
		Utility.chooseFileWithRobot(csvpath);
		Thread.sleep(2000);
		
		int siz = emprpay.EmployerPayeeImportPreviewReportbox.size();

		for (int i = 0; i < siz - 1; i++) 
		{
			WebElement el = emprpay.EmployerPayeeImportPreviewReportbox.get(i);
			String text = el.getText();
			// System.out.println("Text is: "+text);
			Thread.sleep(1000);
			apptext.add(text);
		}
		System.out.println(apptext);
		apptext.clear();
		// This will load csv file
		CSVReader reader = new CSVReader(new FileReader(csvpath));

		// this will load content into list
		List<String[]> li = reader.readAll();

		for (String[] row : li)
		{
			for (String cell : row) 
			{
				// System.out.print(cell);
				// System.out.println(cell.concat(", "));
				exceltext.add(cell);
			}
		}
		reader.close();
		System.err.println(exceltext);
		exceltext.clear();
		CSVWriter writer = new CSVWriter(new FileWriter(csvpath));
		String[] write = new String[] {"pass" };
		writer.writeNext(write);

		writer.flush();
		writer.close();
	}
	
	
	
	
	

	@DataProvider(name = "EmployerPayees")

	public String[][] emPersonalInfo() throws Exception {
		int row = excel.getRowCount(path, "AddnewEmployerPayee");
		int cel = excel.getCellCount(path, "AddnewEmployerPayee", 1);
		String chequeDates[][] = new String[row][cel];

		for (int i = 1; i <= row; i++) {
			for (int j = 0; j < cel; j++) {
				chequeDates[i - 1][j] = excel.getCellData(path, "AddnewEmployerPayee", i, j);
			}

		}
		return chequeDates;
	}
	
	
}
