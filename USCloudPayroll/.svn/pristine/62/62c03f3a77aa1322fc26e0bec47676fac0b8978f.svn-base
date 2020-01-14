package signin.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.baseclass.BaseClass;
import com.utilities.ObjectRepository;

public class SignInPage extends BaseClass {


	@FindBy(xpath=ObjectRepository.SigninPageEmailAddress)
	@CacheLookup
	public WebElement SigninPageEmailAddress;
	
	@FindBy(xpath=ObjectRepository.SigninPagePassword)
	@CacheLookup
	public WebElement SigninPagePassword;
	
	@FindBy(xpath=ObjectRepository.SigninPageButton)
	@CacheLookup
	public WebElement SigninPageButton;
	
	
	public void enterEmailID(String emialid) {
		SigninPageEmailAddress.sendKeys(emialid);
	}

	public void enterPassword(String pwd) {
		SigninPagePassword.sendKeys(pwd);
	}

	public void clickSigninBtn() {
		SigninPageButton.click();
	}


}
