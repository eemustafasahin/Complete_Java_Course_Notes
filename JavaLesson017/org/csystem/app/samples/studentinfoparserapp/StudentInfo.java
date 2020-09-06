package org.csystem.app.samples.studentinfoparserapp;

import org.csystem.util.datetime.Date;

public class StudentInfo {
    private String m_name;
    private Date m_birthDate;
    private String m_lectureName;
    private int m_midtermGrade;
    private int m_finalGrade;

    public StudentInfo(String name, int day, int mon, int year, String lectureName, int midtermGrade, int finalGrade)
    {
        //...
        m_name = name;
        m_birthDate = new Date(day, mon, year);
        m_lectureName = lectureName;
        m_midtermGrade = midtermGrade;
        m_finalGrade = finalGrade;
    }

    public StudentInfo(String name, String birthDateStr, String lectureName, int midtermGrade, int finalGrade)
    {
        //...
        m_name = name;
        m_lectureName = lectureName;
        m_midtermGrade = midtermGrade;
        m_finalGrade = finalGrade;
        setBirthDate(birthDateStr);
    }

    public double getGrade()
    {
        return m_midtermGrade * 0.4 + m_finalGrade * 0.6;
    }

    public void setName(String name)
    {
        m_name = name;
    }

    public void setLectureName(String lectureName)
    {
        m_lectureName = lectureName;
    }

    public void setMidtermGrade(int midtermGrade)
    {
        m_midtermGrade = midtermGrade;
    }

    public void setFinalGrade(int finalGrade)
    {
        m_finalGrade = finalGrade;
    }

    public void setBirthDate(String birthDateStr)
    {
        String [] birthDateInfo = birthDateStr.split("[/]");

        m_birthDate = new Date(Integer.parseInt(birthDateInfo[0]), Integer.parseInt(birthDateInfo[1]), Integer.parseInt(birthDateInfo[2]));
    }

    public String toString()
    {
        double grade = getGrade();

        return String.format("{name:'%s', birthDate:'%s', lectureName:%s, midTermGrade:%d, finalGrade: %d, grade:%f, status:'%s'}",
                m_name, m_birthDate.toLongDateStringTR(), m_lectureName, m_midtermGrade, m_finalGrade, grade,  grade >= 50 ? "Geçti" : "Kaldı");
    }
}