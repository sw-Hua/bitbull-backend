package com.songwen.marketreport;

import java.util.List;

/**
 * @author songwen
 */
public class StudentDTO {
    // 我可以这么理解嘛 studentdto就是可以提供一个固定的json格式的数据？重点是固定，如果没有StudentDTO外部的json格式的会随着实体类变化而变化，但是有了StudentDTO就会固定了，我理解的对吗？
    //
    private String id;
    private String name;
    private long studentNumber;
    private String email;
    private List<String> courseList;
    private float gpa;

    public StudentDTO() {
    }

    public StudentDTO(String id, String name, long studentNumber, String email,
                      List<String> courseList, float gpa) {
        this.id = id;
        this.name = name;
        this.studentNumber = studentNumber;
        this.email = email;
        this.courseList = courseList;
        this.gpa = gpa;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(long studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<String> courseList) {
        this.courseList = courseList;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

}
