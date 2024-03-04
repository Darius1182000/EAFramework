package com.ea.framework.utilities;

import io.cucumber.messages.types.DataTable;
import io.cucumber.messages.types.TableRow;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

public class CucumberUtil {

//    private static Dictionary<String, DataCollection> dataCollectionDictionary = new Hashtable<>();
//
//    public static Dictionary<String, DataCollection> convertDataTableToDictionary(DataTable dataTable){
//        List<TableRow> data = dataTable.getRows();
//        int rowNumber = 0;
//        for(List<String> column : data){
//            for(int columnIndex = 0; columnIndex < column.size(); columnIndex++){
//                dataCollectionDictionary.put(data.get(0).get(columnIndex), new DataCollection(data.get(0).get(columnIndex), column.get(columnIndex),rowNumber));
//            }
//            rowNumber++;
//        }
//        return dataCollectionDictionary;
//    }
//    private static class DataCollection{
//        private String ColumnName;
//        private String ColumnValue;
//        private int RowNumber;
//
//        public DataCollection(String columnName, String columnValue, int rowNumber) {
//            ColumnName = columnName;
//            ColumnValue = columnValue;
//            RowNumber = rowNumber;
//        }
//    }
}