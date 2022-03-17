/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RAQUEL
 */
public class Patient {
    
   private Integer id;
   public boolean pregnant ;
   public boolean gender;
   private enum Gender {MALE,FEMALE};
   public enum Age {CHILD,YOUNG,ADULT,ELDER};
   public int age;
   private String disease;
   private List<String> comorbidity = new ArrayList<>();
   private List<String> medicines = new ArrayList<>();
   //private List<String> treatments = new ArrayList<>();
   private String treatments;
   private Gender gender2;
   private Age age2;

    public boolean getPregnant() {
        return pregnant;
    }

    public void setPregnant(boolean pregnant) {
        this.pregnant = pregnant;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public List<String> getComorbidity() {
        return comorbidity;
    }

    public void setComorbidity(List<String> comorbidity) {
        this.comorbidity = comorbidity;
    }

    public List<String> getMedicines() {
        return medicines;
    }

    public void setMedicines(List<String> medicines) {
        this.medicines = medicines;
    }

    public String getTreatments() {
        return treatments;
    }

    public void setTreatments(String treatments) {
        this.treatments = treatments;
    }
    
    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Patient(Integer id, boolean pregnant, String disease, String treatments, boolean gender, int age) {
        this.id = id;
        this.pregnant = pregnant;
        this.disease = disease;
        this.treatments = treatments;
        this.gender = gender;
        this.age = age;
    }

    public Patient() {
    }
    
   
    
    
}
