package com.learnoset.studentsapp.model;

import java.util.LinkedList;
import java.util.List;

public class Model {
    private static final Model _instance = new Model();

    public static Model instance(){
        return _instance;
    }
    private Model(){
        for(int i=0; i<20; i++){
            addStudent(new Students("name " + i,"" + i,"",false));
        }
    }

    List<Students> data = new LinkedList<>();
    public List<Students> getallStudents(){
        return data;
    }

    public void addStudent(Students st){
        data.add(st);
    }
}
