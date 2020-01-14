package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	public Properties pro;

	public ReadConfig() {
		File src = new File("./Configuration/config.properties");

	try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) { 
			System.out.println("Exception is " + e.getMessage());
		}
	}

	public String getApplicationURL() {
		String url = pro.getProperty("baseURL");
		return url;
	}

	public String getChromePath() {
		String chromepath = pro.getProperty("chromepath");
		return chromepath;
	}

	public String getIEPath() {
		String iepath = pro.getProperty("iepath");
		return iepath;
	}

	public String getFirefoxPath() {
		String firefoxpath = pro.getProperty("firefoxpath");
		return firefoxpath;
	}

	// excel paths

	public String getAdditionalIncomeExcelPath() {
		String excelpath = pro.getProperty("AddtionalIncomeExcelpath");
		return excelpath;
	}

	public String getCompanyInformationExcelPath() {
		String excelpath = pro.getProperty("CompanyInformationExcelpath");
		return excelpath;
	}

	public String getCompareExistingEmployeesTaxValuesExcelpath() {
		String excelpath = pro.getProperty("CompareExistingEmployeesTaxValuesExcelpath");
		return excelpath;
	}

	public String getFederalTaxesExcelpath() {
		String excelpath = pro.getProperty("FederalTaxesExcelpath");
		return excelpath;
	}

	public String getDepartmentsAndJobsExcelpath() {
		String excelpath = pro.getProperty("DepartmentsAndJobsExcelpath");
		return excelpath;
	}

	public String getHourCategoryExcelpath() {
		String excelpath = pro.getProperty("HourCategoryExcelpath");
		return excelpath;
	}

	public String getLedgerAccountsExcelpath() {
		String excelpath = pro.getProperty("LedgerAccountsExcelpath");
		return excelpath;
	}

	public String getDeductionsExcelPath() {
		String excelpath = pro.getProperty("DeductionsExcelPath");
		return excelpath;
	}

	public String getStateTaxesDataExcelpath() {
		String excelpath = pro.getProperty("StateTaxesDataExcelpath");
		return excelpath;
	}

	public String getLocalTaxesDataExcelpath() {
		String excelpath = pro.getProperty("LocalTaxesExcelpath");
		return excelpath;
	}

	public String getEmployerpayeesDataExcelpath() {
		String excelpath = pro.getProperty("EmployerPayeesExcelpath");
		return excelpath;
	}
	
	public String getEnterHoursDataExcelpath() {
		String excelpath = pro.getProperty("EnterHoursExcelpath");
		return excelpath;
	}
	
	public String getDistributeHoursDataExcelpath() {
		String excelpath = pro.getProperty("DistributeHoursExcelpath");
		return excelpath;
	}
}
