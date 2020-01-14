package com.utilities;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

/*Excel Util which is used to GetData,SetData,
 * Getting count for Rows and Clolumns it is mainly used for DataDriven Testing
*/

  public class ExcelUtil {
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;




//Getting Row count from an excel
	public int getRowCount(String xlfile,String xlsheet) throws IOException 
	
	{
		
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		int rowcount=ws.getLastRowNum();
		wb.close();
		fi.close();
		return rowcount;
		
	
	}

	//Getting Cell count from an excel
	public int getCellCount(String xlfile,String xlsheet,int rownum) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		int cellcount=row.getLastCellNum();
		wb.close();
		fi.close();
		return cellcount;
	}

//Get Data from the Excel File
	public String getCellData(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		cell=row.getCell(colnum);
		String data;
		
		try 
		{
			//DataFromatter which is used to fromat ant kind of data whether it is numeric to string
			DataFormatter formatter = new DataFormatter();
			String cellData = formatter.formatCellValue(cell);
			return cellData;
		}
		catch (Exception e) 
		{
			data="";
		}
		wb.close();
		fi.close();
		return data;
	}
	//To Set Data into each Cell
	public String setCellData(String xlfile,String xlsheet,int rownum,int colnum,String data) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		
		if(row==null) 
			row=ws.createRow(rownum);
		cell = row.getCell(colnum);
		
		cell=row.getCell(colnum, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
		if (cell == null) {
			cell = row.createCell(colnum);
			cell.setCellValue(data);
			
		} else {
			cell.setCellValue(data);
			
		}
		fo=new FileOutputStream(xlfile);
		wb.write(fo);		
		wb.close();
		fi.close();
		fo.close();
		return data;

	}
	//To Set Cell data into Bold which may highlight particular cell data
	public String setCellDataBold(String xlfile,String xlsheet,int rownum,int colnum,String data) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		XSSFFont customfont=wb.createFont();
		customfont.setBold(true);
		if(row==null) 
			row=ws.createRow(rownum);
			cell = row.getCell(colnum);
		
		cell=row.getCell(colnum, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
		if (cell == null) {
			cell = row.createCell(colnum);
			CellStyle style=wb.createCellStyle();
			style.setFillBackgroundColor(IndexedColors.RED.getIndex());
			style.setFillPattern(FillPatternType.BIG_SPOTS);
			cell.setCellStyle(style);
			cell.setCellValue(data);
			
		} else {
			cell.setCellValue(data);
			
		}
		fo=new FileOutputStream(xlfile);
		wb.write(fo);		
		wb.close();
		fi.close();
		fo.close();
		return data;

	}

	public String setMultipleValues(String xlfile,String xlsheet,int rowno,int colno,List<String> data) throws IOException  {
		try {
				fi=new FileInputStream(xlfile);
				wb=new XSSFWorkbook(fi);
			
				ws=wb.getSheet(xlsheet);
				for(int i=0;i<=row.getLastCellNum();i++) {
				row=ws.getRow(rowno);
				if(row==null) {
				row=ws.createRow(rowno);
				}
				cell=row.getCell(colno,Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
				if(cell==null) {
				cell=row.createCell(colno);
				cell.setCellValue(data.toString());
				}else {
					cell.setCellValue(data.toString());
				}
				fo=new FileOutputStream(xlfile);
				wb.write(fo);		
				wb.close();
				fi.close();
				fo.close();
				}
				}
			catch(Exception e) {
				System.out.println("The set data exception is"+e);
				
				
			}
			
				return xlsheet; 
			
			}
			

}
