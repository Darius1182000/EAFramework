package com.ea.framework.utilities;

import com.ea.framework.config.Settings;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class DatabaseUtil {

    public static Connection open(String connectionString){

        try {
            Class.forName(Settings.DriverType).getDeclaredConstructor().newInstance();
            return DriverManager.getConnection(connectionString);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException |
                 ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(){

    }

    public static void executeQuery(String query, Connection connection){

        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
