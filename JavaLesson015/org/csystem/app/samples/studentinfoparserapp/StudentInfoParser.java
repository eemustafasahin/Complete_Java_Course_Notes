package org.csystem.app.samples.studentinfoparserapp;

public class StudentInfoParser {
    public StudentInfo studentInfo;

    public StudentInfoParser(String str)
    {
        String [] studentInfoStr = str.split("[:]+");
        //...

        studentInfo = new StudentInfo();
        studentInfo.name = studentInfoStr[0];
        studentInfo.birthDate = studentInfoStr[1];
        studentInfo.lectureName = studentInfoStr[2];
        studentInfo.midtermGrade = Integer.parseInt(studentInfoStr[3]);
        studentInfo.finalGrade = Integer.parseInt(studentInfoStr[4]);
    }
}
