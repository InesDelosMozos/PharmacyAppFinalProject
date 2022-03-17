/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.sqlite;

import db.interfaces.TreatmentManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import pojos.Comorbidity;
import pojos.Treatment;

/**
 *
 * @author RAQUEL
 */
public class SQLiteTreatmentManager implements TreatmentManager {
    private Connection c;

    public SQLiteTreatmentManager(Connection c) {
        this.c = c;
    }
    
    public void add(String treatment) {
        try {
            String sql = "INSERT INTO treatment(name "
                    + ") "
                    + "VALUES (?)";
            PreparedStatement prep = c.prepareStatement(sql);
            prep.setString(1, treatment);
            prep.executeUpdate();
            prep.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
