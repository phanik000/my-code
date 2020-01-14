package companyinfo.dashboard.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.baseclass.BaseClass;
import com.utilities.ObjectRepository;

public class CompanyInformation extends BaseClass { 
	
	
	@FindBy(xpath=ObjectRepository.CompanySetupDropdown)
	public WebElement CompanySetupDropdown;
	
	@FindBy(xpath=ObjectRepository.CompanyInformation)
	public WebElement CompanyInformation;
	
	@FindBy(xpath=ObjectRepository.UserCompanyName)
	public WebElement UserCompanyName;
	
	@FindBy(xpath=ObjectRepository.CompanyInformationTitle)
	public WebElement CompanyInformationTitle;
	
	@FindBy(xpath=ObjectRepository.CompanyLegalName)
	public WebElement CompanyLegalName;
	
	@FindBy(xpath=ObjectRepository.TradeNameTextBox)
	public WebElement TradeNameTextBox;
	
	@FindBy(xpath=ObjectRepository.BusinessTypeDropdown)
	public WebElement BusinessTypeDropdown;
	
	@FindBy(xpath=ObjectRepository.UseTradeNameonCheckscheckbox)
	public WebElement UseTradeNameonCheckscheckbox;
	
	@FindBy(xpath=ObjectRepository.CompanyLogoUploadbtn)
	public WebElement CompanyLogoUploadbtn;
	
	@FindBy(xpath=ObjectRepository.CompanyPhonenumTextBox)
	public WebElement CompanyPhonenumTextBox;
	
	@FindBy(xpath=ObjectRepository.AddressLine1)
	public WebElement AddressLine1;
	
	@FindBy(xpath=ObjectRepository.AddressLine2)
	public WebElement AddressLine2;
	
	@FindBy(xpath=ObjectRepository.CityTextBox)
	public WebElement CityTextBox;
	
	@FindBy(xpath=ObjectRepository.StateName)
	public WebElement StateName;
	
	@FindBy(xpath=ObjectRepository.ZipCode)
	public WebElement ZipCode;
	
	@FindBy(xpath=ObjectRepository.FillingAddressSameAsBusinAddr)
	public WebElement FillingAddressSameAsBusinAddr;
	
	@FindBy(xpath=ObjectRepository.BusnsAddrline1)
	public WebElement BusnsAddrline1;
	
	@FindBy(xpath=ObjectRepository.BusnsAddrline2)
	public WebElement BusnsAddrline2;
	
	@FindBy(xpath=ObjectRepository.BusnsCityName)
	public WebElement BusnsCityName;
	
	@FindBy(xpath=ObjectRepository.BusnsStateName)
	public WebElement BusnsStateName;
	
	@FindBy(xpath=ObjectRepository.BusnsZipCode)
	public WebElement BusnsZipCode;
	
	@FindBy(xpath=ObjectRepository.DateofIncorporation)
	public WebElement DateofIncorporation;
	
	@FindBy(xpath=ObjectRepository.PayrollYearNonEditableTextbox)
	public WebElement PayrollYearNonEditableTextbox;
	
	@FindBy(xpath=ObjectRepository.CommentTextBox)
	public WebElement CommentTextBox;
	
	@FindBy(xpath=ObjectRepository.SaveButton)
	public WebElement SaveButton;
	
	@FindBy(xpath=ObjectRepository.CancelButton)
	public WebElement CancelButton;
	
	@FindBy(xpath=ObjectRepository.ClearButton)
	public WebElement ClearButton;
	
	@FindBy(xpath=ObjectRepository.AllTextBoxes)
	public List<WebElement> AllTextBoxes;
	
	@FindBy(xpath=ObjectRepository.ConfirmPopupBtn)
	public WebElement ConfirmPopupBtn;
	
	@FindBy(xpath=ObjectRepository.ConfirmPopupText)
	public WebElement ConfirmPopupText;
	
	@FindBy(xpath=ObjectRepository.FederalID)
	public WebElement FederalID;
	
}