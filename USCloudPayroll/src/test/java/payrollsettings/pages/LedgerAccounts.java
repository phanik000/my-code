package payrollsettings.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.baseclass.BaseClass;
import com.utilities.ObjectRepository;

public class LedgerAccounts extends BaseClass {
	@FindBy(xpath=ObjectRepository.CompanySetupDropdown)
	public WebElement CompanySetupDropdown;
	
	@FindBy(xpath=ObjectRepository.PayrollSettingDashboard)
	public WebElement PayrollSettingDashboard;
	
	@FindBy(xpath=ObjectRepository.LedgerAccountsTab)
	public WebElement LedgerAccountsTab;
	
	@FindBy(xpath=ObjectRepository.LedgerSelectList)
	public WebElement LedgerSelectList;
	
	@FindBy(xpath=ObjectRepository.LedgerGridCategoryList)
	public WebElement LedgerGridCategoryList;
	
	@FindBy(xpath=ObjectRepository.LedgerGridNextpage)
	public WebElement LedgerGridNextpage;
	
	@FindBy(xpath=ObjectRepository.LedgerGridInfopage)
	public WebElement LedgerGridInfopage;
	
	
}
