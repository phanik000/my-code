package payrollsettings.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.utilities.ObjectRepository;

public class FederalTaxes {
	
	@FindBy(xpath=ObjectRepository.CompanySetupDropdown)
	public WebElement CompanySetupDropdown;
	
	@FindBy(xpath=ObjectRepository.PayrollSettingDashboard)
	public WebElement PayrollSettingDashboard;
	
	@FindBy(xpath=ObjectRepository.FederalTaxesTab)
	public WebElement FederalTaxesTab;
	
	@FindBy(xpath=ObjectRepository.Load2020Button)
	public WebElement Load2020Button;
	
	@FindBy(xpath=ObjectRepository.ReplaceYesOption)
	public WebElement ReplaceYesOption;
	
	@FindBy(xpath=ObjectRepository.MarriedTaxTable)
	public WebElement MarriedTaxTable;
	
	@FindBy(xpath=ObjectRepository.MarrTaxTableValues)
	public WebElement MarrTaxTableValues;
	
	@FindBy(xpath=ObjectRepository.CloseButtonFedTaxtable)
	public WebElement CloseButtonFedTaxtable;
	
	@FindBy(xpath=ObjectRepository.FederalWithholdingTextBox)
	public WebElement FederalWithholdingTextBox;
	
	@FindBy(xpath=ObjectRepository.MaxFutaWagesTextBox)
	public WebElement MaxFutaWagesTextBox;
	
	@FindBy(xpath=ObjectRepository.FUTAperTextBox)
	public WebElement FUTAperTextBox;
	
	@FindBy(xpath=ObjectRepository.MaxSocailSecWagesTextBox)
	public WebElement MaxSocailSecWagesTextBox;
	
	@FindBy(xpath=ObjectRepository.EmployeeSSecPer)
	public WebElement EmployeeSSecPer;
	
	@FindBy(xpath=ObjectRepository.EmployerSSecPer)
	public WebElement EmployerSSecPer;
	
	@FindBy(xpath=ObjectRepository.EmployeeMedicareTextBox)
	public WebElement EmployeeMedicareTextBox;
	
	@FindBy(xpath=ObjectRepository.EmployerMedicareTextBox)
	public WebElement EmployerMedicareTextBox;
	
	@FindBy(xpath=ObjectRepository.WitholdAddtnlMCareTextBox)
	public WebElement WitholdAddtnlMCareTextBox;
	
	@FindBy(xpath=ObjectRepository.EmployeeAddlMedcareTextBox)
	public WebElement EmployeeAddlMedcareTextBox;
	
	@FindBy(xpath=ObjectRepository.SaveButtonFedTax)
	public WebElement SaveButtonFedTax;
	
	@FindBy(xpath=ObjectRepository.ClearButtonFedTax)
	public WebElement ClearButtonFedTax;
	
	@FindBy(xpath=ObjectRepository.CancelButtonFedTax)
	public WebElement CancelButtonFedTax;
	
	@FindBy(xpath=ObjectRepository.AllTextBoxesFederal)
	public List<WebElement> AllTextBoxesFederal;
}
