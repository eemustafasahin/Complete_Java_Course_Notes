package org.csystem.util.datetime;

public enum DayOfWeek {
    SUN("Pazar", "Sun"), MON("Pazartesi", "Mon"), TUE("Salı", "Tue"), WED("Çarşamba", "Wed"),
    THU("Perşembe", "Thu"), FRI("Cuma", "Fri"), SAT("Cumartesi", "Sat");

    DayOfWeek(String nameTR, String nameEN)
    {
        NAME_TR = nameTR;
        NAME_EN = nameEN;
    }

    final String NAME_TR, NAME_EN;
}