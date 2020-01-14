package payrollsettings.tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.baseclass.BaseClass;
import com.relevantcodes.extentreports.LogStatus;
import com.utilities.ExcelUtil;
import com.utilities.ObjectRepository;

import payrollsettings.pages.LedgerAccounts;

public class VerifyLedgerAccounts extends BaseClass {
	ExcelUtil excel = new ExcelUtil();
	public String path = System.getProperty("user.dir") + readconfig.getLedgerAccountsExcelpath();
	String expectedtitle = "";
	public LedgerAccounts ledger;
	public Select s;
	public WebElement enteracno;
	//Here this method defines to edit the account no. of LedgerAccount
	@Test(priority = 1,enabled=true)
	public void ledgerAccountCompare() throws InterruptedException, IOException {
		test = report.startTest("Verify to edit Account no. of LedgerAccount Test");
		test.log(LogStatus.INFO, "Test Started" + test.getStartedTime());
		ledger = PageFactory.initElements(driver, LedgerAccounts.class);
		ArrayList<String> appstr=new ArrayList<String>();
		ArrayList<String> excelstr=new ArrayList<String>();
		ledger.CompanySetupDropdown.click();
		Thread.sleep(1000);
		ledger.PayrollSettingDashboard.click();
		Thread.sleep(1000);
		ledger.LedgerAccountsTab.click();
		Select sel= new Select(ledger.LedgerSelectList);
		List<WebElement> ele=sel.getOptions();
		for(int k=0;k<ele.size();k++) {
			WebElement account=ele.get(k);
			account.click();
			String dropdownName= account.getText();
			String gridinfo=ledger.LedgerGridInfopage.getText();
			System.err.println(gridinfo);
				Thread.sleep(2000);
				List<WebElement> accountNames=driver.findElements(By.xpath(ObjectRepository.LedgerGridCategoryList));
				int dynamicSizeofList=accountNames.size();
				for(int a=0;a<dynamicSizeofList;a++) {
					System.out.println("No.Of Accounts in "+dropdownName+" is "+accountNames.size());
					WebElement single=accountNames.get(a);
					String Name=single.getText();
					appstr.add(Name);
					//excel.setCellData(path, "LedgerAccounts", a+1, k, Name);
					System.out.println(""+dropdownName+"'s Account Name :"+Name);
				String get=	excel.getCellData(path, "LedgerAccounts", a+1, k);
				excelstr.add(get);
				if(appstr.contains(get)) {
					System.out.println("compared");
					excel.setCellData(path, "LedgerAccounts", a+1, 9, "pass");
				}else {
					System.out.println("not compared");
					excel.setCellData(path, "LedgerAccounts", a+1, 9, "fail");
					excel.setCellData(path, "LedgerAccounts", a+1, 10, Name);
				}
				}
			}
			
			}

	@Test(priority = 2,enabled=false)
	public void editAccountno() throws InterruptedException, IOException {
		test = report.startTest("Verify to edit Account no. of LedgerAccount Test");
		test.log(LogStatus.INFO, "Test Started" + test.getStartedTime());
		ledger = PageFactory.initElements(driver, LedgerAccounts.class);
		ledger.CompanySetupDropdown.click();
		Thread.sleep(1000);
		ledger.PayrollSettingDashboard.click();
		Thread.sleep(1000);
		ledger.LedgerAccountsTab.click();
		Select sel= new Select(ledger.LedgerSelectList);
		List<WebElement> ele=sel.getOptions();
		for(int k=0;k<ele.size();k++) {
			WebElement account=ele.get(k);
			account.click();
			String dropdownName= account.getText();
			String gridinfo=ledger.LedgerGridInfopage.getText();
			System.err.println(gridinfo);
			if(gridinfo.equals("1 - 20 of 31 items")) {
				int a=0;
			try {
				Thread.sleep(3500);
				List<WebElement> accountNames=driver.findElements(By.xpath(ObjectRepository.LedgerGridCategoryList));
				int dynamicSizeofList=accountNames.size();
				for(a=0;a<dynamicSizeofList;a++) {
					System.out.println("No.Of Accounts in "+dropdownName+" is "+accountNames.size());
					WebElement single=accountNames.get(a);
					String Name=single.getText();
					excel.setCellData(path, "LedgerAccounts", a+1, k, Name);
					System.out.println(""+dropdownName+"'s Account Name :"+Name);
					
					String NameS=single.getText();
					Thread.sleep(1500);
					ledger.LedgerGridNextpage.click();
					excel.setCellData(path, "LedgerAccounts", a+1, k, NameS);
					System.out.println(""+dropdownName+"'s Account Name :"+NameS);
					Thread.sleep(1000);
				}
			} catch (Exception e) {
				int c=a+1;
				List<WebElement> accountNames=driver.findElements(By.xpath("(.//*[@class='awe-tbody']/tr/td[@colspan])["+c+"]"));
				int dynamicSizeofList=accountNames.size();
				for(a=0;a<dynamicSizeofList;a++) {
					System.out.println("No.Of Accounts in "+dropdownName+" is "+accountNames.size());
					WebElement single=accountNames.get(a);
					String Name=single.getText();
					excel.setCellData(path, "LedgerAccounts", a+1, k, Name);
					System.out.println(""+dropdownName+"'s Account Name :"+Name);
					
					String NameS=single.getText();
					Thread.sleep(1500);
					ledger.LedgerGridNextpage.click();
					excel.setCellData(path, "LedgerAccounts", a+1, k, NameS);
					System.out.println(""+dropdownName+"'s Account Name :"+NameS);
					Thread.sleep(1000);
				}
			}
			
			}else {
				Thread.sleep(3500);
				List<WebElement> accountNames=driver.findElements(By.xpath(ObjectRepository.LedgerGridCategoryList));
				int dynamicSizeofList=accountNames.size();
				for(int a=0;a<dynamicSizeofList;a++) {
					System.out.println("No.Of Accounts in "+dropdownName+" is "+accountNames.size());
					WebElement single=accountNames.get(a);
					String Name=single.getText();
					excel.setCellData(path, "LedgerAccounts", a+1, k, Name);
					System.out.println(""+dropdownName+"'s Account Name :"+Name);
				}
			}
		}
	}
	
		}

