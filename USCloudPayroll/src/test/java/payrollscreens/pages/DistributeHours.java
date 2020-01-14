package payrollscreens.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.baseclass.BaseClass;
import com.utilities.ObjectRepository;
import com.utilities.Utility;

public class DistributeHours extends BaseClass{
	
	
	@FindBy(xpath=ObjectRepository.PayrollDashboard)
	public WebElement PayrollDashboard;
	
	@FindBy(xpath=ObjectRepository.DistributeHoursDashboard)
	public WebElement DistributeHoursDashboard;
	
	@FindBy(xpath=ObjectRepository.DistributeHoursPageTitle)
	public WebElement DistributeHoursPageTitle;
	
	@FindBy(xpath=ObjectRepository.DistributeHoursEmpList)
	public WebElement DistributeHoursEmpList;
	
	@FindBy(xpath=ObjectRepository.DistributeHoursAddNewBtn)
	public WebElement DistributeHoursAddNewBtn;
	
	
	@FindBy(xpath=ObjectRepository.DistributeHoursTextbox)
	public WebElement DistributeHoursTextbox;
	
	@FindBy(xpath=ObjectRepository.DistributeHoursCategorydrpdwn)
	public WebElement DistributeHoursCategorydrpdwn;
	
	@FindBy(xpath=ObjectRepository.DistributeHoursDeptdrpdwn)
	public WebElement DistributeHoursDeptdrpdwn;
	
	
	@FindBy(xpath=ObjectRepository.DistributeSaveBtn)
	public WebElement DistributeSaveBtn;
	
	@FindBy(xpath=ObjectRepository.DistributeHoursCancelBtn)
	public WebElement DistributeHoursCancelBtn;
	
	@FindBy(xpath=ObjectRepository.DistributeHoursUndoAllBtn)
	public WebElement DistributeHoursUndoAllBtn;
	
	@FindBy(xpath=ObjectRepository.DistributeHoursTableGridrows)
	public List<WebElement> DistributeHoursTableGridrows;
	
	@FindBy(xpath=ObjectRepository.DistributeHoursTableEdit)
	public List<WebElement> DistributeHoursTableEdit;
	
	@FindBy(xpath=ObjectRepository.DistributeHoursTableEditDone)
	public WebElement DistributeHoursTableEditDone;
	
	@FindBy(xpath=ObjectRepository.DistributeHoursTableEditCancel)
	public List<WebElement> DistributeHoursTableEditCancel;
	
	
}
