package utilities;

import java.io.FileInputStream;

import java.io.FileNotFoundException;

import java.io.FileOutputStream;

import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;

import org.apache.poi.xssf.usermodel.XSSFRow;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils2 {

	private static XSSFSheet ExcelWSheet;

	private static XSSFWorkbook ExcelWBook;

	private static XSSFCell Cell;

	private static XSSFRow Row;

public static Object[][] getTableArray(String FilePath, String SheetName) throws Exception {   

   String[][] tabArray = null;

   try {
	   System.out.println("Calling fetexecl");

	   FileInputStream ExcelFile = new FileInputStream("./testdata//login.xlsx");

	   // Access the required test data sheet

	   XSSFWorkbook workbook = new XSSFWorkbook(ExcelFile);

	   XSSFSheet sheet = workbook.getSheet(SheetName);

	   int totalRows = sheet.getLastRowNum();

	   int totalCells = sheet.getRow(1).getLastCellNum();
	   
	   
     // tabArray=new String[totalRows][];

	  // ci=0;

	   for (int r=0;r<=totalRows;r++) {           	   
		   for (int c=1;c<=totalCells;c++){

			   tabArray[r][c]=getCellData(r,c);

			   System.out.println(tabArray[r][c]);  

				}

			}

		}

	catch (FileNotFoundException e){

		System.out.println("Could not read the Excel sheet");

		e.printStackTrace();

		}

	catch (IOException e){

		System.out.println("Could not read the Excel sheet");

		e.printStackTrace();

		}

	return(tabArray);

	}

public static String getCellData(int RowNum, int ColNum) throws Exception {

	try{

		Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

	//	CellType dataType = Cell.getCellType();

	//	if  (dataType==null) {

	//		return "";

	//	}else{

			String CellData = Cell.getStringCellValue();

			return CellData;
		//}

		}catch (Exception e){

		System.out.println(e.getMessage());

		throw (e);

		}

	}

}