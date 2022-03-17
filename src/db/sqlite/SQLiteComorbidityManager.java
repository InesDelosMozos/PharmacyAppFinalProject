/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.sqlite;

import db.interfaces.ComorbidityManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import pojos.Comorbidity;

/**
 *
 * @author RAQUEL
 */
public class SQLiteComorbidityManager implements ComorbidityManager {
    private Connection c;

    public SQLiteComorbidityManager(Connection c) {
        this.c = c;
    }
    
    public void add(String comorbidity) {
        try {
            String sql = "INSERT INTO comorbidity (name "
                    + ") "
                    + "VALUES (?)";
            PreparedStatement prep = c.prepareStatement(sql);
            prep.setString(1, comorbidity);
            prep.executeUpdate();
            prep.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    
}
