package org.csystem.app.samples.studentinfoparserapp;

public class StudentInfo {
    public String name;
    public String birthDate;
    public String lectureName;
    public int midtermGrade;
    public int finalGrade;

    public double getGrade()
    {
        return midtermGrade * 0.4 + finalGrade * 0.6;
    }

    public String getBirthDateDayOfWeekTR()
    {
        String [] birthDateInfo = birthDate.split("[/]");

        return DateUtil.getDayOfWeekTR(Integer.parseInt(birthDateInfo[0]), Integer.parseInt(birthDateInfo[1]), Integer.parseInt(birthDateInfo[2]));
    }

    public String toString()
    {
        double grade = getGrade();

        return String.format("{name:'%s', birthDate:'%s %s', lectureName:%s, midTermGrade:%d, finalGrade: %d, grade:%f, status:'%s'}",
                name, birthDate, getBirthDateDayOfWeekTR(), lectureName, midtermGrade, finalGrade, grade,  grade >= 50 ? "Geçti" : "Kaldı");
    }
}