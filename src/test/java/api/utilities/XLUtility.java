package api.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtility
{
	public FileInputStream fs;
	public FileOutputStream fo;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	
	public String path;
	
	public XLUtility(String path)
	{
		this.path=path;
		
		}
	
	public int getRowCount(String sheetName) throws IOException
	{
		fs=new FileInputStream(path);
		workbook=new XSSFWorkbook(fs);
		sheet=workbook.getSheet(sheetName);
	int	rowcount=sheet.getLastRowNum();
	workbook.close();
	fs.close();
		return rowcount;
		
	}
	public int getCellCount(String sheetName,int rownum) throws IOException
	{
		fs=new FileInputStream(path);
		workbook=new XSSFWorkbook(fs);
		sheet=workbook.getSheet(sheetName);
	    row=sheet.getRow(rownum);
	   int cellcount= row.getLastCellNum();
	   workbook.close();
		fs.close();
		return cellcount;
		
	}
	
	public String getcellData(String sheetName,int rownum,int column) throws IOException
	{
		fs=new FileInputStream(path);
		workbook=new XSSFWorkbook(fs);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		cell=row.getCell(column);
		
		DataFormatter formatter=new DataFormatter();
		String data;
		try
		{
			data=formatter.formatCellValue(cell); //returns the formatted value of cell 
		}
		catch (Exception e) 
		{
			data="";
			// TODO: handle exception
		}
		workbook.close();
		fs.close();
		
		return data;
	}
	
	
	
	

}
