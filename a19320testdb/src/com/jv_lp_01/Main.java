package com.jv_lp_01;

import java.sql.*;

public class Main {

    public static final String DB_NAME = "testjava.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:/Volumes/Production/Courses/Programs/JavaPrograms/TestDB/" + DB_NAME;

    public static final String TABLE_CONTACTS = "contacts";

    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_EMAIL = "email";
    
    public static void main(String[] args) {
        try(Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\tmp\\testjava.db");
            Statement statement = conn.createStatement();){
            /* without try with resources we would need to statement.close(); conn.close(); */
            //conn.setAutoCommit(false);

//            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_CONTACTS + " (" + COLUMN_NAME + "  TEXT, " + COLUMN_PHONE + "  INTEGER, " + COLUMN_EMAIL + "  TEXT)");
//
            //statement.execute("INSERT INTO " + TABLE_CONTACTS + " (" + COLUMN_NAME + " , " + COLUMN_PHONE + " , " + COLUMN_EMAIL + " ) VALUES('Ivan',654987,'ivan@mail.ru')");
//            statement.execute("INSERT INTO " + TABLE_CONTACTS + " (" + COLUMN_NAME + " , " + COLUMN_PHONE + " , " + COLUMN_EMAIL + " ) VALUES('Igor',654934587,'ivsdfaan@mail.ru')");
//            statement.execute("INSERT INTO " + TABLE_CONTACTS + " (" + COLUMN_NAME + " , " + COLUMN_PHONE + " , " + COLUMN_EMAIL + " ) VALUES('Ilya',65495487,'iasdfn@mail.ru')");
//            statement.execute("INSERT INTO " + TABLE_CONTACTS + " (" + COLUMN_NAME + " , " + COLUMN_PHONE + " , " + COLUMN_EMAIL + " ) VALUES('Gleb',6542987,'ivasdf@mail.ru')");


//            statement.execute("UPDATE " + TABLE_CONTACTS + " SET " +
//                    COLUMN_PHONE + "=5566789" +
//                    " WHERE " + COLUMN_NAME + "='Jane'");
//
//            statement.execute("DELETE FROM " +TABLE_CONTACTS +
//                    " WHERE " + COLUMN_NAME + "='Joe'");
//
            statement.execute("SELECT * FROM " + TABLE_CONTACTS);
            ResultSet results = statement.getResultSet();
            /* OR */
            //ResultSet result = statement.executeQuery("SELECT * FROM contacts");
            

            /* ALSO COL NAMES CAN BE REPLACED WITH INDEXES */
            while(results.next()) {
                System.out.println(results.getString(COLUMN_NAME) + " " +
                        results.getInt(COLUMN_PHONE) + " " +
                        results.getString(COLUMN_EMAIL));
            }

            results.close();

            //statement.close();
            //conn.close();
            /* two ways of establishing connections = driver manager and data-source object */
        } catch(SQLException e){
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }

    private static void insertContact(Statement statement, String name, int phone, String email) throws SQLException {
        statement.execute("INSERT INTO " + TABLE_CONTACTS +
                " (" + COLUMN_NAME + ", " +
                COLUMN_PHONE + ", " +
                COLUMN_EMAIL +
                " ) " +
                "VALUES('" + name + "', " + phone + ", '" + email + "')");
    }
}
