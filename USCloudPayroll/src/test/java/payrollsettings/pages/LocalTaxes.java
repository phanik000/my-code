package payrollsettings.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.baseclass.BaseClass;
import com.utilities.ObjectRepository;
import com.utilities.Utility;

public class LocalTaxes extends BaseClass {
	
	@FindBy(xpath=ObjectRepository.CompanySetupDropdown)
	public WebElement CompanySetupDropdown;
	
	@FindBy(xpath=ObjectRepository.PayrollSettingDashboard)
	public WebElement PayrollSettingDashboard;
	
	@FindBy(xpath=ObjectRepository.LocalTaxesTab)
	public WebElement LocalTaxesTab;
	
	@FindBy(xpath=ObjectRepository.LocalTaxesPageTitle)
	public WebElement LocalTaxesPageTitle;
	
	@FindBy(xpath=ObjectRepository.LocalTaxesDropDown)
	public WebElement LocalTaxesDropDown;
	
	@FindBy(xpath=ObjectRepository.SearchLocalTaxbutton)
	public WebElement SearchLocalTaxbutton;
	
	@FindBy(xpath=ObjectRepository.LocalTaxLoadFromListButton)
	public WebElement LocalTaxLoadFromListButton;
	
	@FindBy(xpath=ObjectRepository.LocalTaxLoadFromListDropdown)
	public WebElement LocalTaxLoadFromListDropdown;
	
	@FindBy(xpath=ObjectRepository.LocalTaxLoadFromListOkButton)
	public WebElement LocalTaxLoadFromListOkButton;
	
	@FindBy(xpath=ObjectRepository.ConfirmPopupBtn)
	public WebElement ConfirmPopupBtn;
	
	@FindBy(xpath=ObjectRepository.ConfirmPopupBtn1)
	public WebElement ConfirmPopupBtn1;
	
	
	@FindBy(xpath=ObjectRepository.DeleteLocalTaxButton)
	public WebElement DeleteLocalTaxButton;
	
	@FindBy(xpath=ObjectRepository.TaxCategorynameTextBox)
	public WebElement TaxCategorynameTextBox;
	
	@FindBy(xpath=ObjectRepository.LocalTaxCalculationMethodDropDown)
	public WebElement LocalTaxCalculationMethodDropDown;
	
	@FindBy(xpath=ObjectRepository.FixedPerTextBox)
	public WebElement FixedPerTextBox;
	
	@FindBy(xpath=ObjectRepository.FixedAmountTextBox)
	public WebElement FixedAmountTextBox;
	
	@FindBy(xpath=ObjectRepository.FixedAmountPerDropdown)
	public WebElement FixedAmountPerDropdown;
	
	@FindBy(xpath=ObjectRepository.WagelimitTextBox)
	public WebElement WagelimitTextBox;
	
	@FindBy(xpath=ObjectRepository.TaxTableNYC)
	public WebElement TaxTableNYC;
	
	@FindBy(xpath=ObjectRepository.TaxTableValuesList)
	public List<WebElement> TaxTableValuesList;
	
	@FindBy(xpath=ObjectRepository.TaxTableValuesList1)
	public List<WebElement> TaxTableValuesList1;
	
	@FindBy(xpath=ObjectRepository.TaxTableAddLine)
	public WebElement TaxTableAddLine;
	@FindBy(xpath=ObjectRepository.TaxTableRemoveLineBtn)
	public WebElement TaxTableRemoveLineBtn;
	@FindBy(xpath=ObjectRepository.TaxTableCloseLineMultiple)
	public List<WebElement> TaxTableCloseLineMultiple;
	@FindBy(xpath=ObjectRepository.TaxTableOkBtn)
	public WebElement TaxTableOkBtn;
	@FindBy(xpath=ObjectRepository.TaxTableCloseBtn)
	public WebElement TaxTableCloseBtn;
	@FindBy(xpath=ObjectRepository.TaxTableOverTextboxMultipleEdit)
	public WebElement TaxTableOverTextboxMultipleEdit;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@FindBy(xpath=ObjectRepository.ExemptionAmountTextBox)
	public WebElement ExemptionAmountTextBox;
	
	@FindBy(xpath=ObjectRepository.TaxCreditAmountTextBox)
	public WebElement TaxCreditAmountTextBox;
	
	@FindBy(xpath=ObjectRepository.MinSTDDeducTextBox)
	public WebElement MinSTDDeducTextBox;
	
	@FindBy(xpath=ObjectRepository.STDDeducAsPerofGrowthLocaltax)
	public WebElement STDDeducAsPerofGrowthLocaltax;
	
	@FindBy(xpath=ObjectRepository.MaxStdDeducAmount)
	public WebElement MaxStdDeducAmount;
	
	
	@FindBy(xpath=ObjectRepository.LocalTaxSaveButton)
	public WebElement LocalTaxSaveButton;
	
	@FindBy(xpath=ObjectRepository.LocalTaxCancelButton)
	public WebElement LocalTaxCancelButton;
	
	@FindBy(xpath=ObjectRepository.LocalTaxClearButton)
	public WebElement LocalTaxClearButton;
	
	@FindBy(xpath=ObjectRepository.NewTaxCreationButton)
	public WebElement NewTaxCreationButton;
	
	@FindBy(xpath=ObjectRepository.EnterNewNameTextBox)
	public WebElement EnterNewNameTextBox;
	
	@FindBy(xpath=ObjectRepository.LocalTaxSaveNewButton)
	public WebElement LocalTaxSaveNewButton;
	
	@FindBy(xpath=ObjectRepository.LocalTaxCancelNewButton)
	public WebElement LocalTaxCancelNewButton;
	
	@FindBy(xpath=ObjectRepository.CloseNewPopupWindow)
	public WebElement CloseNewPopupWindow;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
