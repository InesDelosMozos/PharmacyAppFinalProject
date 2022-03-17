/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.sqlite;

import db.interfaces.PatientManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import pojos.Patient;

/**
 *
 * @author RAQUEL
 */
public class SQLitePatientManager implements PatientManager {
    private Connection c;

    public SQLitePatientManager(Connection c) {
        this.c = c;
    }
    
    public void add(Patient patient) {
        try {
            String sql = "INSERT INTO patients (disease, age, gender, pregnant "
                    + ") "
                    + "VALUES (?,?,?,?)";
            PreparedStatement prep = c.prepareStatement(sql);
            prep.setString(1, patient.getDisease());
            prep.setInt(2, patient.getAge());
            prep.setBoolean(3, patient.getGender());
            prep.setBoolean(4, patient.getPregnant());
            prep.executeUpdate();
            prep.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void assign_drug(int patientId, int drugId) {
        // Link Product and Component
        try {
            String sql = "INSERT INTO patientDrug (patientId,drugId) " + "VALUES (?,?)";
            PreparedStatement prep = c.prepareStatement(sql);
            prep.setInt(1, patientId);
            prep.setInt(2, drugId);
            prep.executeUpdate();
            prep.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void assign_comorbidity(int patientId, int comorbidityId) {
        // Link Product and Component
        try {
            String sql = "INSERT INTO patientComorbidity (patientId,comorbidityId) " + "VALUES (?,?)";
            PreparedStatement prep = c.prepareStatement(sql);
            prep.setInt(1, patientId);
            prep.setInt(2, comorbidityId);
            prep.executeUpdate();
            prep.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void assign_treatment(int patientId, int treatmentId) {
        // Link Product and Component
        try {
            String sql = "INSERT INTO patientTreatment (patientId,treatmentId) " + "VALUES (?,?)";
            PreparedStatement prep = c.prepareStatement(sql);
            prep.setInt(1, patientId);
            prep.setInt(2, treatmentId);
            prep.executeUpdate();
            prep.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
