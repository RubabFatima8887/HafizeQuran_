package com.example.hafizequran;

public class Student {
    private String rollNo;
    private String name;
    // private String age;

    public Student(String name,String id) {
        this.name = name;
        this.rollNo = id;
        //  this.age = age;
    }

    public Student() {

    }

    public String getId() {
        return rollNo;
    }

    public String getName() {
        return name;
    }
//public String getAge(){
    //  return age;
//}

    public void setId(String id) {
        this.rollNo = id;
    }
public void setName(String Name){
        this.name = Name;
}

    @Override
    public String toString() {
        return "Student{" +
                "id=" + rollNo +
                ", name='" + name + '\'' +
                '}';
    }
    //  ", age='" + age +'
}
