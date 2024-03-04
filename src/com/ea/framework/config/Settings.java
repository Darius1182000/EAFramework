package com.ea.framework.config;

import com.ea.framework.base.BrowserTypes;
import com.ea.framework.utilities.LogUtil;

import java.sql.Connection;

public class Settings {
    public static Connection AUTConnection;
    public static Connection ReportingConnection;
    public  static String AUTConnectionString;
    public  static String ReportingConnectionString;
    public  static String LogPath;
    public  static String DriverType;
    public  static String ExcelSheetPath;
    public  static String AUT;
    public static BrowserTypes BrowserType;
    public static LogUtil Logs;

}
