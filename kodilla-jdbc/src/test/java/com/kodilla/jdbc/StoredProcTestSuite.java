package com.kodilla.jdbc;

import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StoredProcTestSuite {

    @Test
    public void testUpdateVipLevels() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();
        String sqlUpdate = "UPDATE READERS SET VIP_LEVEL = \"Not set \"";
        Statement statement = dbManager.getConnection().createStatement();
        statement.execute(sqlUpdate);

        //When
        String sqlProcedureCall = "CALL UpdateVipLevels()";
        statement.execute(sqlProcedureCall);

        //Then
        String sqlChecktable = "SELECT COUNT(*) AS HOW_MANY FROM READERS WHERE VIP_LEVEL = \"Not set \"";
        ResultSet rs = statement.executeQuery(sqlChecktable);
        int howMany = -1;
        if (rs.next()) {
            howMany = rs.getInt("HOW_MANY");
        }
        assertEquals(0, howMany);
    }

    @Test
    public void testUpdateBestsellers() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();
        String sqlUpdate = "UPDATE BOOKS SET bestseller = 0" ;
        Statement statement = dbManager.getConnection().createStatement();
        statement.execute(sqlUpdate);

        //When
        String sqlProcedureCall = "CALL UpdateBestsellers";
        statement.execute(sqlProcedureCall);

        //Then
        String sqlChecktable = "SELECT bestseller FROM BOOKS WHERE book_id = 1";
        ResultSet rs = statement.executeQuery(sqlChecktable);
        int howMany = 0;
        if (rs.next()) {
            howMany++;
        }
        assertEquals(1, howMany);
    }
}
