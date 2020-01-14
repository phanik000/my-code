package payrollsettings.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.baseclass.BaseClass;
import com.utilities.ObjectRepository;

public class HourCategories extends BaseClass{
	@FindBy(xpath=ObjectRepository.CompanySetupDropdown)
	public WebElement CompanySetupDropdown;
	
	@FindBy(xpath=ObjectRepository.PayrollSettingDashboard)
	public WebElement PayrollSettingDashboard;
	
	
	@FindBy(xpath=ObjectRepository.HourCategoriesTab)
	public WebElement HourCategoriesTab;
	
	@FindBy(xpath=ObjectRepository.HourCategoryPageTitle)
	public WebElement HourCategoryPageTitle;
	
	@FindBy(xpath=ObjectRepository.HourCategoryDropDown)
	public WebElement HourCategoryDropDown;
	
	@FindBy(xpath=ObjectRepository.SearchHourCatButton)
	public WebElement SearchHourCatButton;
	
	@FindBy(xpath=ObjectRepository.LoadFromListButton)
	public WebElement LoadFromListButton;
	
	@FindBy(xpath=ObjectRepository.LoadFromListSelectDropdwn)
	public WebElement LoadFromListSelectDropdwn;
	
	@FindBy(xpath=ObjectRepository.LoadFromListOkButton)
	public WebElement LoadFromListOkButton;
	
	@FindBy(xpath=ObjectRepository.ConfirmPopupBtn)
	public WebElement ConfirmPopupBtn;
	
	
	@FindBy(xpath=ObjectRepository.DeleteButton)
	public WebElement DeleteButton;
	
	@FindBy(xpath=ObjectRepository.HourCategoryTextBox)
	public WebElement HourCategoryTextBox;
	
	@FindBy(xpath=ObjectRepository.EmpHourRateDropDown)
	public WebElement EmpHourRateDropDown;
	
	@FindBy(xpath=ObjectRepository.EmpMultiplierDropDown)
	public WebElement EmpMultiplierDropDown;
	
	@FindBy(xpath=ObjectRepository.UseinCalcCheckBox)
	public WebElement UseinCalcCheckBox;
	
	@FindBy(xpath=ObjectRepository.CreateNewHourButton)
	public WebElement CreateNewHourButton;
	
	@FindBy(xpath=ObjectRepository.NewHourCatNameTextBox)
	public WebElement NewHourCatNameTextBox;
	
	@FindBy(xpath=ObjectRepository.SaveNewHourCatButton)
	public WebElement SaveNewHourCatButton;
	
	@FindBy(xpath=ObjectRepository.NewHourCatCancel)
	public WebElement NewHourCatCancel;
	
	@FindBy(xpath=ObjectRepository.SaveButtonHourCat)
	public WebElement SaveButtonHourCat;
	
	@FindBy(xpath=ObjectRepository.CancelButtonHourCat)
	public WebElement CancelButtonHourCat;
	
	@FindBy(xpath=ObjectRepository.CancelNewButtonHourCat)
	public WebElement CancelNewButtonHourCat;
	
	
	@FindBy(xpath=ObjectRepository.ClearButtonHourCat)
	public WebElement ClearButtonHourCat;
	
	@FindBy(xpath=ObjectRepository.HourCatFullText)
	public WebElement HourCatFullText;
	
	
	
	
	
	
}
