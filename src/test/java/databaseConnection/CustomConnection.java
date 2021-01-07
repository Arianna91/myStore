package databaseConnection;

import java.sql.*;

public class CustomConnection {
    //Connection to DB
    public static Connection connectionAPC = null;
    public static Connection connectionCashOut = null;
    private static CustomConnection CustomConection;
    private static String host="127.0.0.1";

    private static String port="1414";
    private static String dbNameAPC="xxx";
    private static String userNameDB="admin";
    private static String passwordDB="xxxx";




    /**
     * Open and return a connection to database PUNC
     * @return an instance of java.sql.Connection
     */
    public static void connectDBAPC() throws SQLException, ClassNotFoundException {

        //Load driver class for your specific database type
        String conn = "jdbc:mysql://" + host + ":" + port + "/" + dbNameAPC + "?serverTimezone = UTC";

        //Class.forName("org.sqlite.JDBC")
        //String connectionString = "jdbc:sqlite:" + dataFile

        if(connectionAPC == null || connectionAPC.isClosed()){
            String username=userNameDB;
            String password=passwordDB;
            connectionAPC = DriverManager.getConnection(conn, username, password);
        }
    }


    /**
     * execute a SQL query on database PUNC
     * @param queryString SQL query string
     * @return a reference to returned data collection, an instance of java.sql.ResultSet
     */
    public static ResultSet executeQueryAPC(String queryString) throws SQLException, ClassNotFoundException {
        connectDBAPC();
        Statement stm = connectionAPC.createStatement();
        ResultSet rs = stm.executeQuery(queryString);
        return rs;
    }


    //Closing the connection APC
    public void closeDatabaseConnectionAPC() throws SQLException {

        if(connectionAPC != null && !connectionAPC.isClosed()){

            connectionAPC.close();
        }
        connectionAPC = null;
    }


    /**
     * Execute non-query (usually INSERT/UPDATE/DELETE/COUNT/SUM...) on database PUNC
     * @param queryString a SQL statement
     * @return single value result of SQL statement
     */

    public static boolean executeAPC(String queryString) throws SQLException, ClassNotFoundException {
        connectDBAPC();
        Statement stm = connectionAPC.createStatement();
        boolean result = stm.execute(queryString);
        return result;

    }

/*
    //APC Cash Out Cash
    public static void connectDBCASHOUT(){

        //Load driver class for your specific database type
        String conn = "jdbc:mysql://" + GlobalVariable.host + ":" + GlobalVariable.port + "/" + GlobalVariable.db_name_cashOut + "?serverTimezone = UTC";

        //Class.forName("org.sqlite.JDBC")
        //String connectionString = "jdbc:sqlite:" + dataFile

        if(connectionCashOut == null || connectionCashOut.isClosed()){

            String username=GlobalVariable.db_user;
            String password=GlobalVariable.db_password;
            this.connectionCashOut = DriverManager.getConnection(conn, username, password);
        }
    }


    /**
     * execute a SQL query on database PUNC
     * @param queryString SQL query string
     * @return a reference to returned data collection, an instance of java.sql.ResultSet
     */
    /*
    public static ResultSet executeQueryCASHOUT(String queryString) {
        CustomConection.connectDBCASHOUT()
        Statement stm = connectionCashOut.createStatement()
        ResultSet rs = stm.executeQuery(queryString)
        return rs
    }


    //Closing the connection APC
    public void closeDatabaseConnectionCASHOUT() {

        if(connectionCashOut != null && !connectionCashOut.isClosed()){

            connectionCashOut.close()

        }

        connectionCashOut = null

    }


    /**
     * Execute non-query (usually INSERT/UPDATE/DELETE/COUNT/SUM...) on database PUNC
     * @param queryString a SQL statement
     * @return single value result of SQL statement
     */
/*
    public static boolean executeCASHOUT(String queryString) {
        CustomConection.connectDBCASHOUT()
        Statement stm = connectionCashOut.createStatement();
        boolean result = stm.execute(queryString)

        return result
    }
    */
}
