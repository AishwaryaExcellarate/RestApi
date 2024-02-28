package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class Dataproviders
{
	@DataProvider(name="Data")
	public String[][] getAllData() throws IOException
	{
		String path = System.getProperty("C:\\Users\\aishwaryaa\\eclipse-workspace\\RestAssuredApi\\testData\\NewSeleniumProject.xlsx");
		XLUtility x1=new XLUtility(path);
		
		int rownum=x1.getRowCount("Sheet2");
		int colcount=x1.getCellCount("Sheet2",2 );
		
		String apidata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<=colcount;j++)
			{
				apidata[i-1][j]=x1.getcellData("Sheet2", i, j);
				
			}
		}
		return apidata;
		
		}
	
	@DataProvider(name="UserNames")
	public String[] getUserNames() throws IOException
	{
		String path = System.getProperty("C:\\Users\\aishwaryaa\\eclipse-workspace\\RestAssuredApi\\testData\\NewSeleniumProject.xlsx");
		XLUtility x1=new XLUtility(path);
		int rownum=x1.getRowCount("Sheet2");
		String apidata[]=new String[rownum];
		
		for(int i=1;i<=rownum;i++)
		{
		  apidata[i-1]=x1.getcellData("Sheet2", i, 2);
		  
		}
		return apidata;
	}

}
