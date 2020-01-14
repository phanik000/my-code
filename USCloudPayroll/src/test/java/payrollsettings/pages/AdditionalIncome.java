package payrollsettings.pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.baseclass.BaseClass;
import com.utilities.ObjectRepository;
import com.utilities.Utility;

public class AdditionalIncome extends BaseClass{
	
	@FindBy(xpath=ObjectRepository.CompanySetupDropdown)
	public WebElement CompanySetupDropdown;
	
	@FindBy(xpath=ObjectRepository.PayrollSettingDashboard)
	public WebElement PayrollSettingDashboard;
	
	@FindBy(xpath=ObjectRepository.AdditionalIncomeTab)
	public WebElement AdditionalIncomeTab;
	
	@FindBy(xpath=ObjectRepository.AdditionalIncomePageTitle)
	public WebElement AdditionalIncomePageTitle;
	
	@FindBy(xpath=ObjectRepository.AdditionalIncomeDropDown)
	public WebElement AdditionalIncomeDropDown;
	
	@FindBy(xpath=ObjectRepository.SearchButtonAI)
	public WebElement SearchButtonAI;
	
	@FindBy(xpath=ObjectRepository.LoadFromListAI)
	public WebElement LoadFromListAI;
	
	@FindBy(xpath=ObjectRepository.LoadFromListSelectDropdown)
	public WebElement LoadFromListSelectDropdown;
	
	@FindBy(xpath=ObjectRepository.LoadFromListOkButtonAddinc)
	public WebElement LoadFromListOkButtonAddinc;
	
	@FindBy(xpath=ObjectRepository.ConfirmPopupBtn)
	public WebElement ConfirmPopupBtn;
	
	@FindBy(xpath=ObjectRepository.ConfirmPopupBtn1)
	public WebElement ConfirmPopupBtn1;
	
	@FindBy(xpath=ObjectRepository.DeleteFromListAI)
	public WebElement DeleteFromListAI;
	
	@FindBy(xpath=ObjectRepository.AINameTextBox)
	public WebElement AINameTextBox;
	
	@FindBy(xpath=ObjectRepository.AICalcMethodDropDown)
	public WebElement AICalcMethodDropDown;
	
	//for Selecting Fixed Amount and Fixed % Textbox
	@FindBy(xpath=ObjectRepository.AICalcMethodFixedAmountText)
	public WebElement AICalcMethodFixedAmountText;
	
	//for Selecting Mileage and Picework rate Textbox
	@FindBy(xpath=ObjectRepository.AICalcMethodPieceAmountText)
	public WebElement AICalcMethodPieceAmountText;
	
	//for selecting Fixed Amount Dropdown 'per' Dropdown enables
	@FindBy(xpath=ObjectRepository.AICalcMethodPerDropdown)
	public WebElement AICalcMethodPerDropdown;
	
	@FindBy(xpath=ObjectRepository.ApplyToWagesCheckBox)
	public WebElement ApplyToWagesCheckBox;
	
	@FindBy(xpath=ObjectRepository.OmitFromNetCheckBox)
	public WebElement OmitFromNetCheckBox;
	
	@FindBy(xpath=ObjectRepository.MultipleCheckboxesAI)
	public List<WebElement> MultipleCheckboxesAI;
	
	@FindBy(xpath=ObjectRepository.CreateNewAIButton)
	public WebElement CreateNewAIButton;
	
	@FindBy(xpath=ObjectRepository.NewAINameTextBox)
	public WebElement NewAINameTextBox;
	
	@FindBy(xpath=ObjectRepository.NewAISaveButton)
	public WebElement NewAISaveButton;
	
	@FindBy(xpath=ObjectRepository.NewAICancelButton)
	public WebElement NewAICancelButton;
	
	@FindBy(xpath=ObjectRepository.NewAITabCloseButton)
	public WebElement NewAITabCloseButton;
	
	@FindBy(xpath=ObjectRepository.SaveButtonAI)
	public WebElement SaveButtonAI;
	
	@FindBy(xpath=ObjectRepository.SaveNewButtonAI)
	public WebElement SaveNewButtonAI;
	
	
	@FindBy(xpath=ObjectRepository.CancelButtonAI)
	public WebElement CancelButtonAI;
	
	@FindBy(xpath=ObjectRepository.CancelNewButtonAI)
	public WebElement CancelNewButtonAI;
	
	
	@FindBy(xpath=ObjectRepository.ClearButtonAI)
	public WebElement ClearButtonAI;
	
	@FindBy(xpath=ObjectRepository.AlreadyExistsTextAI)
	public WebElement AlreadyExistsTextAI;
	
	public void calculationMethodVariableAmt(String excelstring) {

if(excelstring.contains("Variable Amount")) {
	dropdownSelect(AICalcMethodDropDown, "Variable Amount");
	System.out.println("Variable Amount Selected");
}
	}
	
	public void calculationMethodFixedAMT(String fixedamtexceltext,String fixedamtvalue,String fixedamtdrpdwn) throws Exception {
if(fixedamtexceltext.contains("Fixed Amount")) {
	Thread.sleep(1000);
	dropdownSelect(AICalcMethodDropDown,"Fixed Amount");
	System.out.println("Fixed Amount Selected");
	Thread.sleep(1000);
	AICalcMethodFixedAmountText.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
	AICalcMethodFixedAmountText.sendKeys(fixedamtvalue);
    dropdownSelect(AICalcMethodPerDropdown, fixedamtdrpdwn);}
	}
	public void calculationMethodFixedPercentSales(String excelstring,String fixedpercentbox) {
if(excelstring.contains("Fixed % of Sales")) {
	dropdownSelect(AICalcMethodDropDown, "Fixed % of Sales");
	System.out.println("Fixed % of Sales Selected");
	AICalcMethodFixedAmountText.sendKeys(fixedpercentbox);
	
}
	}
	public void calculationMethodMileageAmt(String excelstring,String mileagetxtbox) {
if(excelstring.contains("Milage Amount per Mile")) {
	dropdownSelect(AICalcMethodDropDown, "Milage Amount per Mile");
	System.out.println("Mileage Amount Selected");
	AICalcMethodPieceAmountText.sendKeys(mileagetxtbox);
	
}
	}
	public void calculationMethodPieceworkAmt(String excelstring,String piceworktxtbox) {
if(excelstring.contains("Piece Work Rate")) {
	dropdownSelect(AICalcMethodDropDown, "Piece Work Rate");
	System.out.println("Piecework Rate Selected");
	AICalcMethodPieceAmountText.sendKeys(piceworktxtbox);
	
}
	}
	
	
	
	
	
	
}
