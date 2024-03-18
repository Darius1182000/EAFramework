package com.ea.framework.utilities;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;

public class ExcelUtil {

    static Sheet worksheet;
    static Workbook workbook = null;
    static HashMap<String, Integer> dict = new HashMap<>();

    public ExcelUtil(String path) throws BiffException, IOException{
        //Initialize
        workbook = Workbook.getWorkbook(new File(path));
        //For Demo purpose the Excel sheet path is hardcoded but not recommended
        worksheet = workbook.getSheet("Sheet1");
        //Call the Column dictionary to store column names
        columnDictionary();
    }
    //Return the number of rows
    public static int rowCount(){
        return worksheet.getRows();
    }
    //Return the cell value by taking row and column values as argument
    private static String readCell(int column, int row){
        return worksheet.getCell(column,row).getContents();
    }

    public static String readCell(String columnName, int rowNumber){
        return readCell(getCell(columnName), rowNumber);
    }

    //Create column dictionary to hold all column names
    private static void columnDictionary(){
        //Iterate through all the columns in the Excel sheet and store the value
        for(int column = 0; column < worksheet.getColumns(); column++){
            dict.put(readCell(column,0), column);
        }
    }

    private static int getCell(String columnName) {
        Integer columnIndex = dict.get(columnName);
        if (columnIndex == null) {
            // Handle the case where the column name wasn't found
            throw new IllegalArgumentException("Column name '" + columnName + "' not found");
        }
        return columnIndex;
    }
}
