/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.interfaces;

import pojos.Patient;

/**
 *
 * @author RAQUEL
 */
public interface PatientManager {
    
    public void add(Patient patient);
    
    public void assign_comorbidity(int patient_id, int comorbidity_id);
    
    public void assign_treatment(int patient_id, int treatment_id);

    public void assign_drug (int patient_id, int drug_id);

    
}
