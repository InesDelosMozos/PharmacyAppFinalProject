/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacyappfinalproject;

import db.interfaces.ComorbidityManager;
import db.interfaces.DBManager;
import db.interfaces.PatientManager;
import db.interfaces.TreatmentManager;
import db.sqlite.SQLiteManager;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author inesd
 */
public class PharmacyAppFinalProject extends Application {
    private static DBManager dbManager;
    private static ComorbidityManager comorbidityManager;
    private static TreatmentManager treatmentManager;
    private static PatientManager patientManager;
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        

        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        dbManager = new SQLiteManager();
        comorbidityManager = dbManager.getComorbidityManager();
        treatmentManager = dbManager.getTreatmentManager();
        patientManager = dbManager.getPatientManager();
        
        String string = null;
        int patient_id=0;
        ComorbidityManager comorbiditymanager;

        String comorbidity[] = string.split(",");
        for(int i=0; i<comorbidity.length;i++){
        String symptom = comorbidity[i];
        comorbidityManager.add(symptom);
        int comorbidityId = dbManager.getLastId();
        patientManager.assign_comorbidity(patient_id, comorbidityId);
        }


        String treatment[] = string.split(",");
        for(int i=0; i<treatment.length;i++){
        String symptom = treatment[i];
        treatmentManager.add(symptom);
        int treatmentId= dbManager.getLastId();
        patientManager.assign_treatment(patient_id, treatmentId);
        }
        launch(args);
    }
    
}
