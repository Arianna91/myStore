package utils;

import databaseConnection.CustomConnection;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TestDB {

    private static CustomConnection CustomConection;

    public static String test() throws SQLException, ClassNotFoundException {
        String query = String.format("select * from card limit 1;");
        ResultSet validationCode = CustomConection.executeQueryAPC(query);
        validationCode.next();
        System.out.println(validationCode.getString("type"));
        return validationCode.getString("type");
    }
}
