package com.example.emd029.sqlite_task;

/**
 * Created by EMD029 on 6/1/2015.
 */
public class StudentNames {
    private int id;
    private String name;
    private String subject;
    private String assignmentTask;

    public StudentNames(){
      /*  this.id=1;
        this.name="jayaraj";
        this.subject="Maths";
        this.assignmentTask="Work Completed";*/
    }
    public StudentNames(int id,String name,String subject,String assignmentTask){
        this.id=id;
        this.name=name;
        this.subject=subject;
        this.assignmentTask=assignmentTask;
    }
    //using encapsulation set and get data
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getSubject(){
        return subject;
    }
    public void setSubject(String subject){
        this.subject=subject;
    }
    public String getAssignmentTask(){
        return assignmentTask;
    }
    public void setAssignmentTask(String assignmentTask){
        this.assignmentTask=assignmentTask;

    }

}
