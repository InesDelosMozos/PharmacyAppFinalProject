/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diagnosis;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.drools.template.model.Rule;
import org.kie.api.KieServices;
import org.kie.api.definition.KiePackage;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 *
 * @author alberto.gildelafuent
 */
public class Diagnosis {

    public static void main(String[] args) {

        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();
        
        KieSession ksession = kc.newKieSession("diagnosisKS");
        Collection<KiePackage> kpcks = ksession.getKieBase().getKiePackages();
        for (KiePackage kpck : kpcks){
            Collection<org.kie.api.definition.rule.Rule> krules = kpck.getRules();
            for(org.kie.api.definition.rule.Rule r : krules){
                System.out.println(r);
            }
        }
        
        
        Patient p1 = new Patient("heart failure", true);
        List<String> comorbidity = new ArrayList<>();
        comorbidity.add("allergic to proteins ");
        p1.setComorbidity(comorbidity);
        List<String> medicines = new ArrayList<>();
        medicines.add("aspirin");
        p1.setMedicines(medicines);
        p1.setAge(Patient.Age.YOUNG);
        
        
        ksession.insert(p1);
        
        ksession.fireAllRules();
        
        System.out.println("AFTER");
        
        System.out.println(p1);
        
        ksession.dispose();
        
    }
}

