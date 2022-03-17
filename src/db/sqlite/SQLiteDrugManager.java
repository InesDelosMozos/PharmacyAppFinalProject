/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.sqlite;

import db.interfaces.DrugManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import pojos.Comorbidity;
import pojos.Drug;

/**
 *
 * @author RAQUEL
 */
public class SQLiteDrugManager implements DrugManager {
    
    private Connection c;

    public SQLiteDrugManager(Connection c) {
        this.c = c;
    }
    
    public void add(Drug drug ) {
        try {
            String sql = "INSERT INTO drug (name, duration "
                    + ") "
                    + "VALUES (?,?)";
            PreparedStatement prep = c.prepareStatement(sql);
            prep.setString(1, drug.getName());
            prep.setInt(2, drug.getDuration());
            prep.executeUpdate();
            prep.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
