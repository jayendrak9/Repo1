package com.hotelogix.AutomationFramework.Pages.GenericMethods;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.xssf.usermodel.XSSFCell;

import org.apache.poi.xssf.usermodel.XSSFRow;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExcelUtil {
	public static XSSFSheet ExcelWSheet;

    public static XSSFWorkbook ExcelWBook;

     public static XSSFCell Cell;

    public static XSSFRow Row;




    public static Sheet  ExcelWSheet1;
    public static Workbook ExcelWBook1;
    public static org.apache.poi.ss.usermodel.Cell Cell1;
    public static org.apache.poi.ss.usermodel.Row Row1;
    public static String flipFlop;



    public static int GetColumnIndex(String Value) throws Exception{
      int noOfColumns = ExcelWSheet.getRow(0).getLastCellNum();
      int i;
         for(i=0;i<noOfColumns;i++){
           String CellValue = ExcelWSheet.getRow(0).getCell(i).getStringCellValue();
              if(Value.equals(CellValue)) {
                  break;
              }
           }
          return i;
           }

    /**
     * This method destroy the all the unused references.
     */
    public static void CloseAllExcelReferences(){
    	ExcelUtil.ExcelWBook=null;
		ExcelUtil.ExcelWSheet=null;
		ExcelUtil.Cell=null;
		ExcelUtil.Row=null;
    }
//This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method

public static void setExcelFile(String Path,String SheetName) throws Exception {

       try {

           // Open and read the Excel file

        FileInputStream ExcelFile = new FileInputStream(Path);
        

        // Access the required test data sheet
          ExcelWBook = new XSSFWorkbook(ExcelFile);
//        XSSFWorkbook Excelbook =new XSSFWorkbook();
        

       // Workbook workbook = WorkbookFactory.create(ExcelFile);

        //ExcelWBook = new XSSFWorkbook(ExcelFile);

        //ExcelWSheet = ExcelWBook.getSheet(SheetName);

       // Sheet sheet = workbook.getSheet(SheetName);
        ExcelWSheet =ExcelWBook.getSheet(SheetName);

      //  Log.info("Excel sheet opened");



        } catch (IOException e){

            throw (e);

        }

}

//This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num

public static String getCellData(int RowNum, int ColNum) throws Exception{
try{

    	  Cell= ExcelWSheet.getRow(RowNum).getCell(ColNum);

          String CellData =Cell.getStringCellValue();

          return CellData;

          }catch (Exception e){

            return"";

          }

}

public static int getCellData_intData(int RowNum, int ColNum) throws Exception{

    try{

 	  Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

       int CellData = (int) Cell.getNumericCellValue();

       return CellData;

       }catch (Exception e){

System.out.println("Failed");
return 0;
       }


}



//This method is to write in the Excel cell, Row num and Col num are the parameters

public static void setCellData(String Value,  int RowNum, int ColNum,String Filename) throws Exception    {

    try{
                 flipFlop=Value;
       Row  = ExcelWSheet.getRow(RowNum);

     Cell = Row.getCell(ColNum, org.apache.poi.ss.usermodel.Row.RETURN_BLANK_AS_NULL);

     if (Cell == null) {

         Cell = Row.createCell(ColNum);

         Cell.setCellValue(Value);

         } else {
         Cell.setCellValue(Value);
         }
           FileOutputStream fileOut = new FileOutputStream(Constant.Path_TestData1+ Filename);

           ExcelWBook.write(fileOut);
           fileOut.flush();
           fileOut.close();
           fileOut=null;
          // ExcelWBook1 = new XSSFWorkbook(new FileInputStream(Constant.Path_TestData1 + Constant.File_TestData1));
         }catch(Exception e){

             throw e;

     }

 }

/*public static void setCellData(String Value,  int RowNum, int ColNum) throws Exception    {

    try{

       Row  = ExcelWSheet.getRow(RowNum);

     Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);

     if (Cell == null) {

         Cell = Row.createCell(ColNum);

         Cell.setCellValue(Value);

         } else {
         Cell.setCellValue(Value);
         }
           FileOutputStream fileOut = new FileOutputStream(Constant.Path_TestData + Constant.File_TestData);
           ExcelWBook.write(fileOut);
           fileOut.close();
           ExcelWBook = new XSSFWorkbook(new FileInputStream(Constant.Path_TestData + Constant.File_TestData));
         }catch(Exception e){

             throw e;

     }

 }*/


	public static int getRowContains(String sTestCaseName, int colNum) throws Exception{

		int i;

		try {

			int rowCount = ExcelUtil.getRowUsed();

			for ( i=0 ; i<rowCount; i++){

				String str=ExcelUtil.getCellData(i,colNum).trim();
				if  (str.equalsIgnoreCase(sTestCaseName)){

					break;

				}

			}

			return i;

				}catch (Exception e){

		//	Log.error("Class ExcelUtil | Method getRowContains | Exception desc : " + e.getMessage());

			throw(e);

			}

		}

	public static int getRowUsed() throws Exception {

		try{

			//int RowCount = ExcelWSheet.getLastRowNum();
			int RowCount1=ExcelWSheet.getLastRowNum();

		//	Log.info("Total number of Row used return as &lt; " + RowCount + " &gt;.");

			return RowCount1;

		}catch (Exception e){

			//Log.error("Class ExcelUtil | Method getRowUsed | Exception desc : "+e.getMessage());

			System.out.println(e.getMessage());

			throw (e);

		}

	}



}
