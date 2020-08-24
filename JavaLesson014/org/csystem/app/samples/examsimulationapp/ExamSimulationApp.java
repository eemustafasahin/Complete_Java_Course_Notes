package org.csystem.app.samples.examsimulationapp;

public class ExamSimulationApp {
    public static void run()
    {
        ExamSimulation examSimulation = new ExamSimulation("Matematik");

        examSimulation.run();
        examSimulation.displayGrades();
        examSimulation.displayStatus();
    }
}
