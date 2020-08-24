package org.csystem.app.samples.studentinfoparserapp;

import java.util.Scanner;

public class StudentInfoParserApp {
    public static void run()
    {
        Scanner kb = new Scanner(System.in);

        for (;;) {
            System.out.print("Formatlı yazıyı giriniz:");
            String str = kb.nextLine();

            if (str.equals("quit"))
                break;

            StudentInfoParser studentInfoParser = new StudentInfoParser(str);

            System.out.println(studentInfoParser.studentInfo.toString());
        }

        System.out.println("Tekrar yapıyor musunuz?");
    }
}
