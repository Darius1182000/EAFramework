package com.ea.framework.utilities;

import io.cucumber.datatable.DataTable;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

public class CucumberUtil {

    private static List<DataCollection> dataCollectionDictionary = new ArrayList<>();

    public static List<DataCollection> convertDataTableToDictionary(DataTable dataTable){
        dataCollectionDictionary.clear();
        var data = dataTable.asLists();
        int rowNumber = 0;
        for(List<String> column : data){
            for(int columnIndex = 0; columnIndex < column.size(); columnIndex++){
                dataCollectionDictionary.add(rowNumber, new DataCollection(data.get(0).get(columnIndex), column.get(columnIndex),rowNumber));
            }
            rowNumber++;
        }
        return dataCollectionDictionary;
    }
    //ToDo: passing the rowIndex to get the columnValue based on Row number
    public static String getCellValueWithRowIndex(String columnName, int rowNumber){
        final String[] columnValue = {null};

        dataCollectionDictionary.forEach(x ->{
            if(x.ColumnName.equals(columnName) && x.RowNumber == rowNumber){
                columnValue[0] = x.ColumnValue;
            }
        });
        return columnValue[0];
    }
    private static class DataCollection{
        private String ColumnName;
        private String ColumnValue;
        private int RowNumber;

        public DataCollection(String columnName, String columnValue, int rowNumber) {
            ColumnName = columnName;
            ColumnValue = columnValue;
            RowNumber = rowNumber;
        }
    }
}