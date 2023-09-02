package utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBUtils {
    public static List<Map<String, String>> fetch(String query) {
        String dbURL = ConfigReader.getPropertyValue("dbUrl");
        String dbUserName = ConfigReader.getPropertyValue("dbUserName");
        String dbPassword = ConfigReader.getPropertyValue("dbPassword");
        List<Map<String, String>> mapList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(dbURL, dbUserName, dbPassword);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            //information about the data for example no of columns their names data types etc.
            ResultSetMetaData metaData = resultSet.getMetaData();
            // gives us the no of columns in the resultSet
            int columnCount = metaData.getColumnCount();
            while (resultSet.next()) {
                Map<String, String> rowMap = new HashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    String key = metaData.getColumnLabel(i);
                    String value = resultSet.getString(i);
                    rowMap.put(key, value);
                }
                mapList.add(rowMap);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            /*finally { // if we don't use try with resources then we have to write below code
                try{
                    if(connection!=null)
                        connection.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }*/

        }
        return mapList;
    }
}
