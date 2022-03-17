/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diagnosis;

/**
 *
 * @author alberto.gildelafuent
 */
public class Student {
    public enum Result {PASS,FAIL};
    private String name;
    private float practiceMark;
    private float examMark;
    private Result finalMark;

    public Student(String name, float practiceMark, float examMark) {
        this.name = name;
        this.practiceMark = practiceMark;
        this.examMark = examMark;
        this.finalMark = Result.PASS;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPracticeMark() {
        return practiceMark;
    }

    public void setPracticeMark(float practiceMark) {
        this.practiceMark = practiceMark;
    }

    public float getExamMark() {
        return examMark;
    }

    public void setExamMark(float examMark) {
        this.examMark = examMark;
    }

    public Result getFinalMark() {
        return finalMark;
    }

    public void setFinalMark(Result finalMark) {
        this.finalMark = finalMark;
    }

    @Override
    public String toString() {
        return "Student{" + "name=" + name + ", practiceMark=" + practiceMark + ", examMark=" + examMark + ", finalMark=" + finalMark + '}';
    }

    
    
}
