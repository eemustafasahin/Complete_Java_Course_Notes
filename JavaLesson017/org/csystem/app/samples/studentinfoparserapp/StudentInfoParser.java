package org.csystem.app.samples.studentinfoparserapp;

public class StudentInfoParser {
    private StudentInfo m_studentInfo;

    public StudentInfoParser(String str)
    {
        String [] studentInfoStr = str.split("[:]+");
        //...

        m_studentInfo = new StudentInfo(studentInfoStr[0], studentInfoStr[1], studentInfoStr[2], Integer.parseInt(studentInfoStr[3]), Integer.parseInt(studentInfoStr[4]));
    }

    public StudentInfo getStudentInfo()
    {
        return m_studentInfo;
    }
}
