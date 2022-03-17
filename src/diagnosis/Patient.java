/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diagnosis;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author inesd
 */
public class Patient {

   public boolean pregnant ;
   private enum Gender {MALE,FEMALE};
   public enum Age {CHILD,YOUNG,ADULT,ELDER};
   private String disease;
   private List<String> comorbidity = new ArrayList<>();
   private List<String> medicines = new ArrayList<>();
   //private List<String> treatments = new ArrayList<>();
   private String treatments;
   private Gender gender;
   private Age age;

    public void setPregnant(boolean pregnant) {
        this.pregnant = pregnant;
    }
public void setTreatments(String t){
    this.treatments = t;
}
    public void setAge(Age age) {
        this.age = age;
    }

    public boolean isPregnant() {
        return pregnant;
    }

    public Age getAge() {
        return age;
    }
   
   
    public Patient(String disease, boolean pregnant) {
        this.disease = disease;
        this.pregnant = pregnant;
        
    }
    @Override
    public String toString() {
        return "Patient1{" + "age=" + age + ", comorbidity=" + comorbidity + ", medicines=" + medicines + ", treatments=" + treatments + '}';
    }

   

    public void setComorbidity(List<String> comorbidity) {
        this.comorbidity = comorbidity;
    }

    public void setMedicines(List<String> medicines) {
        this.medicines = medicines;
    }

    
    

    public List<String> getComorbidity() {
        return comorbidity;
    }

    public List<String> getMedicines() {
        return medicines;
    }

   
    

    public Gender getGender() {
        return gender;
    }

   

    public void setGender(Gender gender) {
        this.gender = gender;
    }
    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getDisease() {
        return disease;
    }

   
    
             
}
